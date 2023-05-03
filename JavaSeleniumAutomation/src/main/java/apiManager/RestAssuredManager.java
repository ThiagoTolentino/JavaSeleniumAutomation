package apiManager;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Properties;

public class RestAssuredManager {

    private final int timeout = 50000;
    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(timeout)
            .setSocketTimeout(timeout)
            .build();

    private final SocketConfig socketConfig = SocketConfig.custom()
            .setSoTimeout(timeout)
            .build();
    private final CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .setDefaultSocketConfig(socketConfig)
            .build();
    private String applicationName;

    public String getHttpRequestResult(String uri, String tool, String applicationAuth, String applicationName) throws InterruptedException {
        String json = null;
        this.applicationName = applicationName;
        json = getHttpRequestResultRapidApi(uri, applicationAuth);
        return json;
    }

    private String getHttpRequestResultRapidApi(String uri, String applicationAuth) throws InterruptedException {
        int maxAttempt = 5;
        int attempt = 1;
        String json = "";

        while(true){
            try{
                URL url = new URL(uri);
                setCookies();
                HttpURLConnection connection;
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json");
                InputStream response = connection.getInputStream();
                OutputStream writer = new ByteArrayOutputStream();
                IOUtils.copy(response, writer);
                json = writer.toString();
                response.close();
                connection.disconnect();
            } catch (Exception e) {
                Thread.sleep(2000);
                if(++attempt >= maxAttempt){
                    break;
                }
            }
        }
        return json;
    }

    private void setCookies(){
        Properties systemProperties = System.getProperties();

        systemProperties.setProperty("http.proxyHost","proxypac");
        systemProperties.setProperty("http.proxyPort","8080");

        HttpURLConnection.setFollowRedirects(false);
        CookieManager cm = new CookieManager();
        CookieHandler.setDefault(cm);
    }
}
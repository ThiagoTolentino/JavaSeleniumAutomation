package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class Utility {

    static Properties properties;
    static InputStream input;
    public static Properties loadProperties(String path) {
        try {
            input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            return properties;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String geraStringAleatoria(int tamanho)
    {
        // Determia as letras que poderão estar presente nas chaves
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
        String txt = "";
        int indiceLetra;
        Random random = new Random();
        for (int i = 0; i < tamanho; i++)
        {
            do{
                indiceLetra = random.nextInt(letras.length());
            }while(indiceLetra == 0);
            txt += letras.substring(indiceLetra-1,indiceLetra);
        }
        return txt;
    }

    public String getReportConfigPath(){
        String reportConfigPath = System.getProperty("user.dir")+ properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}

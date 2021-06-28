package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDrivers {public static WebDriver getDriver(DriverManagerType browserName) {
    if ("ChromeDriver".equals(browserName.getDriver())) {
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    } else if ("firefoxdriver".equals(browserName.getDriver())) {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    } else if ("iedriver".equals(browserName.getDriver())) {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
    return null;
}

}

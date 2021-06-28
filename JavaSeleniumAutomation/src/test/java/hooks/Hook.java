package hooks;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import driverManager.DriverManagerType;
import driverManager.WebDrivers;

import java.io.File;

public class Hook {
    public static WebDriver driver;

    @Before
    public void init(){
        driver = WebDrivers.getDriver(DriverManagerType.CHROME);
    }

    @After
    public void cleanUp(){
        //Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
        if (driver != null) {
            driver.quit();
        }
    }


}

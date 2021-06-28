package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#identifierId")
    private WebElement userTxtBox;

    @FindBy(css = ".VfPpkd-vQzf8d")
    private WebElement proximoUserBtn;

    @FindBy(css = "#password > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    private WebElement pswdTxtBox;

    @FindBy(css = ".VfPpkd-LgbsSe-OWXEXe-k8QpJ > span:nth-child(3)")
    private WebElement proximoPswdBtn;

    public void pressUsr(String user) throws InterruptedException {
        webActionHelperMethods.setTxtBoxString(user,userTxtBox);
        webActionHelperMethods.clickbutton(proximoUserBtn);
    }

    public void pressPswd(String pswd) throws InterruptedException {
        webActionHelperMethods.setTxtBoxString(pswd,pswdTxtBox);
        webActionHelperMethods.clickbutton(proximoPswdBtn);
    }

    public WebElement getUserTxtBox() {
        return userTxtBox;
    }

    public WebElement getProximoUserBtn() {
        return proximoUserBtn;
    }

    public WebElement getPswdTxtBox() {
        return pswdTxtBox;
    }

    public WebElement getProximoPswdBtn() {
        return proximoPswdBtn;
    }

}

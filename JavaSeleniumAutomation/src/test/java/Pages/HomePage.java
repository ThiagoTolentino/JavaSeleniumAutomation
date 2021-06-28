package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageClass {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".n4P87 > div:nth-child(1) > button:nth-child(1) > span:nth-child(3)")
    WebElement fazerLogin;

    @FindBy(css = "#firstName")
    WebElement firstName;

    @FindBy(css = "#lastName")
    WebElement lastName;

    @FindBy(css = "#username")
    WebElement userName;

    @FindBy(css = "#passwd > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    WebElement passwd;

    @FindBy(css = "#confirm-passwd > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
    WebElement confirmPasswd;

    @FindBy(css =".VfPpkd-LgbsSe-OWXEXe-k8QpJ > span:nth-child(3)")
    WebElement proximoBtnCadastro;

    public void maximizar(){
        webActionHelperMethods.MaximizeBrowser();
    }

    public void goToLogin() {
        webActionHelperMethods.clickbutton(fazerLogin);
    }

    public void typeName(String name) throws InterruptedException {
        webActionHelperMethods.setTxtBoxString(name,firstName);
    }

    public void typeLastName(String name) throws InterruptedException {
        webActionHelperMethods.setTxtBoxString(name,lastName);
    }

    public void typeNewUser(String user) throws InterruptedException {
        webActionHelperMethods.setTxtBoxString(user,userName);
    }

    public void typeNewPswd(String pswd) throws InterruptedException {
        webActionHelperMethods.setTxtBoxString(pswd,passwd);
        webActionHelperMethods.setTxtBoxString(pswd,confirmPasswd);
    }

    public void clickProximoCadastro(){
        webActionHelperMethods.clickbutton(proximoBtnCadastro);
    }

    public String getProximoPswdBtnCssSelector() {
        return ".VfPpkd-LgbsSe-OWXEXe-k8QpJ > span:nth-child(3)";
    }
}

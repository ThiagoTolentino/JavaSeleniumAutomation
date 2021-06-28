package stepDefinition;

import Pages.HomePage;
import Pages.RegisterVerify;
import account.GoogleAccount;
import actionHelper.WebActionHelperMethods;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import util.Utility;

import java.util.Properties;

import static hooks.Hook.driver;

public class cadastroEmail {

    protected HomePage homePage;
    private WebActionHelperMethods webActionHelperMethods = new WebActionHelperMethods(driver);
    Properties properties;
    String URL;

    @Given("^Que eu abra o navegador$")
    public void abrirNavegador(){
        String propertyPath = System.getProperty("user.dir") + "//src//main//resources//Env.properties";
        webActionHelperMethods.MaximizeBrowser();
        try {
            properties = Utility.loadProperties(propertyPath);
            URL = properties.getProperty("URL_GOOGLE");

            homePage = new HomePage(driver);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver.get(URL);
        Assert.assertTrue("Erro ao abrir a página",
                webActionHelperMethods.VerifyObjectExists(homePage.getProximoPswdBtnCssSelector()));
    }

    @And("^Que eu preencha os dados de cadastro$")
    public void preencherDados() throws InterruptedException {
        Utility utility = new Utility();
        RegisterVerify registerVerify = new RegisterVerify();
        GoogleAccount googleAccount = new GoogleAccount();
        googleAccount.setUser(utility.geraStringAleatoria(8));
        googleAccount.setPasswd(utility.geraStringAleatoria(8));

        homePage.typeName(utility.geraStringAleatoria(5));
        homePage.typeLastName(utility.geraStringAleatoria(5));
        homePage.typeNewUser(googleAccount.getUser());
        homePage.typeNewPswd(googleAccount.getPasswd());
        homePage.clickProximoCadastro();
        Assert.assertTrue("Erro ao inserir dadados de cadastro",
                webActionHelperMethods.VerifyObjectExistsByID(registerVerify.getPhoneNumberID()));
    }
}

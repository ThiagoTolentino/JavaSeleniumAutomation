package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterVerify {
    @FindBy(id = "phoneNumberId")
    private WebElement phoneNumber;

    public String getPhoneNumberID() {
        return "phoneNumberId";
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authentification extends BasePage {

    @FindBy(id = "SubmitCreate")
    public WebElement CreateAccountButton;

    @FindBy(id = "email_create")
    public WebElement CreateEmailAddressField;

    @FindBy(id = "email")
    public WebElement RegisterEmailAddressField;

    @FindBy(id = "passwd")
    public WebElement RegisterPasswordField;

    @FindBy(id = "SubmitLogin")
    public WebElement SignInButton;

    @FindBy(xpath = "//div[@class= \"alert alert-danger\"]")
    public WebElement ErrorMessage;


    public Authentification(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAccountButton() {
        CreateAccountButton.click();
    }
    public void enterCreateEmailAddress(String email) {
        CreateEmailAddressField.sendKeys(email);
    }
    public void enterRegisterEmailAddress(String email) {
        RegisterEmailAddressField.sendKeys(email);
    }
    public void enterRegisterPassword(String password) {
        RegisterPasswordField.sendKeys(password);
    }
    public void clickSignInButton() {
        SignInButton.click();
    }


}

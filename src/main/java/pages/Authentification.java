package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Authentification extends BasePage {

    @FindBy(id = "SubmitCreate")
    private WebElement CreateAccountButton;

    @FindBy(id = "email_create")
    private WebElement CreateEmailAddressField;

    @FindBy(id = "email")
    private WebElement RegisterEmailAddressField;

    @FindBy(id = "passwd")
    private WebElement RegisterPasswordField;

    @FindBy(id = "SubmitLogin")
    private WebElement SignInButton;

    @FindBy(xpath = "//div[@class= \"alert alert-danger\"]")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = "")
    private WebElement invalidEmailErrorMessage;

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

    public WebElement getInvalidEmailErrorMessage()
    {
        return invalidEmailErrorMessage;
    }

    public WebElement getInvalidPasswordErrorMessage()
    {
        return invalidPasswordErrorMessage;
    }

    public WebElement getCreateAccountButton()
    {
        return CreateAccountButton;
    }
}

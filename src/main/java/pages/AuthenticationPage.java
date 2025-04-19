package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The authentication page where the user can connect into the website or create a new account
 */
public class AuthenticationPage extends BasePage
{
    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email_create")
    private WebElement createEmailAddressField;

    @FindBy(id = "email")
    private WebElement signInEmailAddressField;

    @FindBy(id = "passwd")
    private WebElement signInPasswordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class= \"alert alert-danger\"]")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(id = "create_account_error")
    private WebElement invalidEmailErrorMessage;

    @FindBy(xpath = "//p[@class=\"lost_password form-group\"]/a")
    private WebElement RecoverPasswordButton; // TODO Move to recover password page

    @FindBy(xpath = "//h1[@class=\"page-subheading\"]")
    private WebElement ForgottenPasswordText; // TODO Move to recover password page

    @FindBy(xpath = "//button[@class=\"btn btn-default button button-medium\"]")
    private WebElement RetrievePasswordButton; // TODO Move to recover password page

    @FindBy(xpath = "//p[@class=\"alert alert-success\"]")
    private WebElement SuccessMessage; // TODO Move to recover password page

    @FindBy(xpath = "//h1[text()='Authentication']")
    private WebElement authenticationTitle;

    public AuthenticationPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickCreateAccountButton()
    {
        createAccountButton.click();
    }

    public void enterCreateEmailAddress(String email)
    {
        createEmailAddressField.sendKeys(email);
    }

    public void enterSignInEmailAddress(String email)
    {
        signInEmailAddressField.sendKeys(email);
    }

    public void enterSignInPassword(String password)
    {
        signInPasswordField.sendKeys(password);
    }

    public void clickSignInButton()
    {
        signInButton.click();
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
        return createAccountButton;
    }

    public WebElement getSignInButton()
    {
        return signInButton;
    }

    public WebElement getRecoverPasswordButton()
    {
        return RecoverPasswordButton;
    }

    public WebElement getForgottenPasswordText()
    {
        return ForgottenPasswordText;
    }

    public WebElement getRetrievePasswordButton()
    {
        return RetrievePasswordButton;
    }

    public WebElement getSuccessMessage()
    {
        return SuccessMessage;
    }

    public WebElement getAuthenticationTitle()
    {
        return authenticationTitle;
    }
}

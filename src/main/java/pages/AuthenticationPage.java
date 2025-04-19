package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

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

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(id = "create_account_error")
    private WebElement invalidEmailErrorMessage;

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

    public WebElement getAuthenticationTitle()
    {
        return authenticationTitle;
    }

    public void connectNoAddressAccount()
    {
        connect("email-account-no-address", "password-account-no-address");
    }

    public void connectAddressesAccount()
    {
        connect("email-account-addresses", "password-account-addresses");
    }

    public void connect(String email, String password)
    {
        enterSignInEmailAddress(ConfigReader.getProperty(email));
        enterSignInPassword(ConfigReader.getProperty(password));
        clickSignInButton();
    }
}

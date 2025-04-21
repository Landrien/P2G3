package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

/**
 * The authentication page where the user can connect into the website or create a new account
 * This page provides fields for login credentials and error messages for invalid login attempts
 */
public class AuthenticationPage extends BasePage
{
    /**
     * Web elements on the authentication page.
     */
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

    /**
     * Constructor to initialize the authentication page.
     * @param driver The WebDriver used to interact with the browser.
     */
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

    /**
     * Logs in using a predefined account with no address.
     */
    public void connectNoAddressAccount()
    {
        connect("email-account-no-address", "password-account-no-address");
    }

    /**
     * Logs in using a predefined account with addresses.
     */
    public void connectAddressesAccount()
    {
        connect("email-account-addresses", "password-account-addresses");
    }

    /**
     * Signs in using the provided email and password.
     * @param email The email address used for login.
     * @param password The password used for login.
     */
    public void connect(String email, String password)
    {
        enterSignInEmailAddress(ConfigReader.getProperty(email));
        enterSignInPassword(ConfigReader.getProperty(password));
        clickSignInButton();
    }
}

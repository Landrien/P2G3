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

    @FindBy(xpath = "//div[@class= \"alert alert-danger\"]")
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

    /**
     * Clicks on the "Create Account" button to navigate to the account creation page.
     */
    public void clickCreateAccountButton()
    {
        createAccountButton.click();
    }


    /**
     * Enters the email address for account creation on the "Create Account" page.
     * @param email The email address to be entered for account creation.
     */
    public void enterCreateEmailAddress(String email)
    {
        createEmailAddressField.sendKeys(email);
    }

    /**
     * Enters the email address for sign-in on the authentication page.
     * @param email The email address to be entered for sign-in.
     */
    public void enterSignInEmailAddress(String email)
    {
        signInEmailAddressField.sendKeys(email);
    }


    /**
     * Enters the password for sign-in on the authentication page.
     * @param password The password to be entered for sign-in.
     */
    public void enterSignInPassword(String password)
    {
        signInPasswordField.sendKeys(password);
    }

    /**
     * Clicks the sign-in button to submit the login credentials.
     */
    public void clickSignInButton(){signInButton.click();}


    /**
     * Returns the WebElement representing the error message displayed when an invalid email is entered.
     * @return WebElement representing the invalid email error message.
     */

    public WebElement getInvalidEmailErrorMessage()
    {
        return invalidEmailErrorMessage;
    }

    /**
     * Returns the WebElement representing the error message displayed when an invalid password is entered.
     * @return WebElement representing the invalid password error message.
     */
    public WebElement getInvalidPasswordErrorMessage()
    {
        return invalidPasswordErrorMessage;
    }

    /**
     * Returns the WebElement representing the "Create Account" button.
     * @return WebElement representing the "Create Account" button.
     */
    public WebElement getCreateAccountButton()
    {
        return createAccountButton;
    }


    /**
     * Returns the WebElement representing the "Sign In" button.
     * @return WebElement representing the "Sign In" button.
     */
    public WebElement getSignInButton()
    {
        return signInButton;
    }

    /**
     * Returns the WebElement representing the title of the authentication page.
     * @return WebElement representing the authentication page title.
     */
    public WebElement getAuthenticationTitle()
    {
        return authenticationTitle;
    }

    /**
     * Signs in using the provided email and password.
     * @param email The email address used for login.
     * @param password The password used for login.
     */
    public void connect(String email, String password)
    {
        enterSignInEmailAddress(email);
        enterSignInPassword(password);
        clickSignInButton();
    }
}

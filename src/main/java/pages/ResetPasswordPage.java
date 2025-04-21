package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The reset password page where the user can send a reset link via email
 */
public class ResetPasswordPage extends BasePage
{
    /**
     * Constructor to initialize the reset password page.
     * @param driver The WebDriver used to interact with the browser.
     */
    public ResetPasswordPage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Web elements on the reset password page.
     */
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//h1[@class='page-subheading']")
    private WebElement forgotPasswordTitle;

    @FindBy(xpath = "//button[@class='btn btn-default button button-medium']")
    private WebElement retrievePasswordButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement retrievePasswordConfirmationMessage;

    /**
     * Clicks the "Forgot Password" button to navigate to the reset password section.
     */
    public void clickForgotPasswordButton()
    {
        forgotPasswordButton.click();
    }

    /**
     * Returns the title element of the "Forgot Password" section.
     * @return WebElement representing the "Forgot Password" title.
     */
    public WebElement getForgotPasswordTitle()
    {
        return forgotPasswordTitle;
    }

    /**
     * Clicks the "Retrieve Password" button to submit the password reset request.
     */
    public void clickRetrievePasswordButton()
    {
        retrievePasswordButton.click();
    }

    /**
     * Returns the confirmation message displayed after successfully submitting the password retrieval request.
     * @return WebElement representing the confirmation message.
     */
    public WebElement getRetrievePasswordConfirmationMessage()
    {
        return retrievePasswordConfirmationMessage;
    }

    /**
     * Returns the email field element where users can enter their email address for password retrieval.
     * @return WebElement representing the email field.
     */
    public WebElement getEmailField() {
        return emailField;
    }
}

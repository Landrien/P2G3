package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The reset password page where the user can send a reset link via email
 */
public class ResetPasswordPage extends BasePage
{
    public ResetPasswordPage(WebDriver driver)
    {
        super(driver);
    }

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

    public void clickForgotPasswordButton()
    {
        forgotPasswordButton.click();
    }

    public WebElement getForgotPasswordTitle()
    {
        return forgotPasswordTitle;
    }

    public void clickRetrievePasswordButton()
    {
        retrievePasswordButton.click();
    }

    public WebElement getRetrievePasswordConfirmationMessage()
    {
        return retrievePasswordConfirmationMessage;
    }

    public WebElement getEmailField() {
        return emailField;
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends BasePage {

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

    public AuthenticationPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
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
}

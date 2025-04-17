package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage
{
    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "")
    private WebElement genderTitleSelect;

    @FindBy(xpath = "")
    private WebElement firstNameField;

    @FindBy(xpath = "")
    private WebElement lastNameField;

    @FindBy(xpath = "")
    private WebElement emailAddressField;

    @FindBy(xpath = "")
    private WebElement passwordField;

    @FindBy(xpath = "")
    private WebElement registerButton;

    @FindBy(xpath = "")
    private WebElement invalidEmailMessage;

    @FindBy(xpath = "")
    private WebElement invalidPasswordMessage;

    public void selectGenderTitle(boolean isMale)
    {

    }

    public void enterFirstName(String firstName)
    {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName)
    {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmailAddress(String email)
    {
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
    }

    public void enterPassword(String password)
    {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton()
    {
        registerButton.click();
    }

    public WebElement getInvalidEmailMessage()
    {
        return invalidEmailMessage;
    }

    public WebElement getInvalidPasswordMessage()
    {
        return invalidPasswordMessage;
    }
}

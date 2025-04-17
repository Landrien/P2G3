package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage
{
    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='id_gender1']")
    private WebElement maleGenderRadioSelect;

    @FindBy(xpath = "//label[@for='id_gender2']")
    private WebElement femaleGenderRadioSelect;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailAddressField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(xpath = "//b[text()='email']")
    private WebElement invalidEmailMessage;

    @FindBy(xpath = "//b[text()='passwd']")
    private WebElement invalidPasswordMessage;

    @FindBy(id = "newsletter")
    private WebElement newsletterSignUpCheckbox;

    @FindBy(id = "years")
    private WebElement birthDateYearSelect;
    @FindBy(id = "months")
    private WebElement birthDateMonthSelect;
    @FindBy(id = "days")
    private WebElement birthDateDaySelect;

    public void selectGenderTitle(boolean isMale)
    {
        if (isMale == true)
            maleGenderRadioSelect.click();
        else
            femaleGenderRadioSelect.click();
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

    public void clickNewsletterSignUpCheckbox()
    {
        // TODO
    }

    public void selectBirthDateDay(String day)
    {
        selectValue(day, birthDateDaySelect);
    }
    public void selectBirthDateMonth(String month)
    {
        selectValue(month, birthDateMonthSelect);
    }
    public void selectBirthDateYear(String year)
    {
        selectValue(year, birthDateYearSelect);
    }

    private void selectValue(String value, WebElement element)
    {
        Select select = new Select(element);
        select.selectByValue(value);
    }
}

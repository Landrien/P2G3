package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * The create account page where the user can enter his info to register into the website
 */
public class CreateAccountPage extends BasePage
{
    /**
     * Constructor that initializes the CreateAccountPage with the provided WebDriver.
     * @param driver The WebDriver instance used to interact with the page.
     */
    public CreateAccountPage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Web elements on the create account page.
     */
    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement createAccountTitle;

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

    @FindBy(className = "alert-danger")
    private WebElement errorBox;

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

    /**
     * Selects gender title based on the boolean value.
     * @param isMale True if male, false if female.
     */
    public void selectGenderTitle(boolean isMale)
    {
        if (isMale == true)
            maleGenderRadioSelect.click();
        else
            femaleGenderRadioSelect.click();
    }

    /**
     * Enters the first name into the first name field on the create account page.
     * @param firstName The first name to be entered.
     */
    public void enterFirstName(String firstName)
    {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    /**
     * Enters the last name into the last name field on the create account page.
     * @param lastName The last name to be entered.
     */
    public void enterLastName(String lastName)
    {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    /**
     * Enters the email address into the email field on the create account page.
     * @param email The email address to be entered.
     */
    public void enterEmailAddress(String email)
    {
        emailAddressField.clear();
        emailAddressField.sendKeys(email);
    }

    /**
     * Enters the password into the password field on the create account page.
     * @param password The password to be entered.
     */
    public void enterPassword(String password)
    {
        passwordField.clear();
        passwordField.sendKeys(password);
    }


    /**
     * Clicks on the register button to submit the registration form.
     */
    public void clickRegisterButton()
    {
        registerButton.click();
    }

    /**
     * Returns the WebElement representing the invalid email message displayed on the page.
     * @return WebElement representing the invalid email message.
     */
    public WebElement getInvalidEmailMessage()
    {
        return invalidEmailMessage;
    }

    /**
     * Returns the WebElement representing the invalid password message displayed on the page.
     * @return WebElement representing the invalid password message.
     */
    public WebElement getInvalidPasswordMessage()
    {
        return invalidPasswordMessage;
    }

    /**
     * Clicks on the newsletter sign-up checkbox to enable or disable newsletter subscription.
     */
    public void clickNewsletterSignUpCheckbox()
    {
        newsletterSignUpCheckbox.click();
    }


    /**
     * Selects the day of birth from the dropdown.
     * @param day The day of birth to be selected.
     */
    public void selectBirthDateDay(String day)
    {
        selectValue(day, birthDateDaySelect);
    }


    /**
     * Selects the month of birth from the dropdown.
     * @param month The month of birth to be selected.
     */
    public void selectBirthDateMonth(String month)
    {
        selectValue(month, birthDateMonthSelect);
    }

    /**
     * Selects the year of birth from the dropdown.
     * @param year The year of birth to be selected.
     */
    public void selectBirthDateYear(String year)
    {
        selectValue(year, birthDateYearSelect);
    }


    /**
     * Method to select a value in a dropdown element.
     * @param value The value to be selected in the select element (day,month,year).
     * @param element The WebElement representing the select HTML element.
     */
    private void selectValue(String value, WebElement element)
    {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Returns the WebElement representing the error box that displays validation messages.
     * @return WebElement representing the error box.
     */
    public WebElement getErrorBox()
    {
        return errorBox;
    }


    /**
     * Returns the WebElement representing the title "Create an account" on the page.
     * @return WebElement representing the account creation title.
     */
    public WebElement getCreateAccountTitle()
    {
        return createAccountTitle;
    }
}

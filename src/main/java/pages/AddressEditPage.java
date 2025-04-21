package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utils.AddressJsonUtils.getAddressElement;

/**
 * Represents the address edit page (for creating or updating an address) in the user's account.
 */
public class AddressEditPage extends BasePage
{
    public static final String pageUrlId = "controller=address";

    // ---------- WebElements ----------

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "address1")
    private WebElement addressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement postalCodeField;

    @FindBy(id = "id_country")
    private WebElement countrySelect;

    @FindBy(id = "phone")
    private WebElement homePhoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "alias")
    private WebElement addressTitleField;

    @FindBy(id = "submitAddress")
    private WebElement validateAddressButton;

    // ---------- Constructor ----------

    /**
     * Constructor for the AddressEditPage.
     *
     * @param driver the WebDriver instance used for automation.
     */
    public AddressEditPage(WebDriver driver)
    {
        super(driver);
    }

    // ---------- Field Actions ----------

    /**
     * Clicks the save button to submit the address form.
     */
    public void clickValidateAddressButton()
    {
        validateAddressButton.click();
    }

    /**
     * Fills in the first name field.
     *
     * @param value the first name to enter.
     */
    public void enterFirstNameField(String value)
    {
        firstNameField.clear();
        firstNameField.sendKeys(value);
    }

    /**
     * Fills in the last name field.
     *
     * @param value the last name to enter.
     */
    public void enterLastNameField(String value)
    {
        lastNameField.clear();
        lastNameField.sendKeys(value);
    }

    /**
     * Fills in the street address field.
     *
     * @param value the address to enter.
     */
    public void enterAddressField(String value)
    {
        addressField.clear();
        addressField.sendKeys(value);
    }

    /**
     * Fills in the city field.
     *
     * @param value the city to enter.
     */
    public void enterCityField(String value)
    {
        cityField.clear();
        cityField.sendKeys(value);
    }

    /**
     * Selects a state by its visible text.
     *
     * @param text the visible state name.
     */
    public void selectState(String text)
    {
        Select select = new Select(stateSelect);
        select.selectByVisibleText(text);
    }

    /**
     * Fills in the postal code field.
     *
     * @param value the postal code to enter.
     */
    public void enterPostalCodeField(String value)
    {
        postalCodeField.clear();
        postalCodeField.sendKeys(value);
    }

    /**
     * Selects a country by its visible text.
     *
     * @param text the visible country name.
     */
    public void selectCountry(String text)
    {
        Select select = new Select(countrySelect);
        select.selectByVisibleText(text);
    }

    /**
     * Fills in the home phone field.
     *
     * @param value the phone number to enter.
     */
    public void enterHomePhoneField(String value)
    {
        homePhoneField.clear();
        homePhoneField.sendKeys(value);
    }

    /**
     * Fills in the mobile phone field.
     *
     * @param value the mobile phone number to enter.
     */
    public void enterMobilePhoneField(String value)
    {
        mobilePhoneField.clear();
        mobilePhoneField.sendKeys(value);
    }

    /**
     * Fills in the address alias field.
     *
     * @param value the alias to enter.
     */
    public void enterAddressTitleField(String value)
    {
        addressTitleField.clear();
        addressTitleField.sendKeys(value);
    }

    // ---------- Auto-fill with JSON data ----------

    /**
     * Fills in all address fields using data from the given address key in the JSON file.
     *
     * @param addressKey the key used to retrieve address data from the JSON.
     */
    public void enterAddressInfo(String addressKey)
    {
        enterFirstNameField(getAddressElement(addressKey, "first_name"));
        enterLastNameField(getAddressElement(addressKey, "last_name"));
        enterAddressField(getAddressElement(addressKey, "address"));
        enterCityField(getAddressElement(addressKey, "city"));
        selectState(getAddressElement(addressKey, "state"));
        enterPostalCodeField(getAddressElement(addressKey, "postal_code"));
        enterHomePhoneField(getAddressElement(addressKey, "home_phone"));
        enterMobilePhoneField(getAddressElement(addressKey, "mobile_phone"));
        enterAddressTitleField(getAddressElement(addressKey, "title"));
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * The address page where the user can modify the info for an existing or new address
 */
public class AddressEditPage extends BasePage
{
    /**
     * URL identifier for the address page.
     */
    public static final String pageUrlId = "controller=address";

    /**
     * Web elements on the address edit page.
     */
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


    /**
     * Constructor to initialize the address edit page.
     * @param driver The WebDriver used to interact with the browser.
     */
    public AddressEditPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickValidateAddressButton()
    {
        validateAddressButton.click();
    }

    /**
     * Enters the first name into the corresponding field.
     * @param value The first name to enter.
     */
    public void enterFirstNameField(String value)
    {
        firstNameField.clear();
        firstNameField.sendKeys(value);
    }

    public void enterLastNameField(String value)
    {
        lastNameField.clear();
        lastNameField.sendKeys(value);
    }

    public void enterAddressField(String value)
    {
        addressField.clear();
        addressField.sendKeys(value);
    }

    public void enterCityField(String value)
    {
        cityField.clear();
        cityField.sendKeys(value);
    }

    public void selectState(String text)
    {
        Select select = new Select(stateSelect);
        select.selectByVisibleText(text);
    }

    public void enterPostalCodeField(String value)
    {
        postalCodeField.clear();
        postalCodeField.sendKeys(value);
    }

    public void selectCountry(String text)
    {
        Select select = new Select(countrySelect);
        select.selectByVisibleText(text);
    }

    public void enterHomePhoneField(String value)
    {
        homePhoneField.clear();
        homePhoneField.sendKeys(value);
    }

    public void enterMobilePhoneField(String value)
    {
        mobilePhoneField.clear();
        mobilePhoneField.sendKeys(value);
    }

    public void enterAddressTitleField(String value)
    {
        addressTitleField.clear();
        addressTitleField.sendKeys(value);
    }
}

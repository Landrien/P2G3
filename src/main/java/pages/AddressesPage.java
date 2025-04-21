package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The my addresses page available from the my account page where the user can view, modify and add delivery and invoice addresses
 */
public class AddressesPage extends BasePage
{
    /**
     *  URL identifier for the addresses page
     */
    public static final String pageUrlId = "controller=addresses";


    /**
     * Web elements on the addresses page.
     */
    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement addAddressButton;

    @FindBy(xpath = "//a[@title='Update']")
    private WebElement updateAddressButton;

    /**
     * Constructor to initialize the addresses page.
     * @param driver The WebDriver used to interact with the browser.
     */
    public AddressesPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickAddAddressButton()
    {
        addAddressButton.click();
    }

    public void clickUpdateAddressButton()
    {
        updateAddressButton.click();
    }

    /**
     * @return WebElement for the 'Add Address' button.
     */
    public WebElement getAddAddressButton()
    {
        return addAddressButton;
    }

    /**
     * @return WebElement for the 'Update Address' button.
     */
    public WebElement getUpdateAddressButton()
    {
        return updateAddressButton;
    }
}

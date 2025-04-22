package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The my account page where the user can access multiple pages to manage his account
 */
public class AccountPage extends BasePage
{
    /**
     * Constructor to initialize the account page.
     * @param driver The WebDriver used to interact with the browser.
     */
    public AccountPage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Web elements on the account page.
     */
    @FindBy(className = "alert-success")
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//span[text()='Add my first address']/..")
    private WebElement addMyFirstAddressButton;

    @FindBy(xpath = "//span[text()='Order history and details']/..")
    private WebElement orderHistoryButton;

    @FindBy(xpath = "//span[text()='My credit slips']/..")
    private WebElement creditSlipsButton;

    @FindBy(xpath = "//span[text()='My addresses']/..")
    private WebElement myAddressesButton;

    @FindBy(xpath = "//span[text()='My personal information']/..")
    private WebElement personalInformationButton;

    /**
     * Returns the success message after account creation.
     * @return WebElement for the success message.
     */
    public WebElement getAccountCreatedMessage()
    {
        return accountCreatedMessage;
    }

    // ---------- Page Actions ----------

    /**
     * Clicks the "Add my first address" button to add a first address.
     */
    public void clickAddMyFirstAddressButton()
    {
        addMyFirstAddressButton.click();
    }

    /**
     * Clicks the "Order history and details" button to view the order history.
     */
    public void clickOrderHistoryButton()
    {
        orderHistoryButton.click();
    }

    /**
     * Clicks the "My credit slips" button to access credit notes.
     */
    public void clickCreditSlipsButton()
    {
        creditSlipsButton.click();
    }

    /**
     * Clicks the "My addresses" button to view saved addresses.
     */
    public void clickMyAddressesButton()
    {
        myAddressesButton.click();
    }

    /**
     * Clicks the "My personal information" button to edit personal details.
     */
    public void clickPersonalInformationButton()
    {
        personalInformationButton.click();
    }
}

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

    public void clickAddMyFirstAddressButton()
    {
        addMyFirstAddressButton.click();
    }

    public void clickOrderHistoryButton()
    {
        orderHistoryButton.click();
    }

    public void clickCreditSlipsButton()
    {
        creditSlipsButton.click();
    }

    public void clickMyAddressesButton()
    {
        myAddressesButton.click();
    }

    public void clickPersonalInformationButton()
    {
        personalInformationButton.click();
    }
}

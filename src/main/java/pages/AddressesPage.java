package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The my addresses page available from the my account page where the user can view, modify and add delivery and invoice addresses
 */
public class AddressesPage extends BasePage
{
    public static final String pageUrlId = "controller=addresses";

    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement addAddressButton;

    @FindBy(xpath = "//a[@title='Update']")
    private WebElement updateAddressButton;

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

    public WebElement getAddAddressButton()
    {
        return addAddressButton;
    }

    public WebElement getUpdateAddressButton()
    {
        return updateAddressButton;
    }
}

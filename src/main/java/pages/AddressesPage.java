package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * The my addresses page available from the my account page where the user can view, modify and add delivery and invoice addresses
 */
public class AddressesPage extends BasePage
{
    /**
     * URL identifier for the address page.
     */
    public static final String pageUrlId = "controller=addresses";

    /**
     * Web elements on the address page.
     */
    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement addAddressButton;

    @FindBy(xpath = "//a[@title='Update']")
    private WebElement updateAddressButton;

    /**
     * Constructor to initialize the address page.
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
     * Method to delete all addresses on the page
     */
    public void deleteAddresses()
    {
        boolean shouldDelete = false;
        do
        {
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[@title='Delete']"));
            shouldDelete = deleteButtons.isEmpty() == false;

            if (shouldDelete == true)
            {
                deleteButtons.get(0).click();
                acceptDeletePopup();
            }
        }
        while (shouldDelete == true);
    }

    /**
     * Method to accept the delete confirmation popup
     */
    private void acceptDeletePopup()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

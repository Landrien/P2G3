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
    public static final String pageUrlId = "controller=addresses";

    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement addAddressButton;

    @FindBy(xpath = "//a[@title='Update']")
    private WebElement updateAddressButton;

    /**
     * Constructor that passes the WebDriver instance to the parent BasePage.
     *
     * @param driver the WebDriver used for browser interaction
     */
    public AddressesPage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Clicks the button to add a new address.
     */
    public void clickAddAddressButton()
    {
        addAddressButton.click();
    }

    /**
     * Clicks the button to update an existing address.
     */
    public void clickUpdateAddressButton()
    {
        updateAddressButton.click();
    }

    /**
     * Deletes all the addresses present on the page one by one.
     * It keeps clicking the first delete button until none are left.
     */
    public void deleteAddresses()
    {
        boolean shouldDelete = false;
        do
        {
            // Find all delete buttons currently on the page
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[@title='Delete']"));
            shouldDelete = deleteButtons.isEmpty() == false;

            // If at least one delete button is found, click the first one and confirm deletion
            if (shouldDelete == true)
            {
                deleteButtons.get(0).click();
                acceptDeletePopup();
            }
        }
        while (shouldDelete == true);
    }

    /**
     * Waits for the browser's confirmation alert to appear, and accepts it.
     */
    private void acceptDeletePopup()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

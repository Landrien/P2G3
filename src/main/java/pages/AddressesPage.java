package pages;

import org.openqa.selenium.WebDriver;

/**
 * The my addresses page available from the my account page where the user can view, modify and add delivery and invoice addresses
 */
public class AddressesPage extends BasePage
{
    public static final String pageUrlId = "controller=addresses";

    public AddressesPage(WebDriver driver)
    {
        super(driver);
    }
}

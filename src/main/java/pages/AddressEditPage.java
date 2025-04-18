package pages;

import org.openqa.selenium.WebDriver;

/**
 * The address page where the user can modify the info for an existing or new address
 */
public class AddressEditPage extends BasePage
{
    public static final String pageUrlId = "controller=address";

    public AddressEditPage(WebDriver driver)
    {
        super(driver);
    }
}

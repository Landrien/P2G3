package pages;

import org.openqa.selenium.WebDriver;

/**
 * The shopping cart summary page where the user can see the articles added to his cart
 */
public class CartPage extends BasePage
{
    public static final String pageUrlId = "controller=order";

    public CartPage(WebDriver driver)
    {
        super(driver);
    }
}

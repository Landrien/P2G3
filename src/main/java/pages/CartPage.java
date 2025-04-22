package pages;

import org.openqa.selenium.WebDriver;

/**
 * The shopping cart summary page where the user can see the articles added to his cart
 */
public class CartPage extends BasePage
{

    /**
     *  URL identifier for the cart page
     */
    public static final String pageUrlId = "controller=order";

    /**
     * Constructor that initializes the cart page with the given WebDriver.
     * @param driver The WebDriver instance used to interact with the cart page.
     */
    public CartPage(WebDriver driver)
    {
        super(driver);
    }
}

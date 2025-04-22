package pages;

import org.openqa.selenium.WebDriver;

/**
 * The order history page where the user can see his previous orders
 */
public class OrderHistoryPage extends BasePage
{
    /**
     * The URL part for the order history page
     */
    public static final String pageUrlId = "controller=history";

    /**
     * Constructor to initialize the order history page.
     * @param driver The WebDriver used to interact with the browser.
     */
    public OrderHistoryPage(WebDriver driver)
    {
        super(driver);
    }
}

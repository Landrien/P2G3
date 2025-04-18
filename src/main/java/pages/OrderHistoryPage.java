package pages;

import org.openqa.selenium.WebDriver;

/**
 * The order history page where the user can see his previous orders
 */
public class OrderHistoryPage extends BasePage
{
    public static final String pageUrlId = "controller=history";

    public OrderHistoryPage(WebDriver driver)
    {
        super(driver);
    }
}

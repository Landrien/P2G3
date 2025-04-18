package pages;

import org.openqa.selenium.WebDriver;

/**
 * The contact us page allowing the user to send a message to customer service
 */
public class ContactPage extends BasePage
{
    private static String pageUrlId = "controller=contact";

    public ContactPage(WebDriver driver)
    {
        super(driver);
    }

    public static String getPageUrlId()
    {
        return pageUrlId;
    }
}

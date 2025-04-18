package pages;

import org.openqa.selenium.WebDriver;

/**
 * The contact us page allowing the user to send a message to customer service
 */
public class ContactPage extends BasePage
{
    public static final String pageUrlId = "controller=contact";

    public ContactPage(WebDriver driver)
    {
        super(driver);
    }
}

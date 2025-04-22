package pages;

import org.openqa.selenium.WebDriver;

/**
 * The contact us page allowing the user to send a message to customer service
 */
public class ContactPage extends BasePage
{
    /**
     * URL identifier for the contact page.
     */
    public static final String pageUrlId = "controller=contact";


    /**
     * Constructor that initializes the contact page with the given WebDriver.
     * @param driver The WebDriver instance used to interact with the page.
     */
    public ContactPage(WebDriver driver)
    {
        super(driver);
    }
}

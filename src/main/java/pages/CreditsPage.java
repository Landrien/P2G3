package pages;

import org.openqa.selenium.WebDriver;

/**
 * The credit slips page where the user can see his received slips for canceled orders
 */
public class CreditsPage extends BasePage
{
    /**
     * URL identifier for the credits page
     */
    public static final String pageUrlId = "controller=order-slip";

    /**
     * Constructor to initialize the CreditsPage.
     *
     * @param driver The WebDriver used to interact with the browser.
     */
    public CreditsPage(WebDriver driver)
    {
        super(driver);
    }
}

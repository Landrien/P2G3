package pages;

import org.openqa.selenium.WebDriver;

/**
 * The personal information page where the user can modify his info
 */
public class AccountInfoPage extends BasePage
{
    /**
     *  URL identifier for the account info page.
     */
    public static final String pageUrlId = "controller=identity";

    /**
     * Constructor to initialize the personal information page.
     * @param driver the WebDriver used to interact with the browser.
     */
    public AccountInfoPage(WebDriver driver)
    {
        super(driver);
    }
}

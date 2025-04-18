package pages;

import org.openqa.selenium.WebDriver;

/**
 * The credit slips page where the user can see his received slips for canceled orders
 */
public class CreditsPage extends BasePage
{
    public static final String pageUrlId = "controller=order-slip";

    public CreditsPage(WebDriver driver)
    {
        super(driver);
    }
}

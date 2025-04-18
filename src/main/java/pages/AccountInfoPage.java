package pages;

import org.openqa.selenium.WebDriver;

/**
 * The personal information page where the user can modify his info
 */
public class AccountInfoPage extends BasePage
{
    public static final String pageUrlId = "controller=identity";

    public AccountInfoPage(WebDriver driver)
    {
        super(driver);
    }
}

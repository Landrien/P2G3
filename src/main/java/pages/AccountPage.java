package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The my account page where the user can access multiple pages to manage his account
 */
public class AccountPage extends BasePage
{
    public AccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(className = "alert alert-success")
    private WebElement accountCreatedMessage;

    public WebElement getAccountCreatedMessage()
    {
        return accountCreatedMessage;
    }
}

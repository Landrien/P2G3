package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The header part of any page on the website containing the logo, search bar, cart and connexion links
 */
public class HeaderPage extends BasePage
{
    @FindBy(xpath = "//a[@class= \"logout\"]")
    public WebElement SignOutButton;

    @FindBy(xpath = "//a[@class= \"login\"]")
    public WebElement SignInButton;

    @FindBy(xpath = "//div[@class= \"header_user_info\"]")
    public WebElement SignButton;

    @FindBy(xpath = "//a[@class= \"account\"]")
    public WebElement AccountButton;

    @FindBy(xpath = "//a[@title= \"My Shop\"]")
    public WebElement HomePageButton;

    public HeaderPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickSignOutButton() {
        SignOutButton.click();
    }
    public void clickSignInButton() {
        SignInButton.click();
    }
    public void clickLogoButton() {
        HomePageButton.click();
    }
}

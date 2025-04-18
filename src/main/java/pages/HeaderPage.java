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
    private WebElement signOutButton;

    @FindBy(xpath = "//a[@class= \"login\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class= \"header_user_info\"]")
    private WebElement userAccountButton;
    @FindBy(xpath = "//a[@class= \"account\"]")
    private WebElement clickableUserAccountButton;

    @FindBy(xpath = "//a[@title = 'Contact us']")
    private WebElement contactUs;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement homePageLogoButton;

    public HeaderPage(WebDriver driver)
    {
        super(driver);
    }

    public void clickSignOutButton()
    {
        signOutButton.click();
    }
    public void clickSignInButton()
    {
        signInButton.click();
    }

    public void clickLogoButton()
    {
        homePageLogoButton.click();
    }

    public void clickContactUs()
    {
        contactUs.click();
    }

    public WebElement getSignInButton()
    {
        return signInButton;
    }

    public WebElement getSignOutButton()
    {
        return signOutButton;
    }

    public WebElement getUserAccountButton()
    {
        return userAccountButton;
    }
}

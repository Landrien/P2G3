package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//a[@title='My Shop']")
    private WebElement homePageLogoButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement cartLogoButton;

    private SearchBarPage searchBarPage;

    public HeaderPage(WebDriver driver)
    {
        super(driver);
        searchBarPage = new SearchBarPage(driver);
    }

    public void clickCartLogo()
    {
        cartLogoButton.click();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(homePageLogoButton));

        homePageLogoButton.click();
    }

    public void clickContactUs()
    {
        contactUs.click();
    }

    public void clickUserAccountButton()
    {
        clickableUserAccountButton.click();
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

    public SearchBarPage getSearchBarPage()
    {
        return searchBarPage;
    }
}

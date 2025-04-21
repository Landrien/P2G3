package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The header part of any page on the website containing the logo, search bar, cart and connexion links
 */
public class HeaderPage extends BasePage
{
    /**
     * Web elements on the header
     */
    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOutButton;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='header_user_info']")
    private WebElement userAccountButton;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement clickableUserAccountButton;

    @FindBy(xpath = "//a[@title='Contact us']")
    private WebElement contactUsButton;

    @FindBy(xpath = "//a[@title='My Shop']")
    private WebElement homePageLogoButton;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement cartLogoButton;

    private SearchBarPageElement searchBarPageElement;

    /**
     * Constructor to initialize the HeaderPage and its components.
     * @param driver WebDriver used to interact with the browser.
     */
    public HeaderPage(WebDriver driver)
    {
        super(driver);
        searchBarPageElement = new SearchBarPageElement(driver);
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
        homePageLogoButton.click();
    }

    public void clickContactUsButton()
    {
        contactUsButton.click();
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

    /**
     * Returns the search bar component used to search for products.
     */
    public SearchBarPageElement getSearchBarPage()
    {
        return searchBarPageElement;
    }
}

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
    /**
     * Web elements on the header
     */
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

    @FindBy(xpath = "//div[@id='header_logo']/*")
    private WebElement homePageLogoButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement cartLogoButton;

    private SearchBarPage searchBarPage;


    /**
     * Constructor to initialize the HeaderPage and its components.
     * @param driver driver WebDriver used to interact with the browser
     */
    public HeaderPage(WebDriver driver)
    {
        super(driver);
        searchBarPage = new SearchBarPage(driver);
    }

    /**
     * Clicks on the shopping cart logo to navigate to the shopping cart page.
     */
    public void clickCartLogo()
    {
        cartLogoButton.click();
    }


    /**
     * Clicks on the sign-out button to log the user out.
     */
    public void clickSignOutButton()
    {
        signOutButton.click();
    }


    /**
     * Clicks on the sign-in button to navigate to the login page.
     */
    public void clickSignInButton()
    {
        signInButton.click();
    }

    /**
     * Clicks on the home page logo to navigate back to the homepage.
     */
    public void clickLogoButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (int i = 0; i < 3; i++) {
            try {
                WebElement logoElement = wait.until(ExpectedConditions.elementToBeClickable(homePageLogoButton));
                logoElement.click();
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Stale element - retrying click on logo (" + (i + 1) + "/3)");
            }
        }
        }

    public WebElement getLogoButton()
    {
        return homePageLogoButton;
    }


    /**
     * Clicks on the contact us link to navigate to the contact page.
     */
    public void clickContactUs()
    {
        contactUs.click();
    }

    /**
     * Clicks on the user account button to view the user account details.
     */
    public void clickUserAccountButton()
    {
        clickableUserAccountButton.click();
    }

    /**
     * Returns the sign-in button WebElement.
     * @return WebElement of the sign-in button
     */
    public WebElement getSignInButton()
    {
        return signInButton;
    }


    /**
     * Returns the sign-out button WebElement.
     * @return WebElement of the sign-out button
     */
    public WebElement getSignOutButton()
    {
        return signOutButton;
    }


    /**
     * Returns the user account button WebElement.
     * @return WebElement of the user account button
     */
    public WebElement getUserAccountButton()
    {
        return userAccountButton;
    }

    /**
     * Returns the search bar component used to search for products.
     */
    public SearchBarPage getSearchBarPage()
    {
        return searchBarPage;
    }
}

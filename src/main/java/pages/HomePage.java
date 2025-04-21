package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The home page of the application, this is where the user lands when accessing the website url
 */
public class HomePage extends BasePage
{
    /**
     * Web elements on the homepage.
     */
    @FindBy(xpath = "//a[@class='homefeatured']")
    private WebElement popularButton;

    @FindBy(xpath = "//a[@title='Blog']")
    private WebElement blogTab;

    @FindBy(id = "homepage-slider")
    private WebElement featuredAd;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenTab;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesTab;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[3]/a")
    private WebElement tshirtsTab;

    /**
     * Constructor to initialize the HomePage with the given WebDriver.
     * @param driver The WebDriver used to interact with the browser.
     */
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Clicks on the blog tab to navigate to the blog section.
     */
    public void clickBlogTab()
    {
        blogTab.click();
    }

    /**
     * Clicks on the featured advertisement section.
     */
    public void clickFeaturedAd()
    {
        featuredAd.click();
    }


    /**
     * Clicks on the blog tab to navigate to the blog section
     * @param tabName The name of the tab to click
     */
    public void clickOnCategoryTab(String tabName)
    {
        switch (tabName.toLowerCase())
        {
            case "women":
                womenTab.click();
                break;
            case "dresses":
                dressesTab.click();
                break;
            case "t-shirts":
            case "tshirts":
                tshirtsTab.click();
                break;
            default:
                throw new IllegalArgumentException("Unknown tab: " + tabName);
        }
    }

    public WebElement getPopularButton()
    {
        return popularButton;
    }
}

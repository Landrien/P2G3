package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@title='Blog']")
    private WebElement blogTab;

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(xpath = "//a[@title = 'Contact us']")
    private WebElement contactUs;

    @FindBy(id="homepage-slider")
    private WebElement featuredAd;


    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenTab;

    @FindBy(xpath = "//a[@title='Dresses']")
    private WebElement dressesTab;


    @FindBy(xpath = "//a[@title='T-shirts']")
    private WebElement tshirtsTab;


    public void clickBlogTab() {
        blogTab.click();
    }

    public void clickSignIn() {
        signInLink.click();
    }

    public void clickContactUs() {
        contactUs.click();
    }

    public void clickFeaturedAd() {
        featuredAd.click();
    }

    public void clickOnCategoryTab(String tabName) {
        switch (tabName.toLowerCase()) {
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
}





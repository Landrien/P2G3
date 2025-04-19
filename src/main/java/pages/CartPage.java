package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * The shopping cart summary page where the user can see the articles added to his cart
 */
public class CartPage extends BasePage
{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement cart_logo;


    public void clickCartLogo() {
        cart_logo.click();
    }
}

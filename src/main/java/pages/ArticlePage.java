package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The article page with all the details regarding a specific product.
 * Extends BasePage to inherit shared behavior and WebDriver support.
 */
public class ArticlePage extends BasePage
{
    /**
     * Constructor to initialize the article page.
     * @param driver The WebDriver used to interact with the browser.
     */
    public ArticlePage(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Web element representing the product title on the article page.
     */

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productTitle;


    /**
     * Retrieves the product title from the article page.
     * @return The product title
     */
    public String getProductTitle()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }
}

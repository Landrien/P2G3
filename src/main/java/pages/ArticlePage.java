package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The article page with all the details regarding a specific product
 */
public class ArticlePage extends BasePage
{
    public ArticlePage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productTitle;

    public String getProductTitle()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }
}

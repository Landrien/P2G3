package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * The search results page where multiple articles are listed after a search
 */
public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_query_top")
    private WebElement search_field;


    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//li[contains(@class, 'ac_even')]")
    private List<WebElement> searchSuggestions;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productTitle;


    public void clickSearchButton() {
        searchButton.click();
    }

    public void enter_element(String article) {
        search_field.sendKeys(article);
    }

    public WebElement getSearchField() {
        return search_field;
    }

    public List<WebElement> getSearchSuggestions() {
        return searchSuggestions;
    }

    public void clickOnSuggestion(String suggestionText) {
        for (WebElement suggestion : searchSuggestions) {
            if (suggestion.getText().contains(suggestionText)) {
                suggestion.click();
                break;
            }
        }
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public String getProductTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }
}





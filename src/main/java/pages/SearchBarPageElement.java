package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchBarPageElement extends BasePage
{
    /**
     * Constructor to initialize the search bar.
     * @param driver The WebDriver used to interact with the browser.
     */
    public SearchBarPageElement(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Web elements on the search bar page.
     */
    @FindBy(id = "search_query_top")
    private WebElement searchField;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//li[contains(@class, 'ac_even')]")
    private List<WebElement> searchSuggestions;

    public void clickSearchButton()
    {
        searchButton.click();
    }

    public void enterSearchText(String text)
    {
        searchField.clear();
        searchField.sendKeys(text);
    }

    public WebElement getSearchField()
    {
        return searchField;
    }

    public void clickSearchField()
    {
        searchField.click();
    }

    /**
     * List of search suggestions shown when a user starts typing in the search field
     * @return A list of WebElements representing the search suggestions.
     */
    public List<WebElement> getSearchSuggestions()
    {
        return searchSuggestions;
    }

    /**
     * Clicks on a specific search suggestion.
     * The suggestion is selected if its text contains the provided suggestion text.
     * @param suggestionText The text to search for among the search suggestions.
     */
    public void clickOnSuggestion(String suggestionText)
    {
        for (WebElement suggestion : searchSuggestions)
        {
            if (suggestion.getText().contains(suggestionText))
            {
                suggestion.click();
                break;
            }
        }
    }

    public WebElement getSearchButton()
    {
        return searchButton;
    }
}

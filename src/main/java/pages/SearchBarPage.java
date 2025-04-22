package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Page object for the search bar and its behavior.
 */
public class SearchBarPage extends BasePage
{
    /**
     * Constructor to initialize the search bar.
     * @param driver The WebDriver used to interact with the browser.
     */

    public SearchBarPage(WebDriver driver)
    {
        super(driver);
    }


    /**
     * Web elements on the search bar page.
     */
    @FindBy(id = "search_query_top")
    private WebElement searchField;

    // Button to submit the search query
    @FindBy(name = "submit_search")
    private WebElement searchButton;

    // List of suggested search results (autocomplete)
    @FindBy(xpath = "//li[contains(@class, 'ac_even')]")
    private List<WebElement> searchSuggestions;

    /**
     * Clicks the search button to initiate the search.
     */
    public void clickSearchButton()
    {
        searchButton.click();
    }

    /**
     * Enters a search term into the search input field.
     *
     * @param article the search term to enter
     */
    public void enterSearchElement(String article)
    {
        searchField.clear();
        searchField.sendKeys(article);
    }

    /**
     * Gets the WebElement representing the search input field.
     *
     * @return the search input field element
     */
    public WebElement getSearchField()
    {
        return searchField;
    }

    /**
     * Clicks on the search input field.
     */
    public void clickSearchField()
    {
        searchField.click();
    }

    /**
     * Returns the list of search suggestion elements.
     *
     * @return list of search suggestion WebElements
     */
    public List<WebElement> getSearchSuggestions()
    {
        return searchSuggestions;
    }

    /**
     * Clicks on a suggestion from the autocomplete dropdown that contains the given text.
     *
     * @param suggestionText the text to match within suggestions
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

    /**
     * Gets the WebElement representing the search button.
     *
     * @return the search button element
     */
    public WebElement getSearchButton()
    {
        return searchButton;
    }
}

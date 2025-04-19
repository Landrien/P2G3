package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchBarPageElement extends BasePage
{
    public SearchBarPageElement(WebDriver driver)
    {
        super(driver);
    }

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

    public List<WebElement> getSearchSuggestions()
    {
        return searchSuggestions;
    }

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

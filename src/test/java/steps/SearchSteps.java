package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ArticlePage;
import pages.SearchBarPageElement;

public class SearchSteps extends BaseSteps
{
    SearchBarPageElement searchBarPageElement = new SearchBarPageElement(driver);
    ArticlePage articlePage = new ArticlePage(driver);

    @When("the user clicks on the search field")
    public void clickSearchField()
    {
        searchBarPageElement.clickSearchField();
    }

    @And("the user enters the text {string} in the search bar")
    public void enterSearchText(String article)
    {
        searchBarPageElement.enterSearchText(article);
    }

    @And("the user clicks on the suggestion {string}")
    public void clickOnSuggestion(String suggestion)
    {
        searchBarPageElement.clickOnSuggestion(suggestion);
    }

    @Then("the user should be redirected to the {string} article page")
    public void checkUserIsOnArticlePage(String articleName)
    {
        String actualTitle = articlePage.getProductTitle();
        Assert.assertEquals("Le titre de l'article ne correspond pas", articleName, actualTitle);
    }

    @And("the user clicks on the magnifying glass")
    public void clickSearchButton()
    {
        searchBarPageElement.clickSearchButton();
    }

    @Then("the user should be redirected to the {string} search results page")
    public void checkUserIsOnSearchResultsPage(String searchQuery)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("L'URL des résultats de recherche ne correspond pas. URL actuelle : " + currentUrl,
                currentUrl.contains("search_query=" + searchQuery));
    }

    @Then("the {string} page should contain the search field")
    public void checkPageContainsSearchField(String page)
    {
        WebElement searchField = searchBarPageElement.getSearchField();
        Assert.assertTrue("Le champ de recherche n'est pas visible sur la page " + page, searchField.isDisplayed());
    }

    @And("the {string} page should contain the magnifying glass")
    public void checkPageContainsSearchButton(String page)
    {
        WebElement searchButton = searchBarPageElement.getSearchButton();
        Assert.assertTrue("La loupe de recherche n'est pas visible sur la page " + page, searchButton.isDisplayed());
    }
}

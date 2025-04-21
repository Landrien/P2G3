package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ArticlePage;
import pages.SearchBarPage;

/**
 * Search bar and article page elements
 */
public class SearchSteps extends BaseSteps
{
    SearchBarPage searchBarPage = new SearchBarPage(driver);
    ArticlePage articlePage = new ArticlePage(driver);

    @When("the user clicks on the search field")
    public void clickSearchField()
    {
        searchBarPage.clickSearchField();
    }


    @And("the user enters the text {string} in the search bar")
    public void enterSearchElement(String article)
    {
        searchBarPage.enterSearchElement(article);
    }

    @And("the user clicks on the suggestion {string}")
    public void clickOnSuggestion(String suggestion)
    {
        searchBarPage.clickOnSuggestion(suggestion);
    }

    /**
     * Method to verify if the user is redirected to the correct article page.
     * @param articleName The expected article name to check.
     */
    @Then("the user should be redirected to the {string} article page")
    public void checkUserIsOnArticlePage(String articleName)
    {
        String actualTitle = articlePage.getProductTitle();
        Assert.assertEquals("Le titre de l'article ne correspond pas", articleName, actualTitle);
    }


    @And("the user clicks on the magnifying glass")
    public void clickSearchButton()
    {
        searchBarPage.clickSearchButton();
    }

    /**
     * Verify if the user is redirected to the correct search results page
     * @param searchQuery The search query that should appear in the URL.
     */
    @Then("the user should be redirected to the {string} search results page")
    public void checkUserIsONSearchResultsPage(String searchQuery)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("L'URL des résultats de recherche ne correspond pas. URL actuelle : " + currentUrl,
                currentUrl.contains("search_query=" + searchQuery));
    }

    /**
     * Verify if the search field is visible on the page.
     * @param page The page name to check.
     */
    @Then("the {string} page should contain the search field")
    public void checkPageContainsSearchField(String page)
    {
        WebElement searchField = searchBarPage.getSearchField();
        Assert.assertTrue("Le champ de recherche n'est pas visible sur la page " + page, searchField.isDisplayed());
    }

    /**
     * Verify if the magnifying glass is visible
     * @param page the page name to check
     */
    @And("the {string} page should contain the magnifying glass")
    public void checkPageContainsSearchButton(String page)
    {
        WebElement searchButton = searchBarPage.getSearchButton();
        Assert.assertTrue("La loupe de recherche n'est pas visible sur la page " + page, searchButton.isDisplayed());
    }
}

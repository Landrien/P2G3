package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SearchPage;

public class SearchSteps extends BaseSteps
{
    SearchPage searchPage = new SearchPage(driver);

    @When("the user clicks on the search field")
    public void theUserClicksOnTheSearchField()
    {
        searchPage.getSearchField().click();
    }

    @And("the user types {string}")
    public void theUserTypes(String article)
    {
        searchPage.enter_element(article);
    }

    @And("the user clicks on the suggestion {string}")
    public void theUserClicksOnTheSuggestion(String suggestion)
    {
        searchPage.clickOnSuggestion(suggestion);
    }

    @Then("the user should be redirected to the {string} article page")
    public void theUserShouldBeRedirectedToTheArticlePage(String article_name)
    {
        String actualTitle = searchPage.getProductTitle();
        Assert.assertEquals("Le titre de l'article ne correspond pas", article_name, actualTitle);
    }

    @And("the user clicks on the magnifying glass")
    public void theUserClicksOnTheMagnifyingGlass()
    {
        searchPage.clickSearchButton();
    }

    @Then("the user should be redirected to the {string} search results page")
    public void theUserShouldBeRedirectedToTheSearchResultsPage(String searchQuery)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_query_top")));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("L'URL des résultats de recherche ne correspond pas. URL actuelle : " + currentUrl,
                currentUrl.contains("search_query=" + searchQuery));
    }

    @Then("{string} page should countain the search field")
    public void pageShouldCountainTheSearchField(String page)
    {
        WebElement searchField = searchPage.getSearchField();
        Assert.assertTrue("Le champ de recherche n'est pas visible sur la page " + page, searchField.isDisplayed());
    }

    @And("{string} page should countain the magnifying glass")
    public void pageShouldCountainTheMagnifyingGlass(String page)
    {
        WebElement searchButton = searchPage.getSearchButton();
        Assert.assertTrue("La loupe de recherche n'est pas visible sur la page " + page, searchButton.isDisplayed());
    }
}

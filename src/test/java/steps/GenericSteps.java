package steps;

import io.cucumber.java.en.Given;

/**
 * Generic step definitions allowing direct access
 * to certain key pages of the application via their URL.
 */
public class GenericSteps extends BaseSteps
{
    /**
     * Navigates the user to a specific page by matching the provided page name.
     * @param page The name of the target page
     */
    @Given("the user is on the {string} page")
    public void startAtPage(String page)
    {
        switch (page.toLowerCase())
        {
            case "homepage":
                driver.get("http://www.automationpractice.pl/index.php");
                break;
            case "authentication":
                driver.get("http://www.automationpractice.pl/index.php?controller=authentication");
                break;
            case "search_results":
                driver.get("http://www.automationpractice.pl/index.php?controller=search&search_query=dress&submit_search=");
                break;
            case "article_detail":
                driver.get("http://www.automationpractice.pl/index.php?id_product=1&controller=product");
                break;
            default:
                throw new IllegalArgumentException("Page inconnue : " + page);
        }
    }
}

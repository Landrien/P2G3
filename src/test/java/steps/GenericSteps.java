package steps;

import io.cucumber.java.en.Given;

public class GenericSteps extends BaseSteps
{
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

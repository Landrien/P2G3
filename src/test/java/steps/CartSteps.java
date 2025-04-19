package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps extends BaseSteps
{
    CartPage cartPage = new CartPage(driver);

    @When("the user clicks on the cart logo")
    public void theUserClicksOnTheCartLogo()
    {
        cartPage.clickCartLogo();
    }

    @Then("the user is redirected to the {string} page")
    public void theUserIsRedirectedToTheShoppingCartSummaryPage(String page)
    {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("L'URL de la page du panier ne correspond pas. URL actuelle : " + currentUrl,
                currentUrl.contains("controller=order"));
    }
}
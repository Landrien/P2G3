package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.HeaderPage;

public class CartSteps extends BaseSteps
{
    HeaderPage headerPage = new HeaderPage(driver);

    @When("the user clicks on the cart logo")
    public void clickCartLogo()
    {
        headerPage.clickCartLogo();
    }

    @Then("the user is redirected to the 'Shopping Cart Summary' page")
    public void checkUserIsOnCartPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(CartPage.pageUrlId));
    }
}
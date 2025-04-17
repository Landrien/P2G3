package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PageElement;

import static org.junit.Assert.assertTrue;

public class HomePage_Step extends BaseStep {

    HomePage homePage = new HomePage(driver);
    PageElement pageElement = new PageElement(driver);

    @Given("the user is connected and on the homepage")
        public void theUserIsConnectedAndOnTheHomepage() {
            assertTrue(homePage.PopularButton.isDisplayed());
    }

    @When("the user clicks on the 'Sign out' link")
    public void theUserClicksOnTheSignOutLink() {
        pageElement.SignOutButton.click();
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        assertTrue(pageElement.SignInButton.isDisplayed());
    }

    @And("the login page should contain {string}")
    public void theLoginPageShouldContainSignIn() {
    }
}

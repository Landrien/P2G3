package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.PageElement;

import static org.junit.Assert.assertTrue;

public class HomePage_Step extends BaseSteps {

    HomePage homePage = new HomePage(driver);
    PageElement pageElement = new PageElement(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

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

    @And("the login page should contain 'Sign in'")
    public void theLoginPageShouldContainSignIn() {
        assertTrue(authenticationPage.getSignInButton().isDisplayed());
        assertTrue(pageElement.SignInButton.getText().contains("Sign in"));
    }
}

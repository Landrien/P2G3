package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.HomePage;

import static org.junit.Assert.assertTrue;

public class HomePage_Step extends BaseSteps {

    HomePage homePage = new HomePage(driver);
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @Given("the user is connected and on the homepage")
    public void theUserIsConnectedAndOnTheHomepage() {
        assertTrue(homePage.PopularButton.isDisplayed());
    }

    @When("the user clicks on the 'Sign out' link")
    public void theUserClicksOnTheSignOutLink() {
        headerPage.SignOutButton.click();
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        assertTrue(headerPage.SignInButton.isDisplayed());
    }

    @And("the login page should contain 'Sign in'")
    public void theLoginPageShouldContainSignIn() {
        assertTrue(authenticationPage.getSignInButton().isDisplayed());
        assertTrue(headerPage.SignInButton.getText().contains("Sign in"));
    }
}

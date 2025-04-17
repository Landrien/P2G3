package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AuthenticationPage;
import pages.PageElement;

import static org.junit.Assert.assertTrue;

public class Authentification_Step extends BaseSteps
{
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    PageElement pageElement = new PageElement(driver);

    @Given("the user is on the 'Authentication' page")
    public void theUserIsOnTheAuthenticationPage() {
        authenticationPage.getCreateAccountButton().isDisplayed();
    }

    @When("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        authenticationPage.enterCreateEmailAddress("admin13@gmail.com");
    }

    @And("the user enters an incorrect password")
    public void theUserEntersAnIncorrectPassword() {
        authenticationPage.enterSignInPassword("123456789");
    }

    @Then("an error message Invalid password is displayed")
    public void anErrorMessageInvalidPasswordIsDisplayed() {
        assertTrue(authenticationPage.getInvalidPasswordErrorMessage().isDisplayed());
    }

    @And("the user enters the password associated with their account")
    public void theUserEntersThePasswordAssociatedWithTheirAccount() {
        authenticationPage.enterSignInPassword("admin");
    }

    @And("the user click on the button")
    public void theUserClickOnTheButton() {
        authenticationPage.clickSignInButton();
    }

    @Then("the My Account page is displayed")
    public void theMyAccountPageIsDisplayed() {
        assertTrue(pageElement.SignOutButton.getText().contains("Sign out"));
    }

    @And("the user's first and last name appear in the menu bar")
    public void theUserSFirstAndLastNameAppearInTheMenuBar() {
        assertTrue(pageElement.AccountButton.getText().contains("Admin admin"));
    }

    @Given("the user has an account with a valid email address")
    public void theUserHasAnAccountWithAValidEmailAddress() {
        authenticationPage.enterSignInEmailAddress("admin13@gmail.com");
        authenticationPage.enterSignInPassword("admin");
        authenticationPage.clickSignInButton();
        pageElement.clickLogoButton();
    }
}

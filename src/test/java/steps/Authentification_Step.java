package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Authentification;
import pages.PageElement;

import static org.junit.Assert.assertTrue;

public class Authentification_Step extends BaseStep{
    Authentification authentification = new Authentification(driver);
    PageElement pageElement = new PageElement(driver);


    @Given("the user is on the 'Authentication' page")
    public void theUserIsOnTheAuthenticationPage() {
        authentification.CreateAccountButton.isDisplayed();
    }

    @When("the user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        authentification.enterCreateEmailAddress("admin13@gmail.com");
    }

    @And("the user enters an incorrect password")
    public void theUserEntersAnIncorrectPassword() {
        authentification.enterRegisterPassword("123456789");
    }

    @Then("an error message Invalid password is displayed")
    public void anErrorMessageInvalidPasswordIsDisplayed() {
        assertTrue(authentification.ErrorMessage.isDisplayed());
    }

    @And("the user enters the password associated with their account")
    public void theUserEntersThePasswordAssociatedWithTheirAccount() {
        authentification.enterRegisterPassword("admin");
    }

    @And("the user click on the button")
    public void theUserClickOnTheButton() {
        authentification.clickSignInButton();
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
        authentification.enterCreateEmailAddress("admin13@gmail.com");
        authentification.enterRegisterPassword("admin");
        authentification.clickSignInButton();
        pageElement.clickLogoButton();
    }
}

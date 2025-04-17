package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.PageElement;

import static org.junit.Assert.assertTrue;

public class AuthenticationSteps extends BaseSteps
{
    private CreateAccountPage createAccountPage;

    private CreateAccountPage getCreateAccountPage()
    {
        if (createAccountPage == null)
            createAccountPage = new CreateAccountPage(driver);

        return createAccountPage;
    }

    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    PageElement pageElement = new PageElement(driver);

    @Given("the user is on the Authentication page")
    public void startAtAuthenticationPage()
    {
        // TODO mdroz / Navigate towards the create account page
    }

    @When("the user enters an incorrectly formatted email address in the Email address field")
    public void enterInvalidCreateEmail()
    {
        // TODO mdroz / Data for this parameter
        authenticationPage.enterCreateEmailAddress("INVALID MAIL");
    }

    @And("the user clicks on the Create an account button")
    public void clickCreateAccountButton()
    {
        authenticationPage.clickCreateAccountButton();
    }

    @Then("an error message Invalid email address is displayed")
    public void checkInvalidCreateEmailMessage()
    {
        Assert.assertNotNull(authenticationPage.getInvalidEmailErrorMessage());
    }

    @When("the user enters a valid email address in the Email address field")
    @When("the user enters a valid email address")
    public void enterValidCreateEmail()
    {
        // TODO mdroz / Data for this parameter
        authenticationPage.enterCreateEmailAddress("valid.email@gmail.com");
    }

    @Then("the Create an account page is displayed")
    public void checkCreateAccountPage()
    {
        // TODO
        Assert.assertNotNull(getCreateAccountPage());
    }

    @And("the user enters an incorrect password")
    public void enterInvalidRegisterPassword()
    {
        authenticationPage.enterSignInPassword("123456789");
    }

    @Then("an error message Invalid password is displayed")
    public void checkInvalidPasswordErrorMessage()
    {
        assertTrue(authenticationPage.getInvalidPasswordErrorMessage().isDisplayed());
    }

    @And("the user enters the password associated with their account")
    public void enterValidRegisterPassword()
    {
        authenticationPage.enterSignInPassword("admin");
    }

    @And("the user click on the button")
    public void clickSignInButton()
    {
        authenticationPage.clickSignInButton();
    }

    @Then("the My Account page is displayed")
    public void checkAccountPageDisplayed()
    {
        assertTrue(pageElement.SignOutButton.getText().contains("Sign out"));
    }

    @And("the user's first and last name appear in the menu bar")
    public void checkFirstNameLastNameInMenuBar()
    {
        assertTrue(pageElement.AccountButton.getText().contains("Admin admin"));
    }

    @Given("the user has an account with a valid email address")
    public void signIn()
    {
        // TODO mdroz / Parameters
        authenticationPage.enterSignInEmailAddress("admin13@gmail.com");
        authenticationPage.enterSignInPassword("admin");
        authenticationPage.clickSignInButton();
        pageElement.clickLogoButton();
    }
}

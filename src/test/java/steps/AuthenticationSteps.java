package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HeaderPage;
import utils.ConfigReader;

import static org.junit.Assert.assertTrue;
import static utils.RandomString.getRandomString;

public class AuthenticationSteps extends BaseSteps
{
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    HeaderPage headerPage = new HeaderPage(driver);

    private final String registeredAccountEmail = ConfigReader.getProperty("email-account-addresses");
    private final String registeredAccountPassword = ConfigReader.getProperty("password-account-addresses");

    private final String registeredAccountFirstName = "Admin";
    private final String registeredAccountLastName = "admin";

    @Given("the user is on the Authentication page")
    public void startAtAuthenticationPage()
    {
        headerPage.clickSignInButton();
    }

    @When("the user enters an email address with an invalid format")
    public void enterInvalidCreateEmail()
    {
        authenticationPage.enterCreateEmailAddress("bad-email");
    }

    @And("the user clicks on the Create an account button")
    public void clickCreateAccountButton()
    {
        authenticationPage.clickCreateAccountButton();
    }

    @Then("an error message Invalid email address is displayed")
    public void checkInvalidCreateEmailErrorMessage()
    {
        Assert.assertNotNull(authenticationPage.getInvalidEmailErrorMessage());
    }

    @When("the user enters a valid email address in the Email address field")
    public void enterValidCreateEmail()
    {
        String randomEmail = getRandomString() + "@gmail.com";
        authenticationPage.enterCreateEmailAddress(randomEmail);
    }

    @When("the user enters a valid email address")
    public void enterValidSignInEmail()
    {
        authenticationPage.enterSignInEmailAddress("admin13@gmail.com");
    }

    @Then("the Create an account page is displayed")
    public void checkCreateAccountPage()
    {
        Assert.assertTrue(createAccountPage.getCreateAccountTitle().isDisplayed());
    }

    @And("the user enters an incorrect password")
    public void enterInvalidRegisterPassword()
    {
        authenticationPage.enterSignInPassword("bad-password");
    }

    @Then("an error message Invalid password is displayed")
    public void checkInvalidPasswordErrorMessage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= \"alert alert-danger\"]")));
        assertTrue(authenticationPage.getInvalidPasswordErrorMessage().isDisplayed());
    }

    @And("the user enters the password associated with their account")
    public void enterValidRegisterPassword()
    {
        authenticationPage.enterSignInPassword(registeredAccountPassword);
    }

    @And("the user click on the button")
    public void clickSignInButton()
    {
        authenticationPage.clickSignInButton();
    }

    @Then("the My Account page is displayed")
    public void checkAccountPageDisplayed()
    {
        assertTrue(headerPage.getSignOutButton().getText().contains("Sign out"));
    }

    @And("the user's first and last name appear in the menu bar")
    public void checkFirstNameLastNameInMenuBar()
    {
        assertTrue(headerPage.getUserAccountButton().getText().contains(registeredAccountFirstName + " " + registeredAccountLastName));
    }

    @Given("the user has an account with a valid email address")
    @Given("the user is connected and on the homepage")
    public void connect() {
        // TODO mdroz / Parameters
        headerPage.clickSignInButton();
        authenticationPage.enterSignInEmailAddress(registeredAccountEmail);
        authenticationPage.enterSignInPassword(registeredAccountPassword);
        authenticationPage.clickSignInButton();
        headerPage.clickLogoButton();
    }

    @When("the user clicks on the 'Forgot your password?' link")
    public void clickForgotPasswordLink()
    {
        authenticationPage.getRecoverPasswordButton().click();
    }

    @Then("the user is redirected to the password reset page")
    public void checkForgottenPasswordText()
    {
        assertTrue(authenticationPage.getForgottenPasswordText().isDisplayed());
    }

    @And("the user clicks on the 'Retrieve Password' button")
    public void clickRetrievePasswordButton()
    {
        authenticationPage.getRetrievePasswordButton().click();
    }

    @Then("a confirmation message is displayed")
    public void checkConfirmationMessage()
    {
        assertTrue(authenticationPage.getSuccessMessage().isDisplayed());
    }
}

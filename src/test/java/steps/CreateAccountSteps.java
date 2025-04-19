package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HeaderPage;

import static utils.RandomString.getRandomString;

public class CreateAccountSteps extends BaseSteps
{
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    AccountPage accountPage = new AccountPage(driver);
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @Given("the user is on the Create an account page")
    public void startAtCreateAccountPage()
    {
        headerPage.clickSignInButton();
        String randomEmail = getRandomString() + "@gmail.com";
        authenticationPage.enterCreateEmailAddress(randomEmail);
        authenticationPage.clickCreateAccountButton();
    }

    @When("the user enters a {string} invalid password")
    public void enterInvalidPassword(String badPassword)
    {
        createAccountPage.enterPassword(badPassword);
    }

    @And("the user clicks on the Register button")
    public void clickRegisterButton()
    {
        createAccountPage.clickRegisterButton();
    }

    @Then("a password is invalid message is displayed")
    public void checkPasswordInvalidErrorMessage()
    {
        Assert.assertTrue(createAccountPage.getInvalidPasswordMessage().isDisplayed());
    }

    @When("the user modifies their email address to an invalid format")
    public void enterInvalidEmail()
    {
        createAccountPage.enterEmailAddress("bad-email");
    }

    @Then("an Email is invalid message is displayed")
    public void checkEmailInvalidErrorMessage()
    {
        Assert.assertTrue(createAccountPage.getInvalidEmailMessage().isDisplayed());
    }

    @When("the user selects a gender")
    public void selectGenderTitle()
    {
        createAccountPage.selectGenderTitle(true);
    }

    @And("the user enters their last name")
    public void enterLastName()
    {
        createAccountPage.enterLastName("Doe");
    }

    @And("the user enters their first name")
    public void enterFirstName()
    {
        createAccountPage.enterFirstName("John");
    }

    @And("the user modifies their email address with a valid format")
    public void enterValidEmail()
    {
        String randomEmail = getRandomString() + "@gmail.com";
        createAccountPage.enterEmailAddress(randomEmail);
    }

    @And("the user enters a password with at least '5' characters")
    public void enterValidPassword()
    {
        createAccountPage.enterPassword("mypassword");
    }

    @And("the message 'Your account has been created' is displayed")
    public void checkAccountCreatedMessage()
    {
        Assert.assertTrue(accountPage.getAccountCreatedMessage().isDisplayed());
    }

    @And("the user enters their date of birth")
    public void selectBirthDate()
    {
        createAccountPage.selectBirthDateDay("11");
        createAccountPage.selectBirthDateMonth("10");
        createAccountPage.selectBirthDateYear("2001");
    }

    @And("the user checks Sign up for our newsletter!")
    public void clickNewsletterSignUpCheckbox()
    {
        createAccountPage.clickNewsletterSignUpCheckbox();
    }
}

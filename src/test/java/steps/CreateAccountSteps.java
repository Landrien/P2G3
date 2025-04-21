package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.CreateAccountPage;

import static utils.RandomUtils.getRandomEmail;

/**
 * Step definitions for account creation, including validation of inputs such as email and password.
 */
public class CreateAccountSteps extends BaseSteps
{
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @When("the user enters a {string} invalid password")
    public void enterInvalidPassword(String invalidPassword)
    {
        createAccountPage.enterPassword(invalidPassword);
    }

    @And("the user clicks on the Register button")
    public void clickRegisterButton()
    {
        createAccountPage.clickRegisterButton();
    }

    @Then("a Password is invalid message is displayed")
    public void checkPasswordInvalidErrorMessage()
    {
        Assert.assertTrue(createAccountPage.getInvalidPasswordMessage().isDisplayed());
    }

    @When("the user modifies their email address to an invalid format")
    public void enterInvalidEmail()
    {
        createAccountPage.enterEmailAddress("invalid-email");
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
        createAccountPage.enterEmailAddress(getRandomEmail());
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

    @And("the user checks the Sign up for our newsletter checkbox")
    public void clickNewsletterSignUpCheckbox()
    {
        createAccountPage.clickNewsletterSignUpCheckbox();
    }

    @Then("the user is redirected to the Create account page")
    public void checkUserIsOnCreateAccountPage()
    {
        Assert.assertTrue(createAccountPage.getCreateAccountTitle().isDisplayed());
    }
}

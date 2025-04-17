package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.CreateAccountPage;

public class CreateAccountSteps extends BaseSteps
{
    private CreateAccountPage createAccountPage;

    private CreateAccountPage getCreateAccountPage()
    {
        if (createAccountPage == null)
            createAccountPage = new CreateAccountPage(driver);

        return createAccountPage;
    }

    private AccountPage accountPage;

    private AccountPage getAccountPage()
    {
        if (accountPage == null)
            accountPage = new AccountPage(driver);

        return accountPage;
    }

    // Create Account

    @Given("the user is on the Create an account page")
    public void startAtCreateAccountPage()
    {
        // TODO mdroz / Navigate towards the create account page
    }

    @When("the user enters a <{string}> invalid password")
    public void enterInvalidPassword(String password)
    {
        getCreateAccountPage().enterPassword(password);
    }

    @And("the user clicks on the REGISTER button")
    public void clickRegisterButton()
    {
        getCreateAccountPage().clickRegisterButton();
    }

    @Then("a password is invalid message is displayed")
    public void checkPasswordInvalidMessage()
    {
        Assert.assertNotNull(getCreateAccountPage().getInvalidPasswordMessage());
    }

    @When("the user modifies their email address to an invalid format")
    public void enterInvalidEmail()
    {
        // TODO mdroz / Data for this parameter
        getCreateAccountPage().enterEmailAddress("NOT A VALID EMAIL");
    }

    @Then("an Email is invalid message is displayed")
    public void checkEmailInvalidMessage()
    {
        Assert.assertNotNull(getCreateAccountPage().getInvalidEmailMessage());
    }

    @When("the user selects a gender")
    public void selectGenderTitle()
    {
        // TODO mdroz / Do we need to check for both male and female ?
        getCreateAccountPage().selectGenderTitle(true);
    }

    @And("the user enters their last name")
    public void enterLastName()
    {
        // TODO mdroz / Data for this parameter
        getCreateAccountPage().enterLastName("Doe");
    }

    @And("the user enters their first name")
    public void enterFirstName()
    {
        // TODO mdroz / Data for this parameter
        getCreateAccountPage().enterFirstName("John");
    }

    @And("the user modifies the email address with a valid format")
    public void enterValidEmail()
    {
        // TODO mdroz / Data for this parameter
        getCreateAccountPage().enterEmailAddress("myadress@gmail.com");
    }

    @And("the user enters a password with at least '5' characters")
    public void enterValidPassword()
    {
        // TODO mdroz / Data for this parameter
        getCreateAccountPage().enterPassword("test");
    }

    @And("a message Your account has been created. appears")
    public void checkAccountCreatedMessage()
    {
        Assert.assertNotNull(getAccountPage().getAccountCreatedMessage());
    }
}

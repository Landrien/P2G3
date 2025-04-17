package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AccountPage;
import pages.CreateAccountPage;
import pages.PageElement;

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

    PageElement pageElement = new PageElement(driver);

    @Given("the user is on the Create an account page")
    public void startAtCreateAccountPage()
    {
        // TODO mdroz / Replace with an already defined step
        pageElement.clickSignInButton();
        enterValidEmail();
        clickRegisterButton();
    }

    @When("the user enters a {string} invalid password")
    public void enterInvalidPassword(String badPassword)
    {
        getCreateAccountPage().enterPassword(badPassword);
    }

    @And("the user clicks on the REGISTER button")
    public void clickRegisterButton()
    {
        getCreateAccountPage().clickRegisterButton();
    }

    @Then("a password is invalid message is displayed")
    public void checkPasswordInvalidMessage()
    {
        Assert.assertTrue(getCreateAccountPage().getInvalidPasswordMessage().isDisplayed());
    }

    @When("the user modifies their email address to an invalid format")
    public void enterInvalidEmail()
    {
        getCreateAccountPage().enterEmailAddress("bad-email");
    }

    @Then("an Email is invalid message is displayed")
    public void checkEmailInvalidMessage()
    {
        Assert.assertTrue(getCreateAccountPage().getInvalidEmailMessage().isDisplayed());
    }

    @When("the user selects a gender")
    public void selectGenderTitle()
    {
        getCreateAccountPage().selectGenderTitle(true);
    }

    @And("the user enters their last name")
    public void enterLastName()
    {
        getCreateAccountPage().enterLastName("Doe");
    }

    @And("the user enters their first name")
    public void enterFirstName()
    {
        getCreateAccountPage().enterFirstName("John");
    }

    @And("the user modifies the email address with a valid format")
    public void enterValidEmail()
    {
        getCreateAccountPage().enterEmailAddress("myadress@gmail.com");
    }

    @And("the user enters a password with at least '5' characters")
    public void enterValidPassword()
    {
        getCreateAccountPage().enterPassword("mypassword");
    }

    @And("the message 'Your account has been created' is displayed")
    public void checkAccountCreatedMessage()
    {
        Assert.assertTrue(getAccountPage().getAccountCreatedMessage().isDisplayed());
    }

    @And("the user enters their date of birth")
    public void selectBirthDate()
    {
        getCreateAccountPage().selectBirthDateDay("11");
        getCreateAccountPage().selectBirthDateMonth("October");
        getCreateAccountPage().selectBirthDateYear("2001");
    }

    @And("the user checks Sign up for our newsletter!")
    public void theUserChecksSignUpForOurNewsletter()
    {

    }
}

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CreateAccountPage;

public class AuthenticationSteps extends BaseSteps
{
    private CreateAccountPage createAccountPage;

    private CreateAccountPage getCreateAccountPage()
    {
        if (createAccountPage == null)
            createAccountPage = new CreateAccountPage(driver);

        return createAccountPage;
    }

    @Given("the user is on the Authentication page")
    public void startAtAuthenticationPage()
    {
        // TODO mdroz / Navigate towards the create account page
    }

    @When("the user enters an incorrectly formatted email address in the Email address field")
    public void enterInvalidEmail()
    {

    }

    @And("the user clicks on the Create an account button")
    public void clickCreateAccountButton()
    {
    }

    @Then("an error message Invalid email address is displayed")
    public void checkInvalidEmailMessage()
    {
    }

    @When("the user enters a valid email address in the Email address field")
    public void enterValidEmail()
    {
    }

    @Then("the Create an account page is displayed")
    public void checkCreateAccountPage()
    {
        // TODO
        Assert.assertNotNull(getCreateAccountPage());
    }
}

package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HeaderPage;
import pages.HomePage;

public class ManageAccountSteps extends BaseSteps
{
    AccountPage accountPage = new AccountPage(driver);
    HomePage homePage = new HomePage(driver);
    HeaderPage headerPage = new HeaderPage(driver);

    @Given("the user is on the My Account page")
    public void startAtAccountPage()
    {
        // TODO mdroz / Go to Account Page
    }

    @When("the user clicks on the Home button")
    public void clickHomeButton()
    {
        headerPage.clickLogoButton();
    }

    @Then("the user is redirected to the homepage")
    public void checkHomePageDisplayed()
    {
        // TODO mdroz / Check home page
    }
}

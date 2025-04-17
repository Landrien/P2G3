package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.PageElement;

public class ManageAccountSteps extends BaseSteps
{
    AccountPage accountPage = new AccountPage(driver);
    HomePage homePage = new HomePage(driver);
    PageElement pageElement = new PageElement(driver);

    @Given("the user is on the My Account page")
    public void startAtAccountPage()
    {
        // TODO mdroz / Go to Account Page
    }

    @When("the user clicks on the Home button")
    public void clickHomeButton()
    {
        pageElement.clickLogoButton();
    }

    @Then("the user is redirected to the homepage")
    public void checkHomePageDisplayed()
    {
        // TODO mdroz / Check home page
    }
}

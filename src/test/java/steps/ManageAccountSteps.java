package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.ConfigReader;

public class ManageAccountSteps extends BaseSteps
{
    AccountPage accountPage = new AccountPage(driver);
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @Given("the user is on the My Account page")
    public void startAtAccountPage()
    {
        headerPage.clickSignInButton();
        authenticationPage.enterSignInEmailAddress(ConfigReader.getProperty("email-account-no-address"));
        authenticationPage.enterSignInPassword(ConfigReader.getProperty("password-account-no-address"));
        authenticationPage.clickSignInButton();
    }

    @When("the user clicks on the Home button")
    public void clickHomeButton()
    {
        headerPage.clickLogoButton();
    }

    @When("the user clicks on Add my first Address button")
    public void clickAddMyFirstAddressButton()
    {
        accountPage.clickAddMyFirstAddressButton();
    }

    @Then("the user is redirected to the address entry page")
    public void checkAddressEditPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(AddressEditPage.pageUrlId));
    }

    @When("the user clicks on {string} section")
    public void clickSectionButton(String section)
    {
        switch (section)
        {
            case "Order History":
                accountPage.clickOrderHistoryButton();
                break;
            case "Credits":
                accountPage.clickCreditSlipsButton();
                break;
            case "Delivery Addresses":
                accountPage.clickMyAddressesButton();
                break;
            case "Personal Information":
                accountPage.clickPersonalInformationButton();
                break;
            default:
                Assert.fail("Unknown section : " + section);
        }
    }

    @Then("the user is redirected to the {string} section page")
    public void checkSectionPage(String section)
    {
        switch (section)
        {
            case "Order History":
                Assert.assertTrue(driver.getCurrentUrl().contains(OrderHistoryPage.pageUrlId));
                break;
            case "Credits":
                Assert.assertTrue(driver.getCurrentUrl().contains(CreditsPage.pageUrlId));
                break;
            case "Delivery Addresses":
                Assert.assertTrue(driver.getCurrentUrl().contains(AddressesPage.pageUrlId));
                break;
            case "Personal Information":
                Assert.assertTrue(driver.getCurrentUrl().contains(AccountInfoPage.pageUrlId));
                break;
            default:
                Assert.fail("Unknown section : " + section);
        }
    }
}

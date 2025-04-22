package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

import java.util.List;

import static utils.AddressJsonUtils.getAddressInfo;

/**
 * Managing the account, addresses, and editing address information.
 */
public class ManageAccountSteps extends BaseSteps
{
    AccountPage accountPage = new AccountPage(driver);
    AddressesPage addressesPage = new AddressesPage(driver);
    AddressEditPage addressEditPage = new AddressEditPage(driver);
    HeaderPage headerPage = new HeaderPage(driver);

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

    /**
     * Simulates the user clicking on a specified section in the account page.
     * @param section The section to be clicked ("Order History", "Credits").
     */
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

    @And("the user is on the My Addresses page")
    public void goToAddressesPage()
    {
        headerPage.clickUserAccountButton();
        accountPage.clickMyAddressesButton();
    }

    @When("the user clicks on the 'Add' button")
    public void clickAddAddressButton()
    {
        addressesPage.clickAddAddressButton();
    }

    @When("the user clicks on the 'Update' button")
    public void clickUpdateAddressButton()
    {
        addressesPage.clickUpdateAddressButton();
    }

    @And("the user clicks on the 'Validate' button")
    public void clickValidateAddressButton()
    {
        addressEditPage.clickValidateAddressButton();
    }

    @And("the user enters the address details")
    public void enterNewAddressInfo()
    {
        addressEditPage.enterAddressInfo("new_address");
    }

    @Then("the address details should be added")
    public void checkNewAddressInfo()
    {
        List<String> newAddressInfo = getAddressInfo("new_address");

        if (newAddressInfo != null)
            checkTextsArePresent(newAddressInfo);
    }

    @And("the user modifies their name")
    public void updateAddressFirstName()
    {
        addressEditPage.enterFirstNameField("Mike");
    }

    @Then("the address details should be updated")
    public void checkUpdatedAddressFirstName()
    {
        Assert.assertTrue(checkTextIsPresent("Mike"));
    }

    @And("the page should contain the address details of the user")
    public void checkRegisteredAddressInfo()
    {
        List<String> registeredAddressInfo = getAddressInfo("registered_address");

        if (registeredAddressInfo != null)
            checkTextsArePresent(registeredAddressInfo);
    }

    @And("there are no registered addresses")
    public void deleteRegisteredAddresses()
    {
        headerPage.clickUserAccountButton();
        accountPage.clickMyAddressesButton();

        addressesPage.deleteAddresses();
    }

    @And("there is only one registered address")
    public void deleteRegisteredAddressesAndCreateOne()
    {
        headerPage.clickUserAccountButton();
        accountPage.clickMyAddressesButton();

        addressesPage.deleteAddresses();
        addressesPage.clickAddAddressButton();

        addressEditPage.enterAddressInfo("registered_address");
        addressEditPage.clickValidateAddressButton();
    }

    @And("the user is on the My account page")
    public void goToMyAccountPage()
    {
        headerPage.clickUserAccountButton();
    }
}

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.*;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class ManageAccountSteps extends BaseSteps
{
    AccountPage accountPage = new AccountPage(driver);
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    AddressesPage addressesPage = new AddressesPage(driver);
    AddressEditPage addressEditPage = new AddressEditPage(driver);

    String newAddressFirstName = "John";
    String newAddressLastName = "Doe";
    String newAddress = "8 Main Street";
    String newAddressCity = "Birmingham";
    String newAddressState = "Texas";
    String newAddressPostalCode = "33333";
    String newAddressHomePhone = "6666";
    String newAddressMobilePhone = "7777";
    String newAddressTitle = "Test New Address";

    List<String> newAddressInfo = Arrays.asList(
        newAddressFirstName,
        newAddressLastName,
        newAddress,
        newAddressCity,
        newAddressState,
        newAddressPostalCode,
        newAddressHomePhone,
        newAddressMobilePhone,
        newAddressTitle
    );

    List<String> registeredAddressInfo = Arrays.asList(
        "Admin",
        "admin",
        "Grande Place",
        "Versailles",
        "Florida",
        "78000",
        "027889",
        "02558754",
        "My address"
    );

    @Given("the user is on the My Account page")
    public void startAtAccountPage()
    {
        headerPage.clickSignInButton();
        connectWithAccountNoAddresses();
    }

    private void connectWithAccountNoAddresses()
    {
        authenticationPage.enterSignInEmailAddress(ConfigReader.getProperty("email-account-no-address"));
        authenticationPage.enterSignInPassword(ConfigReader.getProperty("password-account-no-address"));
        authenticationPage.clickSignInButton();
    }

    private void connectWithAccountWithAddresses()
    {
        authenticationPage.enterSignInEmailAddress(ConfigReader.getProperty("email-account-addresses"));
        authenticationPage.enterSignInPassword(ConfigReader.getProperty("password-account-addresses"));
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

    @Given("the user is on the My Addresses page")
    public void startAtAddressesPage()
    {
        headerPage.clickSignInButton();
        connectWithAccountWithAddresses();
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

    @And("the user enters the new contact details")
    public void enterNewAddressInfo()
    {
        addressEditPage.enterFirstNameField(newAddressFirstName);
        addressEditPage.enterLastNameField(newAddressLastName);
        addressEditPage.enterAddressField(newAddress);
        addressEditPage.enterCityField(newAddressCity);
        addressEditPage.selectState(newAddressState);
        addressEditPage.enterPostalCodeField(newAddressPostalCode);
        addressEditPage.enterHomePhoneField(newAddressHomePhone);
        addressEditPage.enterMobilePhoneField(newAddressMobilePhone);
        addressEditPage.enterAddressTitleField(newAddressTitle);
    }

    @Then("the new contact details should be added")
    public void checkNewAddressInfo()
    {
        checkDataIsPresent(newAddressInfo);
    }

    @And("the user modifies their name")
    public void updateAddressFirstName()
    {
        addressEditPage.enterFirstNameField("Mike");
    }

    @Then("the contact details should be updated")
    public void checkUpdatedAddressFirstName()
    {
        Assert.assertTrue(checkTextIsPresent("Mike"));
    }

    @And("the page should contain the user's contact detail")
    public void checkRegisteredAddressInfo()
    {
        checkDataIsPresent(registeredAddressInfo);
    }

    private boolean checkTextIsPresent(String text)
    {
        return driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]")).isEmpty() == false;
    }

    private void checkDataIsPresent(List<String> data)
    {
        for (String value : data)
        {
            Assert.assertTrue(checkTextIsPresent(value));
        }
    }
}

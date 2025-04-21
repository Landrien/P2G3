package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ManageAccountSteps extends BaseSteps
{
    AccountPage accountPage = new AccountPage(driver);
    AddressesPage addressesPage = new AddressesPage(driver);
    AddressEditPage addressEditPage = new AddressEditPage(driver);

    JSONParser parser = new JSONParser();
    String addressesFilePath = "src/main/resources/addresses.json";

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

    @And("the user is on the My Addresses page")
    public void goToAddressesPage()
    {
        accountPage.clickMyAddressesButton();
    }

    @When("the user clicks on the 'Add' button")
    public void clickAddAddressButton()
    {
        //wait.until (ExpectedConditions.alertIsPresent());
        //Alert alert = driver.switchTo().alert();
        //alert.accept();

        //Assert.assertTrue(addressesPage.getAddAddressButton().isEnabled());
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addressesPage.getAddAddressButton());
        addressesPage.clickAddAddressButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("controller=address"));
    }

    @When("the user clicks on the 'Update' button")
    public void clickUpdateAddressButton()
    {
        //wait.until (ExpectedConditions.alertIsPresent());
        //Alert alert = driver.switchTo().alert();
        //alert.accept();

        //Assert.assertTrue(addressesPage.getUpdateAddressButton().isEnabled());
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addressesPage.getUpdateAddressButton());
        addressesPage.clickUpdateAddressButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlContains("controller=address"));
    }

    @And("the user clicks on the 'Validate' button")
    public void clickValidateAddressButton()
    {
        addressEditPage.clickValidateAddressButton();
    }

    @And("the user enters the address details")
    public void enterNewAddressInfo()
    {
        String addressKey = "new_address";

        addressEditPage.enterFirstNameField(getAddressElement(addressKey, "first_name"));
        addressEditPage.enterLastNameField(getAddressElement(addressKey, "last_name"));
        addressEditPage.enterAddressField(getAddressElement(addressKey, "address"));
        addressEditPage.enterCityField(getAddressElement(addressKey, "city"));
        addressEditPage.selectState(getAddressElement(addressKey, "state"));
        addressEditPage.enterPostalCodeField(getAddressElement(addressKey, "postal_code"));
        addressEditPage.enterHomePhoneField(getAddressElement(addressKey, "home_phone"));
        addressEditPage.enterMobilePhoneField(getAddressElement(addressKey, "mobile_phone"));
        addressEditPage.enterAddressTitleField(getAddressElement(addressKey, "title"));
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

    private List<String> getAddressInfo(String addressKey)
    {
        try
        {
            JSONObject addresses = (JSONObject) parser.parse(new FileReader(addressesFilePath));
            JSONObject address = (JSONObject) addresses.get(addressKey);

            List<String> addressInfo = new ArrayList<>();
            for (Object key : address.keySet())
            {
                Object value = address.get(key);
                addressInfo.add(String.valueOf(value));
            }
            return addressInfo;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private String getAddressElement(String addressKey, String elementKey)
    {
        try
        {
            JSONObject addresses = (JSONObject) parser.parse(new FileReader(addressesFilePath));
            JSONObject address = (JSONObject) addresses.get(addressKey);

            return String.valueOf(address.get(elementKey));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

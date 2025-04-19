package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AuthenticationPage;
import pages.ContactPage;
import pages.HeaderPage;
import pages.HomePage;
import utils.ConfigReader;

import static org.junit.Assert.assertTrue;

public class HomePageSteps extends BaseSteps
{
    HomePage homePage = new HomePage(driver);
    HeaderPage headerPage = new HeaderPage(driver);

    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @When("the user clicks on the 'Sign out' link")
    public void theUserClicksOnTheSignOutLink()
    {
        headerPage.clickSignOutButton();
        headerPage.clickSignOutButton();
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut()
    {
        assertTrue(headerPage.getSignInButton().isDisplayed());
    }

    @And("the login page should contain 'Sign in'")
    public void theLoginPageShouldContainSignIn()
    {
        assertTrue(headerPage.getSignInButton().getText().contains("Sign in"));
    }

    @When("The user clicks on the Blog tab")
    public void clickBlogTab()
    {
        homePage.clickBlogTab();
    }

    @Then("the user is redirected to the Prestashop blog website")
    public void checkUserIsOnPrestashopBlog()
    {
        checkNewTabUrl("prestashop.com/blog");
    }

    @When ("the user clicks on the links Sign in")
    public void clickSignInButton()
    {
        headerPage.clickSignInButton();
    }

    @Then("the user is redirected to the Authentication page")
    public void checkUserIsOnAuthenticationPage()
    {
        Assert.assertNotNull(authenticationPage.getAuthenticationTitle());
    }

    @Given("the user is on the homepage")
    public void startAtHomepage()
    {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("the user clicks on a featured advertisement")
    public void clickFeaturedAd()
    {
        homePage.clickFeaturedAd();
    }

    @Then("the user is redirected to the Prestashop website")
    public void checkUserIsOnPrestashop()
    {
        checkNewTabUrl("https://prestashop.com/");
    }

    private void checkNewTabUrl(String url)
    {
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles())
        {
            if (handle.equals(originalWindow))
                continue;

            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("the user clicks on the {string} tab")
    public void clickOnTab(String tabName)
    {
        homePage.clickOnCategoryTab(tabName);
    }

    @Then("the user is redirected to a page displaying {string} items")
    public void checkUserIsRedirectedToCategory(String tabName)
    {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        switch (tabName.toLowerCase()) {
            case "women":
                Assert.assertTrue(currentUrl.contains("id_category=3"));
                break;
            case "dresses":
                Assert.assertTrue(currentUrl.contains("id_category=8"));
                break;
            case "t-shirts":
            case "tshirts":
                Assert.assertTrue(currentUrl.contains("id_category=5"));
                break;
            default:
                Assert.fail("Unknown tab name: " + tabName);
        }
    }

    @And("the user clicks on the links Contact us")
    public void clickContactUs()
    {
        headerPage.clickContactUs();
    }

    @Then("the user is redirected to the Contact page")
    public void checkUserIsOnContactPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(ContactPage.pageUrlId));
    }

    @When("the user clicks on the home logo")
    public void clickHomePageLogo()
    {
        headerPage.clickLogoButton();
    }

    @Then("the user is redirected to the homepage")
    public void checkUserIsOnHomepage()
    {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("L'utilisateur n'est pas sur la page d'accueil. URL actuelle : " + currentUrl, "http://www.automationpractice.pl/index.php", currentUrl);
    }
}

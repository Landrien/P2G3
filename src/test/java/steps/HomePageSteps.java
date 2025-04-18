package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.HomePage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class HomePageSteps extends BaseSteps
{
    HomePage homePage = new HomePage(driver);
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @Given("the user is connected and on the homepage")
    public void theUserIsConnectedAndOnTheHomepage() {
        assertTrue(homePage.PopularButton.isDisplayed());
    }

    @When("the user clicks on the 'Sign out' link")
    public void theUserClicksOnTheSignOutLink() {
        headerPage.SignOutButton.click();
    }

    @Then("the user should be logged out")
    public void theUserShouldBeLoggedOut() {
        assertTrue(headerPage.SignInButton.isDisplayed());
    }

    @And("the login page should contain 'Sign in'")
    public void theLoginPageShouldContainSignIn() {
        assertTrue(authenticationPage.getSignInButton().isDisplayed());
        assertTrue(headerPage.SignInButton.getText().contains("Sign in"));
    }

    @Given("The user is on the {string} page")
    public void theUserIsOnThePage(String page) {
        homePage = new HomePage(driver);
    }

    @When("The user clicks on the 'BLOG' tab")
    public void theUserClicksOnTheBLOGTab() {
        homePage.clickBlogTab();
    }

    @Then("the user is redirected to the Prestashop website")
    public void theUserIsRedirectedToThePrestashopWebsite() {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.getWindowHandles().size() > 1);
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("prestashop.com/blog"));
    }


    @When ("the user clicks on the links Sign in")
    public void theUserClicksOnTheLinksSignIn() {
        homePage.clickSignIn();
    }

    @Then("the Sign in link redirects the user to the authentication page")
    public void theSignInLinkRedirectsTheUserToTheAuthenticationPage() {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            Assert.assertTrue("L'URL attendue doit contenir 'controller=authentication' et 'back=my-account' mais elle est : " + currentUrl,
                    currentUrl.contains("controller=authentication") && currentUrl.contains("back=my-account"));

    }


    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        homePage = new HomePage(driver);
    }

    @When("the user clicks on a featured advertisement")
    public void theUserClicksOnAFeaturedAdvertisement() {
        homePage.clickFeaturedAd();
    }


    @Then("the user is redirected to the Prestashop partner website")
    public void theUserIsRedirectedToThePrestashopPartnerWebsite() {
        String originalWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("https://prestashop.com/"));
    }



    @When("the user clicks on the {string} tab")
    public void theUserClicksOnTheTab(String tabName) {
        homePage.clickOnCategoryTab(tabName);
    }

    @Then("the user is redirected to a page displaying {string} items")
    public void theUserIsRedirectedToAPageDisplayingItems(String tabName) {
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
    public void theUserClicksOnTheLinksContactUs() {
        homePage.clickContactUs();
    }


    @Then("the Contact us link redirects the user to the contact page")
    public void theContactUsLinkRedirectsTheUserToTheContactPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("controller=contact"));
    }

}

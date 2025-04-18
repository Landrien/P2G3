package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthenticationPage;
import pages.ContactPage;
import pages.HeaderPage;
import pages.HomePage;

import java.time.Duration;

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

    @Given("The user is on the {string} page")
    public void theUserIsOnThePage(String page)
    {
        switch (page.toLowerCase())
        {
            case "homepage":
                driver.get("http://www.automationpractice.pl/index.php");
                break;
            case "authentication":
                driver.get("http://www.automationpractice.pl/index.php?controller=authentication");
                break;
            case "search_results":
                driver.get("http://www.automationpractice.pl/index.php?controller=search&search_query=dress&submit_search=");
                break;
            case "article_detail":
                driver.get("http://www.automationpractice.pl/index.php?id_product=1&controller=product");
                break;
            default:
                throw new IllegalArgumentException("Page inconnue : " + page);
        }
    }

    @When("The user clicks on the 'BLOG' tab")
    public void theUserClicksOnTheBLOGTab()
    {
        homePage.clickBlogTab();
    }

    @Then("the user is redirected to the Prestashop website")
    public void theUserIsRedirectedToThePrestashopWebsite()
    {
        goToNewTabUrl("prestashop.com/blog");
    }

    @When ("the user clicks on the links Sign in")
    public void theUserClicksOnTheLinksSignIn()
    {
        headerPage.clickSignInButton();
    }

    @Then("the Sign in link redirects the user to the authentication page")
    public void theSignInLinkRedirectsTheUserToTheAuthenticationPage()
    {
        Assert.assertNotNull(authenticationPage.getAuthenticationTitle());
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage()
    {
        // TODO To remove
    }

    @When("the user clicks on a featured advertisement")
    public void theUserClicksOnAFeaturedAdvertisement()
    {
        homePage.clickFeaturedAd();
    }

    @Then("the user is redirected to the Prestashop partner website")
    public void theUserIsRedirectedToThePrestashopPartnerWebsite()
    {
        goToNewTabUrl("https://prestashop.com/");
    }

    private void goToNewTabUrl(String url)
    {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> driver.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles())
        {
            if (handle.equals(originalWindow))
                continue;

            driver.switchTo().window(handle);
        }
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    @When("the user clicks on the {string} tab")
    public void theUserClicksOnTheTab(String tabName)
    {
        homePage.clickOnCategoryTab(tabName);
    }

    @Then("the user is redirected to a page displaying {string} items")
    public void theUserIsRedirectedToAPageDisplayingItems(String tabName)
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
    public void theUserClicksOnTheLinksContactUs()
    {
        headerPage.clickContactUs();
    }

    @Then("the Contact us link redirects the user to the contact page")
    public void theContactUsLinkRedirectsTheUserToTheContactPage()
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(ContactPage.pageUrlId));
    }

    @When("the user clicks on the logo")
    public void theUserClicksOnTheLogo()
    {
        headerPage.clickLogoButton();
    }

    @Then("the user is redirected to the homepage")
    public void checkHomePageDisplayed()
    {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("L'utilisateur n'est pas sur la page d'accueil. URL actuelle : " + currentUrl,
                currentUrl.equals("http://www.automationpractice.pl/index.php"));
    }
}

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CategoryPage;
import pages.ContactPage;
import pages.HeaderPage;
import pages.HomePage;
import utils.ConfigReader;

/**
 * Actions and verifications related to the homepage,
 * including navigation through tabs, redirects to external links, and core homepage elements.
 */
public class HomePageSteps extends BaseSteps
{
    HomePage homePage = new HomePage(driver);
    HeaderPage headerPage = new HeaderPage(driver);

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

    @When ("the user clicks on the Sign in link")
    public void clickSignIn()
    {
        headerPage.clickSignInButton();
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
                Assert.assertTrue(currentUrl.contains(CategoryPage.womenCategoryId));
                break;
            case "dresses":
                Assert.assertTrue(currentUrl.contains(CategoryPage.dressesCategoryId));
                break;
            case "t-shirts":
                Assert.assertTrue(currentUrl.contains(CategoryPage.tShirtsCategoryId));
                break;
            default:
                Assert.fail("Unknown tab name: " + tabName);
        }
    }

    @And("the user clicks on the Contact us link")
    public void clickContactUs()
    {
        headerPage.clickContactUsButton();
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

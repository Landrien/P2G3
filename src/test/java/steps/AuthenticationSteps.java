package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.ResetPasswordPage;
import utils.ConfigReader;
import utils.Yopmail;

import java.time.Duration;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;
import static utils.RandomUtils.getRandomEmail;

/**
 * Step definitions for authentication-related features
 *  Logging in and out with default credentials
 *  Account creation scenarios with valid/invalid inputs
 *  Password reset flow using a disposable Yopmail email address
 */
public class AuthenticationSteps extends BaseSteps
{
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
    Yopmail yopmail = new Yopmail(driver);

    private final String defaultAccountEmail = ConfigReader.getProperty("default-account-email");
    private final String defaultAccountPassword = ConfigReader.getProperty("default-account-password");

    private final String defaultAccountFirstName = ConfigReader.getProperty("default-account-first-name");
    private final String defaultAccountLastName = ConfigReader.getProperty("default-account-last-name");

    private final String randomEmail = getRandomEmail();
    private String newPassword = "";

    @Given("the user is connected with the default account")
    public void connectDefaultAccount()
    {
        headerPage.clickSignInButton();
        authenticationPage.connect(defaultAccountEmail, defaultAccountPassword);
    }

    @Given("the user is on the Authentication page")
    public void startAtAuthenticationPage()
    {
        headerPage.clickSignInButton();
    }

    @Given("the user is on the Create an account page")
    public void startAtCreateAccountPage()
    {
        headerPage.clickSignInButton();

        authenticationPage.enterCreateEmailAddress(randomEmail);
        authenticationPage.clickCreateAccountButton();
    }

    @When("the user clicks on the 'Sign out' button")
    public void clickSignOutButton()
    {
        headerPage.clickSignOutButton();
    }

    @Then("the user should be logged out and 'Sign in' displayed")
    public void checkUserIsLoggedOut()
    {
        assertTrue(headerPage.getSignInButton().getText().contains("Sign in"));
    }

    @Then("the user is redirected to the Authentication page")
    public void checkUserIsOnAuthenticationPage()
    {
        Assert.assertNotNull(authenticationPage.getAuthenticationTitle());
    }

    @And("the user clicks on the Create an account button")
    public void clickCreateAccountButton()
    {
        authenticationPage.clickCreateAccountButton();
    }

    @When("the user enters a valid account creation email address")
    public void enterValidCreateEmail()
    {
        authenticationPage.enterCreateEmailAddress(randomEmail);
    }

    @When("the user enters an account creation email address with an invalid format")
    public void enterInvalidCreateEmail()
    {
        authenticationPage.enterCreateEmailAddress("bad-email");
    }

    @Then("an error message Invalid email address is displayed")
    public void checkInvalidCreateEmailErrorMessage()
    {
        Assert.assertNotNull(authenticationPage.getInvalidEmailErrorMessage());
    }

    @When("the user enters a valid sign in email address")
    public void enterValidSignInEmail()
    {
        authenticationPage.enterSignInEmailAddress(defaultAccountEmail);
    }

    @And("the user enters an incorrect password")
    public void enterInvalidRegisterPassword()
    {
        authenticationPage.enterSignInPassword("bad-password");
    }

    @Then("an error message Invalid password is displayed")
    public void checkInvalidPasswordErrorMessage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']"))
        );
        assertTrue(errorElement.isDisplayed());
    }


    @And("the user enters the password associated with their account")
    public void enterValidSignInPassword()
    {
        authenticationPage.enterSignInPassword(defaultAccountPassword);
    }

    @And("the user clicks on the sign in button")
    public void clickSignInButton()
    {
        authenticationPage.clickSignInButton();
    }

    @Then("the My Account page is displayed")
    public void checkAccountPageDisplayed()
    {
        assertTrue(headerPage.getSignOutButton().getText().contains("Sign out"));
    }

    @And("the first name and last name of the user are displayed")
    public void checkFirstNameLastNameInMenuBar()
    {
        assertTrue(headerPage.getUserAccountButton().getText().contains(defaultAccountFirstName + " " + defaultAccountLastName));
    }

    @When("the user clicks on the 'Forgot your password' link")
    public void clickForgotPasswordLink()
    {
        resetPasswordPage.clickForgotPasswordButton();
    }

    @Then("the user is redirected to the password reset page")
    public void checkForgottenPasswordText()
    {
        assertTrue(resetPasswordPage.getForgotPasswordTitle().isDisplayed());
    }

    @And("the user clicks on the 'Retrieve Password' button")
    public void clickRetrievePasswordButton()
    {
        resetPasswordPage.clickRetrievePasswordButton();
    }

    @Then("a confirmation message is displayed")
    public void checkPasswordResetConfirmationMessage()
    {
        assertTrue(resetPasswordPage.getRetrievePasswordConfirmationMessage().isDisplayed());
    }

    @When("the user enters a valid email address associated with an account")
    public void EntersAValidEmailAddress() {
        resetPasswordPage.getEmailField().sendKeys(randomEmail);

    }


    @Then("a confirmation message is displayed indicating that an email has been sent")
    public void ConfirmationMessage() {
        resetPasswordPage.getRetrievePasswordConfirmationMessage().isDisplayed();
    }

    @And("the user receives an email containing a reset link")
    public void ReceivesAnEmailContainingAResetLink() {

        yopmail.openYopmail();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), 'Autoriser')]/..")));
        yopmail.getAcceptCookiesButton().click();
        yopmail.enterEmail(randomEmail);
        yopmail.clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wmmail']")));

    }

    @And("the user clicks on the reset link in the email")
    public void ClicksOnTheResetLink() {
        yopmail.waitmail1();
        yopmail.switchToIframe();
        yopmail.getEmailLink().click();
    }

    @Then("the user open the new page")
    public void OpenTheNewPage() {
        yopmail.switchToDefaultContent();
        yopmail.switchToNewTab();
    }
    @And("the user sees a confirmation message")
    public void SeesAConfirmationMessage() {
        assertTrue(resetPasswordPage.getRetrievePasswordConfirmationMessage().isDisplayed());
    }

    @And("the user returns to their mailbox")
    public void ReturnsToTheirMailbox(){
        yopmail.switchToMailTab();
        yopmail.waitmail2();
        yopmail.getRefreshButton().click();
    }

    @And("the user obtains the new password")
    public String ObtainsTheNewPassword(){
        yopmail.switchToIframe();
        String fullPassword = yopmail.getPassword();
        String[] parts = fullPassword.split(" ");
        String password = parts[3];
        Logger.getLogger("ObtainsTheNewPassword").info("Obtaining the new password " + password);
        return newPassword = password;
    }

    @Then("the user returns to the Authentication page")
    public void ReturnsToTheAuthenticationPage() {
        yopmail.switchToOriginTab();
        headerPage.clickSignInButton();
    }

    @And("enters their email address")
    public void entersTheirEmailAddress() {
        authenticationPage.enterSignInEmailAddress(randomEmail);
    }

    @And("the user enters the new password")
    public void theUserEntersTheNewPassword(){
        authenticationPage.enterSignInPassword(newPassword);
    }
}

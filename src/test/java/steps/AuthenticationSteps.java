package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AuthenticationPage;
import pages.HeaderPage;
import pages.ResetPasswordPage;
import utils.ConfigReader;
import utils.Yopmail;

import static org.junit.Assert.assertTrue;
import static utils.RandomString.getRandomString;

public class AuthenticationSteps extends BaseSteps
{
    HeaderPage headerPage = new HeaderPage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
    Yopmail yopmail = new Yopmail(driver);

    // TODO / Manage this data better

    private final String registeredAccountEmail = ConfigReader.getProperty("email-account-addresses");
    private final String registeredAccountPassword = ConfigReader.getProperty("password-account-addresses");

    private final String registeredAccountFirstName = "Admin";
    private final String registeredAccountLastName = "admin";
    private final String disposableAccountEmail = "kemeufexauqua-6861@yopmail.com";

    @Given("the user is connected with an account and no registered addresses")
    public void connectNoAddressesAccount()
    {
        headerPage.clickSignInButton();
        authenticationPage.connectNoAddressAccount();
    }

    @Given("the user is connected with an account with addresses")
    public void connectWithAddressesAccount()
    {
        headerPage.clickSignInButton();
        authenticationPage.connectAddressesAccount();
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

        String randomEmail = getRandomString() + "@gmail.com";
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
        String randomEmail = getRandomString() + "@gmail.com";
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
        authenticationPage.enterSignInEmailAddress("admin13@gmail.com");
    }

    @And("the user enters an incorrect password")
    public void enterInvalidRegisterPassword()
    {
        authenticationPage.enterSignInPassword("bad-password");
    }

    @Then("an error message Invalid password is displayed")
    public void checkInvalidPasswordErrorMessage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= \"alert alert-danger\"]")));
        assertTrue(authenticationPage.getInvalidPasswordErrorMessage().isDisplayed());
    }

    @And("the user enters the password associated with their account")
    public void enterValidRegisterPassword()
    {
        authenticationPage.enterSignInPassword(registeredAccountPassword);
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
    public void checkFirstNameLastDisplayed()
    {
        assertTrue(headerPage.getUserAccountButton().getText().contains(registeredAccountFirstName + " " + registeredAccountLastName));
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
        resetPasswordPage.getEmailField().sendKeys(disposableAccountEmail);

    }


    @Then("a confirmation message is displayed indicating that an email has been sent")
    public void ConfirmationMessage() {
        resetPasswordPage.getRetrievePasswordConfirmationMessage().isDisplayed();
    }

    @And("the user receives an email containing a reset link")
    public void ReceivesAnEmailContainingAResetLink() {

        yopmail.openYopmail();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'fc-dialog-container']")));
        yopmail.getAcceptCookiesButton().click();
        yopmail.enterEmail(disposableAccountEmail);
        yopmail.clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='bname']")));

    }

    @And("the user clicks on the reset link in the email")
    public void ClicksOnTheResetLink() {
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
    public void ReturnsToTheirMailbox() throws InterruptedException {
        yopmail.switchToMailTab();
        Thread.sleep(5000);
        yopmail.getRefreshButton().click();
    }

    @And("the user obtains the new password")
    public String ObtainsTheNewPassword(){
        return yopmail.getPassword().getText();

    }

    @Then("the user returns to the Authentication page")
    public void ReturnsToTheAuthenticationPage() {
        yopmail.switchToOriginTab();
        headerPage.clickSignInButton();
    }

    @And("enters their email address")
    public void entersTheirEmailAddress() {
        authenticationPage.enterSignInEmailAddress(disposableAccountEmail);
    }

    @And("the user enters the new password")
    public void theUserEntersTheNewPassword(){
        authenticationPage.enterSignInPassword(ObtainsTheNewPassword());
    }
}

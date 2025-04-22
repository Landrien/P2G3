package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;

/**
 * Class to interact with the Yopmail service.
 * Extends {@link BasePage} to inherit WebDriver and common methods.
 */
public class Yopmail extends BasePage {

    // ---------- WebElements ----------

    @FindBy(id = "login")
    private WebElement emailField;

    @FindBy(xpath = "//button[@class = 'md']")
    private WebElement searchButton;

    @FindBy(xpath = "//span/a")
    private WebElement emailLink;

    @FindBy(id = "ifmail")
    private WebElement iframe;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//strong[text()='Password:']/parent::span/parent::span")
    private WebElement password;

    @FindBy(xpath = "//p[contains(text(), 'Autoriser')]/..")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[@id='nbmail']")
    private WebElement nbrMail;

    // ---------- Constructor ----------

    /**
     * Constructor for the Yopmail page.
     *
     * @param driver the WebDriver used for automation.
     */
    public Yopmail(WebDriver driver) {
        super(driver);
    }

    // ---------- Getters ----------

    public WebElement getEmailLink() {
        return emailLink;
    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

    // ---------- Page Actions ----------

    /**
     * Enters an email address into the input field.
     *
     * @param email the email address to input.
     */
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    /**
     * Clicks the search button to open the mailbox.
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Retrieves the password from the received email.
     *
     * @return the password as plain text.
     */
    public String getPassword() {
        return password.getText();
    }

    // ---------- Iframe Navigation ----------

    /**
     * Switches to the iframe containing the email content.
     */
    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    /**
     * Switches back to the main content outside of the iframe.
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // ---------- Tab Management ----------

    /**
     * Switches to the original tab (the first opened tab).
     */
    public void switchToOriginTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    /**
     * Switches to the second tab (supposed to be the Yopmail inbox).
     */
    public void switchToMailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    /**
     * Switches to the third tab, if available.
     */
    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    /**
     * Opens a new browser tab and navigates to Yopmail.
     */
    public void openYopmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/fr/");
    }

    // ---------- Email Waiting ----------

    /**
     * Waits until one email is detected ("1 mail" appears).
     */
    public void waitmail1() {
        while (!nbrMail.getText().contains("1 mail")) {
            try {
                Thread.sleep(1000); // Wait 1 second
                getRefreshButton().click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Waits until two emails are detected ("2 mails" appears).
     */
    public void waitmail2() {
        while (!nbrMail.getText().contains("2 mails")) {
            try {
                Thread.sleep(1000); // Wait 1 second
                getRefreshButton().click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

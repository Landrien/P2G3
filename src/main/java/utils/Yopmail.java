package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;

public class Yopmail extends BasePage {

    @FindBy(id = "login")
    private WebElement emailField;
    @FindBy(xpath = "//button[@class = 'md']")
    private WebElement searchButton;
    @FindBy(xpath = "//span/a")
    private WebElement emailLink;
    @FindBy (id = "ifmail")
    private WebElement iframe;
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    //@FindBy(xpath = "//span/text()[4]")
    @FindBy(xpath = "//strong[text()='Password:']/parent::span/parent::span")
    private WebElement password;
    @FindBy(xpath = "//div[@class = 'fc-dialog-container']")
    private WebElement pageCookies;
    @FindBy(xpath = "//p[contains(text(), 'Autoriser')]/..")
    private WebElement acceptCookiesButton;
    @FindBy(xpath = "//div[@id='nbmail']")
    private WebElement nbrMail;



    public Yopmail(WebDriver driver) {
        super(driver);
    }

    public void openYopmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/fr/");

    }
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }
    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getEmailLink() {
        return emailLink;
    }
    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    public void switchToOriginTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
    public void switchToMailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public String getPassword() {
        return password.getText();
    }

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

    public WebElement getPageCookies() {
        return pageCookies;
    }
    public void waitmail1() {
        while (!nbrMail.getText().contains("1 mail")) {
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
                getRefreshButton().click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void waitmail2() {
        while (!nbrMail.getText().contains("2 mails")) {
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
                getRefreshButton().click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

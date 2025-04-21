package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;

public class Yopmail extends BasePage {

    @FindBy(id = "ycptcpt")
    private WebElement emailField;
    @FindBy(xpath = "//button[@class = 'md']")
    private WebElement searchButton;
    @FindBy(xpath = "//span/a")
    private WebElement emailLink;
    @FindBy (id = "ifmail")
    private WebElement iframe;
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//span/span[2]")
    private WebElement password;
    @FindBy(xpath = "//div[@class = 'fc-dialog-container']")
    private WebElement pageCookies;
    @FindBy(xpath = "//button[@class = 'fc-button fc-cta-consent fc-primary-button']")
    private WebElement acceptCookiesButton;



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

    public WebElement getPassword() {
        return password;
    }

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

    public WebElement getPageCookies() {
        return pageCookies;
    }
}

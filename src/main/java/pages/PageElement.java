package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElement extends BasePage {

    @FindBy(xpath = "//a[@class= \"logout\"]")
    public WebElement SignOutButton;

    @FindBy(xpath = "//a[@class= \"login\"]")
    public WebElement SignInButton;

    @FindBy(xpath = "//a[@class= \"account\"]")
    public WebElement AccountButton;

    @FindBy(xpath = "//a[@title= \"My Shop\"]")
    public WebElement HomePageButton;

    public PageElement(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSignOutButton() {
        SignOutButton.click();
    }
    public void clickSignInButton() {
        SignInButton.click();
    }
    public void clickLogoButton() {HomePageButton.click();
    }


}

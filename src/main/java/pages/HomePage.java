package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class=\"homefeatured\"]")
    public WebElement PopularButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * A base page parent class handling the web driver and the initialization of find by elements for all child classes
 */
public class BasePage
{
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver driver;
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * A base page parent class handling the web driver and the initialization of find by elements for all child classes
 * All page classes should extend this class to reuse common behavior.
 */
public class BasePage
{
    /**
     * Constructor that initializes the WebDriver and WebElements for the page.
     * @param driver The WebDriver instance used across the page objects.
     */
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        initializePage();
    }

    public void initializePage()
    {
        PageFactory.initElements(driver, this);
    }

    protected WebDriver driver;
}

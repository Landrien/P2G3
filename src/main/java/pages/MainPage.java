package pages;

import org.openqa.selenium.WebDriver;

/**
 * The parent page for the majority of pages on the website, containing the header and footer available on all pages
 */
public class MainPage extends BasePage
{
    public MainPage(WebDriver driver)
    {
        super(driver);
    }
}

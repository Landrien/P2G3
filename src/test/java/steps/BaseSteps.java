package steps;

import hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;

/**
 * Base class for step definitions providing common utilities and access to the WebDriver.
 */

public class BaseSteps
{
    protected WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    boolean checkTextIsPresent(String text)
    {
        return driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]")).isEmpty() == false;
    }

    void checkTextsArePresent(List<String> texts)
    {
        for (String text : texts)
        {
            Assert.assertTrue(checkTextIsPresent(text));
        }
    }
}

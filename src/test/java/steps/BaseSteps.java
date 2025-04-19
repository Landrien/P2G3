package steps;

import hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BaseSteps
{
    protected WebDriver driver = Hooks.getDriver();

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

package steps;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseStep
{
    protected WebDriver driver = Hooks.getDriver();
}

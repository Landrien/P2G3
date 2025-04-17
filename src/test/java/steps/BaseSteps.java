package steps;

import hooks.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseSteps
{
    protected WebDriver driver = Hooks.getDriver();
}

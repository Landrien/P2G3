package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;

public class Hooks
{
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        return driver;
    }

    @Before
    public void init()
    {
        switch (ConfigReader.getProperty("browser"))
        {
            case "edge":
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            case "Chrome":
            default:
                driver = new ChromeDriver();
        }

        long duration = Long.parseLong(ConfigReader.getProperty("timeout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));

        driver.manage().window().maximize();

        String url = ConfigReader.getProperty("url");
        driver.get(url);
    }

    @After
    public void exit(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        driver.quit();
    }
}

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Hooks
{
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        return driver;
    }

    @Before
    public void init() {
        String gridUrl = System.getProperty("grid.url");
        String browser = ConfigReader.getProperty("browser");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            if (gridUrl != null && !gridUrl.isEmpty()) {
                switch (browser.toLowerCase()) {
                    case "firefox":
                        capabilities.setBrowserName("firefox");
                        break;
                    case "edge":
                        capabilities.setBrowserName("MicrosoftEdge");
                        break;
                    case "chrome":
                    default:
                        capabilities.setBrowserName("chrome");
                        break;
                }

                driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
            } else {
                // Fallback local execution
                switch (browser.toLowerCase()) {
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    case "chrome":
                    default:
                        driver = new ChromeDriver();
                        break;
                }
            }

            long duration = Long.parseLong(ConfigReader.getProperty("timeout"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
            driver.manage().window().maximize();
            driver.get(ConfigReader.getProperty("url"));

        } catch (MalformedURLException e) {
            throw new RuntimeException("Grid URL malformée : " + gridUrl, e);
        }
    }

    @After
    public void exit(Scenario scenario)
    {
        if (driver != null) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            driver.quit();
        } else {
            System.out.println("Driver was null during @After. Possible initialization failure.");
        }
    }
}

package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ConfigReader;

import java.time.Duration;

public class Hooks {

    private WebDriver driver;

    @Before
    public void init() {
        driver = DriverFactory.getDriver();

        long duration = Long.parseLong(ConfigReader.getProperty("timeout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));

        driver.manage().window().maximize();

        String url = ConfigReader.getProperty("url");
        driver.get(url);
    }

    @After
    public void exit(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverFactory.quitDriver();
    }
}

package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver createDriver() {
        try {
            String gridIp = System.getProperty("grid.ip"); // récupéré via Jenkins ou CLI
            String browser = ConfigReader.getProperty("browser");

            if (browser == null || browser.isEmpty()) {
                browser = "chrome"; // fallback
            }

            if (gridIp != null && !gridIp.isEmpty()) {
                System.out.println("[INFO] Utilisation du Selenium Grid à l'adresse : http://" + gridIp + ":4444/wd/hub");

                URL remoteUrl = new URL("http://" + gridIp + ":4444/wd/hub");

                switch (browser.toLowerCase()) {
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        return new RemoteWebDriver(remoteUrl, firefoxOptions);
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        return new RemoteWebDriver(remoteUrl, edgeOptions);
                    case "chrome":
                    default:
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                        return new RemoteWebDriver(remoteUrl, chromeOptions);
                }
            } else {
                System.out.println("[INFO] Exécution en local.");

                switch (browser.toLowerCase()) {
                    case "firefox":
                        return new FirefoxDriver();
                    case "edge":
                        return new EdgeDriver();
                    case "chrome":
                    default:
                        return new ChromeDriver();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création du WebDriver", e);
        }
    }
}

package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/2_POEI25P2G3-18_POEI25P2G3-54.feature",
        //features = "src/test/resources/features/2_POEI25P2G3-7.feature",
        glue = {"steps", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class TestRunner
{
}

package util;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@CucumberOptions(
        strict = true,
        plugin = { "json:target/cucumber-report.json",
                "html:target/cucumber-report"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

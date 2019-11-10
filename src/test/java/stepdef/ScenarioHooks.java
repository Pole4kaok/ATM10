package stepdef;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

public class ScenarioHooks {
    WebDriver driver;
    @Before
    public void beforeScenario(){
    }

    @After
    public void afterScenario(){
        driver.close();
    }
}

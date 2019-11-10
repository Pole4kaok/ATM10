package pageobject.test;

import driver.ChromeCreator;
import driver.DriverDecorator;
import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.page.*;
import util.TestListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
@Listeners({TestListener.class})
public class CommonConditions {

    public WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        DriverSingleton creator = new ChromeCreator();
        driver = creator.getDriver();
        driver = new DriverDecorator(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserClose(){
       driver.quit();
    }
}

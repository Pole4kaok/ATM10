package pageobject.page.calendarPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.page.AbstractPage;

public class CalendarPage extends AbstractPage {
    protected static final By CALENDARSLOT_LOCATOR = By.xpath("//*[@id=\"calendar\"]/div/div/div/div[3]/div/table/tbody/tr[7]/td/div");
    protected static final By EVENTTYPE_LOCATOR = By.name("eventTypeID");
    protected static final By RESOURCETYPE_LOCATOR = By.xpath("//*[@name=\"eventTypeID\"]/option[2]");
    protected static final By SESSIONNAME_LOCATOR = By.name("event.eventName");
    protected static final  By ALLDAYCHECKBOX_LOCATOR = By.id("allDayFlag");
    protected static final By SEARCHLINK_LOCATOR = By.xpath("//*[@id=\"eventForm\"]/div[2]/div[1]/table/tbody/tr[2]/td[2]/a");
   // protected static final By ACTORTYPE_LOCATOR = By.name("actorSearchParameters.calendarTypeID");
    protected static final By ACTORNAME_LOCATOR = By.name("actorSearchParameters.name");
    protected static final By SUBMITBTN_LOCATOR = By.xpath("//*[@id=\"searchSection\"]/table[2]/tbody/tr/td/input[1]");
    protected static final By SUBMITRESULT_LOCATOR = By.className("ct-resultsTable");
    protected static final By RESOURCE_LOCATOR = By. xpath("//*[@id=\"resultsAll\"]/table/tbody/tr[1]/td[1]");
    protected static final By AVAILABILITY_LOCATOR = By.name("event.availabilityType.ID");
    protected static final By SAVEBTN_LOCATOR = By.id("saveButton");
    protected static final By CREATEDEVENT_LOCATOR = By.xpath("//div[contains(@class,\"calendar-event\")][.=\"Mein Session 2\"]");
    protected static final By CREATEDSESSIONNAME_LOCATOR = By.xpath("//*[@id=\"eventPreviewPopup\"]/div/table/tbody/tr[2]/td[2]");
    protected static final By SUCCESSMESSAGE_LOCATOR = By.xpath("//*[@id=\"mainLayoutTable\"]/tbody/tr/td[2]/div[3]");

    public CalendarPage(WebDriver driver){super(driver);}
    public CalendarPage createNewResSchedule(String sessionName, String resourceName){
        WebElement calendarSlot = driver.findElement(CALENDARSLOT_LOCATOR);
        customWait(calendarSlot);
        //driver.findElement(CALENDARSLOT_LOCATOR).click();
        waitElementClickable(EVENTTYPE_LOCATOR);
        driver.findElement(EVENTTYPE_LOCATOR).click();
        driver.findElement(RESOURCETYPE_LOCATOR).click();

        waitElementVisible(SESSIONNAME_LOCATOR);
        driver.findElement(SESSIONNAME_LOCATOR).sendKeys(sessionName);
        driver.findElement(ALLDAYCHECKBOX_LOCATOR).click();
        driver.findElement(SEARCHLINK_LOCATOR).click();

        searchResource(resourceName);
        waitElementVisible(AVAILABILITY_LOCATOR);
        driver.findElement(AVAILABILITY_LOCATOR).sendKeys("Available");
        WebElement saveButton = driver.findElement(SAVEBTN_LOCATOR);
        customWait(saveButton);
        return this;
    }

    public CalendarPage searchResource(String resourceName){
        waitElementVisible(ACTORNAME_LOCATOR);
        driver.findElement(ACTORNAME_LOCATOR).sendKeys(resourceName);
        //driver.findElement(SUBMITBTN_LOCATOR).click();
        WebElement submitButton = driver.findElement(SUBMITBTN_LOCATOR);
        customWait(submitButton);

        waitElementVisible(SUBMITRESULT_LOCATOR);
        //driver.findElement(RESOURCE_LOCATOR).click();
        WebElement foundResource = driver.findElement(RESOURCE_LOCATOR);
        customWait(foundResource);
        return this;
    }

    public String checkCreatedSession(){
//        waitElementVisible(SUCCESSMESSAGE_LOCATOR);
        waitElementClickable(CREATEDEVENT_LOCATOR);
        WebElement createdEvent = driver.findElement(CREATEDEVENT_LOCATOR);
        new Actions(driver).contextClick(createdEvent).build().perform();
        waitElementVisible(CREATEDSESSIONNAME_LOCATOR);
        String createSessionName = driver.findElement(CREATEDSESSIONNAME_LOCATOR).getText();
        return createSessionName;
    }
}

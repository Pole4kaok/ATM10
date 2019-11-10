package pageobject.page.calendarPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobject.page.AbstractPage;

public class ResourceViewPage extends AbstractPage {
    protected static final By DRAGGEDELEMENT_LOCATOR = By.xpath("(//div[contains(@class,\"gv-block\")][.=\"Mein Session 2\"])[1]");
    protected static final By ELEMENTAFTERDROP_LOCATOR = By.xpath("(//div[contains(@class,\"ui-draggable\")][.=\"Mein Session 2\"])");
    protected static final By DROPPEDELEMENT_LOCATOR = By.xpath("(//div[contains(@class,\"gv-block\")][.=\"Mein Session 3\"])[1]");
    protected static final By POPUP_LOCATOR = By.xpath("(//div[contains(@class,\"ui-dialog-titlebar\")])");
    protected static final By EDIT_EVENT_POPUP_LOCATOR = By.xpath("(//span[contains(@id,\"ui-dialog-title-1\")])");
    protected static final By EVENTNAME_LOCATOR = By.name("event.eventName");
    protected static final By OKBTN_LOCATOR = By.xpath("(//input[contains(@value,\"OK\")])");
    protected static final By NEWDATEVALUE_LOCATOR = By.xpath("(//span[contains(@class,\"ct-content\")])[2]");
    protected static final By EVENT_START_DATE_LOCATOR = By.name("endDate.dateField");
    protected static final By SAVEBTN_LOCATOR = By.id("saveButton");
    public ResourceViewPage(WebDriver driver){super(driver);}
    public ResourceViewPage dragAndDrop(){
        WebElement element = driver.findElement(DRAGGEDELEMENT_LOCATOR);
        WebElement position = driver.findElement(DROPPEDELEMENT_LOCATOR);
        new Actions(driver).dragAndDrop(element, position).build().perform();
        return this;
    }

    public String getNewDateValue(){
        waitElementVisible(POPUP_LOCATOR);
        WebElement okBtn = driver.findElement(OKBTN_LOCATOR);
        String newDate = driver.findElement(NEWDATEVALUE_LOCATOR).getText();
        customWait(okBtn);
        return newDate;
    }

    public String verifyNewDate(){
        waitAjaxFinished();
        driver.findElement(ELEMENTAFTERDROP_LOCATOR).click();
        //waitElementVisible(EDIT_EVENT_POPUP_LOCATOR);
        waitAjaxFinished();
        String getNewDate = driver.findElement(EVENT_START_DATE_LOCATOR).getAttribute("value");
        WebElement saveBtn = driver.findElement(SAVEBTN_LOCATOR);
        customWait(saveBtn);
        return getNewDate;
    }

}

package pageobject.test;

import model.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.page.calendarPages.CalendarPage;
import pageobject.page.LoginPage;
import pageobject.page.MainPage;
import pageobject.page.calendarPages.ResourceViewPage;
import service.UserCreator;

public class CalendarTest extends CommonConditions {
    @Test(description = "create resource schedule")
    public void createResourceScheduleSession(){
       // driver.get("https://qa-cms.cefile-app.com");
        UserModel testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new LoginPage(driver).open().login(testUser);
        mainPage.openCalendar();
        String sessionName = "Mein Session 2";
        CalendarPage calendarPage = new CalendarPage(driver).createNewResSchedule(sessionName, "Charles");
        String createdSessionName = new CalendarPage(driver).checkCreatedSession();
        Assert.assertEquals(sessionName,createdSessionName);

    }

    @Test(description = "drag and drop try")
    public void dragAndDropResource(){
       // driver.get("https://qa-cms.cefile-app.com");
        LoginPage loginPage = new LoginPage(driver);
        UserModel testUser = UserCreator.withCredentialsFromProperty();
        loginPage.open().login(testUser);
        MainPage resourceView = new MainPage(driver).openResourceView();
        ResourceViewPage resourceViewPage = new ResourceViewPage(driver).dragAndDrop();
        String newDate = resourceViewPage.getNewDateValue();
        String getNewDate = resourceViewPage.verifyNewDate();
        Assert.assertEquals(newDate,getNewDate);

    }

}

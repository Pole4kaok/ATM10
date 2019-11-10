package pageobject.page.casePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.page.AbstractPage;
import pageobject.page.MainPage;

public class CaseSearchPage extends AbstractPage {
    protected static final By CASENUMBER_FIELD_LOCATOR = By.xpath("//*[@id=\"caseSection\"]/table/tbody/tr[1]/td[2]/input");
    protected static final By SEARCHBTN_LOCATOR = By.xpath("(//input[@value='Search'])[2]");
    protected static final By SEARCHRESULT_LOCATOR = By.xpath("//*[@id=\"caseSearchResultsTable\"]/table/tbody/tr/td[1]");
    public CaseSearchPage(WebDriver driver){super(driver);}

    public CaseSearchPage caseSearch(String caseNumber){
        driver.findElement(MainPage.CASEMENU_LOCATOR).click();
        waitElementClickable(MainPage.CASE_SEARCH_LOCATOR);
        driver.findElement(MainPage.CASE_SEARCH_LOCATOR).click();
        driver.findElement(CASENUMBER_FIELD_LOCATOR).sendKeys(caseNumber);
        WebElement searchBtn = driver.findElement(SEARCHBTN_LOCATOR);
        searchBtn.click();
        waitElementClickable(SEARCHRESULT_LOCATOR);
        driver.findElement(SEARCHRESULT_LOCATOR).click();
        return this;
    }

}

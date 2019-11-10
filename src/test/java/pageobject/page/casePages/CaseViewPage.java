package pageobject.page.casePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import pageobject.page.AbstractPage;

public class CaseViewPage extends AbstractPage {
    private static final By RULES_ENGINE_LOCATOR = By.xpath("//*[@id=\"caseRulesEnginePolling\"]/td/div/span[2]/span");
    private static final By CASE_INFO_LOCATOR = By.xpath("//td/span[@class='ct-content']");

    private String rulesEngineComplete = "Rules Engine Complete";
    public CaseViewPage(WebDriver driver){super(driver);}

    public String getCaseNumber(){
        waitRulesEngineComplete(RULES_ENGINE_LOCATOR,rulesEngineComplete);
       return getFoundCaseNumber();
    }

   public String getFoundCaseNumber(){
        WebElement caseInfo = driver.findElement(CASE_INFO_LOCATOR);
        String caseNumber = caseInfo.getText();
        return caseNumber;
    }


}

package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import model.CaseModel;
import model.PersonModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobject.page.MainPage;
import pageobject.page.casePages.AddPartyPage;
import pageobject.page.casePages.CaseEventPage;
import pageobject.page.casePages.EditCaseViewPage;
import pageobject.test.CommonConditions;
import service.CaseCreator;
import service.PersonCreator;

import java.util.List;

public class CheckListSteps{
    // WebDriver driver = new ChromeDriver();
    WebDriver driver;


    @And("^I add party with type \"([^\"]*)\" and role \"([^\"]*)\"$")
    public void addParty(String partyType, String partyRole){
        PersonModel testPerson = PersonCreator.withDataFromProperties();
        new AddPartyPage(driver).addPartyRoleType(partyType,partyRole).addPerson(testPerson).addLegalRep();
    }

    @And("I add case event")
    public void addingCaseEvent(){
        new CaseEventPage(driver).newCaseEvent("Filing - Bundle").addCaseEvent();
    }

    @And("I add case caption and case title")
    public void addingCaptionAndTitle(){
        CaseModel newCase = CaseCreator.withDataFromProperties();
        new EditCaseViewPage(driver).addCaseCaptionAndTitle(newCase);
    }


    @Then("^checklist is absent on Case View page$")
    public void checklistIsAbsentOnCaseViewPage() {
        List checklist = driver.findElements(By.cssSelector(".cc-checklistTable"));
        Assert.assertTrue(checklist.size()==0,"It is visible. Or not. Maybe wrong selector");
    }

    @When("^I create specific case$")
    public void iCreateSpecificCase() {
        new MainPage(driver).openCreateCase().fillInCaseClassification("@@@").chooseCaseClassification("Business - N8 - Arbitration");
    }
}

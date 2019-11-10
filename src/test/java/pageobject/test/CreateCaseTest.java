package pageobject.test;

import model.CaseModel;
import model.PersonModel;
import model.UserModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.page.*;
import pageobject.page.casePages.*;
import service.CaseCreator;
import service.PersonCreator;
import service.UserCreator;

import java.util.List;

public class CreateCaseTest extends CommonConditions {
    @Test(description = "Creating case")
    public void createCase(){
        //TODO: remove hardcode
        System.setProperty("environment","qa");
        UserModel testUser = UserCreator.withCredentialsFromProperty();
        MainPage mainPage = new LoginPage(driver).open().login(testUser)
                .openCreateCase().fillInCaseClassification("@@@").chooseCaseClassification("Business - N8 - Arbitration");
    }

    @Test (description = "create and search for a case")
    public void createAndSearchCase() {
        createCase();
        String createdCaseNumber = new CaseViewPage(driver).getCaseNumber();
        CaseSearchPage caseSearch = new CaseSearchPage(driver).caseSearch(createdCaseNumber);
        String foundCaseNumber = new CaseViewPage(driver).getFoundCaseNumber();
        Assert.assertEquals(createdCaseNumber,foundCaseNumber,"Failed");
    }

    @Test(description = "complete checklist")
    public void completeChecklist(){
        createCase();
        PersonModel testPerson = PersonCreator.withDataFromProperties();
        CaseModel newCase = CaseCreator.withDataFromProperties();
        AddPartyPage addPartyPage = new AddPartyPage(driver).addPartyRoleType("Party","Defendant")
                .addPerson(testPerson).addLegalRep();
        AddCaseEventPage addCaseEventPage = new CaseEventPage(driver).newCaseEvent("Filing - Bundle").addCaseEvent();
        EditCaseViewPage editCaseViewPage = new EditCaseViewPage(driver).addCaseCaptionAndTitle(newCase);
        List checklist = driver.findElements(By.cssSelector(".cc-checklistTable"));
        Assert.assertTrue(checklist.size()==0,"It is visible. Or not. Maybe wrong selector");
    }
}

package pageobject.page.casePages;

import org.openqa.selenium.WebDriver;
import pageobject.page.AbstractPage;

public class AddCaseEventPage extends AbstractPage {
    public AddCaseEventPage(WebDriver driver){super(driver);}

    public AddCaseEventPage addDescription(String description){
        return this;
    };

}

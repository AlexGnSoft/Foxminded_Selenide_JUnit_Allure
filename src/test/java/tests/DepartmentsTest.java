package tests;

import config.AllureSetup;
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pageobjects.*;
import utils.RandomDataGenerator;
import static com.codeborne.selenide.Selenide.sleep;

@ExtendWith({AllureSetup.class})
public class DepartmentsTest extends BaseTestConfiguration {

    @Tag("department_create")
    @Test
    public void testCreateNewDepartmentWithoutAddInfo() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(15, false, false, true);

        // Go to application Login page
        openBrowser();

        //Make log in
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.departmentsTab.click();
        sleep(1000);
        DepartmentPage.newDepartmentBtn.click();


        //Fill in department title
        DepartmentPage.titleField.setValue(departmentTitle);

        //Click on Submit button
        DepartmentPage.submitBtn.click();
        sleep(1000);

        //Verify presence of entered data on Departments page
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(DepartmentPage.depTitleList), departmentTitle));
    }

    @Tag("department_delete")
    @Test
    public void testDeleteDepartmentWithoutAddInfo() {
        //Test data
        RandomDataGenerator generator = new RandomDataGenerator();
        String departmentTitle = generator.randomString(15, false, false, true);

        // Go to application Login page
        openBrowser();

        //Make log in
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.departmentsTab.click();

        //Get first name string from the list
        String nameOfFirstDepartmentInList = DepartmentPage.depTitleList.get(0).getText();

        //Click on the first department Delete button
        GlobalPages.clickOnTheFirstElementInAList(DepartmentPage.depDeleteList);
        GlobalPages.alertAcceptOrDismiss(true);

        //Verify that deleted department is not present by using search module
        sleep(1000);
        Assertions.assertFalse(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(DepartmentPage.depTitleList), nameOfFirstDepartmentInList));

        //Verify that deleted department is not present by using search module
        DepartmentPage.departmentSearchField.setValue(nameOfFirstDepartmentInList).pressEnter();
        Assertions.assertFalse(GlobalPages.isElementVisibleOnPageSource(nameOfFirstDepartmentInList));
    }

    @Tag("department_edit")
    @Test
    public void testEditDepartment()  {
        //Test data
        int srtLength = 8;

        //Generating random data
        RandomDataGenerator generator = new RandomDataGenerator();
        String rndDepTitle = generator.randomString(srtLength, false, true, false);

        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.departmentsTab.click();

        //Click on Edit button
        GlobalPages.clickOnTheFirstElementInAList(DepartmentPage.editDepartmentBtn);

        //Update title and click submit button
        DepartmentPage.titleField.clear();
        DepartmentPage.titleField.setValue(rndDepTitle);
        DepartmentPage.submitBtn.click();

        sleep(1000);
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(DepartmentPage.depTitleList), rndDepTitle));
    }
}

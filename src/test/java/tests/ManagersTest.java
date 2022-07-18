package tests;

import config.AllureSetup;
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pageobjects.GlobalPages;
import pageobjects.LoginPage;
import pageobjects.ManagersPage;
import pageobjects.MenuDashboard;
import utils.RandomDataGenerator;
import java.util.Locale;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;


@ExtendWith({AllureSetup.class})
public class ManagersTest extends BaseTestConfiguration {

    @Tag("manager_create")
    @Test
    public void testCreateManager() {
        //Test data
        String department = "Комната добра";
        int srtLength = 8;
        int phoneRange = 10;
        int quantityOfPhoneDigits = 10;

        //Generating random data
        RandomDataGenerator generator = new RandomDataGenerator();
        String rndFName = generator.randomString(srtLength, false, false, true);
        String rndLName = generator.randomString(srtLength, false, false, true);
        String rndEmail = generator.randomString(srtLength, true, false, false).replace(" RESEND EMAIL FOR CONFIRMATION", "").toLowerCase(Locale.ROOT);
        String rndLogin = generator.randomString(srtLength, false, true, false);
        String rndSkype = generator.randomString(srtLength, false, true, false);
        String rndPhone = generator.randomInt(phoneRange, quantityOfPhoneDigits);
        String randomFullName = rndFName + " " + rndLName;

        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.managersTab.click();
        sleep(1000);
        ManagersPage.newManagerBtn.click();

        // Fill in all manager's fields
        ManagersPage.fillInAllFields(rndFName, rndLName, rndEmail, rndLogin, rndPhone, rndSkype);
        ManagersPage.drpDepartment.click();

        //Click on Managers drop-down and select an option
        GlobalPages.selectFromDropDownListByVisibleText(ManagersPage.drpDepartment, ManagersPage.drpDepartmentOptions, department);

        //Click on checkboxes (if not clicked).
        ManagersPage.checkCheckboxStatusAndClick();

        //click on Submit button
        ManagersPage.submitBtn.click();

        //click on just created manager profile tab
        GlobalPages.clickOnTheFirstElementInAList(ManagersPage.fullNameList);
        sleep(1000);

        //Check that new manager is created
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.profileDataCreated), randomFullName));
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.profileDataCreated), rndLogin));
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.profileDataCreated), rndEmail));
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.profileDataCreated), rndPhone));
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.profileDataCreated), rndSkype));
    }

    @Tag("manager_delete")
    @Test
    public void testDeleteManager()  {

        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.managersTab.click();
        sleep(1000);

        //Get first name string from the list
        String nameOfFirstManagerInList = ManagersPage.fullNameList.get(0).getText();
        String firstNameLetters = nameOfFirstManagerInList.substring(0, 5);

        //Click on the first contact Delete button
        GlobalPages.clickOnTheFirstElementInAList(ManagersPage.deleteList);
        GlobalPages.alertAcceptOrDismiss(true);

        //Verify that deleted contact is not present by using search module
        sleep(1000);
        Assertions.assertFalse(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.fullNameList), nameOfFirstManagerInList));

        //Verify that deleted contact is not present by using search module
        ManagersPage.firstNameSearchField.setValue(firstNameLetters).pressEnter();
        Assertions.assertFalse(GlobalPages.isElementVisibleOnPageSource(firstNameLetters));
    }

    @Tag("manager")
    @Test
    public void testEditManager()  {
        //Test data
        int srtLength = 8;
        int phoneRange = 10;
        int quantityOfPhoneDigits = 10;

        //Generating random data
        RandomDataGenerator generator = new RandomDataGenerator();
        String rndSkype = generator.randomString(srtLength, false, true, false);
        String rndPhone = generator.randomInt(phoneRange, quantityOfPhoneDigits);

        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        refresh();
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.managersTab.click();
        sleep(1000);

        //Click on Edit button
        GlobalPages.clickOnTheFirstElementInAList(ManagersPage.editBtnList);

        //Update phone and click submit button
        ManagersPage.phoneElement.clear();
        ManagersPage.phoneElement.setValue(rndPhone);
        ManagersPage.submitBtn.click();

        GlobalPages.clickOnTheFirstElementInAList(ManagersPage.fullNameList);
        sleep(2000);
        Assertions.assertTrue(GlobalPages.stringIsPresentInbArray(GlobalPages.getNamesOfAnyColumns(ManagersPage.profileDataCreated), rndPhone));
    }

    @Tag("manager")
    @Test
    public void testFilterManager()  {
        //Test data

        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        refresh();
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.managersTab.click();
        sleep(1000);

        //Filter by FirstName
        String nameOfFirstManagerInList = ManagersPage.fullNameList.get(0).getText();
        String firstNameLetters = nameOfFirstManagerInList.substring(0, 5);
        ManagersPage.firstNameSearchField.setValue(firstNameLetters).pressEnter();
        Assertions.assertTrue(GlobalPages.isElementVisibleOnPageSource(firstNameLetters));

        //Filter by LastName
        String lastNameLetters = nameOfFirstManagerInList.substring(10, 15);
        ManagersPage.lastNameSearchField.setValue(lastNameLetters).pressEnter();
        Assertions.assertTrue(GlobalPages.isElementVisibleOnPageSource(lastNameLetters));

        //Filter by Department
        String nameOfFirstManagerDepartmentInList = ManagersPage.departmentList.get(0).getText();
        ManagersPage.departmentNameField.setValue(nameOfFirstManagerDepartmentInList).pressEnter();
    }

    @Tag("manager")
    @Test
    public void testClearFilter()  {
        //Test data
        String fName = "testName";
        String lName = "testName";
        String depName = "testName";
        String placeholder = "placeholder";


        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        refresh();
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.managersTab.click();
        refresh();
        sleep(1000);

        //Enter test data and press Clear button
        ManagersPage.firstNameSearchField.setValue(fName);
        ManagersPage.lastNameSearchField.setValue(lName);
        ManagersPage.departmentNameField.setValue(depName);
        ManagersPage.clearBtn.pressEnter();

        //Check that entered value disappeared
        String fNamePlaceHolderText = ManagersPage.firstNameSearchField.getAttribute(placeholder);
        String lNamePlaceHolderText = ManagersPage.lastNameSearchField.getAttribute(placeholder);
        String departmentPlaceHolderText = ManagersPage.departmentNameField.getAttribute(placeholder);

        Assertions.assertEquals(fNamePlaceHolderText, "First name");
        Assertions.assertEquals(lNamePlaceHolderText, "Last name");
        Assertions.assertEquals(departmentPlaceHolderText, "Department name");
    }

    @Tag("manager_sorting")
    @Test
    public void testSorting()  {
        //Test data
        String fName = "testName";
        String lName = "testName";
        String depName = "testName";
        String placeholder = "placeholder";

        //Make Sign In
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());

        //Click on Managers tab > 'New Manager+'button
        sleep(1000);
        refresh();
        MenuDashboard.closeButton.click();
        MenuDashboard.minimizeSideBarBtn.click();
        MenuDashboard.managersTab.click();
        refresh();
        sleep(1000);

       //Sort by fullName and Pagination
        String firstFullName = ManagersPage.fullNameList.get(0).getText();
        ManagersPage.sortUpBtn.click();
        ManagersPage.sortDownBtn.click();
        ManagersPage.paginationNextBtn.click();
        ManagersPage.paginationPreviousBtn.click();
    }
}
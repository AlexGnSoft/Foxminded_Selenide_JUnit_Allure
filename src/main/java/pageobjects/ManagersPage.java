package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ManagersPage {

    public static final SelenideElement newManagerBtn = $("#managers-new-manager");
    public static final ElementsCollection fullNameList = $$(By.xpath("//tbody/tr/td[1]/a"));
    public static final SelenideElement firstNameElement = $("#firstName");
    public static final SelenideElement lastNameElement = $("#lastName");
    public static final SelenideElement emailElement = $("#email");
    public static final SelenideElement loginElement = $("#login");
    public static final SelenideElement drpDepartment = $("#manager-form-department-select");
    public static final SelenideElement drpDepartmentOptions = $(By.xpath("//select[@id='manager-form-department-select']"));
    public static final SelenideElement phoneElement = $("#phone");
    public static final SelenideElement skypeElement = $("#skype");
    public static final SelenideElement submitBtn = $("#manager-form-submit");
    public static final ElementsCollection profileDataCreated = $$(By.xpath("//div[@class='col-sm-7']/p"));
    public static final ElementsCollection checkboxesList = $$(By.xpath("//label[@class='manager-form-checkbox_label2']/span/span"));
    public static final ElementsCollection departmentList = $$(By.xpath("//tbody/tr/td[2]"));
    public static final ElementsCollection deleteList = $$("#managers-delete-btn");
    public static final SelenideElement firstNameSearchField = $("#search-manager-firstname");
    public static final SelenideElement lastNameSearchField = $("#search-manager-lastname");
    public static final SelenideElement departmentNameField = $("#search-manager-department");
    public static final ElementsCollection editBtnList = $$("#managers-edit-btn");
    public static final SelenideElement clearBtn = $("#search-manager-clear");
    public static final SelenideElement sortUpBtn = $("#managers-fullname-sort-asc");
    public static final SelenideElement sortDownBtn = $("#managers-fullname-sort-desc");
    public static final SelenideElement paginationNextBtn = $(By.xpath("//a[@aria-label='Next page']"));
    public static final SelenideElement paginationPreviousBtn = $(By.xpath("//a[@aria-label='Previous page']"));


    /**
     * Method enters all manager's fields
     */
    public static void fillInAllFields(String fNameTest, String lNameTest,String emailTest, String loginTest, String phoneTest, String skypeTest){
        //enter enterFirstLastName
        firstNameElement.clear();
        firstNameElement.setValue(fNameTest);
        lastNameElement.clear();
        lastNameElement.setValue(lNameTest);
        //enter Email
        emailElement.clear();
        emailElement.setValue(emailTest);
        //enter Login
        loginElement.clear();
        loginElement.setValue(loginTest);
        //enter Phone
        phoneElement.clear();
        phoneElement.setValue(phoneTest);
        //enter Skype
        skypeElement.clear();
        skypeElement.setValue(skypeTest);
    }

    /**
     * Method is used to check checkBox status.
     * If not checked > we make it checked
     */
    public static void checkCheckboxStatusAndClick(){
        ElementsCollection checkboxesList = ManagersPage.checkboxesList;
        for (int i = 0; i < checkboxesList.size(); i++) {
            if(!checkboxesList.get(i).isSelected()){
                checkboxesList.get(i).click();
            }
        }
    }







}

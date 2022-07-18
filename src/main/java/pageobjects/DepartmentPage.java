package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DepartmentPage {

    public static final SelenideElement newDepartmentBtn = $("#new-department");
    public static final SelenideElement titleField = $("#name");
    public static final SelenideElement submitBtn = $("#department-form-submit");
    public static final SelenideElement departmentSearchField = $("#department-search-title");
    public static final ElementsCollection editDepartmentBtn = $$("#department-edit");
    public static final ElementsCollection depTitleList = $$(By.xpath("//table/tbody/tr/td/a"));
    public static final ElementsCollection depDeleteList = $$("#department-delete");
}

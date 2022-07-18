package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class GlobalPages {

    /**
     * Method is used to select any option by visible text in drop-down options list
     */
    public static void selectFromDropDownListByVisibleText(SelenideElement dropDownElement, SelenideElement drpOptions, String searchedVisibleText) {
       dropDownElement.click();
       Select select = new Select(drpOptions);
       select.selectByVisibleText(searchedVisibleText);
    }

    /**
     * Method is used to click on the first element in a list
     */
    public static void  clickOnTheFirstElementInAList(ElementsCollection elementsCollection){
        elementsCollection.get(0).click();
    }

    /**
     * Method returns title names (of id, title, assignee, stage) using getText().
     * As a parameter is receives a list of elements in a column
     * from which we expect to get title names
     */
    public static ArrayList<String> getNamesOfAnyColumns(ElementsCollection elementsCollection){
        ArrayList<String> titleName = new ArrayList<>();
        for (int i = 0; i < elementsCollection.size(); i++) {
            titleName.add(elementsCollection.get(i).getText());
        }
        return titleName;
    }

    /**
     * Method is used to perform action on Alert pop up:
     * if true - Accept click
     * if false - Dismiss click
     */
    public static void alertAcceptOrDismiss(Boolean isAccept){
        if(isAccept){
            WebDriverRunner.driver().switchTo().alert().accept();
        }else{
            WebDriverRunner.driver().switchTo().alert().dismiss();
        }
    }


    /**
     * Method is used to verify that searched string isPresent is array of strings
     */
    public static Boolean stringIsPresentInbArray(ArrayList<String> stringArrayList, String searchedString){
        boolean isPresent = false;
        for (int i = 0; i < stringArrayList.size(); i++) {
            if(stringArrayList.get(i).contains(searchedString)){
                isPresent = true;
            }
        }

        for (int i = 0; i < stringArrayList.size(); i++) {
            System.out.println(stringArrayList.get(i));
        }

        return isPresent;
    }

    /**
     * Method is used to check whether webElement is visible on the page at all by using getPageSource() method
     */
    public static Boolean isElementVisibleOnPageSource(String searchedString) {
        boolean isVisible = false;
        if(WebDriverRunner.getWebDriver().getPageSource().contains(searchedString)){
            isVisible = true;
        }
        return isVisible;
    }
}

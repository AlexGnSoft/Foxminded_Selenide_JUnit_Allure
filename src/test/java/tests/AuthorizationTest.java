package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.BaseTestConfiguration;
import helpfiles.PropertiesFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;

public class AuthorizationTest extends BaseTestConfiguration {

    @Tag("sign_in")
    @Test
    public void testSignIn() {
        //sign in and wait for a home page to be visible
        LoginPage.makeSignIn(PropertiesFile.getLoginCredentials(), PropertiesFile.getPasswordCredentials());
        SelenideElement selenideHomePageElement = LoginPage.homePage.shouldBe(Condition.visible);

        //verify that home page is download
        Assertions.assertTrue(selenideHomePageElement.isDisplayed());
    }
}

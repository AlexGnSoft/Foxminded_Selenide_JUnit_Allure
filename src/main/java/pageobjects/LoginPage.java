package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import config.BaseTestConfiguration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseTestConfiguration {

    public static final SelenideElement login = $("#username");
    public static final SelenideElement password = $("#password");
    public static final SelenideElement signInButton = $("#login-signin");
    public static final SelenideElement homePage = $(".main-content");

    @Step("Make Sign in")
    public static void makeSignIn(String userName, String pass){
        login.setValue(userName);
        password.setValue(pass);
        signInButton.pressEnter();
    }
}

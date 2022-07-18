package config;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AllureSetup implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {

//        Configuration.timeout = 2;   //change default 4 sec waiting timeout to diff value

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)  //add screenshot as attachment
                        .savePageSource(true)); //add DOM source code as attachment

    }
}

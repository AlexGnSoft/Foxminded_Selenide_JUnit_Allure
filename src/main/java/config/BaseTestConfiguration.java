package config;

import com.codeborne.selenide.Configuration;
import helpfiles.PropertiesFile;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.open;

public class BaseTestConfiguration {

     @Step("Open browser")
     @BeforeEach
     public void openBrowser(){
         PropertiesFile pfile = new PropertiesFile();
         pfile.getBrowser(); // choose browser
         Configuration.browserSize = pfile.getBrowserSize(); //set browser size

         open(pfile.getApplicationUrl());
         }
    }

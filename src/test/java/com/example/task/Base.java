package com.example.task;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;

public class Base {
    /**
     * The 'setUpAll' method we use to set up:
     *  -Size of WebBrowser's window
     *  - Allure listener, to be able to generate report after
     */

    @BeforeClass
    public void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }


    /**
     * With 'setUp' method we setUp:
     * - SelenideDriver, we use WebdriverManager.
     * (Default driver will be ChromeDriver(you can see in browsers.json))
     * We pass String argument - url, witch will be opened after browser windows opens
     * - open the browser and load the URL
     */
    @BeforeMethod
    @Parameters({"url"})
    public void setUp(String baseUrl) {
        open(baseUrl);
    }

}

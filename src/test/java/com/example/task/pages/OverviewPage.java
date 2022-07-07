package com.example.task.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

public class OverviewPage {

    /**
     *  OverviewPage - here we have all SelenideElements and methods witch correspond to Overview page in the app
     *
     *  We extract WebElements(SelenideElements) using selenide framework and Xpath strategy
     */

    public SelenideElement welcomeMessage = $x("//div[@class ='card-title']");
    public SelenideElement addConnectorButton = $x("//div[contains(@class, 'react')]//child::button");
    public SelenideElement signInButton = $x("//div[contains(@class, 'button')]/div[position() = 1]");
    public SelenideElement signInMicrofoftMessage = $x("//div[@class = 'connector-message large-width']");
    public SelenideElement microsoftConnector = $x("//div[@class = 'dropdown-popup-content animation-out']/div[position() = 1]");

    /**
     * With the 'getWelcomeMessageText' method we get text of SelenideElement after we did sign in
     */

    @Step("Get welcome message text")
    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }

    /**
     * With the 'getCurrentUrl' method we get current url to check if it is as expected
     */

    @Step("Get current url")
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    /**
     *  In the 'clickAddConnectorButton' method
     *  we check if the 'clickAddConnectorButton' is visible and enabled with selenide explicit waits, after check passes we
     *  click the 'clickAddConnectorButton'.
     */


    @Step("Click add connector button")
    public void clickAddConnectorButton() {
        addConnectorButton.shouldBe(Condition.visible, Condition.enabled).click();
    }

    /**
     * With the 'chooseConnector' hove over the SelenideElement and click on it
     */

    public void chooseConnector(SelenideElement element) {
        element.hover().click();
    }

    /**
     * With the 'getConnectorMessageText' method we check if the SelenideElement is visible and enabled with selenide
     * explicit waits, after check passes we get 'signInMicrofoftMessage' text after choosing and clicking on Microsoft
     * connector
     */

    public String getConnectorMessageText() {
        return signInMicrofoftMessage.shouldBe(Condition.visible, Duration.ofSeconds(5)).getText();
    }

    /**
     * With the 'checkIfButtonIsClickable' method we check if the SelenideElement is visible and enabled with selenide
     * explicit waits and the element is present and can be clicked to proceed feather with sign to the Microsoft account
     */

    public boolean checkIfButtonIsClickable(SelenideElement element) {
        element.scrollIntoView(true);
        return signInButton.shouldBe(Condition.visible, Condition.enabled).exists();
    }
}

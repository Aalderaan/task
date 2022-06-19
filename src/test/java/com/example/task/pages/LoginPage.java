package com.example.task.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    /**
     *  LoginPage - here we have all SelenideElements and methods witch correspond to login page in the app
     *
     *  We extract WebElements(SelenideElements) using selenide framework and Xpath strategy
     */

    public SelenideElement emailField = $x("//input[@name='email']");
    public SelenideElement passwordField = $x("//input[@name='password']");
    public SelenideElement signInButton = $x("//button[@type='submit']");

    /**
     *  In 'enterEmail' method we pass String argument - user's email;
     *  we check if the email-field is visible with selenide explicit wait, after check passes we
     *  type the user's email(the argument) to the field
     */

    public void enterEmail(String email) {
        emailField.shouldBe(Condition.visible, Duration.ofSeconds(8)).click();
        emailField.sendKeys(email);
    }

    /**
     *  In 'enterPassword' method we pass String argument - user's password;
     *  we check if the password-field is visible with selenide explicit wait(default is 4 sec, nut we can make custom one with Duration()), after check passes we
     *  type the user's password(the argument) to the field
     */

    public void enterPassword(String password) {
        passwordField.shouldBe(Condition.visible).click();
        passwordField.sendKeys(password);
    }

    /**
     *  In the 'clickSigninButton' method
     *  we check if the 'signInButton' is visible and enabled with selenide explicit waits, after check passes we
     *  click the signInButton and return the instance of the OverviewPage.
     */

    public OverviewPage clickSigninButton() {
        signInButton.shouldBe(Condition.visible, Condition.enabled).click();
        return new OverviewPage();
    }

}

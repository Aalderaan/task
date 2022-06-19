package com.example.task.tests;

import com.example.task.Base;
import com.example.task.pages.LoginPage;
import com.example.task.pages.OverviewPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class OverviewPageTests extends Base {

    /**
     * Here we create instances of pages we need to get necessary methods after
     */
    LoginPage loginPage = new LoginPage();
    OverviewPage overviewPage = new OverviewPage();

    /**
     * In the 'checkSuccessfulLoginWithValidCredentials' we check positive login scenario.
     * We use TestNG annotations to add parameters and to be able to run hole test suite independently
     */

    @Test()
    @Parameters({"welcomeMessage", "userName", "password", "overviewUrl", "signInMicrosoftMessage"})
    public void checkSuccessfulLoginWithValidCredentials(String welcomeMessage, String userName, String password,
                                                         String overviewUrl, String signInMicrosoftMessage) {
        loginPage.enterEmail(userName);
        loginPage.enterPassword(password);
        loginPage.clickSigninButton();

        /**
         * Here we use TestNG Soft Assertions - assertions type that does not throw an exception when a assertion fails
         * and continues in the next phase after the assert statement.
         * Is very handy when there are many assertions and we want to run all of them even some of them fails
         */


        SoftAssert softAssert = new SoftAssert();

        /**
         * Here we make assertions - we give expected and actual results to be sure they are the same
         */

        softAssert.assertEquals(overviewPage.getWelcomeMessageText(), welcomeMessage);
        softAssert.assertEquals(overviewPage.getCurrentUrl(), overviewUrl);

        overviewPage.clickAddConnectorButton();
        overviewPage.chooseConnector(overviewPage.microsoftConnector);

        softAssert.assertEquals(overviewPage.getConnectorMessageText(), signInMicrosoftMessage);
        softAssert.assertTrue(overviewPage.checkIfButtonIsClickable(overviewPage.signInButton));
        softAssert.assertAll();
    }
}

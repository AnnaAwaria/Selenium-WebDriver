package com.capgemini.tests;

import com.capgemini.page.objects.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginNegativeTest extends TestBase {

    @Test(dataProvider = "badPassword")
    public void asInvalidUserIWantToLogInTest(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage
                .loadPage()
                .usernameLogin(username)
                .passwordLogin(password)
                .clickOnLoginButton();
        loginPage
                .assertThatWarningMessageIsDisplayed("Invalid username or password. Signon failed.");


    }

    @DataProvider
    public Object[][] badPassword() {
        Object[][] testDataArray = {{"user", "password"}, {"cap", "gemini"}};
        return testDataArray;
    }
}
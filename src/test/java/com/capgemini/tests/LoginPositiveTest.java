package com.capgemini.tests;

import com.capgemini.page.objects.LoginPage;
import org.testng.annotations.Test;

public class LoginPositiveTest extends TestBase {

    @Test
    public void asValidUserIWantToLogInTest() {

        LoginPage loginPage = new LoginPage();
        loginPage
                .loadPage()
                .usernameLogin("j2ee")
                .passwordLogin("j2ee")
                .clickOnLoginButton()
                .assertThatDoggieInFooterIsDisplayed();

    }


}

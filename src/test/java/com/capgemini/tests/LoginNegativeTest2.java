package com.capgemini.tests;

import com.capgemini.page.objects.LoginPage;
import org.osgl.xls.ExcelReader;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class LoginNegativeTest2 extends TestBase {

    private static final String EXCEL_FOR_DDT_XLSX = "excel_for_ddt.xlsx";

    private String username;
    private String password;
    private String expectedResult;

    public LoginNegativeTest2(String username, String password, String expectedResult) {
        this.username = username;
        this.password = password;
        this.expectedResult = expectedResult;
    }

    @Test
    public void asNonRegisterUserFailToLoginUsingBadCredentialsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .loadPage()
                .usernameLogin(username)
                .passwordLogin(password)
                .clickOnLoginButton();
        loginPage
                .assertThatWarningMessageIsDisplayed(expectedResult);
    }

    @Factory
    public static Object[] ddtFactoryExample() {
        String testDataExcelPath = System.getProperty("user.dir") + "/src/main/resources/";

        List<User> users = ExcelReader.read(new File(testDataExcelPath + EXCEL_FOR_DDT_XLSX), User.class);

        Object[] arrayOfTestCaseToExecute = new Object[users.size()];

        for (int testCase = 0; testCase < users.size(); testCase++) {
            arrayOfTestCaseToExecute[testCase] =
                    new LoginNegativeTest2(
                            users.get(testCase).getUserName(),
                            users.get(testCase).getPassword(),
                            users.get(testCase).getExpectedResult());
        }

        return arrayOfTestCaseToExecute;
    }

}


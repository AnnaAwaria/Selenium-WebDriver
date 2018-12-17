package com.capgemini.tests;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.utils.RunProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends SuiteTestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        DriverManager.createDriver(RunProperties.getLocalBowser());
        DriverManager.getDriver();
    }

    @AfterMethod
    public void afterTest() {
    }
}

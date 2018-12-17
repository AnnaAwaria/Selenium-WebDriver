package com.capgemini.tests.other;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SecondGoogleTest extends TestBase {

    @Test
    public void mySecondTest() {
        DriverManager.getDriver().navigate().to("https://www.google.pl/");
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Facebook");
        DriverManager.getDriver().findElement(By.name("q")).submit();
        assertEquals(DriverManager.getDriver().getTitle(), "Facebook - Szukaj w Google");
    }

}

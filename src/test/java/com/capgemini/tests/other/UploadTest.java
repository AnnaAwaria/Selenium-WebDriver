package com.capgemini.tests.other;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UploadTest extends TestBase {

    @Test
    public void myFormTest() {
        DriverManager.getDriver().navigate().to("http://theinternet.przyklady.javastart.pl/upload");
        WebElement uploadElement = DriverManager.getDriver().findElement(By.id("file-upload"));
        uploadElement.sendKeys("C:\\Users\\afrackow\\Pictures\\Capgemini\\Capgemini.jpg");
        WebElement uploaded = DriverManager.getDriver().findElement(By.id("file-submit"));
        uploaded.click();
        assertEquals(DriverManager.getDriver().findElement(By.id("uploaded-files")).getText(), "Capgemini.jpg");
    }


}

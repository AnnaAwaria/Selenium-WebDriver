package com.capgemini.tests.other;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FormTest extends TestBase {

    @Test
    public void myFormTest() {
        DriverManager.getDriver().navigate().to("http://przyklady.javastart.pl/test/full_form.html");
        WebElement element = DriverManager.getDriver().findElement(By.name("username"));
        element.sendKeys("blabla@gmail.com");
        element.clear();
        element.sendKeys("znowublabla@gmail.com");
        WebElement passElement = DriverManager.getDriver().findElement(By.name("password"));
        assertEquals(passElement.isEnabled(),false);
        WebElement radioButton = DriverManager.getDriver().findElement(By.id("" +
                "radios-1"));
        radioButton.click();
        assertEquals(radioButton.isSelected(), true);
        WebElement radioButtonTwo = DriverManager.getDriver().findElement(By.id("radios-0"));
        assertEquals(radioButtonTwo.isSelected(), false);
        WebElement checkBox = DriverManager.getDriver().findElement(By.id("checkboxes-0"));
        checkBox.click();
        assertEquals(checkBox.isSelected(), true);
        assertEquals(DriverManager.getDriver().findElement(By.id("checkboxes-1")).isSelected(), false);
        assertEquals(DriverManager.getDriver().findElement(By.id("checkboxes-2")).isSelected(), false);


    }
}

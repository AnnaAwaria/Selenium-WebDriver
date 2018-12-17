package com.capgemini.tests.other;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExplicitWaitTest extends TestBase {

    @Test
    public void waitForDisappearingElement() {

        DriverManager.getDriver().navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
        WebElement checkBox = DriverManager.getDriver().findElement(By.id("checkbox"));
        assertEquals(checkBox.isSelected(), false);
        assertEquals(checkBox.isDisplayed(), true);
        WebElement button = DriverManager.getDriver().findElement(By.id("btn"));
        button.click();
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        WebElement msg = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        assertEquals(msg.getText(), "It's gone!");
        WebElement button2 = DriverManager.getDriver().findElement(By.id("btn"));
        button2.click();
        WebElement msg2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("message")));
        WebElement checkBox2 = DriverManager.getDriver().findElement(By.id("checkbox"));
        assertEquals(msg2.getText(), "It's back!");
        assertEquals(checkBox2.isSelected(), false);
        assertEquals(checkBox2.isDisplayed(), true);


    }

}
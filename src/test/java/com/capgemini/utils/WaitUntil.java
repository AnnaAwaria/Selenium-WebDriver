package com.capgemini.utils;

import com.capgemini.driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    public static void elementIsVisible(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}

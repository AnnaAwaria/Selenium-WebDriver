package com.capgemini.tests.other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GoogleTest {

        private WebDriver driver;

        @BeforeMethod
        public void beforeTest() {
            System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void myFirstTest() {
            driver.navigate().to("https://www.google.pl/");
            driver.findElement(By.name("q")).sendKeys("Capgemini");
            driver.findElement(By.name("q")).submit();
            assertEquals(driver.getTitle(), "Capgemini - Szukaj w Google");
        }

        @AfterMethod
        public void afterTest() {
            driver.quit();
        }
    }


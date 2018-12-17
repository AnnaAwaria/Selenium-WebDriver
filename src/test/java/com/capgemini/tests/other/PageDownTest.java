package com.capgemini.tests.other;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PageDownTest extends TestBase {

    @Test
    public void myPageTest() {


        DriverManager.getDriver().navigate().to("http://theinternet.przyklady.javastart.pl/large");
        WebElement lastOne = DriverManager.getDriver().findElement(By.xpath("//*[@id='large-table']/tbody/tr[50]/td[50]"));

        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(lastOne).build().perform();

    }

}

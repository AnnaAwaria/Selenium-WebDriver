package com.capgemini.tests.other;

import com.capgemini.driver.manager.DriverManager;
import com.capgemini.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends TestBase {

    @Test
    public void myFormTest() {


        DriverManager.getDriver().navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
        WebElement country = DriverManager.getDriver().findElement(By.id("dropdown"));
        Select select = new Select(country);

        WebElement firstSelectedOption = select.getFirstSelectedOption();
        assertEquals(firstSelectedOption.getText(), "Please select an option");

        select.selectByValue("2");

        WebElement optionAfterSelection = select.getFirstSelectedOption();
        assertEquals(optionAfterSelection.getText(), "Option 2");


    }

}


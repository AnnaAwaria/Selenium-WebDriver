package com.capgemini.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.capgemini.generic.assertions.AssertWebElement.assertThat;
import static com.capgemini.utils.WaitUntil.elementIsVisible;


public class FooterPage extends BasePage<FooterPage> {

    @FindBy(xpath = "//*[@id=\"Banner\"]/img")
    private WebElement doggie;



    public FooterPage loadPage() {
        throw new IllegalStateException("Cannot load page, unknown context");
    }

    @Step("Check that doggie picture is displayed")
    public FooterPage assertThatDoggieInFooterIsDisplayed() {
        elementIsVisible(doggie);
        assertThat(doggie).isDisplayed();
        log().info("Dog banner was displayed");
        return this;

    }


}

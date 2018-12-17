package com.capgemini.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class TopMenuPage extends BasePage<TopMenuPage>{

    @FindBy(xpath = "//*[@id=\"MenuContent\"]/a[2]")
    private WebElement signIn;

    public TopMenuPage loadPage() {
        throw new IllegalStateException("Cannot load page, unknown context");
    }

    @Step("Click on login link at top menu page")
    public LoginPage clickOnLoginLink() {
        signIn.click();
        log().info("Clicked on login");
        return new LoginPage();

    }


}

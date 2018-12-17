package com.capgemini.page.objects;


import com.capgemini.utils.DriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage<HomePage> {

    @FindBy(xpath = "//*[@id='Content']/p[1]/a")
    private WebElement enter;

    @Step("Navigate to main page")
    public HomePage loadPage() {
        DriverUtils.navigateToPage("");
        return this;
    }
    @Step("Click on Enter the store link")
    public TopMenuPage clickOnEnterStoreLink() {
        enter.click();
        log().info("Clicked on enter the store link");
        return new TopMenuPage();
    }


}

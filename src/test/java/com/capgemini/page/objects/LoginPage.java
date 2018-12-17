package com.capgemini.page.objects;

import com.capgemini.utils.DriverUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.capgemini.generic.assertions.AssertWebElement.assertThat;
import static com.capgemini.utils.WaitUntil.*;


public class LoginPage extends BasePage<LoginPage> {

    @FindBy(name = "username")
    private WebElement usrname;

    @FindBy(name = "password")
    private WebElement pssword;

    @FindBy(name = "signon")
    private WebElement signOn;

    @FindBy(xpath = "//*[@id=\"Content\"]/ul/li")
    private WebElement msg;

    @Step("Navigate to Login Page")
    public LoginPage loadPage() {
        DriverUtils.navigateToPage("/actions/Account.action?signonForm=");
        return this;
    }
    @Step("Enter valid username")
    public LoginPage usernameLogin(String username) {
        usrname.sendKeys(username);
        log().info("Entered username {}", username);
        return this;
    }
    @Step("Enter valid password")
    public LoginPage passwordLogin(String password) {
        pssword.clear();
        pssword.sendKeys(password);
        log().info("Entered password {}", password);
        return this;
    }
    @Step("Click on login button")
    public FooterPage clickOnLoginButton() {
        signOn.click();
        log().info("Clicked on login button");

        return new FooterPage();
    }
    @Step("Check that warning message was displayed")
    public LoginPage assertThatWarningMessageIsDisplayed(String message) {
        elementIsVisible(msg);
        log().info("Got message {}", msg.getText());
        assertThat(msg).hasText(message);
        return this;


    }


}

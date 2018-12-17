package com.capgemini.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static final String USERNAME = "AnnaAwaria";
    private static final String ACCESS_KEY = "73378377-557a-46a8-ba67-9bd547341cd1";
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static WebDriver getDriverPerType(BrowserType browserType) {

        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
                return new ChromeDriver();
            case FF:
                System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
                return new FirefoxDriver();

            case IE:
                return null;

            case REMOTE_CHROME:
                DesiredCapabilities chrome = DesiredCapabilities.chrome();
                chrome.setCapability("platform", "Linux");
                chrome.setCapability("version", "48.0");
                try {
                    return new RemoteWebDriver(new URL(URL), chrome);
                } catch (MalformedURLException e) {
                    throw new IllegalStateException(e);
                }

            case REMOTE_SAFARI:
                DesiredCapabilities safari = DesiredCapabilities.safari();
                safari.setCapability("platform", "macOS 10.13");
                safari.setCapability("version", "12.0");
                safari.setCapability("screenResolution", "1024x768");
                try {
                    return new RemoteWebDriver(new URL(URL), safari);
                } catch (MalformedURLException e) {
                    throw new IllegalStateException(e);
                }
            default:
                throw new IllegalStateException("Unknown browser type");

        }
    }

}

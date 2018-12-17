package com.capgemini.driver.manager;

import com.capgemini.utils.DriverEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<WebDriver>();

    private DriverManager() {
    }

    public static void createDriver(BrowserType browserType) {
        WebDriver driverPerType = DriverFactory.getDriverPerType(browserType);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driverPerType);
        DriverEventListener driverEventListener = new DriverEventListener();
        WebDriver register = eventFiringWebDriver.register(driverEventListener);
        webDriverThreadLocal.set(register);
    }

    public static WebDriver getDriver() {
        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("Driver was null. Please call createDriver before calling getDriver");
        }
        return webDriverThreadLocal.get();
    }

    public static void tearDownDriver() {
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }


}
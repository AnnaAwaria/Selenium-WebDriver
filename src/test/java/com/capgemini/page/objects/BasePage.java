package com.capgemini.page.objects;

import com.capgemini.driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage<T> {

    private Logger logger = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected Logger log() {
        return logger;
    }

    public abstract T loadPage();
}

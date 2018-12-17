package com.capgemini.utils;

import com.capgemini.driver.manager.BrowserType;

public class RunProperties {

    public static String getEnviromentUrl() {
        return ConfigurationProperties.getProperties().getProperty("env.url");
    }

    public static BrowserType getLocalBowser() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }
}

package com.capgemini.utils;

import com.capgemini.driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverUtils {

    private static Logger logger = LogManager.getLogger(DriverUtils.class);

    public static void navigateToPage(String uri) {
        DriverManager.getDriver().navigate().to(RunProperties.getEnviromentUrl() + uri);
        logger.info("Navigate to page with url: {}", DriverManager.getDriver().getCurrentUrl());
    }
}

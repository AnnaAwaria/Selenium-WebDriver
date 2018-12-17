package com.capgemini.tests;

import com.capgemini.utils.ConfigurationProperties;
import com.capgemini.utils.PropertiesLoader;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class SuiteTestBase {

    @BeforeSuite
    public void beforeSuite() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");

        ConfigurationProperties.setProperties(propertiesFromFile);

    }


}

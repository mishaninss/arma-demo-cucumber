package com.github.mishaninss;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/steps",
        glue = "com.github.mishaninss.steps",
        strict = true,
        plugin = {

        }
)
public class RunDebugIT {

    private static final String SUITE_NAME = "Debug";
    private static final Logger LOGGER = LoggerFactory.getLogger(RunDebugIT.class);

    @AfterClass
    public static void tearDown(){
        LOGGER.info("FINISH SUITE " + SUITE_NAME + " *****************************************");
    }

    @BeforeClass
    public static void setup(){
        LOGGER.info("START SUITE " + SUITE_NAME + " *****************************************");
    }

}

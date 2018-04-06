/*
 * Copyright 2018 Sergey Mishanin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.myproject;

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
        glue = "com.github.myproject.steps",
        strict = true,
        plugin = {"io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm"}
        ,tags = {"@Debug"}
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

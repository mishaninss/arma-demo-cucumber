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

import com.github.mishaninss.reporting.AllureSlf4jReporter;
import com.github.mishaninss.uidriver.Arma;

public class ScriptStyleDemo {
    public static Arma setup(){
        Arma.using()
                .componentsLocations("com.github.myproject")
                .reporter(AllureSlf4jReporter.class)
                .build();
        Arma arma = Arma.chrome();
        arma.config().framework().enableForcedClosing().addPackageToStacktraceWhiteList("com.github.myproject");
        return arma;
    }

    public static void main(String[] args){
        Arma arma = setup();

        arma.page().goToUrl("/");
        arma.elementBy().id("ss").perform().setValue("Blue Sea Beach Resort");
        arma.elementBy().css("button[type='submit']").perform().click();
    }
}

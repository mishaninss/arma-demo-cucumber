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

package com.github.myproject.html.composites;

import com.github.mishaninss.html.composites.CompositeElement;
import com.github.mishaninss.html.composites.TemplatedElement;
import com.github.mishaninss.html.containers.annotations.Element;
import com.github.mishaninss.html.elements.Icon;
import com.github.mishaninss.html.elements.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Element
public class Datepicker extends CompositeElement{
    private static Pattern datePattern = Pattern.compile("(\\d{1,2})(\\s+)(.+)(\\s+)(\\d{4})");

    @Element(".//i[@class='sb-date-field__chevron bicon-downchevron']")
    public Icon openIcon;

    @Element(locator = ".//th[@class='c2-month-header-monthname'][.='%s']")
    public TemplatedElement<Text> monthYear;

    @Element(locator = "(.//th[@class='c2-month-header-monthname'][.='%s']/../../..//span[@class='c2-day-inner'])[%s]")
    public TemplatedElement<Text> day;

    @Element(byClass = "sb-date-field__display")
    public Text valueElement;

    public Datepicker(String locator){
        super(locator);
    }

    @Override
    public void changeValue(Object value) {
        Matcher m = datePattern.matcher(value.toString().trim());
        if (m.matches()){
            String dayVal = m.group(1);
            String monthYearVal = m.group(3) + " " + m.group(5);
            openIcon.perform().click();
            day.resolveTemplate(monthYearVal, dayVal).perform().click();
        }
    }

    @Override
    public String readValue() {
        return valueElement.readValue();
    }

    @Override
    public void performAction() {
        valueElement.perform().click();
    }

}

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

package com.github.myproject.pages;

import com.github.mishaninss.data.WebDriverProperties;
import com.github.mishaninss.html.containers.ArmaContainer;
import com.github.mishaninss.html.containers.annotations.Container;
import com.github.mishaninss.html.containers.annotations.ContextualElement;
import com.github.mishaninss.html.containers.annotations.Element;
import com.github.mishaninss.html.elements.*;
import com.github.mishaninss.html.elements.interfaces.ISelectable;

@Container("id=frm")
public class SearchForm extends ArmaContainer{

    @ContextualElement({
            @Element("id=ss"),
            @Element(val = "tablet", locator = "id=destination")
    })
    public TextBox search;

    @Element("name=group_adults")
    public Select groupAdults;

    @Element("id=group_children")
    public Select groupChildren;

    @Element("id=no_rooms")
    public Select noRooms;

    @ContextualElement({
            @Element(locator = "name=sb_travel_purpose", type = CheckBox.class),
            @Element(val = "tablet", locator = "name=sb_travel_purpose", type = RadioButton.class)
    })
    @Element("name=sb_travel_purpose")
    public ISelectable businessPurpose;

    @Element("css=button[type='submit']")
    public Button submit;

}

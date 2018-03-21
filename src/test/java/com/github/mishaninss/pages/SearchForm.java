package com.github.mishaninss.pages;

import com.github.mishaninss.html.containers.ArmaContainer;
import com.github.mishaninss.html.containers.annotations.Container;
import com.github.mishaninss.html.containers.annotations.Element;
import com.github.mishaninss.html.elements.*;

@Container("id=frm")
public class SearchForm extends ArmaContainer{

    @Element("id=ss")
    public TextBox search;

    @Element("id=group_adults")
    public Select groupAdults;

    @Element("id=group_children")
    public Select groupChildren;

    @Element("id=no_rooms")
    public Select noRooms;

    @Element("name=sb_travel_purpose")
    public CheckBox businessPurpose;

    @Element("css=button[type='submit']")
    public Button submit;

}

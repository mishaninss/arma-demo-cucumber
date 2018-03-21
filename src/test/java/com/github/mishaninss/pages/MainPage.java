package com.github.mishaninss.pages;

import com.github.mishaninss.html.containers.ArmaContainer;
import com.github.mishaninss.html.containers.annotations.Container;
import com.github.mishaninss.html.containers.annotations.Url;

@Container
@Url("/")
public class MainPage extends ArmaContainer {

    @Container
    public SearchForm searchForm;
}

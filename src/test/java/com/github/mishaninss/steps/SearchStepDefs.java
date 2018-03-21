package com.github.mishaninss.steps;

import com.github.mishaninss.html.containers.annotations.Container;
import com.github.mishaninss.pages.MainPage;
import com.github.mishaninss.pages.SearchForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Map;

public class SearchStepDefs extends BaseStepDefs{

    @Container
    private MainPage mainPage;
    @Container
    private SearchForm searchForm;

    @Given("^I'm on the Main page$")
    public void iMOnTheMainPage(){
        mainPage.goToUrl();
    }

    @When("^I enter \"([^\"]*)\" into Search text box on the Search Form$")
    public void iEnterIntoSearchTextBoxOnTheSearchForm(String value) throws Throwable {
        searchForm.search.changeValue(value);
    }

    @And("^I select \"([^\"]*)\" in the Group Adults select on the Search Form$")
    public void iSelectInTheGroupAdultsSelectOnTheSearchForm(String value) throws Throwable {
        searchForm.groupAdults.changeValue(value);
    }

    @And("^I click Submit button on the Search Form$")
    public void iClickSubmitButtonOnTheSearchForm() throws Throwable {
        searchForm.submit.perform().click();
    }

    @And("^I check Business Purpose checkbox on the Search Form$")
    public void iCheckBusinessPurposeCheckboxOnTheSearchForm() throws Throwable {
        searchForm.businessPurpose.changeValue(true);
    }

    @When("^I change value of \"([^\"]*)\" element on the Search Form to \"([^\"]*)\"$")
    public void iChangeValueOfElementOnTheSearchFormTo(String elementId, String value) throws Throwable {
        searchForm.changeValue(elementId, value);
    }

    @And("^I click on \"([^\"]*)\" element on the Search Form$")
    public void iClickOnElementOnTheSearchForm(String elementId) throws Throwable {
        searchForm.performAction(elementId);
    }

    @When("^I fill the Search Form with values:$")
    public void iFillTheSearchFormWithValues(Map<String, String> inputData) throws Throwable {
        searchForm.changeValues(inputData);
    }
}

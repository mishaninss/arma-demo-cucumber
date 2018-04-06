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

package com.github.myproject.steps;

import com.github.mishaninss.html.containers.annotations.Container;
import com.github.mishaninss.reporting.IReporter;
import com.github.mishaninss.reporting.Reporter;
import com.github.mishaninss.uidriver.Arma;
import com.github.mishaninss.uidriver.interfaces.IWaitingDriver;
import com.github.myproject.pages.MainPage;
import com.github.myproject.pages.SearchForm;
import com.github.myproject.pages.SearchResult;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class SearchStepDefs extends BaseStepDefs{

    @Container
    private MainPage mainPage;
    @Container
    private SearchForm searchForm;
    @Container
    private SearchResult searchResult;
    @Autowired
    private Arma arma;
    @Reporter
    private IReporter reporter;

    @Given("^I'm on the Main page$")
    public void iMOnTheMainPage(){
        mainPage.goToUrl();
    }

    @When("^I enter \"([^\"]*)\" into Search text box on the Search Form$")
    public void iEnterIntoSearchTextBoxOnTheSearchForm(String value) throws Throwable {
        searchForm.search.perform().click().sendKeys(Keys.ESCAPE);
        searchForm.search.changeValue(value);
    }

    @And("^I select \"([^\"]*)\" in the Group Adults select on the Search Form$")
    public void iSelectInTheGroupAdultsSelectOnTheSearchForm(String value) throws Throwable {
        searchForm.groupAdults.selectByValue(value);
    }

    @And("^I click Submit button on the Search Form$")
    public void iClickSubmitButtonOnTheSearchForm() throws Throwable {
        searchForm.submit.perform().click();
    }

    @And("^I check Business Purpose checkbox on the Search Form$")
    public void iCheckBusinessPurposeCheckboxOnTheSearchForm() throws Throwable {
        searchForm.businessPurpose.select();
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

    @Then("^I see (\\d+) hotel description blocs on the Search Results page$")
    public void iSeeHotelDescriptionBlocsOnTheSearchResultsPage(int value) throws Throwable {
        Assert.assertEquals("Incorrect search results count", value, searchResult.count());
    }

    @And("^Hotel Name value of the (\\d+) search result contains \"([^\"]*)\"$")
    public void hotelNameValueOfTheSearchResultContains(int index, String value) throws Throwable {
        Assert.assertEquals("Unexpected hotel name", value, searchResult.index(index).hotelName.readValue());
    }

    @After
    public void addFailureInfo(Scenario scenario) {
        if (scenario.isFailed() && arma.browser().isBrowserStarted()) {
            reporter.attachScreenshot(arma.page().takeScreenshot());
        }
    }

    @And("^I select \"([^\"]*)\" in the Check-in Date field on the Search Form$")
    public void iSelectInTheCheckInDateFieldOnTheSearchForm(String value) throws Throwable {
        searchForm.checkinDate.changeValue(value);
    }

    @When("^I select \"([^\"]*)\" in the Check-out Date field on the Search Form$")
    public void iSelectInTheCheckOutDateFieldOnTheSearchForm(String value) throws Throwable {
        searchForm.checkoutDate.changeValue(value);
    }
}

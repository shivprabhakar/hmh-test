package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MainPage;

public class WebsiteTestStepdefs {

    MainPage mainPage;

    @Given("^a user launch the website (.+)$")
    public void aUserLaunchTheWebsiteURL(String url) throws InterruptedException {
        System.out.println("launch website!!" + url);
        mainPage =new MainPage(DriverManager.getDriver());
        mainPage.launchMainPage(url);
    }

    @When("^user navigates to (.+) page$")
    public void userNavigatesToTabbedPagePage(String tabName) {
        mainPage.navigateToTab(tabName);
    }

    @Then("^verify the page title (.+) on tab (.+)$")
    public void verifyThePageTitle(String title, String tab) throws InterruptedException {
        mainPage.verifyTitle(title, tab);
    }

    @Then("^verify page url (.+)$")
    public void verifyPageUrlPageUrl(String pageUrl) {
        mainPage.verifyPageUrl(pageUrl);
    }

    @Then("^verify dayDate (.+)$")
    public void verifyDayDate(String tabName) {
        mainPage.verifyDayDate(tabName);
    }

    @When("^enter the text (.+) on search box$")
    public void enterTheTextSearchTextOnSearchBox(String searchText) {

        mainPage.verifySearch(searchText);
    }

    @Then("^verify the search results (.+)$")
    public void verifyTheSearchResults(String searchText) {

        mainPage.verifySearchResult(searchText);
    }

}

package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.OnlineStatementsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StatementsAndDocumentsStepDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    OnlineStatementsPage onlineStatementsPage = new OnlineStatementsPage();
    BrowserUtils browserUtils = new BrowserUtils();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

    int year ;
    String statementName;
    String downloadPath;


    @Given("the user accesses the Statements & Documents tab")
    public void the_user_accesses_the_Statements_Documents_tab() {
        accountSummaryPage.onlineStatementsTab.click();
        String onlineStatementsHeaderExpectedTitle = "Statements & Documents";
        assertEquals(onlineStatementsPage.onlineStatementsHeaderTitle.getText(),onlineStatementsHeaderExpectedTitle);
    }

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(int year) {
        onlineStatementsPage.selectYear(year).click();
        this.year=year;

    }

    @Then("{int} statements should be displayed for that year")
    public void statements_should_be_displayed_for_that_year(int count) {
        assertEquals(onlineStatementsPage.getStatementsList(year).size(),count);
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statement) {
        this.statementName = statement;
        onlineStatementsPage.getStatementName(statement).click();
        BrowserUtils.wait(1);
    }

    @Then("the downloaded file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String nameOfTheFile) {
        downloadPath = "C:/Users/rojhat/Downloads";
        assertTrue(browserUtils.compareDownloadedFileName(downloadPath, nameOfTheFile));
    }

    @Then("the file type should be pdf")
    public void the_file_type_should_be_pdf() {
       assertTrue(browserUtils.compareDownloadedFileExt(downloadPath,"pdf"));
    }


}

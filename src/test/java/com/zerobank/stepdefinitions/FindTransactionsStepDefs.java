package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FindTransactionsStepDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
    BrowserUtils browserUtils = new BrowserUtils();
    Select select;

    Integer startDateNum;
    Integer endDateNum;
    List<Integer> dateListNums;

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.accountActivityTab));
        accountSummaryPage.accountActivityTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(accountActivityPage.findTransactionsTab));
        accountActivityPage.findTransactionsTab.click();
        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.findTransactionsHeadTitle));
        assertEquals(accountActivityPage.findTransactionsHeadTitle.getText(),"Find Transactions");
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startDate, String endDate) {
        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.startDate));
        accountActivityPage.startDate.sendKeys(startDate);
        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.endDate));
        accountActivityPage.endDate.sendKeys(endDate);
    }

    @When("clicks search")
    public void clicks_search() {
        wait.until(ExpectedConditions.elementToBeClickable(accountActivityPage.findButton));
        accountActivityPage.findButton.click();
        browserUtils.wait(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String endDate) {
        this.startDateNum = Integer.valueOf(startDate.replace("-",""));
        this.endDateNum = Integer.valueOf(endDate.replace("-",""));
        dateListNums = new ArrayList<>();
        for (WebElement each:accountActivityPage.findTransactionsDateList){;
            this.dateListNums.add(Integer.valueOf(each.getText().replace("-","")));
        }
        for (int num:dateListNums){
            assertTrue(num>=startDateNum && num<=endDateNum);
        }
        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.startDate));
        accountActivityPage.startDate.clear();
        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.endDate));
        accountActivityPage.endDate.clear();
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<Integer> beforeSortDateList = dateListNums;
        Collections.sort(dateListNums);
        Collections.reverse(dateListNums);
        assertEquals(dateListNums,beforeSortDateList);

    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String oldDate) {
        wait.until(ExpectedConditions.visibilityOfAllElements(accountActivityPage.findTransactionsDateList));
        for (WebElement each:accountActivityPage.findTransactionsDateList){
            assertNotEquals(each.getText(),oldDate);
        }
    }
    //////////////////////////
    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {

        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.descriptionTextBox));
        accountActivityPage.descriptionTextBox.clear();

        wait.until(ExpectedConditions.visibilityOf(accountActivityPage.descriptionTextBox));
        accountActivityPage.descriptionTextBox.sendKeys(string.toUpperCase());
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        for (WebElement each : accountActivityPage.findTransactionsDescriptionList){
            assertTrue(each.getText().contains(string));
        }

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        for (WebElement each : accountActivityPage.findTransactionsDescriptionList) {
            assertFalse(each.getText().contains(string));
        }
    }

    ////////////////////////////////////////////////////////////////////////////////

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        assertTrue(accountActivityPage.findTransactionsDepositList.size()>0);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        assertTrue(accountActivityPage.findTransactionsWithdrawalList.size()>0);
    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        select = new Select(accountActivityPage.typeSelectBox);
        select.selectByVisibleText(string);
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        for (WebElement each:accountActivityPage.findTransactionsWithdrawalList){
            assertTrue(each.getText().isEmpty());
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        for (WebElement each:accountActivityPage.findTransactionsDepositList){
            assertTrue(each.getText().isEmpty());
        }
    }



}

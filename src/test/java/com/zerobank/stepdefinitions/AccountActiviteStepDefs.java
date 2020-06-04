package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountActiviteStepDefs {
    LoginPage loginPage = new LoginPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInHomePageButton));
        loginPage.signInHomePageButton.click();
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }

    @When("the user clicks on Savings link on the Account Summery page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summery_page() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.savingLink));
        accountSummaryPage.savingLink.click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        wait.until(ExpectedConditions.titleContains("Zero - Account Activity"));
        assertTrue(Driver.getDriver().getTitle().contains("Zero - Account Activity"));
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        Select accountBox = new Select(accountActivityPage.accountSelectBox);
        String actualAccount = accountBox.getFirstSelectedOption().getText();
        assertEquals(actualAccount,"Savings");
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.brokerageLink));
        accountSummaryPage.brokerageLink.click();
    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        Select accountBox = new Select(accountActivityPage.accountSelectBox);
        String actualAccount = accountBox.getFirstSelectedOption().getText();
        assertEquals(actualAccount,"Brokerage");
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.checkingLink));
        accountSummaryPage.checkingLink.click();
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        Select accountBox = new Select(accountActivityPage.accountSelectBox);
        String actualAccount = accountBox.getFirstSelectedOption().getText();
        assertEquals(actualAccount,"Checking");
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.creditCardLink));
        accountSummaryPage.creditCardLink.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Select accountBox = new Select(accountActivityPage.accountSelectBox);
        String actualAccount = accountBox.getFirstSelectedOption().getText();
        assertEquals(actualAccount,"Credit Card");
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.loanLink));
        accountSummaryPage.loanLink.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        Select accountBox = new Select(accountActivityPage.accountSelectBox);
        String actualAccount = accountBox.getFirstSelectedOption().getText();
        assertEquals(actualAccount,"Loan");
    }

}

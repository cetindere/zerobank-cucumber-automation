package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.*;

public class PurchaseForeignCurrencyStepDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    PayBillsPage payBillsPage = new PayBillsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
    Select select;

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.payBillsTab));
        accountSummaryPage.payBillsTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(payBillsPage.purchaseForeignCurrencyTab));
        payBillsPage.purchaseForeignCurrencyTab.click();
        String purchaseForeignCurrencyHeaderExpectedTitle = "Purchase foreign currency cash";
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.purchaseForeignCurrencyHeaderTitle));
        assertEquals(payBillsPage.purchaseForeignCurrencyHeaderTitle.getText(),purchaseForeignCurrencyHeaderExpectedTitle);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencies) {
        select = new Select(payBillsPage.currencySelectBox);
        List<String> list = BrowserUtils.getElementsText(select.getOptions());
        list.remove(0);
        assertTrue(list.containsAll(currencies));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.purchaseForeignCurrencyAmountBox));
        payBillsPage.purchaseForeignCurrencyAmountBox.sendKeys("1000");
        wait.until(ExpectedConditions.elementToBeClickable(payBillsPage.purchaseForeignCurrencyDollarRadioButton));
        payBillsPage.purchaseForeignCurrencyDollarRadioButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(payBillsPage.purchaseForeignCurrencyCalculateCostsButton));
        payBillsPage.purchaseForeignCurrencyCalculateCostsButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.getDriver().switchTo().alert();
        String expectedMessage = "Please, ensure that you have filled all the required fields with valid values.";
        assertEquals(alert.getText(),expectedMessage);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        select = new Select(payBillsPage.currencySelectBox);
        select.selectByIndex(4);
        payBillsPage.purchaseForeignCurrencySelectedCurrencyRadioButton.click();
        payBillsPage.purchaseForeignCurrencyCalculateCostsButton.click();


    }



}

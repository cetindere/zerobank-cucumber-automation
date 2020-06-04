package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddNewPayeeStepDefs {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    PayBillsPage payBillsPage = new PayBillsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        wait.until(ExpectedConditions.elementToBeClickable(accountSummaryPage.payBillsTab));
        accountSummaryPage.payBillsTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(payBillsPage.addNewPayeeTab));
        payBillsPage.addNewPayeeTab.click();
        String headerTitleExpected = "Who are you paying?";
        assertTrue(payBillsPage.addNewPayeeHeaderTitle.getText().contains(headerTitleExpected));
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> newPayee) {
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.payeeNameBox));
        payBillsPage.payeeNameBox.sendKeys(newPayee.get("Payee Name"));
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.payeeAddressBox));
        payBillsPage.payeeAddressBox.sendKeys(newPayee.get("Payee Address"));
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.addNewPayeeAccountBox));
        payBillsPage.addNewPayeeAccountBox.sendKeys(newPayee.get("Account"));
        wait.until(ExpectedConditions.visibilityOf(payBillsPage.getAddNewPayeePayeeDetails));
        payBillsPage.getAddNewPayeePayeeDetails.sendKeys(newPayee.get("Payee details"));
        wait.until(ExpectedConditions.elementToBeClickable(payBillsPage.getAddNewPayeeAddButton));
        payBillsPage.getAddNewPayeeAddButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_Should_Be_Displayed(String str) {
        assertEquals(payBillsPage.addNewPayeeAddedMessage.getText(),str);
    }
}

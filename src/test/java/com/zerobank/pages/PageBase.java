package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
    public PageBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account_summary_tab")
    public WebElement accountSummaryTab;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivityTab;

    @FindBy(id = "transfer_funds_tab")
    public WebElement transferFundsTab;

    @FindBy(id = "pay_bills_tab")
    public WebElement payBillsTab;

    @FindBy(id = "money_map_tab")
    public WebElement myMoneyMapTab;

    @FindBy(id = "online_statements_tab")
    public WebElement onlineStatementsTab;

    @FindBy(xpath = "//a[text()='Savings']")
    public WebElement savingLink;

    @FindBy(xpath = "//a[text()='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//a[text()='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[text()='Credit Card']")
    public WebElement creditCardLink;

    @FindBy(xpath = "//a[text()='Loan']")
    public WebElement loanLink;

}

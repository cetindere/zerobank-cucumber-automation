package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivityPage {
    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Show Transactions']")
    public WebElement showTransactionsTab;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactionsTab;

    @FindBy(id = "aa_accountId")
    public WebElement accountSelectBox;

    @FindBy(xpath = "//h2[text()='Find Transactions']")
    public WebElement findTransactionsHeadTitle;

    @FindBy(id = "aa_description")
    public WebElement descriptionTextBox;

    @FindBy(id = "aa_fromDate")
    public WebElement startDate;

    @FindBy(id = "aa_toDate")
    public WebElement endDate;

    @FindBy(id = "aa_fromAmount")
    public WebElement startAmount;

    @FindBy(id = "aa_toAmount")
    public WebElement endAmount;

    @FindBy(id = "aa_type")
    public WebElement typeSelectBox;

    @FindBy(css = "[type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[1]")
    public List<WebElement> findTransactionsDateList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> findTransactionsDescriptionList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> findTransactionsDepositList;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> findTransactionsWithdrawalList;



}

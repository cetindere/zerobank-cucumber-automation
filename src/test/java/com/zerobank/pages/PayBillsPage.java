package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage {
    public PayBillsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Pay Saved Payee']")
    public WebElement paySavedPayeeTab;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayeeTab;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(xpath = "//h2[text()='Who are you paying?']")
    public WebElement addNewPayeeHeaderTitle;

    @FindBy(xpath = "//h2[text()='Purchase foreign currency cash']")
    public WebElement purchaseForeignCurrencyHeaderTitle;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement addNewPayeeAccountBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement getAddNewPayeePayeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement getAddNewPayeeAddButton;

    @FindBy(id = "alert_content")
    public WebElement addNewPayeeAddedMessage;

    @FindBy(id = "pc_currency")
    public WebElement currencySelectBox;

    @FindBy(id = "pc_amount")
    public WebElement purchaseForeignCurrencyAmountBox;

    @FindBy(id = "pc_inDollars_true")
    public WebElement purchaseForeignCurrencyDollarRadioButton;

    @FindBy(id = "pc_inDollars_false")
    public WebElement purchaseForeignCurrencySelectedCurrencyRadioButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement purchaseForeignCurrencyCalculateCostsButton;

}

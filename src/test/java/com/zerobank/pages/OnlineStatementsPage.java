package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OnlineStatementsPage {

    public OnlineStatementsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[text()='Statements & Documents']")
    public WebElement onlineStatementsHeaderTitle;

    @FindBy(id = "os_accountId")
    public WebElement onlineStatementsAccountSelect;

    public WebElement selectYear(int year){
        String yearPath = "//a[text()='"+year+"']";
        WebElement years = Driver.getDriver().findElement(By.xpath(yearPath));
        return years;
    }

    public List<WebElement> getStatementsList(int year){
        String yearPath = "#os_"+year+" table tbody td a";
        List<WebElement> statementsList = Driver.getDriver().findElements(By.cssSelector(yearPath));
        return statementsList;
    }

    public WebElement getStatementName(String name){
        String statementName = "//a[text()='"+name+"']";
        WebElement ste_Name = Driver.getDriver().findElement(By.xpath(statementName));
        return ste_Name;
    }




}

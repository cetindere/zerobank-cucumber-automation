package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "signin_button")
    public WebElement signInHomePageButton;

    @FindBy(id = "user_login")
    public WebElement userName;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement signInLoginPageButton;

    @FindBy(css = ".alert.alert-error")
    public WebElement loginErrorMessage;

    public void login(String username, String passWord){
        wait.until(ExpectedConditions.visibilityOf(userName));
        this.userName.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(password));
        this.password.sendKeys(passWord);
        wait.until(ExpectedConditions.elementToBeClickable(signInLoginPageButton));
        signInLoginPageButton.click();
    }




}

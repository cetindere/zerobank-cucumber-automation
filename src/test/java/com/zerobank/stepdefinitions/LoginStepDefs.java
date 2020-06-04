package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInHomePageButton));
        loginPage.signInHomePageButton.click();
    }

    @When("I login as authorized user")
    public void i_login_as_authorized_user() {
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username,password);
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        wait.until(ExpectedConditions.titleContains("Zero - Account Summary"));
        assertEquals(Driver.getDriver().getTitle(),"Zero - Account Summary");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.userName.sendKeys(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.password.sendKeys(password);
    }

    @And("click the sign in button")
    public void clickTheSignInButton() {
        loginPage.signInLoginPageButton.click();
    }

    @Then("error message {string} should be displayed.")
    public void errorMessageShouldBeDisplayed(String message) {
        assertTrue(loginPage.loginErrorMessage.getText().contains(message));
    }
}

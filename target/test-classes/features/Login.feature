@login
Feature: Login
  As a user,
  I should be able to login to the application
 @positive_login
  Scenario: Login as an authorized user
    Given I am on the login page
    When I login as authorized user
    Then Account summary page should be displayed

  @negative_login
  Scenario: Login as an unauthorized user
    Given I am on the login page
    When I enter username "user"
    And I enter password "password"
    And click the sign in button
    Then error message "Login and/or password are wrong." should be displayed.
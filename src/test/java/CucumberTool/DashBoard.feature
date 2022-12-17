Feature: Dash Board verifivcation
  Scenario: Dash Board verifivcation
    Given user is navigated to HRMS application
    When user enteres valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
    Then user verify DashBoard page
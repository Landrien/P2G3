Feature: Forgot Email
  Scenario: LinkEmail
    Given the user is on the Authentication page
    When the user clicks on the 'Forgot your password' link
    Then the user is redirected to the password reset page
    When the user enters a valid email address associated with an account
    And the user clicks on the 'Retrieve Password' button
    Then a confirmation message is displayed indicating that an email has been sent
    And the user receives an email containing a reset link
    When the user clicks on the reset link in the email
    Then the user open the new page
    And the user sees a confirmation message
    And the user returns to their mailbox
    And the user obtains the new password
    Then the user returns to the Authentication page
    And enters their email address
    And the user enters the new password
    Then the user clicks on the sign in button
    Then the My Account page is displayed
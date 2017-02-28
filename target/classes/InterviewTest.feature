Feature: This feature contains scenarios for registering and print the items in the settings menu of the Babylon app


Scenario: Register the new user and validate the settings menu
    Given The below new user is registered
      | Email                  			    | Password         | First Name            | Last Name             | Date of Birth |
      | testemail10@gmail.com       |Password1        | TestFirstName      | TestLastName        | 28-Mar-1997 |                
    When The Settings menu is clicked
    Then Print the Settings menu items to the console
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/InterviewTest.feature");
formatter.feature({
  "line": 1,
  "name": "This feature contains scenarios for registering and print the items in the settings menu of the Babylon app",
  "description": "",
  "id": "this-feature-contains-scenarios-for-registering-and-print-the-items-in-the-settings-menu-of-the-babylon-app",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Register the new user and validate the settings menu",
  "description": "",
  "id": "this-feature-contains-scenarios-for-registering-and-print-the-items-in-the-settings-menu-of-the-babylon-app;register-the-new-user-and-validate-the-settings-menu",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "The below new user is registered",
  "rows": [
    {
      "cells": [
        "Email",
        "Password",
        "First Name",
        "Last Name",
        "Date of Birth"
      ],
      "line": 6
    },
    {
      "cells": [
        "testemail10@gmail.com",
        "Password1",
        "TestFirstName",
        "TestLastName",
        "28-Mar-1997"
      ],
      "line": 7
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "The Settings menu is clicked",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Print the Settings menu items to the console",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps_InterviewTest.the_below_new_user_is_registered(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 77747748460,
  "status": "passed"
});
formatter.match({
  "location": "Steps_InterviewTest.the_Settings_menu_is_clicked()"
});
formatter.result({
  "duration": 4765819002,
  "status": "passed"
});
formatter.match({
  "location": "Steps_InterviewTest.print_the_Settings_menu_items_to_the_console()"
});
formatter.result({
  "duration": 5191814735,
  "status": "passed"
});
});
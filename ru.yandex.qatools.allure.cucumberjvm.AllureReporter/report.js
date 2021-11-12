$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ConstructAppLogin.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Prashanthi"
    }
  ],
  "line": 2,
  "name": "Construct Aapp Login Feature",
  "description": "",
  "id": "construct-aapp-login-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "User should be able to login to the dashboard",
  "description": "",
  "id": "construct-aapp-login-feature;user-should-be-able-to-login-to-the-dashboard",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I am in app splash screen",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I click on skip button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I want to click the login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on continue button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter email id \"\u003cemailid\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I enter password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click on signin button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I should see the login page",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "construct-aapp-login-feature;user-should-be-able-to-login-to-the-dashboard;",
  "rows": [
    {
      "cells": [
        "emailid",
        "password"
      ],
      "line": 19,
      "id": "construct-aapp-login-feature;user-should-be-able-to-login-to-the-dashboard;;1"
    },
    {
      "cells": [
        "psunkavalli@sisn.com",
        "Ct@PS2021!"
      ],
      "line": 20,
      "id": "construct-aapp-login-feature;user-should-be-able-to-login-to-the-dashboard;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 20,
  "name": "User should be able to login to the dashboard",
  "description": "",
  "id": "construct-aapp-login-feature;user-should-be-able-to-login-to-the-dashboard;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I am in app splash screen",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I click on skip button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I want to click the login button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on continue button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I enter email id \"psunkavalli@sisn.com\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "I enter password \"Ct@PS2021!\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I click on signin button",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I should see the login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.i_am_in_app_splash_screen()"
});
formatter.result({
  "duration": 322117672,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.i_click_on_skip_button()"
});
formatter.result({
  "duration": 3695450151,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.i_want_to_click_the_login_button()"
});
formatter.result({
  "duration": 1255512585,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.i_click_on_continue_button()"
});
formatter.result({
  "duration": 5008111153,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "psunkavalli@sisn.com",
      "offset": 18
    }
  ],
  "location": "LoginPageStepDefinitions.i_enter_email_id(String)"
});
formatter.result({
  "duration": 5467550772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Ct@PS2021!",
      "offset": 18
    }
  ],
  "location": "LoginPageStepDefinitions.i_enter_password(String)"
});
formatter.result({
  "duration": 3362696111,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.i_click_on_signin_button()"
});
formatter.result({
  "duration": 3263400514,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.i_should_see_the_login_page()"
});
formatter.result({
  "duration": 27042,
  "status": "passed"
});
});
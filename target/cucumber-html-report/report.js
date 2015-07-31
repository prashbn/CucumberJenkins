$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/login.feature");
formatter.feature({
  "line": 2,
  "name": "The user should be able to login  and the screen must request for a username and password",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "line": 6,
  "name": "The user should be able to login with a valid",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 5,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "\u003cTestCaseID\u003e I open the page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I click on Login after keyin \u003cUserName\u003e and \u003cPassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I should be redirected to the landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Update results in vansha",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid;",
  "rows": [
    {
      "cells": [
        "TestCaseID",
        "",
        "UserName",
        "",
        "Password"
      ],
      "line": 14,
      "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid;;1"
    },
    {
      "cells": [
        "257",
        "",
        "sample",
        "",
        "sample123"
      ],
      "line": 15,
      "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 15,
  "name": "The user should be able to login with a valid",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    },
    {
      "line": 5,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "257 I open the page",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I click on Login after keyin sample and sample123",
  "matchedColumns": [
    2,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I should be redirected to the landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Update results in vansha",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "257",
      "offset": 0
    }
  ],
  "location": "StepDefn.tc_I_open_the_page(int)"
});

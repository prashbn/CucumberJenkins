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
  "name": "I open the page",
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
formatter.examples({
  "line": 12,
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
      "line": 13,
      "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid;;1"
    },
    {
      "cells": [
        "TC001",
        "",
        "sample",
        "",
        "sample123"
      ],
      "line": 14,
      "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-be-able-to-login-with-a-valid;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 14,
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
  "name": "I open the page",
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
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenarioOutline({
  "line": 20,
  "name": "The user should not be able to login with a invalid login details",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-not-be-able-to-login-with-a-invalid-login-details",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 19,
      "name": "@Regression"
    },
    {
      "line": 19,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "I open the page",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I click on Login after keyin incorrect \u003cUserName\u003e and \u003cPassword\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I should be displayed with an error message",
  "keyword": "Then "
});
formatter.examples({
  "line": 25,
  "name": "",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-not-be-able-to-login-with-a-invalid-login-details;",
  "rows": [
    {
      "cells": [
        "TestCaseID",
        "",
        "UserName",
        "",
        "Password"
      ],
      "line": 26,
      "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-not-be-able-to-login-with-a-invalid-login-details;;1"
    },
    {
      "cells": [
        "TC002",
        "",
        "sample",
        "",
        "sample12"
      ],
      "line": 27,
      "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-not-be-able-to-login-with-a-invalid-login-details;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 27,
  "name": "The user should not be able to login with a invalid login details",
  "description": "",
  "id": "the-user-should-be-able-to-login--and-the-screen-must-request-for-a-username-and-password;the-user-should-not-be-able-to-login-with-a-invalid-login-details;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    },
    {
      "line": 19,
      "name": "@Smoke"
    },
    {
      "line": 19,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "I open the page",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I click on Login after keyin incorrect sample and sample12",
  "matchedColumns": [
    2,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I should be displayed with an error message",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});
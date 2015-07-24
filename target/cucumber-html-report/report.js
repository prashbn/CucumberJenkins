$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/login.feature");
formatter.feature({
  "line": 2,
  "name": "The user should be able to login screen must request for a username and password",
  "description": "",
  "id": "the-user-should-be-able-to-login-screen-must-request-for-a-username-and-password",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "line": 17,
  "name": "The sum of a list of numbers should be calculated",
  "description": "",
  "id": "the-user-should-be-able-to-login-screen-must-request-for-a-username-and-password;the-sum-of-a-list-of-numbers-should-be-calculated",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 15,
      "name": "@TC002"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "a list of numbers",
  "rows": [
    {
      "cells": [
        "18"
      ],
      "line": 19
    },
    {
      "cells": [
        "42"
      ],
      "line": 20
    },
    {
      "cells": [
        "4711"
      ],
      "line": 21
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "I summarize them",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "should I get 4770",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefn.a_list_of_numbers(Integer\u003e)"
});
formatter.result({
  "duration": 107030385,
  "status": "passed"
});
formatter.match({
  "location": "StepDefn.i_summarize_them()"
});
formatter.result({
  "duration": 61593,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4770",
      "offset": 13
    }
  ],
  "location": "StepDefn.should_I_get(int)"
});
formatter.result({
  "duration": 2849000,
  "error_message": "java.lang.AssertionError: expected:\u003c4771\u003e but was:\u003c4770\u003e\n\tat org.junit.Assert.fail(Assert.java:88)\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\n\tat org.junit.Assert.assertEquals(Assert.java:118)\n\tat org.junit.Assert.assertEquals(Assert.java:555)\n\tat org.junit.Assert.assertEquals(Assert.java:542)\n\tat StepDefn.should_I_get(StepDefn.java:30)\n\tat ✽.Then should I get 4770(src/test/resources/login.feature:23)\n",
  "status": "failed"
});
});
$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("connectApium.feature");
formatter.feature({
  "line": 1,
  "name": "Make login in the mobile application",
  "description": "As a user\r\nI want to make login in the mobile application",
  "id": "make-login-in-the-mobile-application",
  "keyword": "Feature"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "we are a user",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "we enter to application",
  "keyword": "And "
});
formatter.match({
  "location": "ConnectSteps.we_are_a_user()"
});
formatter.result({
  "duration": 235149472,
  "status": "passed"
});
formatter.match({
  "location": "ConnectSteps.we_enter_to_application()"
});
formatter.result({
  "duration": 11906379641,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Do login in the application",
  "description": "",
  "id": "make-login-in-the-mobile-application;do-login-in-the-application",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "we make login with user and password",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the login is successfull",
  "keyword": "Then "
});
formatter.match({
  "location": "ConnectSteps.we_make_login_with_user_and_password()"
});
formatter.result({
  "duration": 11840551282,
  "status": "passed"
});
formatter.match({
  "location": "ConnectSteps.the_login_is_successfull()"
});
formatter.result({
  "duration": 3857479345,
  "status": "passed"
});
});
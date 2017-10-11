Feature: Make login in the mobile application
As a user
I want to make login in the mobile application

Background:
    Given we are a user
    And we enter to application

Scenario: Do login in the application
    When we make login with user and password
    Then the login is successfull


#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@Smoke
Feature: Title of your feature
  I want to use this template for my feature file

  @SmokeUI
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    When I complete action
    Then I validate the outcomes
    
@SmokeAPI
  Scenario: Get Response validation of Books
    Given I have a endPoint to hit
    When I want to hit get request
    Then validate statusCode and StatusLine
    
@SmokeAWS
  Scenario: Get Response validation of Books
    Given I have a endPoint to hit
    When I want to hit get request
    Then validate statusCode and StatusLine
    
@Smoke
  Scenario: Get Response validation of Books
    Given I have a endPoint to hit
    When I want to hit get request
    Then validate statusCode and StatusLine
    
@SmokeUI
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    When I complete action
    Then I validate the outcomes
    
@SmokeUI
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    When I complete action
    Then I validate the outcomes
 


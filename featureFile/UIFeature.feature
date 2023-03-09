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
@UI
Feature: Title of your feature
  I want to use this template for my feature file

  @UISmoke
  Scenario: Verify the Title of Web Page
    Given I navigate to the url
    When I will land up in Home page
    Then Validate the Title of Web Page

  @UIRegression
  Scenario: Verify Contact page is loading
    Given I navigate to the url
    When  I will land up in Home page
    And I will click on contact hyperlink
    Then I verify contact header is on the page


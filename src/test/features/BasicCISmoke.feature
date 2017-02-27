@PoC
Feature: The BeInformed web has been deployed
  As a developer
  I want to be able to see the service has been deployed properly
  So that I can continue with further functional testing

  @smoke
  Scenario: server is up and running
    Given I start as "Pablo Arroyo"
    Then I will see the service is running

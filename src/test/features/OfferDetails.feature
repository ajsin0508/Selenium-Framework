@CIAll
@Offer
Feature: Offer details
  As customer I want to check the details of an offer before deciding if I apply to it
  so that I can have more information and customize the product

  Scenario: Loan offer details, which allows customizing
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I get in the PSP page
    When I check the details of the loan offer
    Then I see the details of the loan and can customize the product

  Scenario: PCA offer details
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_AND_NO_LOAN_OFFER"
    And I get in the PSP page
    When I check the details of the PCA offer
    Then I see the details of the PCA


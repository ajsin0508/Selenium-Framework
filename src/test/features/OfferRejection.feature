@CIAll
@Offer
Feature: Offer rejection
  As customer I want to be able to reject an offer if I'm not interested in the product

  Scenario: Loan offer rejection
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I get in the PSP page
    And I check the details of the loan offer
    When I reject the loan offer
    Then I'm in PSP
    #And I see no offers

  Scenario: PCA offer rejection
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_AND_NO_LOAN_OFFER"
    And I get in the PSP page
    And I check the details of the PCA offer
    When I reject the PCA offer
    Then I'm in PSP
    #And I see no offers


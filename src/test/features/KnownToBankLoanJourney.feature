@CIAll
@Loan
@KnownToBank
Feature: Known to bank PCA journey
  As customer I want to be able to request a PCA by filling the minimum amount of information

  Scenario: Loan journey starts by explaining how loans work
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    When I proceed with the Loan application
    Then I am informed of how Tesco Bank loans work

  Scenario: Loan journey first question is bank account details
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    When I acknowledge how loans work
    Then I am asked my bank account details

  Scenario: Loan journey second question is preferred payment date
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    When I acknowledge how loans work
    And I indicate my account details
    Then I am asked my preferred payment date

  Scenario: Loan journey third question is country of birth and nationality
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm asked my preferred payment date
    When I indicate my preferred payment date and elect to continue
    Then I am asked my country of birth and nationality

  Scenario: Loan journey fourth question is document preferences
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm asked my country of birth and nationality in loans
    And I indicate my country of birth and nationality
    Then I am asked my document preferences

  Scenario: Loan journey after documentation preferences I see a summary of the documents to be reviewed before approval
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm asked my documentation preferences in loans
    When I indicate my documentation preferences
    Then I am presented the documentation to review in loans: understanding loan, SECCI and digital signature

  Scenario: Loan journey the first document to accept is understanding my loan
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm presented the documentation to review in loans
    When I continue on the message about the documents to review
    Then I am presented a text for understanding my loan

  Scenario: Loan journey the second document to accept is pre-contract credit information
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm presented a text for understanding my loan
    When I accept the understanding my loan information
    Then I am presented the pre-contract credit information for loans

  Scenario: Loan journey the third document to accept is your credit agreement
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm presented the pre-contract credit information for loans
    When I accept the pre-contract credit information for loans
    Then I am presented my loan credit agreement

  Scenario: Loan journey after signing the agreement I see a confirmation that the account is set up
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm presented my loan credit agreement
    When I sign the Loan agreement
    Then I am presented a confirmation that the loan is set up

  Scenario: Loan journey after continuing in the last confirmation I am sent back to PSP
    Given I log in as "CUSTOMER_WITH_LOAN_OFFER"
    And I proceed with the Loan application
    And I continue until I'm presented a confirmation that the loan is set up
    When I continue on the confirmation that the loan is set up
    Then I am back to PSP with a loan

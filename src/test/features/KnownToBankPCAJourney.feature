@CIAll
@PCA
@KnownToBank
Feature: Known to bank PCA journey
  As customer I want to be able to request a PCA by filling the minimum amount of information

  @BDDexample
  Scenario: PCA journey first question can be income if unknown
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_INCOME_FIRST"
    When I proceed with the PCA application
    Then I am asked my income

  Scenario: PCA journey asks to agree doing a credit check
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_INCOME_FIRST"
    And I proceed with the PCA application
    When I indicate my income
    Then I am asked if I accept doing a credit check

  Scenario: PCA journey second question is overdraft
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_INCOME_FIRST"
    And I proceed with the PCA application
    When I indicate my income
    And I accept doing a credit check
    Then I am asked if I want an overdraft

  Scenario: PCA journey third question is cheque book
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_INCOME_FIRST"
    And I proceed with the PCA application
    And I continue until I'm asked if I want an overdraft
    When I indicate my overdraft details
    Then I am asked if I want a cheque book

  Scenario: PCA journey fourth question can be country of birth and nationality
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_UNKNOWN"
    And I proceed with the PCA application
    And I continue until I'm asked if I want a cheque book
    When I indicate if I want a cheque book
    Then I am asked my country of birth and nationality

  Scenario: PCA journey fourth or fifth question can be mother's maiden name
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_UNKNOWN"
    And I proceed with the PCA application
    And I continue until I'm asked my country of birth and nationality
    When I indicate my country of birth and nationality
    Then I am asked my mother's maiden name

  Scenario: PCA journey after mother's maiden name the next question is documentation preferences
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_UNKNOWN"
    And I proceed with the PCA application
    And I continue until I'm asked my mother's maiden name
    When I indicate my mother's maiden name
    Then I am asked my document preferences

  Scenario: PCA journey can skip both country of birth and mother's maiden name if known and jump into documentation preferences
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm asked if I want a cheque book
    When I indicate if I want a cheque book
    Then I am asked my document preferences

  Scenario: PCA journey after documentation preferences the next question is if I want to go paperless
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm asked my documentation preferences
    When I indicate my documentation preferences
    Then I am asked if I want to go paperless

  Scenario: PCA journey after paperless I see a summary of the documents to be reviewed before approval
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm asked if I want to go paperless
    When I indicate I want to go paperless
    Then I am presented the documentation to review

  @branch
  Scenario: PCA journey if not selected overdraft the summary does not contain pre-contract credit information
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NO_OVERDRAFT"
    And I proceed with the PCA application
    And I continue until I'm asked if I want an overdraft
    And I indicate I don't want an overdraft
    And I indicate if I want a cheque book
    And I indicate my documentation preferences
    When I indicate I want to go paperless
    Then I am presented the documentation to review with no pre-contract credit information

  Scenario: PCA journey after the summary of the documents I have to approve the Financial Services Compensation Scheme
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm presented the documentation to review
    When I continue on the message about the documents to review
    Then I am presented the Financial Services Compensation Scheme

  Scenario: PCA journey after accepting FSCS I have to approve the rates and fees for my current account
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm presented the Financial Services Compensation Scheme
    When I accept the Financial Services Compensation Scheme
    Then I am presented the rates and fees for my current account

  Scenario: PCA journey after accepting the rates and fees I have to approve the pre-contract credit information
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm presented the rates and fees for my current account
    When I accept the rates and fees for my current account
    Then I am presented the pre-contract credit information

  Scenario: PCA journey after accepting the pre-contract credit information I have to sign my agreement
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm presented the pre-contract credit information
    When I accept the pre-contract credit information
    Then I am presented the PCA agreement signature

  Scenario: PCA journey after signing the agreement I see a confirmation that the account is set up
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm presented the PCA agreement signature
    When I sign the PCA agreement
    Then I am presented a confirmation that the account is set up

  Scenario: PCA journey after continuing in the last confirmation I am sent back to PSP
    Given I log in as "CUSTOMER_WITH_PCA_OFFER_NATIONALITY_MAIDEN_KNOWN"
    And I proceed with the PCA application
    And I continue until I'm presented a confirmation that the account is set up
    When I continue on the confirmation that the account is set up
    Then I am back to PSP with an account ready to activate



@KTB-413
@Loan
@LoanPreAgreement
Feature: Display loan pre-agreement
  As a customer
  I want to know what documents I need to agree to
  So that I can understand what's required to sign up to the terms and conditions of my new loan account

#  Scenario 1: Customer is eligible to sign digitally
#  Given I am eligible to sign my application digitally
#  When I navigate to the loan pre-agreement stage
#  Then I see an Introductory page explaining what I am about to see, describing the:
#     - Understanding your loan page
#     - SECCI credit information page
#     - Fixed sum loan agreement and digital signature page
#  And I have the option to continue
  Scenario: Customer is eligible to sign digitally
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm presented the loan pre-agreement stage
    Then I am presented the documentation to review in loans: understanding loan, SECCI and digital signature
    And I have the option to continue

#  Scenario 2: Customer elects to continue
#  Given I am on the loan pre-agreement page
#  When I elect to continue
#  Then I am taken to the next step in the process
  Scenario: Customer elects to continue
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm presented the loan pre-agreement stage
    When I elect to continue
    Then I am presented a text for understanding my loan



#  All presented as per the UX and Tesco Bank's accessibility guidelines and all question text, error messages and other copy is manageable via the CMS.
#  Note: Legal will need to OK the final copy and format used
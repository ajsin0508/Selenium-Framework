@KTB-412
@Loan
@RepaymentDate
Feature: Repayment date selection for a loan
  As a customer
  I want to select the date for my monthly loan repayment
  So that my payments leave my account at a time that suits me
  
#  Scenario 1: Request repayment date
#  Given that I am progressing with a loan offer
#  When I see the page requesting my preferred repayment date
#  Then I am presented with a choice of days from the 1st to the 28th
#  And the choice is set to the 1st as a default
#  And I can select one and only one date
#  And I see an explanation of what I'm being asked to do
#  And I have the option to continue

  Scenario: Request repayment date
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm asked my preferred payment date
    Then I am presented with a choice of days from the 1st to the 28th
    And the choice is set to the 1st as a default
    And I can select one and only one date
    And I see an explanation of what I'm being asked to do
    And I have the option to continue

#  Scenario 2: Provide repayment date
#  Given I am on the page requesting my preferred repayment date
#  When I select a repayment date and elect to continue
#  Then that date is persisted for use in my application
#  And I am taken to the next step in the process
  Scenario: Provide repayment date
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my preferred payment date
    When I indicate my preferred payment date and elect to continue
    Then that repayment date is persisted for use in my application
    And I am presented the documentation to review in loans: understanding loan, SECCI and digital signature
    
#  Scenario: Provide no repayment date
#  Given I am on the page requesting my preferred repayment date
#  When I don't select a repayment date and elect to continue
#  Then the default date is persisted for use in my application
#  And I am taken to the next step in the process
  Scenario: Provide no repayment date
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my preferred payment date
    When I do not select a repayment date and elect to continue
    Then the default date is persisted for use in my application
    And I am presented the documentation to review in loans: understanding loan, SECCI and digital signature

# Need a copy of the UX and Tesco Bank's accessibility guidelines
# We will access case by case basis
#  All presented as per the UX and Tesco Bank's accessibility guidelines and all question text,
#  error messages and other copy is manageable via the CMS.
  @failing
  Scenario: Accessibility for entering the repayment date
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm asked my preferred payment date
    Then I have the right accessibility to enter my preferred payment date


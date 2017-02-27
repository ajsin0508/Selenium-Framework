@KTB-513
@Loan
@MobilePhone
Feature: Mobile Phone is required for loan on boarding
  As a customer
  I need to provide my mobile no. only where the bank needs that information and does not already know it
  So that my application is as quick and easy as possible

#Scenario 1: Get reusable mobile no.
#GIVEN the bank retrieves the primary mobile no. they hold for me
#WHEN that mobile no. is 11 long
#AND that mobile no. is wholly numeric
#AND that mobile no. begins with 07
#THEN the bank is able to re-use that mobile no.

  Scenario: 1 Get reusable mobile no.
   Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_WITH_REUSABLE_MOBILE"
     When I check for mobile number validity rules
     Then I am taken to the next stage of the journey

#Scenario 2: Get non-reusable mobile no.
#GIVEN the bank retrieves the primary mobile no. they hold for me
#WHEN that mobile no. is not 11 long
#OR that mobile no. is not wholly numeric
#OR that mobile no. does not begin with 07
#THEN the bank is not able to re-use that mobile no.

  Scenario: 2 Get non-reusable mobile no.
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_WITH_NON_REUSABLE_MOBILE"
    When I check for mobile number validity rules
    Then I am unable to proceed to next stage of journey

#Scenario 3: Reusable mobile no. already held
#GIVEN scenario 1 is true
#WHEN my application requires my mobile no.
#THEN the mobile no. held is used for the application
#AND I am not asked to provide a mobile no.

  Scenario: 3 Valid mobile no. already held
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_MOBILE_ALREADY_HELD"
    When I continue until I could be asked my mobile number
    Then I am asked my preferred payment date

#  Scenario 4: No valid mobile no. held
#  GIVEN I am proceeding with a loan offer
#  WHEN the bank does not hold a valid mobile no. for me
#  THEN I am taken to the page where I am asked to provide a mobile no. at the appropriate point in the journey
#  AND I see an explanation of what I'm being asked to do
#  AND I see the question about mobile no.
#  AND I have the option to continue

  Scenario: 4 No valid mobile no. held
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm asked my mobile number
    Then I am asked my mobile number
    And I have the option to continue

#�	Online validation must be 11 digits starting with 07 

#  Scenario 5: Customer provides valid mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter a valid mobile no. and elect to continue
#  THEN it is retained for use in my application
#  AND I am taken to the next stage of the journey

  Scenario: 5 Customer provides valid mobile no.
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my mobile number
    When I enter a valid mobile number and elect to continue
    Then The mobile number is retained for use in my application
    And I am asked my preferred payment date
    
#  Scenario 6: Customer provides no mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter nothing and elect to continue
#  THEN I see a message explaining the error - Please enter your mobile number. It will be 11 digits long.
#  AND I ignore the error and am unable to progress to the next stage of the journey
#  AND Page background changes colour.

  Scenario: 6 Customer provides no mobile no.
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my mobile number
    When I elect to continue
    Then I see an error message for the mobile number
    And I enter a valid mobile no. and elect to continue
    And The mobile number is retained for use in my application
    And I am taken to the next stage of the journey

#  Scenario 7: Customer provides invalid alpha mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter an invalid alpha mobile no. and move focus out of input field
#  THEN I see a message explaining the error - Please enter your mobile number. It will be 11 digits long.
#  AND I am unable to progress to the next stage of the journey
#
# Scenario 7.1: Customer provides valid mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter a valid mobile no. and elect to continue
#  THEN it is retained for use in my application
#  AND I am taken to the next stage of the journey

 Scenario: 7 Customer provides invalid alpha mobile no.
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I am asked to enter my mobile no.
    When I enter an invalid alpha mobile no. and move focus out of input field
    Then I see the error message
    And I am unable to proceed to next stage of journey

  Scenario: 7.1 Customer provides valid mobile no
   Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
   And I continue until I'm asked my mobile number
   When I enter a valid mobile number and elect to continue
   Then The mobile number is retained for use in my application



#  Scenario 8: Customer provides invalid special chars mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter an invalid alpha mobile no. and move focus out of input field
#  THEN I see a message explaining the error - Please enter your mobile number. It will be 11 digits long.
#  AND I am unable to progress to the next stage of the journey

#  Scenario 8.1: Customer provides valid mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter a valid mobile no. and elect to continue
#  THEN it is retained for use in my application
#  AND I am taken to the next stage of the journey


   Scenario: 8 Customer provides invalid special chars mobile no.
     Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
     And I am asked to enter my mobile no.
     When  I enter an invalid special characters mobile no. and move focus out of input field
     Then I see the error message
     And I am unable to proceed to next stage of journey

  Scenario: 8.1 Customer provides valid mobile no
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my mobile number
    When I enter a valid mobile number and elect to continue
    Then The mobile number is retained for use in my application


#  Scenario 9: Customer clears mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter an valid alpha mobile no. and then clear the data from the field
#  THEN I see a message explaining the error - Please enter your mobile number. It will be 11 digits long.
#  AND I am unable to progress to the next stage of the journey

#  Scenario 9.1: Customer provides valid mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter a valid mobile no. and elect to continue
#  THEN it is retained for use in my application
#  AND I am taken to the next stage of the journey

 Scenario:9 Customer clears mobile no.
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I am asked to enter my mobile no. and then clear the data from the field
     And I am unable to proceed to next stage of journey
    Then I see an error message for the mobile number

  Scenario: 9.1 Customer provides valid mobile no
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my mobile number
    When I enter a valid mobile number and elect to continue
    Then The mobile number is retained for use in my application

#  Scenario 10: Customer provides mobile no. less than 11 digits
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter an less than 11 digits
#Example:
#|Mobile Number|
#|0|
#|07|
#|07|
#|071|
#|0712|
#|07123|
#|071234|
#|0712345|
#|07123456|
#|071234567|
#|0712345678|
#  THEN I see a message explaining the error - Please enter your mobile number. It will be 11 digits long.
#  AND I am unable to progress to the next stage of the journey

#  Scenario 10.1: Customer provides valid mobile no.
#  GIVEN I am asked to enter my mobile no.
#  WHEN I enter a valid mobile no. and elect to continue
#  THEN it is retained for use in my application
#  AND I am taken to the next stage of the journey

  Scenario Outline: 10 Customer provides mobile no. less than 11 digits
  Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I am asked to enter my mobile no.
    When I enter "<MobileNumber>" less than allowed digits
    Then I see error message for minimum 11 digits required
    And  I am unable to proceed to next stage of journey

 Examples:
|MobileNumber|
|0|
|07|
#|07|
#|071|
#|0712|
#|07123|
#|071234|
#|0712345|
#|07123456|
#|071234567|
#|0712345678|

  Scenario: 10.1 Customer provides valid mobile no
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my mobile number
    When I enter a valid mobile number and elect to continue
    Then The mobile number is retained for use in my application


#  Scenario 11: Customer provides mobile no. more than 11 digits
#  GIVEN I am asked to enter my mobile no.
#  WHEN I attempt to enter more than 11 digits
#  THEN I see that I cannot enter more than 11 digits 
  Scenario: 11 Customer provides mobile no. more than 11 digits
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm asked my mobile number
    When I try to enter more than 11 digits
    Then I see I'm unable to enter more than 11 digits
    
#Mobile phone validation rules
#•Must only contain numeric values
#•Must be 11 digits
#•Must start with 07

#  All presented as per the UX and Tesco Bank's accessibility guidelines and all question text, error messages and other copy is manageable via the CMS.
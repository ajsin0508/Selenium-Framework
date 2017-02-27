@KTB-24
@Loan
@EmailAddress
Feature: Email Address is required for loan on boarding
  As a customer
  I need to provide my email address only where the bank needs that information and does not already know it
  So that my application is as quick and easy as possible
  ##
#Scenario 1: Get reusable email address
#GIVEN I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_VALID_EMAIL_ALREADY_HELD"
#WHEN that email address complies with the vaildity rules in the note below
#THEN the bank is able to re-use that email address
#AND I am not asked to provide an email address

Scenario: 1 Get reusable email address
 Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_VALID_EMAIL_ALREADY"
 When That email address complies with the vaildity rules in the note below
 Then The bank is able to re-use that email address
 And I am not asked to provide an email address

#Scenario 3: No email address held
#GIVEN I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
#WHEN the bank does not hold an email address for me
#THEN I am taken to the page where I am asked to provide an email address at the appropriate point in the journey
#AND I see an explanation of what I'm being asked to do
#AND I see the question about email address with a blank input box
#AND I have the option to continue

 Scenario: 3 No email address held
  Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
  When The bank does not hold an email address for me
  Then I am taken to the page where I am asked to provide an email address at the appropriate point in the journey
  And I see the question about email address with a blank input box
  And I enter a valid email address and elect to continue

#Scenario 4: Reusable email address already held
#GIVEN I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_EMAIL_ALREADY_HELD"
#WHEN my application requires my email address
#THEN the email address held is used for the application
#AND I am not asked to provide an email address
#THEN the bank is not able to re-use that email address

 Scenario: 4 Reusable email address already held
  Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_EMAIL_ALREADY_HELD"
  When I continue until I could be asked my email address
  Then I am asked my mobile number

#Scenario 6.0: Customer provides valid email address
#GIVEN I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NON_REUSABLE_EMAIL_ALREADY_HELD"
#AND I am asked to enter my email address
#WHEN I enter an <email address>
#AND that email address complies with the validity rules below 
#AND I elect to continue
#THEN it is retained to be used as part of my application
#AND I am taken to the next stage of the journey
#Examples:
#    | email address                                 |
#    | prettyandsimple@example.com                   |
#    | very.common@example.com                       |
#    | disposable.style.emai.with+symbol@example.com |
#    | x@example.com 
#    | 1234567891123456789212345678931234567894123456789512345678961234@tesco.com|
#    | a234567891123456789212345678931234567894123456789512345678961234@tesco.com|
#    | A234567891123456789212345678931234567894123456789512345678961234@tesco.com|
#    | Aa!#$%&'*+-/=?^_`{|}21234567893123456789412345678951234567896123@tesco.com|
#    | Aa!#$%&'*+-/=?^_`{|}1234567893123456789412345678951234.56789612@tesco.com|
#    | colin.wallace@tesco.co|
#    | colin.wallace@tesco.Co|
#    | colin.wallace@tesco.1A|
#    | colin.wallace@tesco.1a|
#    | colin.wallace@tes-co.1A|



 Scenario Outline: 6.0 Customer provides valid email address
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NON_REUSABLE_EMAIL_ALREADY_HELD"
    And I continue until I'm asked my email address
    When I enter a valid "<emailaddress>" and elect to continue
    And the valid email address is retained, updates source then TCV
    And I am asked my mobile number

   Examples:
     |emailaddress|
     |prettyandsimple@example.com|
     |very.common@example.com|
     |disposable.style.emai.with+symbol@example.com|
     |x@example.com|
     |1234567891123456789212345678931234567894123456789512345678961234@tesco.com|
     |a234567891123456789212345678931234567894123456789512345678961234@tesco.com|
     |A234567891123456789212345678931234567894123456789512345678961234@tesco.com|
     |Aa!#$%&'*+-/=?^_`{\|}21234567893123456789412345678951234567896123@tesco.com|
     |Aa!#$%&'*+-/=?^_`{\|}1234567893123456789412345678951234.56789612@tesco.com|
     |colin.wallace@tesco.co|
     |colin.wallace@tesco.Co|
     |colin.wallace@tesco.1A|
     |colin.wallace@tesco.1a|
     |colin.wallace@tes-co.1A|

#Scenario 6.1: Customer provides valid email address
#GIVEN I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
#AND I am asked to enter my email address
#WHEN I enter an email address
#AND that email address complies with the validity rules below 
#AND I elect to continue
#THEN it is retained to be used as part of my application
#AND I am taken to the next stage of the journey

  Scenario: 6.1 Customer provides valid email address
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
    And I continue until I'm asked my email address
    When I enter a valid email address and elect to continue
    And the valid email address is retained, updates source then TCV
    And I am asked my mobile number

#Scenario 8: Customer provides no email address
#GIVEN I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
#AND I am asked to enter my email address
#WHEN I leave the input field blank 
#AND I elect to continue
#THEN I see a message explaining the error
#AND I am unable to progress to the next stage of the journey

  Scenario: 8 Customer provides no email address
  Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
  And I am not asked to provide an email address
  When I leave the input field blank
  And I elect to continue
  Then I see a message explaining the error
  And I am unable to progress to the next stage of the journey

#Scenario 9: Customer provides invalid email address
#GIVEN I am asked to enter my <email address>
#WHEN I enter an email address
#AND that email address does not comply with the vaildity rules in the note below
#AND I elect to continue
#THEN I see a message explaining the error
#AND I am unable to progress to the next stage of the journey
#Examples:
#      | email address                   |
#      | abc.example.com                 |
#      | a@b@c@example.com               |
#      | doubledotlocal..doe@example.com |                              
#      | 12345678911234567892123456789312345678941234567895123456789612345@tesco.com|
#      | .Aa!#$%&'*+-/=?^_`{|}1234567893123456789412345678951234567896123@tesco.com|
#      | Aa!#$%&'*+-/=?^_`{|}123456789312345678941234567895123456789612.@tesco.com|
#      | colin.wallace@tesco.c|
#      | colin.wallace@-tesco.1A|
#      | colin.wallace@tesco-.1A|
#      | colin.wallace@tesco..1A|
#      | colin.wallace@.tesco.com|
#      | colin.wallace@tescocom.|


@current
 Scenario Outline: 9 Customer provides invalid email address
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NON_REUSABLE_EMAIL_ALREADY_HELD"
    And I continue until I'm asked my email address
    When I enter an invalid "<emailaddress>" and elect to continue
    Then I see an error message for the valid email address required
    And I am unable to proceed to next stage of journey

  Examples:
    |emailaddress|
    |abc.example.com|
    |a@b@c@example.com|
    |doubledotlocal..doe@example.com|
    |12345678911234567892123456789312345678941234567895123456789612345@tesco.com|
    |.Aa!#$%&'*+-/=?^_`{\|}1234567893123456789412345678951234567896123@tesco.com|
    |Aa!#$%&'*+-/=?^_`{\|}123456789312345678941234567895123456789612.@tesco.com|
    |colin.wallace@tesco.c|
    |colin.wallace@-tesco.1A|
    |colin.wallace@tesco-.1A|
    |colin.wallace@tesco..1A|
    |colin.wallace@.tesco.com|
    |colin.wallace@tescocom.|

#Scenario 10: Customer constrained in providing email address
#GIVEN I enter an email address
#WHEN I try to enter more than 75 characters
#THEN my input of that character is not accepted

Scenario: 10 Customer constrained in providing email address
  Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER_NO_EMAIL_HELD"
  When I try to enter more than 75 characters "nmn.jfnfjhfdjfhjkdnmkd.cdbhgjkjshjfchjfbhjvbfjvhbvjkfnvjnf.mvfkkvmj@jfvnjnfvjf.com" for email address
  Then my input of the character are truncated and I am able to see only 75 characters being entered in the email field


#Note:
#To be reusable the email address must comply with the following rules.
#To be valid the email address must comply with these same rules.
#Rules:
#(Copied from https://stonecutter.jira.com/wiki/display/CTT/3.3+Origination+Datasets )
#The email address comprises a Local Part and Domain, separated by a "@" character. e.g. LocalPart@domain.
#Entire email address length cannot exceed 75 characters.
#*Local Part *may contain
#a maximum of 64 characters
#a minimum of one uppercase or lowercase Latin letters A to Z and a to z or numeric digits 0 to 9
#Special characters !#$%&'*+-/=?^_` {|}
#~
#Dot (.), provided that it is not the first or last character and provided also that it does not appear consecutively
#Domain may contain
#a minimum of two uppercase or lowercase Latin letters A to Z and a to z or numeric digits 0 to 9, provided that top-level domain names are not all-numeric
#hyphen , provided that it is not the first or last character
#a minimum of one dot (.), provided that it is not the first or last character and provided also that it does not appear consecutively
#EMail address is stored across two fields if required. If the entire email address (e.g. Local-Part@Domain.com) is <=40 characters, it is persisted in CM01-ADDRESS-LINE1. If the email address is >40 characters, the excess characters are persisted in CM01-ADDRESS-LINE2



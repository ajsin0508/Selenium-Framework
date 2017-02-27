@KTB-416
@CIALL
@Loan
@LoanCreditAgreement
Feature: Display the loan credit agreement
  As Tesco Bank
  I want to ensure that customers are clear on the terms of the legal agreement before they agree to it
  And that they provide a formal signature to the agreement
  So that there is a formal capture of the acknowledgement of the loan terms and credit agreement and an audit trail of the fact that the customer has signed the legal agreement

#  Scenario 1: Customer has accepted a loan offer and customised the offer
#  GIVEN the customer is eligible to sign digitally
#  WHEN they navigate to the digital signature page
#  THEN they see the fixed sum loan agreement showing the fixed sum loan agreement with parameterised values:
#  <Customer's title, forename & surname>, <Customer's address>, <Total amount of credit>, <Rate of interest>, <Duration of credit agreement>,
#  <Number of repayments>, <Duration of credit agreement>, <Number of repayments>, <Repayments>, <Repayment date>, <Total amount of interest due>, <APR>, <Total amount to pay>  
#  AND they can download a pdf copy for their records
#  AND they see the size of the downloadable pdf in kb
#  AND they see the details of the bank account they entered for repayments with parameterised values (see note 2 below)
#  AND they see the digital signature statement and tick box for the customer to formally sign
#  AND the customer is told clearly that continuing will trigger the funds being sent to their account
#  AND the customer has the option to continue
# Examples:
#         |Customer's title, forename & surname|Customer's address|Total amount of credit|Rate of interest|Duration of credit agreement|Number of repayments|Duration of credit agreement|Number of repayments|Duration of credit agreement|Number of repayments|Repayments|Repayment date|Total amount of interest due|APR|Total amount to pay| 
#         |Customer's title, forename & surname|Customer's address|Total amount of credit|Rate of interest|Duration of credit agreement|Number of repayments|Duration of credit agreement|Number of repayments|Duration of credit agreement|Number of repayments|Repayments|Repayment date|Total amount of interest due|APR|Total amount to pay|         |               

# modify the following url at this stage to get values into the pages/pdf * interim solution until we have loans calc page*
# http://surface.cd.tbaws.com/apply/1111111111/LOAN/5223/Yhs4BRFlkEn8kL0mbn-hxi7hQ-QwbVLD?loanAmount=1110&loanTerm=20&loanAPR=430&repaymentAmount=599.63&totalToPay=35977.73&rateOfInterest=6.7000&numberOfRepayments=60&totalAmountOfInterestDue=1000

  Scenario Outline: 1 Customer has accepted a loan offer and customised the offer and is presented with a digital signature details and wording
    Given I start the Loan originating journey with parameters as "CUSTOMER_WITH_LOAN_OFFER"
    But I wrote my name as "<Title>","<Forename>","<Surname>"and address as "<Address>"
    And In this instance I am requesting "<Total amount of credit>","<Duration of credit agreement>" for my loan
    And I am requesting "<Repayments>" and "<Total amount to pay>" for my loan
    And the "<Rate of interest>" and "<APR>" for the loan
    And I proceed the Journey According to my Loan Details
    And I continue until I'm presented the digital signature page

    Examples:
      |Title|Forename|Surname|Address|Total amount of credit|Duration of credit agreement|Repayments|Total amount to pay|Rate of interest|APR     |
      | Mr  |John    |Doe    |EH12 9FQ|1110.00                |20                         |599.63    |35977.73           |6.7000          |4.30    |
      | Mr  |John    |Doe    |EH12 9FQ|1110.03                |1                          |599.63    |35977.73           |1.1234          |1.234   |

  Scenario: 1.1 Customer has accepted a loan offer and customised the offer and can sign the agreement and download the pdf
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm presented the digital signature page
    Then I am presented the digital signature for loans
    And  I see a link to download a pdf copy of the credit agreement for my records including the pdf size
    And  I see that continue will trigger the money into my given account
    And  I have the option to continue
    And  I see the digital signature statement and tick box to formally sign


# Scenario 2: Customer downloads generated pdf
# GIVEN the customer is on the digital signature page
# WHEN they select the pdf download
# THEN the pdf is downloaded and is requested to be opened in a separate window
# AND the downloaded pdf has an easily recognisable filename
# AND the content matches exactly the fixed sum loan agreement content on the screen

  Scenario Outline: 2 Customer downloads generated pdf
   Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When the customer is on the digital signature page
    And I click on PDF link "tescobank-loan-fixed-sum-loan-agreement-v1.pdf"
    Then the fixed sum agreement pdf is downloaded and is requested to be opened in a separate window
    And the downloaded pdf has an easily recognisable "<filename>"
  Examples:
  |filename|
  |tescobank-loan-fixed-sum-loan-agreement-v1.pdf|


# Scenario 3: Customer elects to continue without digital signature
#  GIVEN the customer is on the digital signature page
#  WHEN the customer elects to continue
#  AND has not provided their digital signature
#  THEN the customer sees a message explaining what they need to do
#  AND is unable to proceed to the next step in the process

  Scenario: 3 Customer elects to continue without digital signature
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm presented the digital signature page
    And I click on continue without providing my digital signature
    Then I see a message explaining the error- This field is required
    And I am unable to proceed to next stage of journey

#  Scenario 4: Customer elects to continue with digital signature
#  GIVEN the customer is on the digital signature page
#  WHEN they elect to continue
#  AND they have provided their digital signature
#  THEN the customer is taken to the next step in the process
#  AND the date and time of their agreement is retained for use in their application

    Scenario: 4 Customer elects to continue with digital signature
     Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
     When I continue until I'm presented the digital signature page
     And I have provided the signature and continue to next process
     Then the default date is persisted for use in my application

#  All presented as per the UX held here: link to repo tbc
#  All compliant withTesco Bank's accessibility guidelines - covered in   KTB-752 TO DO
#
#  All content to be managed via CMS - covered in   KTB-753 TO DO
#

#  Note 2: The following items are parameterised for the bank account
#  Sort code, account number for bank account specified by the customer
#  Bank name from bank wizard absolute service
#
#  Note 3:
#  The copy will be based on the existing loans journey
#  Legal will need to OK the final copy and format used
#
#  Note 4:
#  The name of the PDF should:
#  match the convention for static PDF assets
#  include the product e.g. "tescobank-loan" as a prefix
#  include a document identifier e.g. "fixed-sum-loan-agreement"
#  include the version number e.g. "-v1"
#
#  Note 5:
#  See http://nexus.tbdevops.com/content/repositories/Digital-Releases/com/tescobank/sal/dist/sal-dist-cms/2.0.0/sal-dist-cms-2.0.0.zip for template
#
#  Note 6:
#  Customers are not able to resume an incomplete offer application
#
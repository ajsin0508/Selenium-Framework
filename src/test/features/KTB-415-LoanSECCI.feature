@CIALL
@KTB-415
@Loan
@LoanSECCI
Feature: Display understanding your loan
As a customer
I WANT to display information about the loan in a standard SECCI format
SO THAT I satisfy the regulatory requirement to do this


#  Scenario 1: Customer can view SECCI page 
#  GIVEN the customer is eligible to sign my application digitally
#  WHEN they navigate to the SECCI page
#  THEN they see the SECCI credit information page with parameterised values <Total amount of credit>, <Duration of credit agreement>, <Repayments>, <Total amount to pay>, <Rate of interest>, <APR>
#  AND they can download a pdf version for their records
#  AND they see the size of the downloadable pdf in kb
#  AND they have the option to continue
#  AND they must acknowledge reading the SECCI to proceed
# Examples:
#         |Total amount of credit|Duration of credit agreement|Repayments| Total amount to pay|Rate of interest|    APR|
#         |                  1110|                          20|    599.63|           35977.73|          6.7000|    4.30|
#         |               1110.03|                           1|    599.63|           35977.73|          1.1234|   1.234|
#         |               1110.03|                         120|    599.63|           35977.73|         10.4321|   4.321|   
          
# modify the following url at this stage to get values into the pages/pdf * interim solution until we have loans calc page*
# http://surface.cd.tbaws.com/apply/1111111111/LOAN/5223/Yhs4BRFlkEn8kL0mbn-hxi7hQ-QwbVLD?loanAmount=1110&loanTerm=20&loanAPR=430&repaymentAmount=599.63&totalToPay=35977.73&rateOfInterest=6.7000&numberOfRepayments=60&totalAmountOfInterestDue=1000

  Scenario Outline: 1 Customer is eligible to sign digitally
    Given I start the Loan originating journey with parameters as "CUSTOMER_WITH_LOAN_OFFER"
    But In this instance I am requesting "<Total amount of credit>","<Duration of credit agreement>" for my loan
    And I am requesting "<Repayments>" and "<Total amount to pay>" for my loan
    And the "<Rate of interest>" and "<APR>" for the loan
    And I proceed the Journey According to my Loan Details
    When I continue until I'm presented the pre-contract credit information for loans
    Then I am presented the pre-contract credit information for loans
    And I see the parametrised values in SECCI for loan amount, duration, total to pay, repayments, APR and rate of interest
    And I see an explanation for SECCI
    And I see a link to download a pdf copy of SECCI for my records
    And I have the option to continue
Examples:
  |Total amount of credit|Duration of credit agreement|Repayments|Total amount to pay|Rate of interest|APR     |
  |1110                   |20                         |599.63    |35977.73           |6.7000          |4.30    |
  |1110.03                |1                          |599.63    |35977.73           |1.1234          |1.234   |
  |1110.03                |120                        |599.63    |35977.73           |10.4321         |4.321   |

#  Scenario 2: Customer downloads generated pdf
#  GIVEN the customer is on the SECCI page
#  WHEN they select the pdf download
#  THEN the pdf is downloaded and requested to be opened in a separate window
#  AND the downloaded pdf has an easily recognised filename
#  AND the content matches exactly the SECCI content on the screen
# Examples:
#         |Total amount of credit|Duration of credit agreement|Repayments|Total amount to pay|Rate of interest|    APR|
#         |               1110.00|                          20|    599.63|           35977.73|          6.7000|    430|
#         |               1110.03|                           1|    599.63|           35977.73|          1.1234|   1234|
#         |               1110.03|                         120|    599.63|           35977.73|         10.4321|   4321|   
          
# modify the following url at this stage to get values into the pages/pdf * interim solution until we have loans calc page*
# http://surface.cd.tbaws.com/apply/1111111111/LOAN/5223/Yhs4BRFlkEn8kL0mbn-hxi7hQ-QwbVLD?loanAmount=1110&loanTerm=20&loanAPR=430&repaymentAmount=599.63&totalToPay=35977.73&rateOfInterest=6.7000&numberOfRepayments=60&totalAmountOfInterestDue=1000


  Scenario Outline: 2 Customer downloads generated pdf
    Given I start the Loan originating journey with parameters as "CUSTOMER_WITH_LOAN_OFFER"
    But In this instance I am requesting "<Total amount of credit>","<Duration of credit agreement>" for my loan
    And I am requesting "<Repayments>" and "<Total amount to pay>" for my loan
    And the "<Rate of interest>" and "<APR>" for the loan
    And I proceed the Journey According to my Loan Details
    And I continue until I'm presented the pre-contract credit information for loans
    When I select the pdf download "tescobank-loan-secci-v1.pdf"
    Then the SECCI pdf is downloaded and opens in a separate window
   Examples:
      |Total amount of credit |Duration of credit agreement|Repayments|Total amount to pay|Rate of interest|APR     |
      |1110.00                |20                          |599.63    |35977.73           |6.7000          |4.30    |
      |1110.03                |1                           |599.63    |35977.73           |1.1234          |1.234   |
      |1110.03                |120                         |599.63    |35977.73           |10.4321         |4.321   |

#  Scenario 3: Customer elects to continue
#  GIVEN the customer is on the SECCI page
#  WHEN they elect to continue
#  THEN they are taken to the next step in the process
#  AND the pdf is retained for later storage in the customer's online banking

  Scenario: 3 Customer elects to continue
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm presented the pre-contract credit information for loans
    When I elect to continue
    Then I am presented my loan credit agreement


#  All presented as per the UX held here: link to repo tbc
#  All compliant withTesco Bank's accessibility guidelines - covered in

#  Note 2:
#  The copy will be based on the existing loans journey
#  Legal will need to OK the final copy and format used

#  Note 3:
#  The name of the downloaded PDF should:
#  match the convention for static PDF assets
#  include the product e.g. "tescobank-loan" as a prefix
#  include a document identifier e.g. "secci"
#  include the version number e.g. "-v1"

#  Note 4:
#  See http://nexus.tbdevops.com/content/repositories/Digital-Releases/com/tescobank/sal/dist/sal-dist-cms/2.0.0/sal-dist-cms-2.0.0.zip for template

#  Note 5:
#  Customers are not able to resume an incomplete offer application

  #  Total amount of credit: loan amount selected by customer on loan offer calculator �.pp (values as per understanding your loan)
  #  Duration of credit agreement: term of loan selected by customer on loan offer calculator in months (assumed from 1 to 120 months)
  #  Repayments: number of repayments and monthly repayment amount from loan offer calculator �.pp (values as per understanding your loan)
  #  Total amount to pay: calculated amount from loan offer calculator �.pp (values as per understanding your loan)
  #  Rate of interest: fixed rate from loan offer calculator to 4 decimal places (values as per understanding your loan)
  #  APR: APR from loan offer calculator to at least one decimal place, more if used (up to 4) (values as per understanding your loan)
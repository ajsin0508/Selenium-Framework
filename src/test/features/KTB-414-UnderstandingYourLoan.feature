@CIALL
@KTB-414
@Loan
@LoanUnderstandingYourLoan
Feature: Display understanding your loan
As a customer
I WANT to see information on my new loan
SO THAT I can understand how my new loan will work

#Scenario 1: Customer can view Understanding your loan page 
#GIVEN the customer is eligible to sign my application digitally
#WHEN I navigate to the Understanding your loan page
#THEN I see the Understanding your loan information with parameterised values <Total amount of credit>, <Duration of credit agreement>, <Repayments>, <Total amount to pay>, <Rate of interest>, <APR>
#AND I can download a pdf copy for my records
#AND I see the size of the downloadable pdf in kb
#AND I have the option to continue
#AND I must acknowledge reading the information to proceed 
# Examples:
#         |Total amount of credit|Duration of credit agreement|Repayments| Total amount to pay|Rate of interest|    APR|
#         |                  1110|                          20|    599.63|           35977.73|          6.7000|    4.30|
#         |               1110.03|                           1|    599.63|           35977.73|          1.1234|   1.234|
#         |               1110.03|                         120|    599.63|           35977.73|         10.4321|   4.321|  
        
# modify the following url at this stage to get values into the pages/pdf * interim solution until we have loans calc page*
# http://surface.cd.tbaws.com/apply/1111111111/LOAN/5223/Yhs4BRFlkEn8kL0mbn-hxi7hQ-QwbVLD?loanAmount=1110&loanTerm=20&loanAPR=430&repaymentAmount=599.63&totalToPay=35977.73&rateOfInterest=6.7000&numberOfRepayments=60&totalAmountOfInterestDue=1000


  Scenario Outline: 1 Customer is eligible to sign digitally
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    But In this instance I am requesting "<Total amount of credit>","<Duration of credit agreement>" for my loan
    And I am requesting "<Repayments>" and "<Total amount to pay>" for my loan
    And the "<Rate of interest>" and "<APR>" for the loan
    And I proceed the Journey According to my Loan Details
    When I continue until I'm presented a text for understanding my loan
    Then I am presented a text for understanding my loan
    And I see the parametrised values for loan amount, total to pay, repayments, APR and rate of interest
    And I see an explanation of why I need to understand my loan
    And I see a link to download a pdf copy of understand my loan for my records
    And I have the option to continue
 Examples:
      |Total amount of credit|Duration of credit agreement|Repayments|Total amount to pay|Rate of interest|APR     |
      |1110                   |20                         |599.63    |35977.73           |6.7000          |4.30    |
      |1110.03                |1                          |599.63    |35977.73           |1.1234          |1.234   |
      |1110.03                |120                        |599.63    |35977.73           |10.4321         |4.321   |


  Scenario Outline: 1.1 Customer downloads generated pdf
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    But In this instance I am requesting "<Total amount of credit>","<Duration of credit agreement>" for my loan
    And I am requesting "<Repayments>" and "<Total amount to pay>" for my loan
    And the "<Rate of interest>" and "<APR>" for the loan
    And I proceed the Journey According to my Loan Details
    And I continue until I'm presented a text for understanding my loan
    When I select the pdf download "tescobank-loan-understanding-your-loan-v1.pdf"
    Then the understand your loan pdf is downloaded and opens in a separate window
  Examples:
  |Total amount of credit|Duration of credit agreement|Repayments|Total amount to pay|Rate of interest|APR     |
  |1110                   |20                         |599.63    |35977.73           |6.7000          |4.30    |
  |1110.03                |1                          |599.63    |35977.73           |1.1234          |1.234   |
  |1110.03                |120                        |599.63    |35977.73           |10.4321         |4.321   |

#+Scenario 6: Customer downloads generated pdf+*
#GIVEN* I am on the understanding your loan page
#WHEN* I select the pdf download
#THEN* the pdf is downloaded and requested to be opened in a separate window
#AND* the downloaded pdf has an easily recognisable <filename> 
#AND* the content matches exactly the understanding your loan content on the screen
# Examples:
#         |filename|
#         |tescobank-loan-understanding your loan-v1.pdf|

  Scenario Outline: 6 Customer downloads generated pdf and checks the name of the pdf file
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm presented a text for understanding my loan
    When I select the pdf download "tescobank-loan-understanding-your-loan-v1.pdf"
    Then the understand your loan pdf is downloaded and opens in a separate window
    And the downloaded pdf from understanding your loan page has an easily recognisable "<filename>"
    Examples:
        |filename|
        |tescobank-loan-understanding-your-loan-v1.pdf|

#Note 3:
# The name of the PDF should:
# - match the convention for static PDF assets
# - include the product e.g. "tescobank-loan" as a prefix
# - include a document identifier e.g. "understanding your loan"
# - include the version number e.g. "-v1"
# - have the .pdf suffix

#Scenario  7 : Customer elects to continue+*
#GIVEN* I am on the understanding your loan page
#WHEN* I elect to continue
#THEN* I am taken to the next step in the process

  Scenario: 7 Customer elects to continue
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm presented a text for understanding my loan
    When I elect to continue
    Then I am presented the pre-contract credit information for loans

#Scenario 8: Customer elects to continue without acknowledgement
#GIVEN I log in as "CUSTOMER_WITH_LOAN_OFFER" 
#AND I am eligible to sign my application digitally
#AND I am on the understanding your loan page
#WHEN I elect to continue
#AND I have not acknowledged reading understanding your loan
#THEN I am unable to proceed to the next step in the process

Scenario: 8 Customer elects to continue without acknowledgement
  Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
  And I continue until I'm presented a text for understanding my loan
  When I elect to continue

#Scenario 9: Customer elects to continue with acknowledgement and generated pdf
#GIVEN I log in as "CUSTOMER_WITH_LOAN_OFFER" 
#AND I am eligible to sign my application digitally
#AND I am on the understanding your loan page
#WHEN I elect to continue
#AND I have acknowledged reading understanding your loan
#AND the pdf has been successfully generated
#THEN I am taken to the next step in the process
#AND the pdf is retained for later storage --where?

  Scenario: 9 Customer elects to continue with acknowledgement and generated pdf
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm presented a text for understanding my loan
    When I am presented a text for understanding my loan
    And I click on PDF link "tescobank-loan-understanding-your-loan-v1.pdf"
    Then I am taken to the next stage of the journey
   
#Scenario 10: Ensure the copy on the Understanding your loan page and the PDF match
#GIVEN I log in as "CUSTOMER_WITH_LOAN_OFFER" 
#AND I am eligible to sign my application digitally
#WHEN I navigate to the Understanding your loan page
#THEN I see the Understanding your loan information 
#AND I can check that the copy matches the existing copy from the loans journey
#AND I can download and save a pdf copy for my records


  Scenario: 10 Ensure the copy on the Understanding your loan page and the PDF match
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    And I continue until I'm presented a text for understanding my loan
    When I am presented a text for understanding my loan
    Then I see a link to download a pdf copy of understand my loan for my records
    And I click on PDF link "tescobank-loan-understanding-your-loan-v1.pdf"


#Scenario 11: Check the naming covention of the PDF - understanding your loan
#GIVEN I log in as "CUSTOMER_WITH_LOAN_OFFER" 
#AND I am eligible to sign my application digitally
#WHEN I navigate to the Understanding your loan page
#THEN I see the Understanding your loan information 
#AND I can check that the pdf name matches the convention for static PDF assets
# - include the product e.g. "tescobank-loan" as a prefix
# - include a document identifier e.g. "understanding your loan"
# - include the version number e.g. "-v1"
# - have the .pdf suffix
#(tescobank-loan-understanding your loan-v1.pdf)

 Scenario Outline: 11 Check the naming convention of the PDF - understanding your loan
    Given I start the Loan originating journey as "CUSTOMER_WITH_LOAN_OFFER"
    When I continue until I'm presented a text for understanding my loan
    And I see the Understanding your loan information
    And I select the pdf download "<filename>"
    Then the understand your loan pdf is downloaded and opens in a separate window
    And the downloaded pdf from understanding your loan page has an easily recognisable "<filename>"
   Examples:
     |filename|
     |tescobank-loan-understanding-your-loan-v1.pdf|

   # Then I can check that the pdf name matches the convention for static PDF assets: "tescobank-loan-understanding-your-loan-v1.pdf"

#All presented as per the UX and Tesco Bank's accessibility guidelines and all templates, question text, error messages and other copy is manageable via the CMS.

#Note 1: The following items are parameterised in 'Understanding your loan'
# - Total amount of credit: loan amount selected by customer on loan offer calculator £.pp (assume from £100.00 to £99,999.99)
# - Total amount to pay: calculated amount from loan offer calculator £.pp (assume from £100.00 to £99,999.99)
# - Repayments: monthly repayment amount from loan offer calculator £.pp (assume from £0.99 to £9,999.99)
# - APR: APR from loan offer calculator to at least one decimal place, more if used (assume from 0.1% to 999.9999% and from 1 to 4 decimal places)
# - Rate of interest: fixed rate from loan offer calculator to 4 decimal places (assume from 0.0001% to 999.9999%)

#Note 2:
# - The copy will come from the existing loans journey
# - Legal will need to OK the final copy and format used

#Note 3:
# The name of the PDF should:
# - match the convention for static PDF assets
# - include the product e.g. "tescobank-loan" as a prefix
# - include a document identifier e.g. "understanding your loan"
# - include the version number e.g. "-v1"
# - have the .pdf suffix



package com.tescobank.judge.stepDefs;

import com.tescobank.judge.actions.EmailAddressAction;
import com.tescobank.judge.actions.MobileNumberAction;
import com.tescobank.judge.state.Actor;
import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Questions;
import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.task.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BeInformedJourneyStepDefs {
    public Object MobNo = SharedState.get(StateKey.MOBILE_NUMBER);

    @When("^I continue on the message about many questions$")
    public void I_continue_on_the_message_about_many_questions() throws Throwable {
        BeInformedGeneralTask.continueOnIntroScreen();
    }

    @When("^I indicate my income$")
    public void I_indicate_my_income() throws Throwable {
        IncomeTask.enterIncome();
    }

    @And("^I accept doing a credit check$")
    public void I_accept_doing_a_credit_check() throws Throwable {
        BeInformedGeneralTask.continueOnWaitingScreen();
    }

    @And("^I continue until I'm asked if I want an overdraft$")
    public void I_continue_until_I_m_asked_if_I_want_an_overdraft() throws Throwable {
        I_indicate_my_income();
        I_accept_doing_a_credit_check();
    }

    @When("^I indicate my overdraft details$")
    public void I_indicate_my_overdraft_details() throws Throwable {
        OverdraftTask.enterSomeOverdraft();
    }

    @When("^I indicate I don't want an overdraft$")
    public void I_indicate_I_don_t_want_an_overdraft() throws Throwable {
        OverdraftTask.enterNoOverdraft();
    }

    @And("^I continue until I'm asked if I want a cheque book$")
    public void I_continue_until_I_m_asked_if_I_want_a_cheque_book() throws Throwable {
        I_continue_until_I_m_asked_if_I_want_an_overdraft();
        I_indicate_my_overdraft_details();
    }

    @When("^I indicate if I want a cheque book$")
    public void I_indicate_if_I_want_a_cheque_book() throws Throwable {
        ChequeBookTask.answerChequeBook();
    }

    @When("^I acknowledge how loans work$")
    public void I_acknowledge_how_loans_work() throws Throwable {
        BeInformedGeneralTask.continueOnWaitingScreen();
    }

    @When("^I indicate my account details$")
    public void I_indicate_my_account_details() throws Throwable {
        AccountDetailsTask.enterAccountDetails();
    }

    @When("^I continue until I'm asked my email address|I continue until I could be asked my email address$")
    public void I_continue_until_I_m_asked_my_email_address() throws Throwable {
        // TODO when coming from the loan calculator
        // I_acknowledge_how_loans_work();
    }

    @When("^I continue until I'm asked my mobile number|I continue until I could be asked my mobile number$")
    public void I_continue_until_I_m_asked_my_mobile_number() throws Throwable {
        I_continue_until_I_m_asked_my_email_address();
        I_enter_a_valid_email_address_and_elect_to_continue();
    }

    @And("^I continue until I'm asked my preferred payment date$")
    public void I_continue_until_I_m_asked_my_preferred_payment_date() throws Throwable {
        I_continue_until_I_m_asked_my_mobile_number();
        I_enter_a_valid_mobile_number_and_elect_to_continue();
    }

    @When("^I indicate my preferred payment date and elect to continue$")
    public void I_indicate_my_preferred_payment_date_and_elect_to_continue() throws Throwable {
        PreferredPaymentDateTask.enterPaymentDate();
    }

    @When("^I do not select a repayment date and elect to continue$")
    public void I_do_not_select_my_preferred_payment_date_and_elect_to_continue() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm asked my country of birth and nationality$")
    public void I_continue_until_I_m_asked_my_country_of_birth_and_nationality() throws Throwable {
        I_continue_until_I_m_asked_if_I_want_a_cheque_book();
        I_indicate_if_I_want_a_cheque_book();
    }

    @And("^I continue until I'm asked my country of birth and nationality in loans$")
    public void I_continue_until_I_m_asked_my_country_of_birth_and_nationality_in_loans() throws Throwable {
        I_continue_until_I_m_asked_my_preferred_payment_date();
        I_indicate_my_preferred_payment_date_and_elect_to_continue();
    }

    @And("^I enter valid mobile no$")
    public void iEnterValidMobileNo() throws Throwable {
        Actions.getMobileNumberAction().enterMobileNumber();
    }

    @When("^I indicate my country of birth and nationality$")
    public void I_indicate_my_country_of_birth_and_nationality() throws Throwable {
        CountryBirthNationalityTask.answerBirthAndNationality();
    }

    @And("^I continue until I'm asked my mother's maiden name$")
    public void I_continue_until_I_m_asked_my_mothers_maiden_name() throws Throwable {
        I_continue_until_I_m_asked_my_country_of_birth_and_nationality();
        if (Questions.getCountryBirthNationalityView().isRendered()) I_indicate_my_country_of_birth_and_nationality();
    }

    @When("^I indicate my mother's maiden name$")
    public void I_indicate_my_mothers_maiden_name() throws Throwable {
        MotherMaidenNameTask.answer();
    }

    @And("^I continue until I'm asked my documentation preferences$")
    public void I_continue_until_I_m_asked_my_documentation_preferences() throws Throwable {
        I_continue_until_I_m_asked_my_mothers_maiden_name();
        if (Questions.getMotherMaidenNameView().isRendered()) I_indicate_my_mothers_maiden_name();
    }

    @And("^I continue until I'm asked my documentation preferences in loans$")
    public void I_continue_until_I_m_asked_my_documentation_preferences_in_loans() throws Throwable {
        I_continue_until_I_m_asked_my_country_of_birth_and_nationality_in_loans();
        I_indicate_my_country_of_birth_and_nationality();
    }

    @When("^I indicate my documentation preferences$")
    public void I_indicate_my_documentation_preferences() throws Throwable {
        DocumentationPreferencesTask.answer();
    }

    @And("^I continue until I'm asked if I want to go paperless$")
    public void I_continue_until_I_m_asked_if_I_want_to_go_paperless() throws Throwable {
        I_continue_until_I_m_asked_my_documentation_preferences();
        I_indicate_my_documentation_preferences();
    }

    @When("^I indicate I want to go paperless$")
    public void I_indicate_if_I_want_to_go_paperless() throws Throwable {
        PaperlessTask.answer();
    }

    @And("^I continue until I'm presented the documentation to review$")
    public void I_continue_until_I_m_presented_the_documentation_to_review() throws Throwable {
        I_continue_until_I_m_asked_if_I_want_to_go_paperless();
        I_indicate_if_I_want_to_go_paperless();
    }

    @And("^I continue until I'm presented the documentation to review in loans|I continue until I'm presented the loan pre-agreement stage$")
    public void I_continue_until_I_m_presented_the_documentation_to_review_in_loans() throws Throwable {
        I_continue_until_I_m_asked_my_preferred_payment_date();
        I_indicate_my_preferred_payment_date_and_elect_to_continue();
    }

    @When("^I continue on the message about the documents to review$")
    public void I_continue_on_the_message_about_the_documents_to_review() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented the Financial Services Compensation Scheme$")
    public void I_continue_until_I_m_presented_the_Financial_Services_Compensation_Scheme() throws Throwable {
        I_continue_until_I_m_presented_the_documentation_to_review();
        I_continue_on_the_message_about_the_documents_to_review();
    }

    @When("^I accept the Financial Services Compensation Scheme$")
    public void I_accept_the_Financial_Services_Compensation_Scheme() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented the rates and fees for my current account$")
    public void I_continue_until_I_m_presented_the_rates_and_fees_for_my_current_account() throws Throwable {
        I_continue_until_I_m_presented_the_Financial_Services_Compensation_Scheme();
        I_accept_the_Financial_Services_Compensation_Scheme();
    }

    @When("^I accept the rates and fees for my current account$")
    public void I_accept_the_rates_and_fees_for_my_current_account() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented the pre-contract credit information$")
    public void I_continue_until_I_m_presented_the_pre_contract_credit_information() throws Throwable {
        I_continue_until_I_m_presented_the_rates_and_fees_for_my_current_account();
        I_accept_the_rates_and_fees_for_my_current_account();
    }

    @When("^I accept the pre-contract credit information$")
    public void I_accept_the_pre_contract_credit_information() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented the PCA agreement signature$")
    public void I_continue_until_I_m_presented_the_PCA_agreement_signature() throws Throwable {
        I_continue_until_I_m_presented_the_pre_contract_credit_information();
        I_accept_the_pre_contract_credit_information();
    }

    @When("^I sign the PCA agreement$")
    public void I_sign_the_PCA_agreement() throws Throwable {
        PCASignatureTask.signAgreement();
    }

    @And("^I continue until I'm presented a confirmation that the account is set up$")
    public void I_continue_until_I_m_presented_a_confirmation_that_the_account_is_set_up() throws Throwable {
        I_continue_until_I_m_presented_the_PCA_agreement_signature();
        I_sign_the_PCA_agreement();
    }

    @When("^I continue on the confirmation that the account is set up$")
    public void I_continue_on_the_confirmation_that_the_account_is_set_up() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented a text for understanding my loan$")
    public void I_continue_until_I_m_presented_a_text_for_understanding_my_loan() throws Throwable {
        I_continue_until_I_m_presented_the_documentation_to_review_in_loans();
        I_continue_on_the_message_about_the_documents_to_review();
    }

    @When("^I accept the understanding my loan information$")
    public void I_accept_the_understanding_my_loan_information() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented the pre-contract credit information for loans$")
    public void I_continue_until_I_m_presented_the_pre_contract_credit_information_for_loans() throws Throwable {
        I_continue_until_I_m_presented_a_text_for_understanding_my_loan();
        I_accept_the_understanding_my_loan_information();
    }

    @When("^I accept the pre-contract credit information for loans$")
    public void I_accept_the_pre_contract_credit_information_for_loans() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I continue until I'm presented my loan credit agreement$")
    public void I_continue_until_I_m_presented_my_loan_credit_agreement() throws Throwable {
        I_continue_until_I_m_presented_the_pre_contract_credit_information_for_loans();
        I_accept_the_pre_contract_credit_information_for_loans();
    }

    @When("^I sign the Loan agreement$")
    public void I_sign_the_Loan_agreement() throws Throwable {
        LoanSignatureTask.signAgreement();
    }

    @And("^I continue until I'm presented a confirmation that the loan is set up$")
    public void I_continue_until_I_m_presented_a_confirmation_that_the_loan_is_set_up() throws Throwable {
        I_continue_until_I_m_presented_my_loan_credit_agreement();
        I_sign_the_Loan_agreement();
    }

    @When("^I continue on the confirmation that the loan is set up$")
    public void I_continue_on_the_confirmation_that_the_loan_is_set_up() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @And("^I have the option to continue$")
    public void I_have_the_option_to_continue() throws Throwable {
        Questions.getGeneralBeInformedView().optionToContinueIsPresent();
    }

    @When("^I elect to continue$")
    public void I_elect_to_continue() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    @When("^I enter a valid email address and elect to continue$")
    public void I_enter_a_valid_email_address_and_elect_to_continue() throws Throwable {
        EmailAddressTask.answer();
    }

    @When("^I enter an invalid email address and elect to continue$")
    public void I_enter_an_invalid_email_address_and_elect_to_continue() throws Throwable {
        EmailAddressTask.tryInvalidEmail();
    }

    @When("^I enter a valid mobile number and elect to continue$")
    public void I_enter_a_valid_mobile_number_and_elect_to_continue() throws Throwable {
        Actions.getMobileNumberAction().MobilenumberValidation(Actor.getString(StateKey.MOBILE_NUMBER));
        MobileNumberTask.answer();
    }

    @When("^I enter an invalid mobile number and elect to continue$")
    public void I_enter_an_invalid_mobile_number_and_elect_to_continue() throws Throwable {
        MobileNumberTask.tryInvalidMobileNumber();
    }

    @When("^I select the pdf download \"([^\"]*)\"$")
    public void I_select_the_pdf_download(String linkName) throws Throwable {
        BeInformedGeneralTask.fetchPdfUrl(linkName);
        PdfTasks.clickOnPDF(linkName);
    }

    @But("^In this instance I am requesting (\\d+) pounds for my loan$")
    public void In_this_instance_I_am_requesting_pounds_for_my_loan(int loanAmountAmended) throws Throwable {
        SharedState.put(StateKey.LOAN_AMOUNT, loanAmountAmended);
    }

    @When("^I accept the understanding my digital_signature information$")
    public void I_accept_the_understanding_my_digital_signature_information() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();
    }

    //KTB416
    @When("^I continue until I'm presented the digital signature page$")
    public void i_continue_until_I_m_presented_the_digital_signature_page() throws Throwable {
        I_continue_until_I_m_presented_the_pre_contract_credit_information_for_loans();
        I_accept_the_understanding_my_digital_signature_information();
    }


    @Then("^I see the digital signature statement and tick box to formally sign$")
    public void i_see_the_digital_signature_statement_and_tick_box_to_formally_sign(
    ) throws Throwable {
        I_sign_the_Loan_agreement();
        //BeInformedGeneralTask.continueOnScreen();
    }

    @When("^the customer is on the digital signature page$")
    public void the_customer_is_on_the_digital_signature_page() throws Throwable {
        I_continue_until_I_m_presented_the_pre_contract_credit_information_for_loans();
        I_accept_the_understanding_my_digital_signature_information();

    }


    @And("^I click on PDF link \"([^\"]*)\"$")
    public void iClickOnPDFLink(String linkName) throws Throwable {
        BeInformedGeneralTask.fetchPdfUrl(linkName);
        PdfTasks.clickOnPDF(linkName);

    }
    //KTB513
    @When("^I am asked to enter my mobile no\\.$")
    public void i_am_asked_to_enter_my_mobile_no() throws Throwable {
        I_continue_until_I_m_asked_my_email_address();
        I_enter_a_valid_email_address_and_elect_to_continue();
    }

    @When("^I enter a valid mobile no\\. and elect to continue$")
    public void i_enter_a_valid_mobile_no_and_elect_to_continue() throws Throwable {
        MobileNumberTask.answer();
    }


    @And("^I am taken to the next stage of the journey$")
    public void i_am_taken_to_the_next_stage_of_the_journey() throws Throwable {
        Actions.getBeInformedGeneralAction().clickNext();
    }

    @When("^I enter an invalid alpha mobile no\\. and move focus out of input field$")
    public void i_enter_an_invalid_alpha_mobile_no_and_move_focus_out_of_input_field() throws Throwable {
        MobileNumberTask.tryInvalidMobileNumber();
    }


    @And("^I am unable to proceed to next stage of journey$")
    public void i_am_unable_to_proceed_to_next_stage_of_journey() throws Throwable {
        Actions.getBeInformedGeneralAction().clickNext();
    }

    @When("^I enter valid mobile no\\. and elect to continue$")
    public void i_enter_valid_mobile_no_and_elect_to_continue() throws Throwable {

        Actions.getMobileNumberAction().enterMobileNumber();
    }

    @When("^I enter an invalid special characters mobile no\\. and move focus out of input field$")
    public void i_enter_an_invalid_special_characters_mobile_no_and_move_focus_out_of_input_field() throws Throwable {

        MobileNumberTask.trySpecialCharacter();
    }

    @When("^I am asked to enter my mobile no\\. and then clear the data from the field$")
    public void i_am_asked_to_enter_my_mobile_no_and_then_clear_the_data_from_the_field() throws Throwable {

        I_enter_a_valid_email_address_and_elect_to_continue();
        Actions.getMobileNumberAction().enterMobileNumber();
        Actions.getMobileNumberAction().ClearMobileNumber();
    }

    @When("^I enter \"([^\"]*)\" less than allowed digits$")
    public void iEnterLessThanAllowedDigits(String MobileNumber) throws Throwable {

        SharedState.put(StateKey.MOBILE_NUMBER, MobileNumber);
        Actions.getMobileNumberAction().enterMobileNumber();
        SharedState.put(StateKey.MOBILE_NUMBER, MobNo);

    }

    @When("^I enter \"([^\"]*)\" more than allowed digits$")
    public void iEnterMoreThanAllowedDigits(String MobileNumber) throws Throwable {
        SharedState.put(StateKey.MOBILE_NUMBER, MobileNumber);
        Actions.getMobileNumberAction().enterMobileNumber();
        SharedState.put(StateKey.MOBILE_NUMBER, MobNo);
    }
    @When("^The bank does not hold an email address for me$")
    public void theBankDoesNotHoldAnEmailAddressForMe() throws Throwable {
        I_continue_until_I_m_asked_my_email_address();
        //Need to check in DB whether the email address for the customer is held
    }


    @When("^That email address complies with the vaildity rules in the note below$")
    public void thatEmailAddressCompliesWithTheVaildityRulesInTheNoteBelow() throws Throwable {
        Actions.getEmailAddressAction().emailAddressValidation(Actor.getString(StateKey.EMAIL));
    }

    @When("^I click on continue without providing my digital signature$")
    public void i_click_on_continue_without_providing_my_digital_signature() throws Throwable {
        BeInformedGeneralTask.continueOnScreen();

    }

    @When("^I check for mobile number validity rules$")
    public void checkForMobileNumberValidityRules() throws Throwable {
        I_continue_until_I_m_asked_my_mobile_number();
        Actions.getMobileNumberAction().MobilenumberValidation(Actor.getString(StateKey.MOBILE_NUMBER));
        MobileNumberTask.answer();
    }


    @And("^I have provided the signature and continue to next process$")
    public void iHaveProvidedTheSignatureAndContinueToNextProcess() throws Throwable {
        i_see_the_digital_signature_statement_and_tick_box_to_formally_sign();
    }

    @When("^That email address does not complies with the vaildity rules in the note below$")
    public void thatEmailAddressDoesNotCompliesWithTheVaildityRulesInTheNoteBelow() throws Throwable {
        Actions.getEmailAddressAction().emailAddressValidation(Actor.getString(StateKey.EMAIL));
    }

    @When("^I leave the input field blank$")
    public void iLeaveTheInputFieldBlank() throws Throwable {
        //Email filed is left blank
    }

    @When("^I enter an email address and elect to continue$")
    public void iEnterAnEmailAddressAndElectToContinue() throws Throwable {
        EmailAddressTask.answer();

    }

    @And("^I enter valid mobile number$")
    public void iEnterValidMobileNumber() throws Throwable {
       Actions.getMobileNumberAction().enterMobileNumber();
    }


    @When("^I try to enter more than (\\d+) digits$")
    public void iTryToEnterMoreThanDigits(int arg0) throws Throwable {
         Actions.getMobileNumberAction().enterMobileNumber();

    }

    @When("^I enter a valid \"([^\"]*)\" and elect to continue$" )
    public void iEnterAValidAndElectToContinue(String emailaddress) throws Throwable {
      SharedState.put(StateKey.EMAIL,emailaddress);
      EmailAddressTask.answer();
    }

    @When("^I enter an invalid \"([^\"]*)\" and elect to continue$")
    public void iEnterAnInvalidAndElectToContinue(String emailaddress) throws Throwable {
        SharedState.put(StateKey.EMAIL,emailaddress);
        EmailAddressTask.answer();
    }

    @When("^I try to enter more than (\\d+) characters \"([^\"]*)\" for email address$")
    public void iTryToEnterMoreThanCharactersForEmailAddress(int arg0, String emailaddress) throws Throwable {
        SharedState.put(StateKey.EMAIL,emailaddress);
        EmailAddressTask.answerAndNotContinue();
    }
}





package com.tescobank.judge.question;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Questions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class BeInformedJourneyQuestion {

    @Then("^I am asked my income$")
    public void I_am_asked_my_income() throws Throwable {
        Questions.getIncomeView().assertInView();
    }

    @Then("^I am asked if I want an overdraft$")
    public void I_am_asked_if_I_want_an_overdraft() throws Throwable {
        Questions.getOverdraftView().assertInView();
    }

    @Then("^I am asked if I accept doing a credit check$")
    public void I_am_asked_if_I_accept_doing_credit_check() throws Throwable {
        Questions.getGeneralBeInformedView().assertMessageAcceptCreditCheckVisible();
    }

    @Then("^I am asked if I want a cheque book$")
    public void I_am_asked_if_I_want_a_cheque_book() throws Throwable {
        Questions.getChequeBookView().assertInView();
    }

    @Then("^I am asked my country of birth and nationality$")
    public void I_am_asked_my_country_of_birth_and_nationality() throws Throwable {
        Questions.getCountryBirthNationalityView().assertInView();
    }

    @Then("^I am informed of how Tesco Bank loans work$")
    public void I_am_informed_of_how_Tesco_Bank_loans_work() throws Throwable {
        Questions.getGeneralBeInformedView().assertMessageHowLoansWorkVisible();
    }

    @Then("^I am asked my bank account details$")
    public void I_am_asked_my_bank_account_details() throws Throwable {
        Questions.getAccountDetailsView().assertInView();
    }

    @Then("^I am asked my mother's maiden name$")
    public void I_am_asked_my_moders_maiden_name() throws Throwable {
        Questions.getMotherMaidenNameView().assertInView();
    }

    @Then("^I am asked my document preferences$")
    public void I_am_asked_my_document_preferences() throws Throwable {
        Questions.getDocumentPreferencesView().assertInView();
    }

    @Then("^I am asked if I want to go paperless$")
    public void I_am_asked_if_I_want_to_go_paperless() throws Throwable {
        Questions.getPaperlessView().assertInView();
    }

    @Then("^I am presented the documentation to review$")
    public void I_am_asked_the_documentation_to_review() throws Throwable {
        Questions.getPCADocumentationSummaryView().assertInView();
    }

    @Then("^I am presented the Financial Services Compensation Scheme$")
    public void I_am_asked_the_FSCS() throws Throwable {
        Questions.getFSCSView().assertInView();
    }

    @Then("^I am presented the rates and fees for my current account$")
    public void I_am_presented_the_rates_and_fees_for_my_current_account() throws Throwable {
        Questions.getRatesFeesPCAView().assertInView();
    }

    @Then("^I am presented the pre-contract credit information$")
    public void I_am_presented_the_pre_contract_credit_information() throws Throwable {
        Questions.getPreContractPCAView().assertInView();
    }

    @Then("^I am presented the PCA agreement signature$")
    public void I_am_presented_the_PCA_agreement_signature() throws Throwable {
        Questions.getPCASignatureView().assertInView();
    }

    @Then("^I am presented a confirmation that the account is set up$")
    public void I_am_presented_a_confirmation_that_the_account_is_set_up() throws Throwable {
        Questions.getPCAAllDoneView().assertInView();
    }

    @Then("^I am back to PSP with an account ready to activate$")
    public void I_am_back_to_PSP_with_an_account_ready_to_activate() throws Throwable {
        Questions.getPspView().assertPCAisReadyToActivate();
    }

    @Then("^I am presented the documentation to review in loans: understanding loan, SECCI and digital signature$")
    public void I_am_presented_the_documentation_to_review_in_loans() throws Throwable {
        Questions.getLoanDocumentationSummaryView().assertInView();
        Questions.getLoanDocumentationSummaryView().assertUnderstandingLoanIsPresent();
        Questions.getLoanDocumentationSummaryView().assertSECCIIsPresent();
        Questions.getLoanDocumentationSummaryView().assertDigitalSignatureIsPresent();
    }

    @Then("^I am presented my loan credit agreement$")
    public void I_am_presented_my_loan_credit_agreement() throws Throwable {
        Questions.getLoanSignatureView().assertInView();
    }

    @Then("^I am presented a confirmation that the loan is set up$")
    public void I_am_presented_a_confirmation_that_the_loan_is_set_up() throws Throwable {
        Questions.getLoanAllDoneView().assertInView();
    }

    @Then("^I am back to PSP with a loan$")
    public void I_am_back_to_PSP_with_a_loan() throws Throwable {
        Questions.getPspView().assertLoanIsPresent();
    }

    @Then("^I am presented the documentation to review with no pre-contract credit information$")
    public void I_am_presented_the_documentation_to_review_with_no_overdraft_documents() throws Throwable {
        Questions.getPCADocumentationSummaryView().assertInView();
        Questions.getPCADocumentationSummaryView().assertNoPreContractDocument();
    }


    @Then("^I am taken to the page where I am asked to provide an email address at the appropriate point in the journey$")
    public void iAmTakenToThePageWhereIAmAskedToProvideAnEmailAddressAtTheAppropriatePointInTheJourney() throws Throwable {
        //Check whether the page contains textbox to enter the email address
        Questions.getEmailAddressView().assertInView();
    }


    @And("^I see the Understanding your loan information$")
    public void iSeeTheUnderstandingYourLoanInformation() throws Throwable {
        Questions.getUnderstandingLoanView().assertInView();
    }

}

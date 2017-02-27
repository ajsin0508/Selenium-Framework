package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class LoanSECCIQuestion {

    @Then("^I am presented the pre-contract credit information for loans$")
    public void I_am_presented_the_pre_contract_credit_information() throws Throwable {
        Questions.getPreContractLoanView().assertInView();
    }

    @And("^I see the parametrised values in SECCI for loan amount, duration, total to pay, repayments, APR and rate of interest$")
    public void I_see_the_parametrised_values_in_SECCI_for_loan_amount_duration_total_to_pay_repayments_APR_and_rate_of_interest() throws Throwable {
        Questions.getPreContractLoanView().assertLoanAmountParameter();
        Questions.getPreContractLoanView().assertDurationParameter();
        Questions.getPreContractLoanView().assertTotalAmountParameter();
        Questions.getPreContractLoanView().assertMonthlyRepaymentParameter();
        Questions.getPreContractLoanView().assertAPRParameter();
        Questions.getPreContractLoanView().assertAnnualInterestParameter();
    }

    @And("^I see an explanation for SECCI$")
    public void I_see_an_explanation_for_SECCI() throws Throwable {
        Questions.getPreContractLoanView().assertExplanationPresent();
    }

    @And("^I see a link to download a pdf copy of SECCI for my records$")
    public void I_see_a_link_to_download_a_pdf_copy_of_SECCI_for_my_records() throws Throwable {
        Questions.getPreContractLoanView().assertPdfLinkPresent();
    }
}

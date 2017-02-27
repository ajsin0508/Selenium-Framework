package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import com.tescobank.judge.tbcukesupport.judge.JudgeConfig;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class UnderstandingYourLoanQuestion {

    @Then("^I am presented a text for understanding my loan$")
    public void I_am_presented_a_text_for_understanding_my_loan() throws Throwable {
        Questions.getUnderstandingLoanView().assertInView();
    }

    @And("^I see the parametrised values for loan amount, total to pay, repayments, APR and rate of interest$")
    public void I_see_the_parametrised_values_for_amount_total_to_pay_repayments_APR_and_rate_of_interest() throws Throwable {
        Questions.getUnderstandingLoanView().assertLoanAmountParameter();
        Questions.getUnderstandingLoanView().assertTotalAmountParameter();
        Questions.getUnderstandingLoanView().assertMonthlyRepaymentParameter();
        Questions.getUnderstandingLoanView().assertAPRParameter();
        Questions.getUnderstandingLoanView().assertAnnualInterestParameter();
    }

    @And("^I see an explanation of why I need to understand my loan$")
    public void I_see_an_explanation_of_why_I_need_to_understand_my_loan() throws Throwable {
        Questions.getUnderstandingLoanView().assertExplanationPresent();
    }

    @And("^I see a link to download a pdf copy of understand my loan for my records$")
    public void I_see_a_link_to_download_a_pdf_copy_of_understand_my_loan_for_my_records() throws Throwable {
        Questions.getUnderstandingLoanView().assertPdfLinkPresent();
    }

    @Then("^I can check that the pdf name matches the convention for static PDF assets: \"([^\"]*)\"$")
    public void I_can_check_that_the_pdf_name_matches_the_convention_for_static_PDF_assets(String pdfName) throws Throwable {
        Questions.getUnderstandingLoanView().assertPdfMatchesName(pdfName);
    }

    @And("^the downloaded pdf from understanding your loan page has an easily recognisable \"([^\"]*)\"$")
    public void theDownloadedPdfFromUnderstandingYourLoanPageHasAnEasilyRecognisable(String pdfName) throws Throwable {
       Questions.getUnderstandingLoanView().assertPdfMatchesName(pdfName);
    }

    @And("^I see the size of the downloadable pdf in kb in understanding your loan page$")
    public void iSeeTheSizeOfTheDownloadablePdfInKbInUnderstandingYourLoanPage() throws Throwable {

    }
}

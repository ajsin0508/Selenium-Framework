package com.tescobank.judge.question;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Questions;
import com.tescobank.judge.task.BeInformedGeneralTask;
import com.tescobank.judge.task.PreparePDFTemplateTask;
import com.tescobank.judge.tbcukesupport.judge.JudgeConfig;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class PdfQuestion {

    @Then("^the understand your loan pdf is downloaded and opens in a separate window$")
    public void the_understand_your_loan_pdf_is_downloaded_and_opens_in_a_separate_window() throws Throwable {
        // Not implementing the separate window check, just downloading the file
        Questions.getPdfQuestion().assertCanDownload();
        Questions.getPdfQuestion().assertSeparateWindowCheck();
    }

    @And("^the content exactly matches the understanding your loan content on the screen$")
    public void the_content_exactly_matches_the_understanding_your_loan_content_on_the_screen() throws Throwable {
        Actions.getUnderstandingYourLoanAction().setPdfExpectationFromScreen();
        Questions.getPdfQuestion().assertContentMatches();
    }

    @Then("^the SECCI pdf is downloaded and opens in a separate window$")
    public void the_SECCI_pdf_is_downloaded_and_opens_in_a_separate_window() throws Throwable {
        // Not implementing the separate window check, just downloading the file
        Questions.getPdfQuestion().assertCanDownload();
    }

    @And("^the content exactly matches the SECCI content on the screen$")
    public void the_content_exactly_matches_the_SECCI_content_on_the_screen() throws Throwable {
        Actions.getLoanSECCIAction().setPdfExpectationFromScreen();
        Questions.getPdfQuestion().assertContentMatches();
    }

    @Then("^the fixed sum agreement pdf is downloaded and is requested to be opened in a separate window$")
    public void thePdfIsDownloadedAndIsRequestedToBeOpenedInASeparateWindow() throws Throwable {
        Questions.getPdfQuestion().assertCanDownload();
        Questions.getPdfQuestion().assertSeparateWindowCheck();
    }

    @Then("^the content matches exactly the fixed sum loan agreement content on the screen$")
    public void the_content_matches_exactly_the_fixed_sum_loan_agreement_content_on_the_screen() throws Throwable {
        Actions.getLoanSignatureAction().setPdfExpectationFromScreen();
        Questions.getPdfQuestion().assertContentMatches();
    }

    @And("^the content exactly matches the SECCI content as per template \"([^\"]*)\"$")
    public void theContentExactlyMatchesTheSECCIContentAsPerTemplate(String pdfTemplateName) throws Throwable {
        PreparePDFTemplateTask.getOrginalTemplate(pdfTemplateName);
        Questions.getPdfQuestion().assertContentMatches();
    }
}

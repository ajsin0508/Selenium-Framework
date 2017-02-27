package com.tescobank.judge.stepDefs;

import com.tescobank.judge.task.BeInformedGeneralTask;
import com.tescobank.judge.task.CheckOfferDetailsTask;
import com.tescobank.judge.task.GoToPspTask;
import com.tescobank.judge.task.IncomeTask;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class PspStepDefs {

    @When("^I get in the PSP page$")
    public void I_get_in_the_PSP_page() throws Throwable {
        GoToPspTask.beOrMoveToPsp();
    }

    @When("^I check the details of the loan offer$")
    public void I_check_the_details_of_the_loan_offer() throws Throwable {
        CheckOfferDetailsTask.viewLoanOfferDetails();
    }

    @When("^I check the details of the PCA offer$")
    public void I_check_the_details_of_the_PCA_offer() throws Throwable {
        CheckOfferDetailsTask.viewPcaOfferDetails();
    }

    @When("^I proceed with the PCA application$")
    public void I_proceed_with_the_PCA_application() throws Throwable {
        GoToPspTask.beOrMoveToPsp();
        CheckOfferDetailsTask.viewPcaOfferDetails();
        CheckOfferDetailsTask.proceedWithPcaOffer();
    }

    @When("^I proceed with the Loan application$")
    public void I_proceed_with_the_Loan_application() throws Throwable {
        GoToPspTask.beOrMoveToPsp();
        CheckOfferDetailsTask.viewLoanOfferDetails();
        CheckOfferDetailsTask.proceedWithLoanOffer();
    }

    @When("^I reject the loan offer$")
    public void I_reject_the_loan_offer() throws Throwable {
        CheckOfferDetailsTask.rejectLoanOffer();
    }

    @When("^I reject the PCA offer$")
    public void I_reject_the_PCA_offer() throws Throwable {
        CheckOfferDetailsTask.rejectPcaOffer();
    }

}





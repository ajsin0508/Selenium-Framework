package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import cucumber.api.java.en.Then;

public class PspQuestion {

    @Then("^I'm in PSP$")
    public void I_am_in_PSP() throws Throwable {
        Questions.getPspView().assertIsRendered();
    }

    @Then("^I see an offer for a loan$")
    public void I_see_an_offer_for_a_loan() throws Throwable {
        Questions.getPspView().assertLoanOfferIsVisible();
    }

    @Then("^I see an offer for PCA account$")
    public void I_see_an_offer_for_PCA_account() throws Throwable {
        Questions.getPspView().assertPCAOfferIsVisible();
    }

    @Then("^I see no offers$")
    public void I_see_no_offers() throws Throwable {
        Questions.getPspView().assertNoOfferIsVisible();
    }
}





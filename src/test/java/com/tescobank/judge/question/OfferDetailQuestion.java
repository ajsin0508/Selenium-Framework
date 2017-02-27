package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import com.tescobank.judge.task.CheckOfferDetailsTask;
import com.tescobank.judge.task.GoToPspTask;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OfferDetailQuestion {

    @Then("^I see the details of the loan and can customize the product$")
    public void I_see_the_details_of_the_loan_and_can_customize_the_product() throws Throwable {
        Questions.getLoanOfferDetailView().assertIsVisible();
    }

    @Then("^I see the details of the PCA$")
    public void I_see_the_details_of_the_PCA() throws Throwable {
        Questions.getPcaOfferDetailView().assertIsVisible();
    }
}





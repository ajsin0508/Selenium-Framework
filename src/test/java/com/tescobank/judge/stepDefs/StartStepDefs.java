package com.tescobank.judge.stepDefs;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Actor;
import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.targets.MobileNumberTarget;
import com.tescobank.judge.task.ResetOffersTask;
import com.tescobank.judge.task.StartBrowsingTask;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StartStepDefs {

    @Given("^I start as \"([^\"]*)\"")
    public void I_start_as_X(String userName) throws Throwable {
        Actor.startWith(userName);
        StartBrowsingTask.startUnauthenticated();
    }

    @Given("^I log in as \"([^\"]*)\"")
    public void I_log_in_as_X(String userName) throws Throwable {
        Actor.startWith(userName);
        ResetOffersTask.resetOffers();
        StartBrowsingTask.startAuthenticated();
    }

    @Given("^I start the Loan originating journey as \"([^\"]*)\"")
    public void I_start_the_loan_originating_journey_as_X(String userName) throws Throwable {
        Actor.startWith(userName);
        StartBrowsingTask.startLoanOriginatingJourneySkippingLogin();
    }


    @Given("^I start the Loan originating journey with parameters as \"([^\"]*)\"$")
    public void iStartTheLoanOriginatingJourneyWithParametersAs(String userName) throws Throwable {
        Actor.startWith(userName);
    }


    @But("^In this instance I am requesting \"([^\"]*)\",\"([^\"]*)\" for my loan$")
    public void inThisInstanceIAmRequestingForMyLoan(String TotCreditAmount, String TotCreditDuration) throws Throwable {
        SharedState.put(StateKey.LOAN_AMOUNT,TotCreditAmount);
        SharedState.put(StateKey.LOAN_TERM,TotCreditDuration);
    }

    @And("^I am requesting \"([^\"]*)\" and \"([^\"]*)\" for my loan$")
    public void iAmRequestingAndForMyLoan(String Repayment, String TotAmountToPay) throws Throwable {
        SharedState.put(StateKey.MONTHLY_REPAYMENT,Repayment);
        SharedState.put(StateKey.TOTAL_AMOUNT,TotAmountToPay);
    }

    @And("^the \"([^\"]*)\" and \"([^\"]*)\" for the loan$")
    public void theAndForTheLoan(String ROI, String APR) throws Throwable {
        SharedState.put(StateKey.ANNUAL_INTEREST,ROI);
        SharedState.put(StateKey.LOAN_APR,APR);
    }

    @And("^I proceed the Journey According to my Loan Details$")
    public void iProceedTheJourneyAccordingToMyLoanDetails() throws Throwable {
        StartBrowsingTask.startLoanOriginatingJourneySkippingLogin();
    }


    @But("^I wrote my name as \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and address as \"([^\"]*)\"$")
    public void iWroteMyNameAsAndAddressAs(String Title, String Name, String Surname, String Address) throws Throwable {
        SharedState.put(StateKey.TITLE,Title);
        SharedState.put(StateKey.FIRST_NAME,Name);
        SharedState.put(StateKey.SURNAME,Surname);
        SharedState.put(StateKey.ADDRESS,Address);
    }
}





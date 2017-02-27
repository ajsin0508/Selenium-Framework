package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.*;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class BrowseAction extends JudgeTescoBankInteractionBase {

    private static final String SLASH = "/";
    private static final String MOCK_SESSION_ID = "Yhs4BRFlkEn8kL0mbn-hxi7hQ-QwbVLD";

    public BrowseAction(WebDriver driver) {
        super(driver);
    }

    public void startUnauthenticated() {
        getDriver().get(getBaseUrl());
    }

    public void navigateToPsP() {
        getDriver().get(getBaseUrl());
    }

    // EXAMPLE: http://surface.cd.tbaws.com/apply/1111111111/LOAN/11417/Yhs4BRFlkEn8kL0mbn-hxi7hQ-QwbVLD?
    // loanAmount=30500&
    // loanTerm=5&
    // loanAPR=670&
    // repaymentAmount=599.63&
    // totalToPay=35977.73&
    // rateOfInterest=6.7000&
    // numberOfRepayments=60&
    // totalAmountOfInterestDue=1000
    public void startLoanOriginatingJourneySkippingLogin() {


        StringBuilder url = new StringBuilder("http://surface.cd.tbaws.com").append("/apply/")
       // StringBuilder url = new StringBuilder(getBaseUrl()).append("/apply/")
                .append(Actor.getString(TBID)).append(SLASH)
                .append("LOAN").append(SLASH)
                .append(Actor.getString(OFFERID)).append(SLASH)
                .append(MOCK_SESSION_ID).append("?")
                .append("loanAmount=").append(Actor.getString(LOAN_AMOUNT)).append("&")
                .append("loanTerm=").append(Actor.getString(LOAN_TERM)).append("&")
                .append("loanAPR=").append(Actor.getString(LOAN_APR)).append("&")
                .append("repaymentAmount=").append(Actor.getString(MONTHLY_REPAYMENT)).append("&")
                .append("totalToPay=").append(Actor.getString(TOTAL_AMOUNT)).append("&")
                .append("rateOfInterest=").append(Actor.getString(ANNUAL_INTEREST)).append("&")
                .append("numberOfRepayments=").append(Actor.getString(NUMBER_REPAYMENTS)).append("&")
                .append("totalAmountOfInterestDue=").append(Actor.getString(TOTAL_INTEREST));
        getDriver().get(url.toString());
    }
}

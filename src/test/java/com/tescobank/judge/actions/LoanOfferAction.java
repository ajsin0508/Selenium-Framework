package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.LoanOfferDetailsTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.LOAN_AMOUNT;
import static com.tescobank.judge.state.StateKey.LOAN_TERM;
import static com.tescobank.judge.targets.LoanOfferDetailsTarget.*;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class LoanOfferAction extends JudgeTescoBankInteractionBase {
    public LoanOfferAction(WebDriver driver) {
        super(driver);
    }

    public void proceedWithLoanOffer() {
        clickElement(ACCEPT_BUTTON);
    }

    public void rejectLoanOffer() {
        clickElement(REJECT_BUTTON);
    }

    public void setUpLoanParameters() {
        dragSliderWithTarget(LoanOfferDetailsTarget.AMOUNT_SLIDER, LoanOfferDetailsTarget.AMOUNT_SLIDER_OUTCOME, Integer.parseInt(Actor.getString(LOAN_AMOUNT)));
        dragSliderWithTarget(LoanOfferDetailsTarget.TERM_SLIDER, LoanOfferDetailsTarget.TERM_SLIDER_OUTCOME, Integer.parseInt(Actor.getString(LOAN_TERM)));
    }

}

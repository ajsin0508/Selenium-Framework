package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Questions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class CheckOfferDetailsTask {
    public static void viewLoanOfferDetails() {
        Actions.getPspAction().viewLoanOfferDetails();
    }

    public static void viewPcaOfferDetails() {
        Actions.getPspAction().viewPcaOfferDetails();
    }

    public static void proceedWithPcaOffer() {
        Actions.getPcaOfferAction().proceedWithPcaOffer();
    }

    public static void proceedWithLoanOffer() {
        Actions.getLoanOfferAction().setUpLoanParameters();
        Actions.getLoanOfferAction().proceedWithLoanOffer();
    }

    public static void rejectLoanOffer() {
        Actions.getLoanOfferAction().rejectLoanOffer();
    }

    public static void rejectPcaOffer() {
        Actions.getPcaOfferAction().rejectPcaOffer();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class LoanSignatureTask {

    public static void signAgreement() {
        Actions.getLoanSignatureAction().signAgreement();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class PCASignatureTask {

    public static void signAgreement() {
        Actions.getPCASignatureAction().signAgreement();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

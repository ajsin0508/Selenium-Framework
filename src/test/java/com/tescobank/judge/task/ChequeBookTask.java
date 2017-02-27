package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class ChequeBookTask {

    public static void answerChequeBook() {
        Actions.getChequeBookAction().makeSelection();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

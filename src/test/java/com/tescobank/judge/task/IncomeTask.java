package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class IncomeTask {

    public static void enterIncome() {
        Actions.getIncomeAction().enterIncome();
        Actions.getIncomeAction().enterAdditionalIncome();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

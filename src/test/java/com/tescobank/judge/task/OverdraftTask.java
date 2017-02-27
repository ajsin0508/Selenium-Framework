package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class OverdraftTask {

    public static void enterSomeOverdraft() {
        Actions.getOverdraftAction().enterValue();
        Actions.getBeInformedGeneralAction().clickNext();
    }

    public static void enterNoOverdraft() {
        Actions.getOverdraftAction().enterZero();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

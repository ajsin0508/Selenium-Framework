package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class PreferredPaymentDateTask {

    public static void enterPaymentDate() {
        Actions.getPreferredPaymentDateAction().enterPaymentDate();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class AccountDetailsTask {

    public static void enterAccountDetails() {
        Actions.getAccountDetailsAction().enterSortcode();
        Actions.getAccountDetailsAction().enterAccountNumber();
        Actions.getAccountDetailsAction().enterAccountName();
        Actions.getAccountDetailsAction().enterAccountOpenMonth();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

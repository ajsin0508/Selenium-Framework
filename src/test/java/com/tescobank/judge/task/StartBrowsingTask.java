package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class StartBrowsingTask {
    public static void startUnauthenticated() {
        Actions.getBrowseAction().startUnauthenticated();
    }

    public static void startAuthenticated() {
        Actions.getBrowseAction().startUnauthenticated();
        Actions.getLoginAction().enterUsername();
        Actions.getLoginAction().clickNext();
        Actions.getPasswordAction().enterSecurityNumber();
        Actions.getPasswordAction().enterPassword();
        Actions.getPasswordAction().clickNext();
    }

    public static void startLoanOriginatingJourneySkippingLogin() {
        Actions.getBrowseAction().startLoanOriginatingJourneySkippingLogin();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class EmailAddressTask {

    public static void answer() {
        Actions.getEmailAddressAction().enterEmail();
        Actions.getBeInformedGeneralAction().clickNext();
    }

    public static void tryInvalidEmail() {
        Actions.getEmailAddressAction().enterWrongEmail();
        Actions.getBeInformedGeneralAction().clickNext();
    }

    public static void answerAndNotContinue() {
        Actions.getEmailAddressAction().enterEmail();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class MobileNumberTask {

    public static void answer() {
        Actions.getMobileNumberAction().enterMobileNumber();
        Actions.getBeInformedGeneralAction().clickNext();
    }

    public static void tryInvalidMobileNumber() {
        Actions.getMobileNumberAction().enterWrongMobileNumber();
        Actions.getBeInformedGeneralAction().clickNext();
    }

    public static void trySpecialCharacter(){
        Actions.getMobileNumberAction().enterSpecialCharacter();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

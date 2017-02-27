package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class MotherMaidenNameTask {

    public static void answer() {
        Actions.getMotherMaidenNameAction().enterMaidenName();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

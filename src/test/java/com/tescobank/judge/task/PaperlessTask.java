package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class PaperlessTask {

    public static void answer() {
        Actions.getPaperlessAction().enterPaperlessChoice();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Questions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class GoToPspTask {
    public static void beOrMoveToPsp() {
        if (!Questions.getPspView().inPSP()) {
            Actions.getBrowseAction().navigateToPsP();
        }
    }
}

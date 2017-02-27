package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class BeInformedGeneralTask {

    public static void continueOnIntroScreen() {
        Actions.getBeInformedGeneralAction().continueOnIntroScreen();
    }

    public static void continueOnWaitingScreen() {
        Actions.getBeInformedGeneralAction().continueOnWaitingScreen();
    }

    public static void continueOnScreen() {
        Actions.getBeInformedGeneralAction().continueOnScreen();
    }

    public static void fetchPdfUrl(String linkName) {
        Actions.getPdfAction().getUrlFromLink(linkName);
    }
}


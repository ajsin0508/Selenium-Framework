package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;

/**
 * Created by pabloarroyo on 17/07/16.
 */
public class DocumentationPreferencesTask {

    public static void answer() {
        Actions.getDocumentationPreferencesAction().enterDocumentationPreferences();
        Actions.getBeInformedGeneralAction().clickNext();
    }
}

package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;

/**
 * Created by IR86 on 1/27/2017.
 */
public class PreparePDFTemplateTask  {
    public static void getOrginalTemplate(String templateName) throws Throwable{
        SharedState.put(StateKey.EXPECTED_PDF_CONTENT,Actions.gePreparePDFTemplateAction().getPdfTemplate(templateName));
    }
}

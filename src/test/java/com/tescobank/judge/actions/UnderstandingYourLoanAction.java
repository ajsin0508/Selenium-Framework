package com.tescobank.judge.actions;

import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.targets.UnderstandingLoanTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class UnderstandingYourLoanAction extends JudgeTescoBankInteractionBase {
    public UnderstandingYourLoanAction(WebDriver driver) {
        super(driver);
    }

    public void setPdfExpectationFromScreen() {
        String screenContents = getTextForElement(UnderstandingLoanTarget.DOCUMENT_WORDING);
        SharedState.put(StateKey.EXPECTED_PDF_CONTENT, screenContents);
    }
}

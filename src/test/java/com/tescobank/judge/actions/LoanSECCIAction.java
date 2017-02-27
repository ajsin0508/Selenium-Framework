package com.tescobank.judge.actions;

import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.targets.PreContractLoanTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class LoanSECCIAction extends JudgeTescoBankInteractionBase {
    public LoanSECCIAction(WebDriver driver) {
        super(driver);
    }

    public void setPdfExpectationFromScreen() {
        String screenContents = getTextForElement(PreContractLoanTarget.DOCUMENT_WORDING);
        SharedState.put(StateKey.EXPECTED_PDF_CONTENT, screenContents);
    }
}

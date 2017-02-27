package com.tescobank.judge.actions;

import com.tescobank.judge.targets.PCASignatureTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PCASignatureAction extends JudgeTescoBankInteractionBase {
    public PCASignatureAction(WebDriver driver) {
        super(driver);
    }

    public void signAgreement() {
        clickElement(PCASignatureTarget.PCA_SIGNATURE_BOX);
    }
}

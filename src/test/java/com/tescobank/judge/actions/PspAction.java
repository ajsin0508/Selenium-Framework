package com.tescobank.judge.actions;

import com.tescobank.judge.targets.PspTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PspAction extends JudgeTescoBankInteractionBase {
    public PspAction(WebDriver driver) {
        super(driver);
    }

    public void viewLoanOfferDetails() {
        clickElement(PspTarget.LOAN_OFFER_DETAIL_BUTTON);
    }

    public void viewPcaOfferDetails() {
        clickElement(PspTarget.PCA_OFFER_DETAIL_BUTTON);
    }
}

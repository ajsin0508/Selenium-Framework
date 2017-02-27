package com.tescobank.judge.actions;

import static com.tescobank.judge.targets.PcaOfferDetailsTarget.*;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PcaOfferAction extends JudgeTescoBankInteractionBase {
    public PcaOfferAction(WebDriver driver) {
        super(driver);
    }

    public void proceedWithPcaOffer() {
        clickElement(ACCEPT_BUTTON);
    }

    public void rejectPcaOffer() {
        clickElement(REJECT_BUTTON);
    }
}

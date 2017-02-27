package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.PcaOfferDetailsTarget.ACCEPT_BUTTON;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class PcaOfferDetailsView extends JudgeTescoBankInteractionBase {
    public PcaOfferDetailsView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(ACCEPT_BUTTON);
    }

    public void assertIsVisible() {
        assertTrue(isRendered());
    }
}
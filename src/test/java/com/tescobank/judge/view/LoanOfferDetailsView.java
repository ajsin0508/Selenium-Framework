package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.LoanOfferDetailsTarget.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class LoanOfferDetailsView extends JudgeTescoBankInteractionBase {
    public LoanOfferDetailsView(WebDriver driver) {
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
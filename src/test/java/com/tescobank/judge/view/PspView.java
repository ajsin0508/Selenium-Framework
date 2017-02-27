package com.tescobank.judge.view;

import static com.tescobank.judge.targets.PspTarget.*;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class PspView extends JudgeTescoBankInteractionBase {
    public PspView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public boolean inPSP() {
        return isRendered();
    }

    public void assertLoanOfferIsVisible() {
        assertTrue(isElementDisplayed(LOAN_OFFER_WRAPPER));
    }

    public void assertPCAOfferIsVisible() {
        assertTrue(isElementDisplayed(PCA_OFFER_WRAPPER));
    }

    public void assertNoOfferIsVisible() {
        assertFalse(isElementDisplayed(LOAN_OFFER_WRAPPER));
        assertFalse(isElementDisplayed(PCA_OFFER_WRAPPER));
    }

    public void assertPCAisReadyToActivate() {
        assertTrue(isElementDisplayed(PCA_CURRENT_ACCOUNT_PRODUCT));
        assertTrue(getPageSourceContent().contains("Ready to activate"));
    }

    public void assertLoanIsPresent() {
        assertTrue(isElementDisplayed(LOAN_PRODUCT));
        assertTrue(getPageSourceContent().contains("Your loan funds are on their way"));
    }

    public void assertIsRendered() {
        assertTrue(isRendered());
    }

}
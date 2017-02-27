package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.LoanDocumentationSummaryTarget.VIEW_IDENTIFIER;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class LoanDocumentationSummaryView extends JudgeTescoBankInteractionBase {
    public LoanDocumentationSummaryView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        waitForDocumentReady();
        assertTrue(isRendered());
    }

    public void assertUnderstandingLoanIsPresent() {
        assertTrue(getPageSourceContent().contains("Understanding your loan"));
    }

    public void assertSECCIIsPresent() {
        assertTrue(getPageSourceContent().contains("Pre-contract credit information"));
    }

    public void assertDigitalSignatureIsPresent() {
        assertTrue(getPageSourceContent().contains("Your credit agreement"));
    }
}
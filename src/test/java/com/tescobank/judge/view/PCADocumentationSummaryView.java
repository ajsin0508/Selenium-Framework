package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.PCADocumentationSummaryTarget.VIEW_IDENTIFIER;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class PCADocumentationSummaryView extends JudgeTescoBankInteractionBase {
    public PCADocumentationSummaryView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        assertTrue(isRendered());
    }

    public void assertNoPreContractDocument() {
        assertFalse(getPageSourceContent().contains("<li>Pre-contract credit information"));
    }
}
package com.tescobank.judge.view;

import static com.tescobank.judge.targets.BeInformedGeneralTarget.*;

import com.tescobank.judge.targets.BeInformedGeneralTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class GeneralBeInformedView extends JudgeTescoBankInteractionBase {
    public GeneralBeInformedView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertMessageAcceptCreditCheckVisible() {
        assertTrue(isRendered());
        assertTrue(getPageSourceContent().contains("We're about to work out your overdraft"));
    }

    public void assertMessageHowLoansWorkVisible() {
        assertTrue(isRendered());
        assertTrue(getPageSourceContent().contains("How do our loans work?"));
    }

    public void optionToContinueIsPresent() {
        assertTrue(isElementDisplayed(BeInformedGeneralTarget.NEXT_BUTTON));
    }
}
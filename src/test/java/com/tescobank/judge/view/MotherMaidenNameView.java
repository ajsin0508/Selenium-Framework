package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.MotherMaidenNameTarget.VIEW_IDENTIFIER;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class MotherMaidenNameView extends JudgeTescoBankInteractionBase {
    public MotherMaidenNameView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        assertTrue(isRendered());
    }
}
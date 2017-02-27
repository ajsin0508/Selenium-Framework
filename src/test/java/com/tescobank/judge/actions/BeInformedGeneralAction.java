package com.tescobank.judge.actions;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.BeInformedGeneralTarget.*;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class BeInformedGeneralAction extends JudgeTescoBankInteractionBase {
    public BeInformedGeneralAction(WebDriver driver) {
        super(driver);
    }

    public void continueOnScreen() {
        sleepFor(2000); // TODO fix when we know what to wait for
        waitForElementVisible(CONTINUE_EXTRA_STEP_BUTTON);
        clickElement(CONTINUE_EXTRA_STEP_BUTTON);
        sleepFor(2000); // TODO fix when we know what to wait for
    }

    public void continueOnIntroScreen() {
        waitForElementVisible(CONTINUE_EXTRA_STEP_BUTTON);
        clickElement(CONTINUE_EXTRA_STEP_BUTTON);
    }

    public void clickNext() {
        waitForElementVisible(NEXT_BUTTON);
        clickElement(NEXT_BUTTON);

    }

    public void continueOnWaitingScreen() {
        continueOnIntroScreen();
        sleepFor(2000); // TODO fix when we know what to wait for
    }


}

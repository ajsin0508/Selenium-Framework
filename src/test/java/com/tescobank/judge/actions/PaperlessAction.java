package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.PaperlessTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.GO_PAPERLESS;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PaperlessAction extends JudgeTescoBankInteractionBase {
    public PaperlessAction(WebDriver driver) {
        super(driver);
    }

    public void enterPaperlessChoice() {
        if (Actor.getString(GO_PAPERLESS).equalsIgnoreCase("no")) clickElement(PaperlessTarget.GO_PAPERLESS_SWITCH);
    }
}

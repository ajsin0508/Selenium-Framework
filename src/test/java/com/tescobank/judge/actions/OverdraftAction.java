package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.OverdraftTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.OVERDRAFT;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class OverdraftAction extends JudgeTescoBankInteractionBase {
    public OverdraftAction(WebDriver driver) {
        super(driver);
    }

    public void enterValue() {
        dragSliderWithTarget(OverdraftTarget.OVERDRAFT_SLIDER, OverdraftTarget.OVERDRAFT_OUTPUT, Integer.parseInt(Actor.getString(OVERDRAFT)));
    }

    public void enterZero() {
        dragSliderWithTarget(OverdraftTarget.OVERDRAFT_SLIDER, OverdraftTarget.OVERDRAFT_OUTPUT, 0);
    }
}

package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.MotherMaidenNameTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.MAIDEN_NAME;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class MotherMaidenNameAction extends JudgeTescoBankInteractionBase {
    public MotherMaidenNameAction(WebDriver driver) {
        super(driver);
    }

    public void enterMaidenName() {
        enterValueForInputElement(MotherMaidenNameTarget.MAIDEN_NAME_FIELD, Actor.getString(MAIDEN_NAME));
    }
}

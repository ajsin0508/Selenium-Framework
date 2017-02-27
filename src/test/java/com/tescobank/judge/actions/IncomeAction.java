package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.IncomeTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.*;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class IncomeAction extends JudgeTescoBankInteractionBase {
    public IncomeAction(WebDriver driver) {
        super(driver);
    }

    public void enterIncome() {
        enterValueForInputElement(IncomeTarget.INCOME_FIELD, Actor.getString(INCOME));
    }

    public void enterAdditionalIncome() {
        enterValueForInputElement(IncomeTarget.ADDITIONAL_INCOME_FIELD, Actor.getString(ADDITIONAL_INCOME));
    }
}

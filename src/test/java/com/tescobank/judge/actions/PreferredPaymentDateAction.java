package com.tescobank.judge.actions;

import com.tescobank.judge.targets.PreferredPaymentDateTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PreferredPaymentDateAction extends JudgeTescoBankInteractionBase {
    public PreferredPaymentDateAction(WebDriver driver) {
        super(driver);
    }

    public void enterPaymentDate() {
        clickElement(PreferredPaymentDateTarget.DATE_18);
    }
}

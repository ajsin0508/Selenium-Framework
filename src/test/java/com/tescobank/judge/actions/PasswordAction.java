package com.tescobank.judge.actions;

import static com.tescobank.judge.state.StateKey.*;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.PasswordTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PasswordAction extends JudgeTescoBankInteractionBase {
    public PasswordAction(WebDriver driver) {
        super(driver);
    }

    public void enterSecurityNumber() {
        enterValueForInputElement(PasswordTarget.SECURITY_NUMBER_FIELD_3, Actor.getString(SECURITY_NUMBER_3));
        enterValueForInputElement(PasswordTarget.SECURITY_NUMBER_FIELD_4, Actor.getString(SECURITY_NUMBER_4));
    }

    public void enterPassword() {
        enterValueForInputElement(PasswordTarget.PASSWORD_FIELD, Actor.getString(PASSWORD));
    }

    public void clickNext() {
        clickElement(PasswordTarget.NEXT_BUTTON);
    }
}

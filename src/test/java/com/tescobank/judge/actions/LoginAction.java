package com.tescobank.judge.actions;

import static com.tescobank.judge.state.StateKey.*;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.LoginTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class LoginAction extends JudgeTescoBankInteractionBase {
    public LoginAction(WebDriver driver) {
        super(driver);
    }

    public void enterUsername() {
        enterValueForInputElement(LoginTarget.USERNAME_FIELD, Actor.getString(USERNAME));
    }

    public void clickNext() {
        clickElement(LoginTarget.NEXT_BUTTON);
    }
}

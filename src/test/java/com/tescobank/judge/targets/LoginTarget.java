package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

/**
 * Created by pabloarroyo on 21/07/16.
 */

public enum LoginTarget implements ByAccessor {

    USERNAME_FIELD(id("login-uid")),
    NEXT_BUTTON(id("login-uid-submit-button"));

    private By elementIdentifier;

    LoginTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


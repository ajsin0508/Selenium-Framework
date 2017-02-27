package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

/**
 * Created by pabloarroyo on 21/07/16.
 */

public enum PasswordTarget implements ByAccessor {

    SECURITY_NUMBER_FIELD_1(id("DIGIT1")),
    SECURITY_NUMBER_FIELD_2(id("DIGIT2")),
    SECURITY_NUMBER_FIELD_3(id("DIGIT3")),
    SECURITY_NUMBER_FIELD_4(id("DIGIT4")),
    SECURITY_NUMBER_FIELD_5(id("DIGIT5")),
    SECURITY_NUMBER_FIELD_6(id("DIGIT6")),
    PASSWORD_FIELD(id("PASSWORD")),
    NEXT_BUTTON(id("NEXTBUTTON"));

    private By elementIdentifier;

    PasswordTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


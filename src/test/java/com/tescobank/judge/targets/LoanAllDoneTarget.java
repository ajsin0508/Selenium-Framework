package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public enum LoanAllDoneTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("ApplicationCompletedForm"));

    private By elementIdentifier;

    LoanAllDoneTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


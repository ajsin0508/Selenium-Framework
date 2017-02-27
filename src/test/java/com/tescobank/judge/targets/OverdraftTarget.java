package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.cssSelector;

public enum OverdraftTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("OverdraftCustomisationForm")),
    OVERDRAFT_SLIDER(cssSelector(".rc-slider")),
    OVERDRAFT_OUTPUT(cssSelector(".overdraft-slider__output"));

    private By elementIdentifier;

    OverdraftTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


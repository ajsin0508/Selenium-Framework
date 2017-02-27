package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public enum MotherMaidenNameTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("MaidenName")),
    MAIDEN_NAME_FIELD(id("motherMaidenName"));

    private By elementIdentifier;

    MotherMaidenNameTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


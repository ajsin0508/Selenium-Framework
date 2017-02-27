package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum PaperlessTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("CustomisePCAProduct")),
    GO_PAPERLESS_SWITCH(xpath("//label[@for='PaperlessPreferences-0' and contains(@class,'checkbox__label')]"));

    private By elementIdentifier;

    PaperlessTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


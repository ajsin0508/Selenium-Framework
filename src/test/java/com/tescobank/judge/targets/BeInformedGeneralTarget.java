package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum BeInformedGeneralTarget implements ByAccessor {

    VIEW_IDENTIFIER(xpath("//section[@class='step']")),
    CONTINUE_EXTRA_STEP_BUTTON(xpath("//button")),
    NEXT_BUTTON(xpath("//button[@class='button button--primary ']"));

    private By elementIdentifier;

    BeInformedGeneralTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


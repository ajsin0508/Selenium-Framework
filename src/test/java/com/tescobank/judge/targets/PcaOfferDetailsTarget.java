package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public enum PcaOfferDetailsTarget implements ByAccessor {

    ACCEPT_BUTTON(xpath("//button[contains(.,'Go for it')]")),
    REJECT_BUTTON(xpath("//button[contains(.,'not interested')]"));

    private By elementIdentifier;

    PcaOfferDetailsTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


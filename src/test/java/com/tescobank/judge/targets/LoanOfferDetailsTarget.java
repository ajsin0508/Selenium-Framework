package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum LoanOfferDetailsTarget implements ByAccessor {

    ACCEPT_BUTTON(xpath("//button[contains(.,'Go for it')]")),
    REJECT_BUTTON(xpath("//button[contains(.,'not interested')]")),
    AMOUNT_SLIDER(id("offer-amount")),
    TERM_SLIDER(id("offer-term")),
    AMOUNT_SLIDER_OUTCOME(xpath("//output[contains(., '£')]")),
    TERM_SLIDER_OUTCOME(xpath("//output[contains(., 'year')]"));

    private By elementIdentifier;

    LoanOfferDetailsTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


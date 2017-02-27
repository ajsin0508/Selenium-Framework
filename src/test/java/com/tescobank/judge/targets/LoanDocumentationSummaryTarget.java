package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public enum LoanDocumentationSummaryTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("LoanPre_Agreement"));

    private By elementIdentifier;

    LoanDocumentationSummaryTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}

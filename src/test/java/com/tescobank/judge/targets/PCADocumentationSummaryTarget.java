package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public enum PCADocumentationSummaryTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("TCRelatedFormsPCAForm"));

    private By elementIdentifier;

    PCADocumentationSummaryTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


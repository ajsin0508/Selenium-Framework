package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum PCASignatureTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("PCASignatureForm")),
    PCA_SIGNATURE_BOX(xpath("//label[@for='PCASignature-0' and contains(@class,'checkbox__label')]"));

    private By elementIdentifier;

    PCASignatureTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


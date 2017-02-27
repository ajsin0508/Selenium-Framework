package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public enum PreContractPCATarget implements ByAccessor {

    VIEW_IDENTIFIER(id("CurrentAccountECCIForm"));

    private By elementIdentifier;

    PreContractPCATarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum PreContractLoanTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("LoanSECCIForm")),
    PDF_LINK(xpath("//a[@class='download-doc ' and contains(.,'tescobank-loan-secci-v1.pdf')]")),
    DOCUMENT_WORDING(xpath("//div[@class='field__control']"));

    private By elementIdentifier;

    PreContractLoanTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


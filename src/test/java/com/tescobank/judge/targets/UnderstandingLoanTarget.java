package com.tescobank.judge.targets;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.state.StateKey;
import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum UnderstandingLoanTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("UnderstandingYourLoanForm")),
    PDF_LINK(xpath("//a[@class='download-doc ' and contains(.,'tescobank-loan-understanding-your-loan-v1.pdf')]")),
   // PDF_LINK(xpath("//a[@download='tescobank-loan-understanding-your-loan-v1.pdf']")),
    DOCUMENT_WORDING(xpath("//div[@class='field__control']"));

    private By elementIdentifier;

    UnderstandingLoanTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


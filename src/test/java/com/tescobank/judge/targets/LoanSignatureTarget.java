package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.xpath;

public enum LoanSignatureTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("FixSumLoanAgreementForm")),
    LOAN_SIGNATURE_BOX(xpath("//label[@for='FixSumLoanAgreement-0' and contains(@class,'checkbox__label')]")),
    PDF_LINK(xpath("//a[@class='download-doc ' and contains(.,'tescobank-loan-fixed-sum-loan-agreement-v1.pdf')]")),
    DOCUMENT_WORDING(xpath("//div[@class='field__control']")),
    ERROR_MSG(xpath("//span[@class='error-message']")),
    ACCOUNT_NUMBER_DETAILS(xpath("(//div[@class='summary-box'])[1]"));

    private By elementIdentifier;

    LoanSignatureTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


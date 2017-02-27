package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.By.id;

public enum ChequeBookTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("ChequeBookForm")),
    NO_THANKS_OPTION(xpath("//label[@for='ChequeBookCustomisation-0' and contains(@class,'radio__label')]")),
    CHEQUE_BOOK_OPTION(xpath("//label[@for='ChequeBookCustomisation-1' and contains(@class,'radio__label')]")),
    PAY_IN_BOOK_OPTION(xpath("//label[@for='ChequeBookCustomisation-2' and contains(@class,'radio__label')]"));

    private By elementIdentifier;

    ChequeBookTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


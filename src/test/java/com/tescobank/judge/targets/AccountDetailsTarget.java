package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.By.id;

public enum AccountDetailsTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("CustomiseLoanProduct")),
    SORT_CODE(id("SortCode")), 
    ACCOUNT_NUMBER(id("AccountNo")), 
    BANK_STATEMENT_NAME(id("NameAsItAppearsOnStatement")),
    OPEN_ACCOUNT_YEAR(xpath("//div[@class='monthpicker__year field__control']//select")),
    OPEN_ACCOUNT_MONTH(xpath("//div[@class='monthpicker__month field__control ']//select"));

    private By elementIdentifier;

    AccountDetailsTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


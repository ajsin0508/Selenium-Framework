package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum PspTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("sv-banking-title")),
    LOAN_OFFER_WRAPPER(xpath("//div[@class='panel offer-panel' and contains(.,'loan')]")),
    PCA_OFFER_WRAPPER(xpath("//div[@class='detail-content' and contains(.,'conditionally approved for a Tesco Bank Current Account with overdraft')]")),
    LOAN_OFFER_DETAIL_BUTTON(xpath("//a[@class='btn primary-btn' and contains(.,'Find out more')]")),
    PCA_OFFER_DETAIL_BUTTON(xpath("//a[@class='btn primary-btn' and contains(.,'Find out more')]")),
    PCA_CURRENT_ACCOUNT_PRODUCT(id("personal-current-account-1")),
    LOAN_PRODUCT(id("sv-personal-loan-product"));

    private By elementIdentifier;

    PspTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


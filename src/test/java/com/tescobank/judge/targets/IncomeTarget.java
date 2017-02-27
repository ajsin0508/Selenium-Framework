package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.id;

public enum IncomeTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("ProvideIncomeInformation")),
    INCOME_FIELD(id("TakeHomePay")),
    ADDITIONAL_INCOME_FIELD(id("AdditionalIncome")); // TODO FIX

    private By elementIdentifier;

    IncomeTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


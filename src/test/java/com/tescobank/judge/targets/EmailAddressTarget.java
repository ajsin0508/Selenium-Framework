package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum EmailAddressTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("ProvideEmailAddressForm")),
    EMAIL_FIELD(id("emailAddress")),
    VALID_EMAIL_ADDRESS_REQUIRED(xpath("//label[@for='emailAddress']//span[contains(text(),'Please enter a valid email address')]")),
    EMAIL_REQUIRED_ERROR(xpath("//label[@for='emailAddress' and contains(.,'This field is required')]"));


    private By elementIdentifier;

    EmailAddressTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }

}


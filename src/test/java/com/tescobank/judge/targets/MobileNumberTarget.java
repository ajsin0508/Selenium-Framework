package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static com.tescobank.tests.tbcukesupport.Hooks.driver;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum MobileNumberTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("ProvideMobileNumberForm")),
    MOBILE_NUMBER_FIELD(id("mobileTelephoneNumber")),
    MOBILE_NUMBER_ERROR(xpath("//span[@class='error-message'and contains(.,'Please enter your mobile number')]"));

    private By elementIdentifier;

    MobileNumberTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }



}


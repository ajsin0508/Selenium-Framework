package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;

public enum CountryBirthNationalityTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("CountryNationalityForm")),
    COUNTRY_OF_BIRTH_FIELD(id("countryOfBirth")),
    NATIONALITY_FIELD(id("nationality"));

    private By elementIdentifier;

    CountryBirthNationalityTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


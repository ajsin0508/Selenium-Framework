package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum DocumentationPreferencesTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("DocumentationPreferences")),
    NO_THANKS_OPTION(xpath("//label[@for='DocumentationPreferences-0' and contains(@class,'radio__label')]")),
    LARGE_PRINT_OPTION(xpath("//label[@for='DocumentationPreferences-1' and contains(@class,'radio__label')]")),
    BRAILLE_OPTION(xpath("//label[@for='DocumentationPreferences-2' and contains(@class,'radio__label')]")),
    AUDIO_OPTION(xpath("//label[@for='DocumentationPreferences-2' and contains(@class,'radio__label')]"));

    private By elementIdentifier;

    DocumentationPreferencesTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


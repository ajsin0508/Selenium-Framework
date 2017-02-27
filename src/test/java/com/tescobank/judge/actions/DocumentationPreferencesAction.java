package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.DocumentationPreferencesTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.DOCUMENTATION_PREFERENCE;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class DocumentationPreferencesAction extends JudgeTescoBankInteractionBase {
    public DocumentationPreferencesAction(WebDriver driver) {
        super(driver);
    }

    public void enterDocumentationPreferences() {
        if (Actor.getString(DOCUMENTATION_PREFERENCE).equalsIgnoreCase("no")) clickElement(DocumentationPreferencesTarget.NO_THANKS_OPTION);
        else if (Actor.getString(DOCUMENTATION_PREFERENCE).equalsIgnoreCase("largeprint")) clickElement(DocumentationPreferencesTarget.LARGE_PRINT_OPTION);
        else if (Actor.getString(DOCUMENTATION_PREFERENCE).equalsIgnoreCase("braille")) clickElement(DocumentationPreferencesTarget.BRAILLE_OPTION);
        else if (Actor.getString(DOCUMENTATION_PREFERENCE).equalsIgnoreCase("audio")) clickElement(DocumentationPreferencesTarget.AUDIO_OPTION);
    }
}

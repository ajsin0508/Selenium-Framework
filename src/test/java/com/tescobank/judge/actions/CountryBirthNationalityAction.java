package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.CountryBirthNationalityTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.COUNTRY_OF_BIRTH;
import static com.tescobank.judge.state.StateKey.NATIONALITY;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class CountryBirthNationalityAction extends JudgeTescoBankInteractionBase {
    public CountryBirthNationalityAction(WebDriver driver) {
        super(driver);
    }

    public void enterCountryOfBirth() {
        selectEntryInDropdown(CountryBirthNationalityTarget.COUNTRY_OF_BIRTH_FIELD, Actor.getString(COUNTRY_OF_BIRTH));
    }

    public void enterNationality() {
        selectEntryInDropdown(CountryBirthNationalityTarget.NATIONALITY_FIELD, Actor.getString(NATIONALITY));
    }
}

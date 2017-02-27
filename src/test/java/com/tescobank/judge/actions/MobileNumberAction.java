package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Actor;
import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.targets.MobileNumberTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tescobank.judge.state.StateKey.MOBILE_NUMBER;
import static org.hamcrest.core.Is.is;


/**
 * Created by pabloarroyo on 21/07/16.
 */
public class MobileNumberAction extends JudgeTescoBankInteractionBase {
    private Pattern pattern;
    private Matcher matcher;
    private static final String MOBILENO_VALIDATION = "^07\\d{9}$";

    public MobileNumberAction(WebDriver driver) {
        super(driver);
    }

    public void enterMobileNumber() {

        enterValueForInputElement(MobileNumberTarget.MOBILE_NUMBER_FIELD, Actor.getString(MOBILE_NUMBER));
    }

    public void MobilenumberValidation(String mobileno) {
        pattern = Pattern.compile(MOBILENO_VALIDATION);
        matcher = pattern.matcher(mobileno);
        if (Actor.getString(StateKey.ID).equalsIgnoreCase("CUSTOMER_WITH_LOAN_OFFER_WITH_REUSABLE_MOBILE")) {
            Assert.assertThat("Mobile Number not valid: " + mobileno, matcher.matches(), is(true));
        } else if (Actor.getString(StateKey.ID).equalsIgnoreCase("CUSTOMER_WITH_LOAN_OFFER_WITH_NON_REUSABLE_MOBILE")) {
            Assert.assertThat("Mobile Number not valid: " + mobileno, matcher.matches(), is(false));
        } else {
            Assert.assertThat("Mobile Number not valid: " + mobileno, matcher.matches(), is(true));
        }
    }

    public void enterWrongMobileNumber() {
        enterValueForInputElement(MobileNumberTarget.MOBILE_NUMBER_FIELD, "errormobile");
    }

    public void enterSpecialCharacter() {
        enterValueForInputElement(MobileNumberTarget.MOBILE_NUMBER_FIELD, "@#$%!^&*()+");
    }

    public void ClearMobileNumber() throws Throwable {
        enterValueForInputElementNotLosingFocus(MobileNumberTarget.MOBILE_NUMBER_FIELD, "");
    }

}

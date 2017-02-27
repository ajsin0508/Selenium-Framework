package com.tescobank.judge.question;

import com.tescobank.judge.actions.MobileNumberAction;
import com.tescobank.judge.state.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class MobileNumberQuestion {

    @And("^I am asked my mobile number|I am still asked my mobile number$")
    public void I_am_asked_my_mobile_number() throws Throwable {
        Questions.getMobileNumberView().assertInView();
    }

    @Then("^I see an error message for the mobile number$")
    public void I_see_an_error_message_for_the_mobile_number() throws Throwable {
        Questions.getMobileNumberView().errorForMobileNumberRequiredIsPresent();

    }
    
    @Then("^I see error message for minimum (\\d+) digits required$")
    public void iSeeErrorMessageForMinimumDigits(int arg0) throws Throwable {
        Questions.getMobileNumberView().errorForMobileNumberRequiredIsPresent();
    }

    @Then("^I see error message for maximum (\\d+) digits allowed$")
    public void iSeeErrorMessageForMaximumDigitsAllowed(int arg0) throws Throwable {
        Questions.getMobileNumberView().errorForMobileNumberRequiredIsPresent();
    }

    @Then("^I see the error message$")
    public void i_see_the_error_message() throws Throwable {
        Questions.getMobileNumberView().errorForMobileNumberRequiredIsPresent();
    }

    @Then("^I see I'm unable to enter more than (\\d+) digits$")
    public void iSeeIMUnableToEnterMoreThanDigits(int arg0) throws Throwable {
       Questions.getMobileNumberView().tryToEntermoreThan11Digits();
    }
}

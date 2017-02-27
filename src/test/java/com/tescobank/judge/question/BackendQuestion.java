package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import com.tescobank.judge.tbcukesupport.judge.JudgeConfig;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class BackendQuestion {

    @And("^the valid email address is retained, updates source then TCV$")
    public void the_valid_email_address_is_retained_updates_source_then_TCV() throws Throwable {
        Thread.sleep(10000);
        if (JudgeConfig.testBackEnd()) {
            throw new PendingException();
        }
    }

    @Then("^The mobile number is retained for use in my application$")
    public void The_mobile_number_is_retained_for_use_in_my_application() throws Throwable {
        if (JudgeConfig.testBackEnd()) {
            throw new PendingException();
        }
    }
}

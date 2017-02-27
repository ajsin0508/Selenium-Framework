package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class GeneralServiceQuestion {

    @Then("^I will see the service is running$")
    public void I_will_see_the_service_is_running() throws Throwable {
        Questions.getLoginView().assertIsRunning();
    }
}

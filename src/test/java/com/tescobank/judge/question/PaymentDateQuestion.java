package com.tescobank.judge.question;

import com.tescobank.judge.state.Questions;
import com.tescobank.judge.tbcukesupport.judge.JudgeConfig;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class PaymentDateQuestion {

    @Then("^I am asked my preferred payment date$")
    public void I_am_asked_my_preferred_payment_date() throws Throwable {
        Questions.getPreferredPaymentDateView().assertInView();
    }

    @Then("^I am presented with a choice of days from the 1st to the 28th$")
    public void I_am_presented_with_a_choice_of_days_from_the_1st_to_the_28th() throws Throwable {
        Questions.getPreferredPaymentDateView().choiceIsFrom1to28();
    }

    @And("^the choice is set to the 1st as a default$")
    public void the_choice_is_set_to_the_1st_as_a_default() throws Throwable {
        Questions.getPreferredPaymentDateView().choiceIs1sfByDefault();
    }

    @And("^I can select one and only one date$")
    public void I_can_select_one_and_only_one_date() throws Throwable {
        Questions.getPreferredPaymentDateView().canOnlySelectOneDate();
    }

    @And("^I see an explanation of what I'm being asked to do$")
    public void I_see_an_explanation_of_what_I_m_being_asked_to_do() throws Throwable {
        Questions.getPreferredPaymentDateView().explanationIsPresent();
    }

    @Then("^that repayment date is persisted for use in my application$")
    public void that_repayment_date_is_persisted_for_use_in_my_application() throws Throwable {
        if (JudgeConfig.testBackEnd()) {
            Questions.getBeInformedDataView().selectedRepaymentDateMatchesUserSelection();
        }
    }

    @Then("^the default date is persisted for use in my application$")
    public void the_default_date_is_persisted_for_use_in_my_application() throws Throwable {
        if (JudgeConfig.testBackEnd()) {
            Questions.getBeInformedDataView().selectedRepaymentDateMatchesDefaultDate();
        }
    }

    @Then("^I have the right accessibility to enter my preferred payment date$")
    public void I_have_the_right_accessibility_to_enter_my_preferred_payment_date() throws Throwable {
        Questions.getPreferredPaymentDateView().assertIsProperlyAccessible();
    }
}

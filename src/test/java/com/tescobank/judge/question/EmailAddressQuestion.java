package com.tescobank.judge.question;

import com.tescobank.judge.state.Actions;
import com.tescobank.judge.state.Actor;
import com.tescobank.judge.state.Questions;
import com.tescobank.judge.state.StateKey;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by pabloarroyo on 09/07/16.
 */
public class EmailAddressQuestion {

    @Then("^I am asked my email|I am still asked my email$")
    public void I_am_asked_my_email() throws Throwable {
        Questions.getEmailAddressView().assertInView();
    }

    @Then("^I see an error message for the email address$")
    public void I_see_an_error_message_for_the_email_address() throws Throwable {
        Questions.getEmailAddressView().errorForEmailRequiredIsPresent();
    }

    @And("^I see the question about email address with a blank input box$")
    public void iSeeTheQuestionAboutEmailAddressWithABlankInputBox() throws Throwable {
        Questions.getEmailAddressView().isEmailTextBoxBlank();
    }

    @Then("^The bank is able to re-use that email address$")
    public void theBankIsAbleToReUseThatEmailAddress() throws Throwable {
        // Email Address is valid, reuse the same and proceed to next page
        /*
        Boolean flag = Actions.getEmailAddressAction().emailAddressValidation(Actor.getString(StateKey.EMAIL));
        if(flag){
            //Valid Email Address, Reuse the same and proceed

        }
        else {
            //Get new email address from customer and update the same in DB/Excel
        }
         */

    }

    @And("^I am not asked to provide an email address$")
    public void iAmNotAskedToProvideAnEmailAddress() throws Throwable {
        //Check Email Address page
    }

    @Then("^Email Address is non-reusable$")
    public void emailAddressIsNonReusable() throws Throwable {
        //Email Address is non reusable
        //TO DO need to write the logic based on boolean received
        boolean flag;
        flag = Actions.getEmailAddressAction().emailAddressValidation(Actor.getString(StateKey.EMAIL));
    }

    @Then("^my new email address is updated in the database$")
    public void myNewEmailAddressIsUpdatedInTheDatabase() throws Throwable {
        //Update the new email address entered in the database or Excel
    }

    @Then("^I see a message explaining the error$")
    public void iSeeAMessageExplainingTheError() throws Throwable {
        Questions.getEmailAddressView().errorForEmailRequiredIsPresent();
    }

    @And("^I am unable to progress to the next stage of the journey$")
    public void iAmUnableToProgressToTheNextStageOfTheJourney() throws Throwable {
       Questions.getEmailAddressView().isRendered();
    }

    @Then("^I see an error message for the valid email address required$")
    public void iSeeAnErrorMessageForTheValidEmailAddressRequired() throws Throwable {
     Questions.getEmailAddressView().errorForValidEmailRequiredIsPresent();
    }

    @Then("^my input of the character are truncated and I am able to see only (\\d+) characters being entered in the email field$")
    public void myInputOfTheCharacterAreTruncatedAndIAmAbleToSeeOnlyCharactersBeingEnteredInTheEmailField(int arg0) throws Throwable {
        Questions.getEmailAddressView().checkWhetherEmailAddressIsTruncated();
    }
}

package com.tescobank.judge.view;

import com.tescobank.judge.targets.EmailAddressTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.core.Is.is;


import static com.tescobank.judge.targets.EmailAddressTarget.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class EmailAddressView extends JudgeTescoBankInteractionBase {
    public EmailAddressView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        assertTrue(isRendered());
    }


    public void errorForEmailRequiredIsPresent() {
        assertTrue(isElementDisplayed(EMAIL_REQUIRED_ERROR));
    }

    public  void errorForValidEmailRequiredIsPresent(){
        assertTrue(isElementDisplayed(VALID_EMAIL_ADDRESS_REQUIRED));
    }

    public void isEmailTextBoxBlank() {
        Assert.assertThat("Email text box is not empty",getValueForInputElement(EMAIL_FIELD),is(""));

    }

    public void checkWhetherEmailAddressIsTruncated(){

        String max=findWebElementById("emailAddress").getAttribute("maxlength");
        String EnteredEmailAddress=findWebElementById("emailAddress").getAttribute("value");
        Assert.assertTrue("The Email field doesn't have a limit of 75 characters",max.contains("75"));
        Assert.assertThat("Entered email is not truncated to 75 characters",EnteredEmailAddress.length(),is(75));
    }
}
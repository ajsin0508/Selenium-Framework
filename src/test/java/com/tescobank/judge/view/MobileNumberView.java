package com.tescobank.judge.view;

import com.tescobank.judge.state.Questions;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.MobileNumberTarget.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class MobileNumberView extends JudgeTescoBankInteractionBase {
    public MobileNumberView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        assertTrue(isRendered());
    }

    public void errorForMobileNumberRequiredIsPresent() {
        assertTrue(isElementDisplayed(MOBILE_NUMBER_ERROR));
    }
    public void tryToEntermoreThan11Digits()throws Throwable{
        String max=findWebElementById("mobileTelephoneNumber").getAttribute("maxlength");
        String EnteredMobileNumber=findWebElementById("mobileTelephoneNumber").getAttribute("value");
        Assert.assertTrue("The Mobile number field doesn't have a limit of 11 digits",max.contains("11"));
        Assert.assertThat("Entered Number is not restricted to 11 digits",EnteredMobileNumber.length(),is(11));
    }
}
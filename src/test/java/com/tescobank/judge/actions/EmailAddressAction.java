package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tescobank.judge.state.StateKey.EMAIL;
import static com.tescobank.judge.targets.EmailAddressTarget.EMAIL_FIELD;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class EmailAddressAction extends JudgeTescoBankInteractionBase {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailAddressAction(WebDriver driver) {
        super(driver);
    }

    public void enterEmail() {
        enterValueForInputElement(EMAIL_FIELD, Actor.getString(EMAIL));
    }

    public void enterWrongEmail() {
        enterValueForInputElement(EMAIL_FIELD, "erroremail");
    }


    public boolean emailAddressValidation(String emailAddres){
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(emailAddres);
      //  Assert.assertThat("Email address not valid: "+ emailAddres,matcher.matches(),is(true));
        return matcher.matches();
    }
}
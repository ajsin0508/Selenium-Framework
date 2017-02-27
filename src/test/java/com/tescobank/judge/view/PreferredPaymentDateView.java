package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.PreferredPaymentDateTarget.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class PreferredPaymentDateView extends JudgeTescoBankInteractionBase {
    public PreferredPaymentDateView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        assertTrue(isRendered());
    }

    public void choiceIsFrom1to28() {
        for (int date=1; date<=28; date++) {
            assertTrue(dateChoiceIsPresent(date));
        }
    }

    private boolean dateChoiceIsPresent(int date) {
        return isXPathDisplayed(DATE_XPATH.replace("XX", "" + date));
    }

    public void choiceIs1sfByDefault() {
        assertTrue(isRadioButtonSelectedById(DATE1_INPUT_ID));
    }

    public void canOnlySelectOneDate() {
        assertTrue(isRadioButtonSelectedById(DATE1_INPUT_ID));
        assertFalse(isRadioButtonSelectedById(DATE18_INPUT_ID));
        setFocus(DATE_18);
        assertTrue(isRadioButtonSelectedById(DATE18_INPUT_ID));
        assertFalse(isRadioButtonSelectedById(DATE1_INPUT_ID));
    }

    public void explanationIsPresent() {
        assertTrue(getPageSourceContent().contains("What day of the month is good for your repayments?"));
    }

    public void assertIsProperlyAccessible() {
        setFocus(DATE_1);
        for (int date=1; date<=28; date++) {
            assertTrue(isRadioButtonSelectedById("repaymentDate-" + date));
            arrowRightToNextElement();
        }
    }

}
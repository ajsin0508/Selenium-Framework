package com.tescobank.judge.targets;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public enum PreferredPaymentDateTarget implements ByAccessor {

    VIEW_IDENTIFIER(id("FirstPaymentDateForm")),
    DATE_1(xpath(PreferredPaymentDateTarget.DATE_XPATH.replace("XX", "1"))),
    DATE_18(xpath(PreferredPaymentDateTarget.DATE_XPATH.replace("XX", "18")));

    public static final String DATE_XPATH = "//div[@id='FirstPaymentDateForm']/section/section[2]/div/section/div/div/div/div[XX]/label";
    public static final String DATE1_INPUT_ID = "repaymentDate-1";
    public static final String DATE18_INPUT_ID = "repaymentDate-18";

    private By elementIdentifier;

    PreferredPaymentDateTarget(By elementIdentifier) {
        this.elementIdentifier = elementIdentifier;
    }

    public By getIdentifier() {
        return elementIdentifier;
    }
}


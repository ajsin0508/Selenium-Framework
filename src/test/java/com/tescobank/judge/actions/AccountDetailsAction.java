package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.AccountDetailsTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.SORTCODE;
import static com.tescobank.judge.state.StateKey.ACCOUNT_NUMBER;
import static com.tescobank.judge.state.StateKey.BANK_STATEMENT_NAME;
import static com.tescobank.judge.state.StateKey.OPEN_ACCOUNT_YEAR;
import static com.tescobank.judge.state.StateKey.OPEN_ACCOUNT_MONTH;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class AccountDetailsAction extends JudgeTescoBankInteractionBase {
    public AccountDetailsAction(WebDriver driver) {
        super(driver);
    }

    public void enterSortcode() {
        enterValueForInputElement(AccountDetailsTarget.SORT_CODE, Actor.getString(SORTCODE));
    }

    public void enterAccountNumber() {
        enterValueForInputElement(AccountDetailsTarget.ACCOUNT_NUMBER, Actor.getString(ACCOUNT_NUMBER));
    }

    public void enterAccountName() {
        enterValueForInputElement(AccountDetailsTarget.BANK_STATEMENT_NAME, Actor.getString(BANK_STATEMENT_NAME));
    }

    public void enterAccountOpenMonth() {
        selectEntryInDropdown(AccountDetailsTarget.OPEN_ACCOUNT_YEAR, Actor.getString(OPEN_ACCOUNT_YEAR));
        selectEntryInDropdown(AccountDetailsTarget.OPEN_ACCOUNT_MONTH, Actor.getString(OPEN_ACCOUNT_MONTH));
    }
}

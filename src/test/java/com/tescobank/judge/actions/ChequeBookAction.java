package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.ChequeBookTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.CHEQUE_BOOK;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class ChequeBookAction extends JudgeTescoBankInteractionBase {
    public ChequeBookAction(WebDriver driver) {
        super(driver);
    }

    public void makeSelection() {
        if (Actor.getString(CHEQUE_BOOK).equalsIgnoreCase("no")) clickElement(ChequeBookTarget.NO_THANKS_OPTION);
        else if (Actor.getString(CHEQUE_BOOK).equalsIgnoreCase("cheque")) clickElement(ChequeBookTarget.CHEQUE_BOOK_OPTION);
        else if (Actor.getString(CHEQUE_BOOK).equalsIgnoreCase("payin")) clickElement(ChequeBookTarget.PAY_IN_BOOK_OPTION);
    }
}

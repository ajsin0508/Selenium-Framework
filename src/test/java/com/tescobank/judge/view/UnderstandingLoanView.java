package com.tescobank.judge.view;

import com.tescobank.judge.question.QuestionUtil;
import com.tescobank.judge.state.Actor;
import com.tescobank.judge.targets.LoanSignatureTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.UnderstandingLoanTarget.*;
import static com.tescobank.judge.state.StateKey.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class UnderstandingLoanView extends JudgeTescoBankInteractionBase {
    public UnderstandingLoanView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }

    public void assertInView() {
        assertTrue(isRendered());
    }

    public void assertLoanAmountParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("The total amount you have borrowed: " + QuestionUtil.formatCurrency((String) Actor.get(LOAN_AMOUNT))));
    }

    public void assertTotalAmountParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("The total amount you have agreed to pay back: " + QuestionUtil.formatCurrency((String) Actor.get(TOTAL_AMOUNT))));
    }

    public void assertMonthlyRepaymentParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("Monthly Repayment: " + QuestionUtil.formatCurrency((String) Actor.get(MONTHLY_REPAYMENT))));
    }

    public void assertAPRParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("The interest rates: Your APR is " + Actor.get(LOAN_APR)));
    }

    public void assertAnnualInterestParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("and interest rate of " + Actor.get(ANNUAL_INTEREST)));
    }

    public void assertExplanationPresent() {
        assertTrue(getPageSourceContent().contains("It's important you think about whether this loan is the right option for you. To help you do this, you should think about the following questions."));
    }

    public void assertPdfLinkPresent() {
       // assertTrue(getPageSourceContent().contains("Download a copy"));
        assertTrue(isElementDisplayed(PDF_LINK));
    }

    public void assertPdfMatchesName(String pdfName) {
        waitForDocumentReady();
        String xPath = "//a[@class='download-doc ' and contains(.,'" + pdfName + "')]";
        assertTrue(isElementPresentByXpath(xPath));
    }

    public void assertPdfSize(){

    }

}
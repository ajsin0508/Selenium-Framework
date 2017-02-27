package com.tescobank.judge.view;

import com.tescobank.judge.question.QuestionUtil;
import com.tescobank.judge.state.Actor;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.*;
import static com.tescobank.judge.state.StateKey.ANNUAL_INTEREST;
import static com.tescobank.judge.targets.PreContractLoanTarget.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class PreContractLoanView extends JudgeTescoBankInteractionBase {
    public PreContractLoanView(WebDriver driver) {
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
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("This means the amount of credit to be provided under the proposedcredit agreement or the credit limit " + QuestionUtil.formatCurrency((String) Actor.get(LOAN_AMOUNT))));
    }

    public void assertDurationParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("The duration of the credit agreement. " + Actor.get(LOAN_TERM) + " months"));
    }

    public void assertRepaymentsParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("Repayments  " + Actor.get(LOAN_TERM)));
    }

    public void assertTotalAmountParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("This means the amount you have borrowed plus interest and other costs. " + QuestionUtil.formatCurrency((String) Actor.get(TOTAL_AMOUNT))));
    }

    public void assertMonthlyRepaymentParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("monthly repayments of " + QuestionUtil.formatCurrency((String) Actor.get(MONTHLY_REPAYMENT))));
    }

    public void assertAPRParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("The APR is there to help you compare different offers. " + Actor.get(LOAN_APR)));
    }

    public void assertAnnualInterestParameter() {
        assertTrue(getTextForElement(DOCUMENT_WORDING).contains("Fixed rate of " + Actor.get(ANNUAL_INTEREST) + "% per annum (Nominal)"));
    }

    public void assertExplanationPresent() {
        assertTrue(getPageSourceContent().contains("(Standard European Consumer Credit Information)"));
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
}
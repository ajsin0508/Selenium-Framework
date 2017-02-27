package com.tescobank.judge.actions;

import com.tescobank.judge.state.Actor;
import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.targets.LoanSignatureTarget;
import com.tescobank.judge.targets.MobileNumberTarget;
import com.tescobank.judge.targets.PreContractLoanTarget;
import com.tescobank.judge.targets.UnderstandingLoanTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.state.StateKey.LAST_PDF_URL;
import static com.tescobank.judge.state.StateKey.MOBILE_NUMBER;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 21/07/16.
 */
public class PdfAction extends JudgeTescoBankInteractionBase {
    public PdfAction(WebDriver driver) {
        super(driver);
    }

    public void getUrlFromLink(String linkName) {
        waitForDocumentReady();
        String xPath = "//a[@class='download-doc ' and contains(.,'" + linkName + "')]";
        assertTrue(isElementPresentByXpath(xPath));
        String href = findWebElementByXPath(xPath).getAttribute("href");
        assertTrue(href.startsWith("http"));
        SharedState.put(StateKey.LAST_PDF_URL, href);
    }

    public void clickOnPDF(String linkName){

         if(linkName.contains("tescobank-loan-understanding-your-loan")){
             clickElement(UnderstandingLoanTarget.PDF_LINK);
    }
         else if(linkName.contains("tescobank-loan-secci")){
             clickElement(PreContractLoanTarget.PDF_LINK);
    }
         else if(linkName.contains("tescobank-loan-fixed-sum-loan-agreement")){
             clickElement(LoanSignatureTarget.PDF_LINK);
    }
    }
}

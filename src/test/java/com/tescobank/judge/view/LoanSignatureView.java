package com.tescobank.judge.view;

import com.tescobank.judge.targets.LoanSignatureTarget;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static com.tescobank.judge.targets.LoanSignatureTarget.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class LoanSignatureView extends JudgeTescoBankInteractionBase {
    public LoanSignatureView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return isElementDisplayed(VIEW_IDENTIFIER);
    }



    public void assertInView() {
        assertTrue(isRendered());
    }

    public void assertPdfLinkPresent() {
       // assertTrue(getPageSourceContent().contains("Download a copy"));
        assertTrue(isElementDisplayed(PDF_LINK));
    }

    public void errorMsgRequiredIsPresent() {
        assertTrue(isElementDisplayed(ERROR_MSG));
    }

    public void accountDetailsIsPresent(){
        assertTrue(isElementDisplayed(ACCOUNT_NUMBER_DETAILS));
    }

    public void assertDownloadedPDFName(){
        assertTrue("The Downloaded PDF Name is not Correct", getTextForElement(LoanSignatureTarget.PDF_LINK).contains("fixed-sum-loan-agreement"));
    }

    public void assertPdfMatchesName(String pdfName) {
        waitForDocumentReady();
        String xPath = "//a[@class='download-doc ' and contains(.,'" + pdfName + "')]";
        assertTrue(isElementPresentByXpath(xPath));
    }


}
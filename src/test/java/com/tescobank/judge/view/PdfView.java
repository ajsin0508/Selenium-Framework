package com.tescobank.judge.view;

import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import com.tescobank.judge.tbcukesupport.PDFUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by pabloarroyo on 13/07/16.
 */
public class PdfView extends JudgeTescoBankInteractionBase {
    public PdfView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return true;
    }

    public void assertCanDownload() {
        String pdfUrl = (String) SharedState.get(StateKey.LAST_PDF_URL);
        PDFUtil.loadPdf(pdfUrl);
    }

    public void assertContentMatches() {
        String expectedPdfContent = (String) SharedState.get(StateKey.EXPECTED_PDF_CONTENT);
        PDFUtil.assertPdfContains(expectedPdfContent);
    }
    public void assertSeparateWindowCheck(){
        PDFUtil.separateWindowCheck();
    }
}
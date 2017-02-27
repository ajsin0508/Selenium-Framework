package com.tescobank.judge.tbcukesupport;

import com.tescobank.judge.state.SharedState;
import com.tescobank.judge.state.StateKey;
import cucumber.api.java.gl.E;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import static com.tescobank.tests.tbcukesupport.Hooks.driver;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by pabloarroyo on 23/11/2016.
 */
public class PDFUtil {

    public static void loadPdf(String pdfLink) {
        try {
            String response = getPdfContent(pdfLink);
            SharedState.put(StateKey.PDF_CONTENT, response);
        } catch (Throwable t) {
            fail(t.getMessage());
        }
    }

    private static String getPdfContent(String url) throws Throwable {
        System.setProperty("http.proxyHost","192.168.29.200");
        System.setProperty("http.proxyPort","80");
        BufferedInputStream file = new BufferedInputStream(new URL(url).openStream());
        PDDocument pdDoc = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();

        String parsedText = pdfStripper.getText(pdDoc);
        if (pdDoc != null) pdDoc.close();

        return parsedText;
    }

    public static void assertPdfContains(String string) {
        String pdfContent = (String) SharedState.get(StateKey.PDF_CONTENT);
        String UpdatedPdfContent=pdfContent.replaceAll("\r\n","");
        assertTrue("pdf does not contain '" + string + "'", UpdatedPdfContent.contains(string));
    }

    public static void separateWindowCheck(){

        String parentWindowHandlerP= driver.getWindowHandle();
        String SecondwindowHandle=parentWindowHandlerP;
        Set <String> myWindowHandle = driver.getWindowHandles();
        for (String winHandle : myWindowHandle){
            if (!winHandle.equals(parentWindowHandlerP)) {
                SecondwindowHandle=winHandle;
            }
        }
        assertTrue("PDF Did not Open in a new Tab",!parentWindowHandlerP.equalsIgnoreCase(SecondwindowHandle));
            }
}

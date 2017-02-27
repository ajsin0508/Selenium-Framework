package com.tescobank.judge.task;

import com.tescobank.judge.state.Actions;
import org.openqa.selenium.WebDriver;
/**
 * Created by er63 on 12/22/2016.
 */
public class PdfTasks {
    public static void clickOnPDF(String linkname){
     Actions.getPdfAction().clickOnPDF(linkname);

    }


}


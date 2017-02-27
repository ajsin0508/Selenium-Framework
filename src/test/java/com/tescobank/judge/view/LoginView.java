package com.tescobank.judge.view;

import com.tescobank.judge.tbcukesupport.JudgeTescoBankInteractionBase;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by pabloarroyo on 03/08/16.
 */
public class LoginView extends JudgeTescoBankInteractionBase {
    public LoginView(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isRendered() {
        return getPageSourceContent().contains("Welcome to Online Banking");
    }

    public void assertIsRunning() {
        assertTrue(isRendered());
    }
}

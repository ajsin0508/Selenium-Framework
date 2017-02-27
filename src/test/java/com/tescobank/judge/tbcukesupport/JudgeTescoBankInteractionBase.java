package com.tescobank.judge.tbcukesupport;

import com.tescobank.tests.tbcukesupport.ByAccessor;
import com.tescobank.tests.tbcukesupport.TescoBankPageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class JudgeTescoBankInteractionBase extends TescoBankPageBase {
    private static final int STEP_WIDTH = 25;
    private static final int MAX_STEPS = 20;
    private static final int LEFT_TOPMOST = -1*STEP_WIDTH*(MAX_STEPS/2);

    public JudgeTescoBankInteractionBase(WebDriver driver) {
        super(driver);
    }

    protected void dragSlider(ByAccessor byAccesor, int steps) {
        WebElement slider = driver.findElement(byAccesor.getIdentifier());
        Actions drag = new Actions(driver);
        drag.dragAndDropBy(slider, STEP_WIDTH*steps, 0).build().perform();
    }

    protected void dragSliderWithTarget(ByAccessor byAccesor, ByAccessor reader, int target) {
        WebElement slider = driver.findElement(byAccesor.getIdentifier());
        Actions drag = new Actions(driver);
        int steps = 0;
        do {
            drag.dragAndDropBy(slider, LEFT_TOPMOST + steps * STEP_WIDTH, 0).build().perform();
            steps++;
        } while (getCurrentValue(reader) < target && steps < MAX_STEPS);
    }

    private int getCurrentValue(ByAccessor reader) {
        return Integer.parseInt(getTextForElement(reader).replaceAll("[ .,£a-zA-Z]", ""));
    }

    protected boolean isRadioButtonSelectedById(String id) {
        Object returned = ((JavascriptExecutor)driver).executeScript("return document.getElementById('" + id + "').checked");
        return (Boolean)returned;
    }

    protected void tabToNextElement() {
        driver.findElement(By.tagName("html")).sendKeys(Keys.TAB);
    }

    protected void arrowRightToNextElement() {
        driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_RIGHT);
    }

    protected void setFocus(ByAccessor byAccesor) {
        WebElement element = driver.findElement(byAccesor.getIdentifier());
        Actions move = new Actions(driver);
        move.click(element).perform();
    }
}

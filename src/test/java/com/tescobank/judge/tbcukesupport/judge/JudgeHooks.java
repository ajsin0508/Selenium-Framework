package com.tescobank.judge.tbcukesupport.judge;

import com.tescobank.judge.state.Actor;
import cucumber.api.java.Before;

/* Controls the cleaning of pages and state (resetting singletons per scenario) */
public class JudgeHooks {

    @Before
    public void setUp() throws Throwable {
        Actor.reset();
    }

}
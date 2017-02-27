package com.tescobank.judge;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import org.junit.Ignore;
import org.junit.runner.RunWith;

//@Ignore
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:build/test-report", "json:build/test-report.json", "junit:build/test-report.xml" },
					features = {"src/test/features"},
					glue = {"com.tescobank.beinformed.acceptance.cucumber",
                            "com.tescobank.tests.tbcukesupport"},
					tags = "@KTB-513")
public class CucumberTestRunner {

}

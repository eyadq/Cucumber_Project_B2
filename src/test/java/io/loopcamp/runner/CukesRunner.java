package io.loopcamp.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Locale;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {  "html:target/html-reports/cucumber-report.html",
                    "json:target/json-reports/json-report.json",
                    "rerun:target/rerun.txt",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/features",
        glue = "io/loopcamp/step_definitions",
        dryRun = false,
        tags = "@day20",
        //tags = "@googleSearchOutline",
        monochrome = false,
        publish = false
)

public class CukesRunner {
}
package org.example.Runner.AIR;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/Complementary_Invoice.html",
                "json:target/cucumber-reports/Complementary_Invoice.json"},
        features = {"src/test/resources/Features/AIR/Complementary_Invoice.feature"},
        publish = true,
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)

public class Complementary_InvoiceTestRunner extends AbstractTestNGCucumberTests {
}

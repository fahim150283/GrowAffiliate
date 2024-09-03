package org.example.Runner.AIR;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/GoodsRequisition.html",
                "json:target/cucumber-reports/GoodsRequisition.json"},
        features = {"src/test/resources/Features/AIR/GoodsRequisition.feature"},
        publish = true,
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)
public class GoodsRequisitionTestRunner extends AbstractTestNGCucumberTests {
}

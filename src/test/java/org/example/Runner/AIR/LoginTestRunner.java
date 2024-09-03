package org.example.Runner.AIR;


import io.cucumber.java.en.Given;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.Page_Options;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports-html/Login.html",
                "json:target/cucumber-reports/Login.json"},
        features = {"src/test/resources/Features/AIR/Login.feature"},
        publish = true,
        glue = {"org.example.StepDefinitions"}
//        ,tags = "@regression" //it runs all the scenarios of the feature file that contains @regression
//        ,tags = "@google"  //it runs all the scenarios of the feature file that contains @google
//        ,tags = " @practice"  //it runs all the scenarios of the feature file that contains @google
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {

}
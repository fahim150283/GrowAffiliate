package org.example.StepDefinitions.Initial;

import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.testng.asserts.SoftAssert;

public class Signup extends Page_Options {
    SoftAssert softAssert = new SoftAssert();
    @Given("Navigate to HomePage")
    public void navigate_to_home_page() throws InterruptedException {
        System.out.println(Signup.url);
        navigatetourl(Signup.url);
        closedriver();
        softAssert.assertAll();
    }

}
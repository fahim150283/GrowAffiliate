package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Signup extends Page_Options {
    SoftAssert softAssert = new SoftAssert();


    @Given("zoro")
    public void zoro() throws InterruptedException {


        System.out.println("this is expected");
        System.out.println(Signup.url);
        navigatetourl(Signup.url);
        softAssert.assertAll();
        closedriver();
    }

    @Given("Navigate to GrowAffiliate signup page")
    public void navigate_to_grow_affiliate_signup_page() throws InterruptedException {
        navigatetourl(Signup.url);

        //click the getting started button
        xpath = "/html/body/header/div[1]/div/div/div[3]/div/ul/li[2]/a";
        clickbyxpath(xpath);


    }


}
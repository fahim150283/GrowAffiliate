package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;


public class Dashboard extends Page_Options {

    @Given("^login for accessing dashboard$")
    public void dashboard() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
    }

    @When("^click the Dashboard$")
    public void clickDashboard() throws InterruptedException {
        Click_from_leftSideBar("Dashboard");
        switchTab();
        scrollToTheBottom();
    }

    @Then("^Close Driver for dashboard$")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
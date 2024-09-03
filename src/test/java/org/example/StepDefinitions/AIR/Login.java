package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class Login extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    @Given("Navigate to AIR")
    public void navigate_to_air() {
        navigatetourl(Users.AIR_2);
    }

    @When("Input the credentials\\(invalid username and invalid password)")
    public void input_the_credentials_invalid_username_and_invalid_password() {
        id = "username";
        inputbyid(id, "invalid");
        id = "password";
        inputbyid(id, "password");
        id = "login";
        clickbyId(id);
    }

    @When("verify if the login is unsuccessful")
    public void verify_if_the_login_is_unsuccessful() throws InterruptedException {
        try {
            System.out.println("The expected page title is: AIR - Login" + " and the actual page title is: " + driver.getTitle());
            softAssert.assertEquals(driver.getTitle(), "AIR - Login");
            closedriver();
            softAssert.assertAll();
        } catch (TimeoutException | InterruptedException | AssertionError e) {
            throw e;
        }
    }

    @When("Input the credentials\\(invalid username and valid password)")
    public void inputTheCredentialsInvalidUsernameAndValidPassword() {
        id = "username";
        inputbyid(id, "invalid");
        id = "password";
        inputbyid(id, Users.password);
        id = "login";
        clickbyId(id);
    }

    @When("Input the credentials\\(valid username and invalid password)")
    public void inputTheCredentialsValidUsernameAndInvalidPassword() {
        id = "username";
        inputbyid(id, Users.user_Haseeb);
        id = "password";
        inputbyid(id, "password");
        id = "login";
        clickbyId(id);
    }

    @When("Input the credentials\\(valid username and valid password)")
    public void inputTheCredentialsValidUsernameAndValidPassword() {
        id = "username";
        inputbyid(id, Users.user_Haseeb);
        id = "password";
        inputbyid(id, Users.password);
        id = "login";
        clickbyId(id);
    }

    @When("verify if the login is successful")
    public void verify_if_the_login_is_successful() throws InterruptedException {
        try {
            System.out.println("The expected page title is: AIR - Contacts" + " and the actual page title is: " + driver.getTitle());
            PrintPageTitle();
            Thread.sleep(1000);
            softAssert.assertEquals(driver.getTitle(), "AIR - Contacts");
            closedriver();
            softAssert.assertAll();
        } catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }
}

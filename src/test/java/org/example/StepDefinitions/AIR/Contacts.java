package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Contacts extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    @Given("^login for accessing Contacts$")
    public void contacts() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Contacts");
    }

    @When("search for employee")
    public void search_for_employee() throws InterruptedException {
        try{
        id = "search";
        waitById(id);
        Thread.sleep(2000);
        inputbyid(id,ContactsSearchInfo);
        }catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("verify if the the employee is searched or not")
    public void verifyIfTheTheEmployeeIsSearchedOrNot() throws InterruptedException {
            Boolean isNameFound = false;
            Thread.sleep(100);

            // Find the parent element containing all the employee details
            WebElement wrapper = driver.findElement(By.id("wrapper"));
            int i = 0;

            // Find all the visible boxes
            java.util.List<WebElement> boxes = wrapper.findElements(By.xpath(".//div"));

            // Iterate through each visible box
            for (WebElement box : boxes) {
                // Find the <p> element with class 'name' inside each box
                WebElement nameElement = null;
                try {
                    if (!box.getAttribute("style").contains("display: none;")) {
                        // Find and click the "Add App Permissions" button for the visible row
                        nameElement = box.findElement(By.xpath(".//p"));
                        // Get the text of the <p> element
                        String name = nameElement.getText();
                        // Check if the name contains the desired string
                        if (name.contains(ContactsSearchInfo)) {
                            isNameFound = true;
                            break; // Exit the loop if the name is found
                        }
                    }
                } catch (NoSuchElementException e) {
                    // If the name element is not found in the current box, continue to the next box
                    continue;
                }
            }

            // Assert if the name is found
            softAssert.assertTrue(isNameFound, "Employee name '" + ContactsSearchInfo + "' not found");
            closedriver();
            softAssert.assertAll();
    }
}

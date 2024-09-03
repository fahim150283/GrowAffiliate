package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

public class Apps extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    public static String AppName = Apps.Name;
    public static String Editedname = Apps.EditedName + randomnumber();
    public static String EditedDisplayname = Apps.EditedDisplayName + randomnumber();

    /*
    create a new app
    */
    @Given("login for creating new app")
    public void login_for_creating_new_app() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Apps");
    }

    @When("create new  app")
    public void create_new_app() throws InterruptedException {
        try {
            Thread.sleep(500);
            //click the create new button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            Thread.sleep(500);
            //fillup name
            id = "add_name";
            waitById(id);
            inputbyid(id, AppName);
            System.out.println(AppName);

            //fillup Display name
            id = "add_d_name";
            waitById(id);
            inputbyid(id, Apps.DisplayName);

            //functions
            Thread.sleep(500);
            xpath = "//*[@id=\"add_apps_form\"]/div/div[3]/div/span/span[1]/span";
            waitByxpath(xpath);
            for (int i = 0; i < 7; i++) {
                waitByxpath(xpath);
                pressDownbyXpath(xpath);
                pressEnterbyXpath(xpath);
            }
            clickbyxpath(xpath);

            //status
            xpath = "//*[@id=\"add_status\"]";
            String status = getTextAttributebyXpath(xpath);
            Boolean isAppActive = Apps.AppActive;
            if (isAppActive == true) {
                if (Objects.equals(status, "In Active")) {
                    clickbyxpath(xpath);
                    pressUPbyXpath(xpath);
                    pressEnterbyXpath(xpath);
                }
            } else if (isAppActive == false) {
                if (Objects.equals(status, "Active")) {
                    clickbyxpath(xpath);
                    pressDownbyid(xpath);
                    pressEnterbyXpath(xpath);
                }
            }

            //click the save button
            xpath = "//*[@id=\"add_apps_form\"]/div/div[5]/div/button";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("verify that the app is created and listed in the apps list")
    public void verifyThatTheAppIsCreatedAndListedInTheAppsList() throws InterruptedException {

        Thread.sleep(3000);
        id = "search_input";
        inputbyid(id, AppName);

        Thread.sleep(200);
        // verify the created product
        WebElement table = driver.findElement(By.id("apps_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                softAssert.assertEquals(AppName, row.findElement(By.xpath(".//td[2]")).getText());
            }
        }

        closedriver();
        softAssert.assertAll();
    }


    /*
    editing an app
    */
    @Given("login for editing an app")
    public void login_for_editing_an_app() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Apps");
    }

    @When("search for the app")
    public void search_for_the_app() throws InterruptedException {
        Thread.sleep(500);
        id = "search_input";
        waitById(id);
        inputbyid(id, Apps.Name);
    }

    @And("edit the app")
    public void editTheApp() throws InterruptedException {
        try {
            Thread.sleep(3000);

            // click the edit button of the displayed app
            WebElement table = driver.findElement(By.id("apps_tableData"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    WebElement editButton = row.findElement(By.id("btn_edit"));
                    editButton.click();
                    break;
                }
            }

            Thread.sleep(3000);


            //edit name
            xpath = "//*[@id=\"edit_apps_form\"]/div[1]/div[1]/div[1]/input";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, Editedname);

            //edit display name
            xpath = "//*[@id=\"edit_apps_form\"]/div[1]/div[1]/div[2]/input";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, EditedDisplayname);

            //status
            xpath = "//*[@id=\"edit_status\"]";
            String status = getTextAttributebyXpath(xpath);
            Boolean isAppActive = Apps.AppActive;
            if (isAppActive == true) {
                if (Objects.equals(status, "In Active")) {
                    clickbyxpath(xpath);
                    pressUPbyXpath(xpath);
                    pressEnterbyXpath(xpath);
                }
            } else if (isAppActive == false) {
                if (Objects.equals(status, "Active")) {
                    clickbyxpath(xpath);
                    pressDownbyid(xpath);
                    pressEnterbyXpath(xpath);
                }
            }


            //save
            id = "edit_apps";
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("verify that the app is edited")
    public void verify_that_the_app_is_edited() throws InterruptedException {

        Thread.sleep(3000);
        id = "search_input";
        inputbyid(id, Editedname);

        Thread.sleep(200);
        // verify the created product
        WebElement table = driver.findElement(By.id("apps_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                softAssert.assertEquals(Editedname, row.findElement(By.xpath(".//td[2]")).getText());
            }
        }

        closedriver();
        softAssert.assertAll();
    }


    /*
    Give permission to a user for an App
    */
    @Given("login for giving access to an user")
    public void login_for_giving_access_to_an_user() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Apps");
    }

    @When("search for the app to give access")
    public void search_for_the_app_to_give_access() throws InterruptedException {
        try {
            Thread.sleep(1000);
            id = "search_input";
            waitById(id);
            inputbyid(id, AppName);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }


    @And("add permission")
    public void add_permission() throws InterruptedException {

        Thread.sleep(1000);

        // click the edit button of the displayed app
        WebElement table = driver.findElement(By.id("apps_tableData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement addButton = row.findElement(By.id("btn_add_emp"));
                addButton.click();
                break;
            }
        }

        //info about employee table
        WebElement emptable = driver.findElement(By.id("include_emp_func_tbody"));
        java.util.List<WebElement> rows1 = emptable.findElements(By.xpath(".//tr"));

        for (int i = 0; i < Apps.EmployeeInfo.length; i++) {
            Thread.sleep(100);
            //click the employees field
            xpath = "//*[@id=\"select2-add_emp_list_" + (i + 1) + "-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for user
            Thread.sleep(100);
            xpath = "//*[@id=\"modal_emp\"]/span/span/span[1]/input";
            clickbyxpath(xpath);
            waitByxpath(xpath);
            inputbyxpath(xpath, Apps.EmployeeInfo[i]);
            Thread.sleep(100);
            pressEnterbyXpath(xpath);

            //add another row
            if ((Apps.EmployeeInfo.length > rows1.size()) && ((i + 1) < Apps.EmployeeInfo.length)) {
                id = "add-row";
                clickbyId(id);
            }
        }


        // Locate all the rows in the table
        WebElement table3 = driver.findElement(By.id("include_emp_func_tbody"));
        List<WebElement> rows2 = table3.findElements(By.tagName("tr"));

        //remove employees
        // Iterate through the rows to find the one with "1077" in the dropdown
        for (int i = 0; i < rows2.size(); i++) {
            xpath = "//*[@id=\"select2-add_emp_list_" + (i + 1) + "-container\"]";
            String s = getTextbyXpath(xpath);

            if (s.contains(Apps.EmployeeInfo[i]) && i % 2 == 0) {
                //select the row
                xpath = "//*[@id=\"include_emp_func_tbody\"]/tr[" + (i + 1) + "]/td[1]/input";
                clickbyxpath(xpath);
            }
        }

        //click the delete button for the selected employees
        Thread.sleep(200);
        //click the delete button
        id = "delete-row";
        clickbyId(id);

        //add functions for the employees
        id = "check_APPR";
        clickbyId(id);
        id = "check_CREATE";
        clickbyId(id);
        id = "check_EDIT";
        clickbyId(id);
        id = "check_LIST";
        clickbyId(id);
        id = "check_PRINT";
        clickbyId(id);
        id = "check_PRINTL";
        clickbyId(id);
        id = "check_VIEW";
        clickbyId(id);

        //click the save button
        id = "save";
        clickbyId(id);

        PrintConfirmationMessage();

        closedriver();
        softAssert.assertAll();
    }


    /*
    verify if the user has access to the app
    */
    @Given("login for checking access of first user")
    public void login_for_checking_access_of_first_user() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
    }

    @And("verify from the side panel")
    public void verify_from_the_side_panel() throws InterruptedException {

        Thread.sleep(2000);

        // Find all span elements within the specified ul element
        WebElement ulElement = driver.findElement(By.id("menu"));
        java.util.List<WebElement> spanElements = ulElement.findElements(By.tagName("span"));
        boolean AppFound = false;

        // Loop through each span element and print its text
        for (WebElement span : spanElements) {
            if (Apps.DisplayName.equals(span.getText())) {
                AppFound = true;
                break;
            }
            ;
        }
        System.out.println("Apps Found? " + AppFound);
        softAssert.assertTrue(AppFound);

        closedriver();
        softAssert.assertAll();
    }


    @Then("login for checking access of 2nd user")
    public void login_for_checking_access_of_2nd_user() throws InterruptedException {
        Login_AIR2(Users.user_Ashik);
    }



    @When("Revoke user permission")
    public void revoke_user_permission() {
        try {
            Thread.sleep(1000);
            // click the plus button of the displayed app
            WebElement table = driver.findElement(By.id("apps_tableData"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    WebElement addButton = row.findElement(By.id("btn_add_emp"));
                    addButton.click();
                    break;
                }
            }

            //click the checkbox of the row for which user permission needs to be revoked

            Thread.sleep(4000);
            // Locate all the rows in the table
//            WebElement table1 = driver.findElement(By.id("emp_func_table"));
            List<WebElement> emprows2 = driver.findElements(By.xpath("//*[@id=\"emp_func_table\"]/tbody/tr"));
            System.out.println("row size is : " + emprows2.size());

            //remove employees
            // Iterate through the rows
            for (int i = 0; i < emprows2.size(); i++) {     //emprows2 has 111 invalid rows. It has to be subtracted
                xpath = "//*[@id=\"include_emp_func_tbody\"]/tr[" + (i + 1) + "]/td[2]/div/span/span/span/span";
                String s = getTextbyXpath(xpath);
                System.out.println(s);

                for (int j = 0; j < Apps.EmployeeInfo.length; j++) {
                    if (s.contains(Apps.EmployeeInfo[j])) {
                        //select the row
                        xpath = "//*[@id=\"include_emp_func_tbody\"]/tr[" + (i + 1) + "]/td[1]/input";
                        clickbyxpath(xpath);
                        break;
                    }
                }
            }

            //click the delete button for the selected employees
            Thread.sleep(200);
            //click the delete button
            id = "delete-row";
            clickbyId(id);

            //save
            xpath = "//*[@id=\"save\"]";
            clickbyxpath(xpath);

            PrintConfirmationMessage();

            closedriver();

        } catch (TimeoutException | InterruptedException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }


    @And("verify that the app is listed in the apps list")
    public void verifyThatTheAppIsListedInTheAppsList() throws InterruptedException {
        Thread.sleep(200);
        // verify the created product
        WebElement table = driver.findElement(By.id("apps_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                softAssert.assertEquals(AppName, row.findElement(By.xpath(".//td[2]")).getText());
            }
        }

        closedriver();
        softAssert.assertAll();
    }
}
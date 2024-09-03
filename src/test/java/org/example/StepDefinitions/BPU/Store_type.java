package org.example.StepDefinitions.BPU;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Store_type extends Page_Options {

    SoftAssert softAssert = new SoftAssert();
    int randomnumber = randomnumber();
    String Store_type_name = StoreType.FullName + " " + randomnumber;
    String Store_type_Short_name = StoreType.ShortName + " " + randomnumber;
    String Store_type_edited_Short_name = StoreType.E_ShortName + " " + randomnumber;
    String Store_type_edited_name = StoreType.E_FullName + " " + randomnumber;

    @Given("login to Search for Store_type")
    public void loginToSearchForStore_type() throws InterruptedException {
        Login_BPU(Users.L1Tester);
        Click_from_leftSideBar("INV Store Types");
    }

    @When("Search for the Store_type")
    public void searchForTheStore_type() throws InterruptedException {
        Thread.sleep(1000);

        id = "search_input";
        waitById(id);
        inputbyid(id, StoreType.SearchInfo);
    }

    @Then("verify if the Store_type is visible accordingly")
    public void verifyIfTheStore_typeIsVisibleAccordingly() throws InterruptedException {
        Thread.sleep(2000);
        Boolean search_found = false;

        // verify the searched Store type
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                String SearchedItem = row.findElement(By.xpath(".//td[3]/p")).getText();
                if (SearchedItem.contains(StoreType.SearchInfo)) {
                    search_found = true;
                    break;
                }
            }
        }
        softAssert.assertTrue(search_found);
        closedriver();
        softAssert.assertAll();
    }

    @When("Create a Store_type with active status and visibility inactive")
    public void createAStore_typeWithActiveStatus() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id, Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id, Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Active");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Inactive");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is active or not and visibility in stores is inactive or not")
    public void checkIfThisStoreTypeIsActiveOrNotAndVisibilityInStoresIsInactiveOrNot() throws InterruptedException {

        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Active", "Status is Inactive");
                break;
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(1100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible, "visiblity as active");

        //click the close button
        xpath = "//*[@id=\"create_new\"]/div/div/div[3]/button";
        clickbyxpath(xpath);

        softAssert.assertAll();
    }

    @When("Create a Store_type with active status and visiblity active")
    public void createAStore_typeWithActiveStatusAndVisiblityActive() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id, Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id, Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Active");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Active");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is active or not and visibility in stores is active or not")
    public void checkIfThisStoreTypeIsActiveOrNotAndVisibilityInStoresIsActiveOrNot() throws InterruptedException {

        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Active", "Status is Inactive");
                break;
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertTrue(visible, "visiblity as active");
        //click the close button
        xpath = "//*[@id=\"create_new\"]/div/div/div[3]/button";
        clickbyxpath(xpath);
        softAssert.assertAll();
    }

    @When("Create a Store_type with inactive status and visibility inactive")
    public void createAStore_typeWithInactiveStatusAndVisibilityInactive() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id, Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id, Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Inactive");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Inactive");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is inactive or not and visibility in stores is inactive or not")
    public void checkIfThisStoreTypeIsInactiveOrNotAndVisibilityInStoresIsInactiveOrNot() throws InterruptedException {

        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Inactive", "Status is active");
                break;
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible, "visiblity as active");
        //click the close button
        xpath = "//*[@id=\"create_new\"]/div/div/div[3]/button";
        clickbyxpath(xpath);
        softAssert.assertAll();
    }

    @When("Create a Store_type with inactive status and visiblity active")
    public void createAStore_typeWithInactiveStatusAndVisiblityActive() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        //full name
        id = "f_name";
        inputbyid(id, Store_type_name);

        //short name
        id = "s_name";
        inputbyid(id, Store_type_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Inactive");

        // Select the visiblity as inactive
        WebElement dropdown2 = driver.findElement(By.id("is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Active");

        //click the save button
        id = "save_btn";
        clickbyId(id);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been saved");
    }

    @And("check if this store type is inactive or not and visibility in stores is active or not")
    public void checkIfThisStoreTypeIsInactiveOrNotAndVisibilityInStoresIsActiveOrNot() throws InterruptedException {
        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        // verify the Store type
        Boolean Status = false;
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Inactive", "Status is active");
                break;
            }
        }


        //verify that the visibility in stores is inactive or not


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible, "visiblity as active");
        //click the close button
        xpath = "//*[@id=\"create_new\"]/div/div/div[3]/button";
        clickbyxpath(xpath);
        softAssert.assertAll();
    }

    @When("Edit a Store_type with active status and visiblity active")
    public void editAStore_typeWithActiveStatusAndVisiblityActive() throws InterruptedException {
        //navigate to the Store_type page
        Click_from_leftSideBar("INV Store Types");

        Thread.sleep(1000);

        //search for the store type
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        //click the edit button
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // click the edit button of the visible result
                WebElement Button = row.findElement(By.id("btn_edit"));
                Button.click();
                break;
            }
        }

        Thread.sleep(1000);
        //full name
        id = "edit_f_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        //short name
        id = "edit_s_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("edit_is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Active");

        // Select the visiblity as active
        WebElement dropdown2 = driver.findElement(By.id("edit_is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Active");

        //click the save button
        xpath = "//*[@id=\"edit_inv_store_type_form\"]/div[1]/div[5]/div[1]/button";
        clickbyxpath(xpath);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been edited");

    }

    @And("check if the edited store type is active or not and visibility in stores is active or not")
    public void checkIfTheEditedStoreTypeIsActiveOrNotAndVisibilityInStoresIsActiveOrNot() throws InterruptedException {
        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        // verify the Store type
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Active", "Status is inactive");
                break;
            }
        }


        //verify that the visibility in stores


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertTrue(visible, "visiblity as inactive");

        closedriver();
        softAssert.assertAll();
    }

    @When("Edit a Store_type with inactive status and visiblity active")
    public void editAStore_typeWithInactiveStatusAndVisiblityActive() throws InterruptedException {
        //navigate to the Store_type page
        Click_from_leftSideBar("INV Store Types");

        Thread.sleep(1000);

        //search for the store type
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        //click the edit button
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // click the edit button of the visible result
                WebElement Button = row.findElement(By.id("btn_edit"));
                Button.click();
                break;
            }
        }

        Thread.sleep(1000);
        //full name
        id = "edit_f_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        //short name
        id = "edit_s_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_Short_name);

        // Select the Status
        WebElement dropdown1 = driver.findElement(By.id("edit_is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Inactive");

        // Select the visiblity
        WebElement dropdown2 = driver.findElement(By.id("edit_is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Active");

        //click the save button
        xpath = "//*[@id=\"edit_inv_store_type_form\"]/div[1]/div[5]/div[1]/button";
        clickbyxpath(xpath);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been edited");
    }

    @And("check if the edited store type is inactive or not and visibility in stores is active or not")
    public void checkIfTheEditedStoreTypeIsInactiveOrNotAndVisibilityInStoresIsActiveOrNot() throws InterruptedException {
        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        // verify the Store type
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Inactive", "Status is active");
                break;
            }
        }


        //verify that the visibility in stores


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible, "visiblity as inactive");

        closedriver();
        softAssert.assertAll();
    }

    @When("Edit a Store_type with inactive status and visiblity inactive")
    public void editAStore_typeWithInactiveStatusAndVisiblityInactive() throws InterruptedException {
        //navigate to the Store_type page
        Click_from_leftSideBar("INV Store Types");

        Thread.sleep(1000);

        //search for the store type
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        //click the edit button
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // click the edit button of the visible result
                WebElement Button = row.findElement(By.id("btn_edit"));
                Button.click();
                break;
            }
        }

        Thread.sleep(1000);
        //full name
        id = "edit_f_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        //short name
        id = "edit_s_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_Short_name);

        // Select the Status
        WebElement dropdown1 = driver.findElement(By.id("edit_is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Inactive");

        // Select the visiblity
        WebElement dropdown2 = driver.findElement(By.id("edit_is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Inactive");

        //click the save button
        xpath = "//*[@id=\"edit_inv_store_type_form\"]/div[1]/div[5]/div[1]/button";
        clickbyxpath(xpath);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been edited");
    }

    @And("check if the edited store type is inactive or not and visibility in stores is inactive or not")
    public void checkIfTheEditedStoreTypeIsInactiveOrNotAndVisibilityInStoresIsInactiveOrNot() throws InterruptedException {
        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        // verify the Store type
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Inactive", "Status is active");
                break;
            }
        }


        //verify that the visibility in stores


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible, "visiblity as inactive");

        closedriver();
        softAssert.assertAll();
    }

    @When("Edit a Store_type with active status and visiblity inactive")
    public void editAStore_typeWithActiveStatusAndVisiblityInactive() throws InterruptedException {
        //navigate to the Store_type page
        Click_from_leftSideBar("INV Store Types");

        Thread.sleep(1000);

        //search for the store type
        id = "search_input";
        waitById(id);
        inputbyid(id, Store_type_name);

        //click the edit button
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // click the edit button of the visible result
                WebElement Button = row.findElement(By.id("btn_edit"));
                Button.click();
                break;
            }
        }

        Thread.sleep(1000);
        //full name
        id = "edit_f_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        //short name
        id = "edit_s_name";
        clearByid(id);
        inputbyid(id, Store_type_edited_Short_name);

        // Select the Status as active
        WebElement dropdown1 = driver.findElement(By.id("edit_is_active"));
        Select select1 = new Select(dropdown1);
        select1.selectByVisibleText("Active");

        // Select the visiblity as active
        WebElement dropdown2 = driver.findElement(By.id("edit_is_pos"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("Inactive");

        //click the save button
        xpath = "//*[@id=\"edit_inv_store_type_form\"]/div[1]/div[5]/div[1]/button";
        clickbyxpath(xpath);

        softAssert.assertEquals(GetConfirmationMessage(), "Store Type has been edited");
    }

    @And("check if the edited store type is active or not and visibility in stores is inactive or not")
    public void checkIfTheEditedStoreTypeIsActiveOrNotAndVisibilityInStoresIsInactiveOrNot() throws InterruptedException {
        //search for the store type in the list
        Thread.sleep(2000);
        id = "search_input";
        clearByid(id);
        inputbyid(id, Store_type_edited_name);

        // verify the Store type
        WebElement table = driver.findElement(By.id("inv_store_type_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and get the information of the visible row
                softAssert.assertEquals(row.findElement(By.xpath(".//td[5]/p")).getText(), "Active", "Status is inactive");
                break;
            }
        }


        //verify that the visibility in stores


        Click_from_leftSideBar("INV Stores");
        Thread.sleep(2100);

        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
        clickbyxpath(xpath);

        // check the visiblity as inactive
        WebElement dropdown = driver.findElement(By.id("store_type_id"));
        Boolean visible = false;

        // Get all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));

        // Iterate over each option and print its text
        for (WebElement option : options) {
            String expected_storeType = option.getText();
            System.out.println(option.getText());
            if (expected_storeType.contains(Store_type_name)) {
                visible = true;
                break;
            }
        }
        softAssert.assertFalse(visible, "visiblity as active");

        closedriver();
        softAssert.assertAll();
    }

    @Then("Check the title of Store_type")
    public void checkTheTitleOfStore_type() throws InterruptedException {
        softAssert.assertEquals(driver.getTitle(),"AIR - Store Types");
        closedriver();
        softAssert.assertAll();
    }
}

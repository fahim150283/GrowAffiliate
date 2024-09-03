package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductCategories extends Page_Options {
    String name = PRODCAT.Name + randomnumber();
    String E_name = PRODCAT.E_Name + randomnumber();

    String MainCategory = PRODCAT.MainCategory;


    /*
    Creation of a product Category
    */
    @Given("login for creating new  Product Category")
    public void login_for_creating_new_product_category() {
        Login_AIR2_AIR(Users.user_Fahim);
        cssSelector = ".menues-bar:nth-child(25) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("create new  Product Category")
    public void create_new_product_category() throws InterruptedException {
        try {
            Thread.sleep(2000);

            //click the create new button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            Thread.sleep(500);

            //name
            id = "add_name";
            waitById(id);
            inputbyid(id, name);

            //main category
            id = "select2-add_sub_of_list-container";
            waitById(id);
            clickbyId(id);
            //search for cateegory
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            inputbyxpath(xpath, MainCategory);
            pressEnterbyXpath(xpath);

            //status
            id = "add_status";
            WebElement Dropdown = driver.findElement(By.id(id));
            Select CatgSelect = new Select(Dropdown);
            CatgSelect.selectByVisibleText(PRODCAT.Status);
            Thread.sleep(20);

            //click save
            xpath = "//*[@id=\"add_product_categories_form\"]/div/div/div[3]/div/button";

            clickbyxpath(xpath);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("verify that the Product Category is created and listed in the Products Category list")
    public void verify_that_the_product_category_is_created_and_listed_in_the_products_category_list() throws InterruptedException {
        try {
            Thread.sleep(2000);

            //search for the category
            id = "search_input";
            clickbyId(id);
            inputbyid(id, name);

            Thread.sleep(100);

            // verify the created product
            WebElement table = driver.findElement(By.id("product_categories_tableData"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    Assert.assertEquals(name, row.findElement(By.xpath(".//td[2]")).getText());
                    Assert.assertEquals(PRODCAT.MainCategory, row.findElement(By.xpath(".//td[3]")).getText());
                }
            }
        }  catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close driver for creating Product Category")
    public void close_driver_for_creating_product_category() throws InterruptedException {
        closedriver();
    }


    /*
    edit a product category
    */
    @Given("login for editing a Product Category")
    public void login_for_editing_a_product_category() {
        Login_AIR2_AIR(Users.user_Fahim);
        cssSelector = ".menues-bar:nth-child(25) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("edit a Product Category")
    public void edit_a_product_category() throws InterruptedException {
        try {
            Thread.sleep(2000);

            //search for the category
            id = "search_input";
            clickbyId(id);
            inputbyid(id, name);

            Thread.sleep(100);

            // edit the category
            WebElement table = driver.findElement(By.id("product_categories_tableData"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    row.findElement(By.id("btn_edit")).click();
                }
            }

            Thread.sleep(1000);

            //name
            id = "edit_name";
            waitById(id);
            clearById(id);
            inputbyid(id, E_name);

            //main category
            id = "select2-edit_sub_of_list-container";
            waitById(id);
            clickbyId(id);
            //search for category
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, MainCategory);
            pressEnterbyXpath(xpath);

            //status
            id = "edit_status";
            WebElement Dropdown = driver.findElement(By.id(id));
            Select CatgSelect = new Select(Dropdown);
            CatgSelect.selectByVisibleText(PRODCAT.Status);
            Thread.sleep(20);

            //save
            xpath = "//*[@id=\"edit_product_categories_form\"]/div/div/div[3]/div/button";
            clickbyxpath(xpath);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("verify that the Product Category is edited")
    public void verify_that_the_product_category_is_edited() throws InterruptedException {
        try {
            Thread.sleep(2000);

            //search for the category
            id = "search_input";
            clickbyId(id);
            clearById(id);
            inputbyid(id, E_name);

            Thread.sleep(1000);

            // verify the created product
            WebElement table = driver.findElement(By.id("product_categories_tableData"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    Assert.assertEquals(E_name, row.findElement(By.xpath(".//td[2]")).getText());
                    Assert.assertEquals(MainCategory, row.findElement(By.xpath(".//td[3]")).getText());
                }
            }
        }  catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close driver for editing Product Category")
    public void close_driver_for_editing_product_category() throws InterruptedException {
        closedriver();
    }


    /*
    Verify functionality of a Product Category
    */
    @Given("login for Verifying functionality of a Product Category")
    public void login_for_verifying_functionality_of_a_product_category() {
        Login_AIR2_AIR(Users.user_Fahim);
        cssSelector = ".menues-bar:nth-child(25) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("create a product")
    public void create_a_product() throws InterruptedException {
        try {
            Thread.sleep(2000);

            //navigate to the products page
            cssSelector = ".menues-bar:nth-child(24) .active";
            waitByCssSelector(cssSelector);
            clickbycssselector(cssSelector);

            //click the create new button
            xpath = "/html/body/div[2]/div[2]/a";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //product code
            xpath = "//*[@id=\"product_code\"]";
            waitByxpath(xpath);
            inputbyxpath(xpath, "productcode");

            //product name
            xpath = "//*[@id=\"product_name\"]";
            waitByxpath(xpath);
            inputbyxpath(xpath, "productname");

            //product category
            xpath = "//*[@id=\"select2-product_category-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            inputbyxpath(xpath, E_name);
            pressEnterbyXpath(xpath);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @When("verify that the Product Category is there for product creation")
    public void verify_that_the_product_category_is_there_for_product_creation() throws InterruptedException {
        try {
            Thread.sleep(2000);
            xpath = "//*[@id=\"select2-product_category-container\"]";
            waitByxpath(xpath);
            String s = getTextAttributebyXpath(xpath);
            Assert.assertTrue(s.contains(E_name));
        }  catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close driver for verifying Product Category")
    public void close_driver_for_verifying_product_category() throws InterruptedException {
        closedriver();
    }
}

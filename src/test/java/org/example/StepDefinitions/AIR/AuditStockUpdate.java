package org.example.StepDefinitions.AIR;

import io.cucumber.java.Before;
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

public class AuditStockUpdate extends Page_Options {
    SoftAssert softAssert = new SoftAssert();


    @Given("login for Audit Stock")
    public void login_for_audit_stock() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Audit Stock Update");
    }

    @When("search for Audit Stock")
    public void search_for_audit_stock() throws InterruptedException {
        Thread.sleep(1000);
        //search an FG store
        xpath = "//*[@id=\"inv_tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, AuditStockUpdate.SearchInfo);
    }

    @When("view an Audit Stock update")
    public void view_an_Audit_Stock_update() throws InterruptedException {
        try {
            Thread.sleep(100);

            xpath = "//*[@id=\"inv_tableData\"]/tbody/tr[1]/td[7]/a";
            waitByxpath(xpath);
            clickbyxpath(xpath);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Given("create new Audit Stock")
    public void create_new_audit_stock() throws InterruptedException {
        try {
            //click the create new button

            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]/span";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //in the modal form

            //select depot
            xpath = "//*[@id=\"select2-add_depot-container\"]";
            waitByxpath(xpath);
            Thread.sleep(1000);
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, AuditStockUpdate.DepotSearch);
            Thread.sleep(10);
            pressEnterbyXpath(xpath);

            //select store
            xpath = "//*[@id=\"select2-add_store-container\"]";
            waitByxpath(xpath);
            Thread.sleep(1000);
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, AuditStockUpdate.StoreSearch);
            Thread.sleep(10);
            pressEnterbyXpath(xpath);

            //set audit date
            xpath = "//*[@id=\"adjustment_date\"]";
            inputbyxpath(xpath, getToday());

            //set quantity amout
            Thread.sleep(500);
            int rowCnt = getTotalRowCountByXpath("//*[@id=\"product_details\"]");
            for (int i = 0; i < rowCnt; i++) {
                //set ctn amount
                xpath = "//*[@id=\"product_details\"]/tr[" + (i + 1) + "]/td[6]/input";
                clearByXpath(xpath);
                inputbyxpath(xpath, AuditStockUpdate.ItemQuantity);

//                //set pcs amount
//                xpath = "//*[@id=\"product_details\"]/tr[" + (i + 1) + "]/td[7]/input";
//                clearByXpath(xpath);
//                inputbyxpath(xpath, AuditStockUpdate.ItemQuantity);
            }

            //click save button
            xpath = "//*[@id=\"add_audit_stock\"]/div/div[3]/div/button";
            clickbyxpath(xpath);

            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("verify that the searched result is correct")
    public void verifyThatTheSearchedResultIsCorrect() throws InterruptedException {

        Boolean depotisvisible = false;
        Boolean updatedbyisvisible = false;

        String DepotString = getTextbyXpath("//*[@id=\"inv_tableData\"]/tbody/tr[1]/td[2]");
        String UpdatedByString = getTextbyXpath("//*[@id=\"inv_tableData\"]/tbody/tr[1]/td[5]");
        String str = AuditStockUpdate.SearchInfo;
        String[] arrOfStr = str.split(" ");

        if (DepotString.contains(arrOfStr[0])) {
            depotisvisible = true;
        }
        if (UpdatedByString.contains(arrOfStr[1])) {
            updatedbyisvisible = true;
        }
        softAssert.assertTrue(depotisvisible);
        softAssert.assertTrue(updatedbyisvisible);

        closedriver();
        softAssert.assertAll();
    }

    @And("verify that the audit stock update is viewed")
    public void verifyThatTheAuditStockUpdateIsViewed() throws InterruptedException {

        Thread.sleep(4000);

        Boolean depotisvisible = false;
        Boolean updatedbyisvisible = false;

        String DepotString = getTextbyXpath("//*[@id=\"v_depot\"]");
        String UpdatedByString = getTextbyXpath("//*[@id=\"v_emp\"]");
        String str = AuditStockUpdate.SearchInfo;
        String[] arrOfStr = str.split(" ");

        if (DepotString.contains(arrOfStr[0])) {
            depotisvisible = true;
        }
        if (UpdatedByString.contains(arrOfStr[1])) {
            updatedbyisvisible = true;
        }
        softAssert.assertTrue(depotisvisible);
        softAssert.assertTrue(updatedbyisvisible);

        closedriver();
        softAssert.assertAll();
    }

    @And("verify that the Fg Store is updated")
    public void verifyThatTheFgStoreIsUpdated() throws InterruptedException {

        Thread.sleep(2000);
        Click_from_leftSideBar("Finish Goods Store");

        String searchString = AuditStockUpdate.DepotSearch + " " + AuditStockUpdate.StoreSearch + " Store";

        Thread.sleep(2000);
        //search a FG store
        id = "search";
        waitById(id);
        inputbyid(id, searchString);

        //description of the store
        WebElement table = driver.findElement(By.id("fg_store_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "delete" button for the visible row
                WebElement view_Button = row.findElement(By.id("btn_view"));
                view_Button.click();
            }
        }

        //check if the items are all the same amount as the audit stock update
        for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"fg_store_qty\"]") - 3; i++) {   // (-3) is used here because 3 of the last rows are reserved for the total value or amount calculation
            softAssert.assertEquals(getTextbyXpath("//*[@id=\"fg_store_qty\"]/tr[" + (i + 1) + "]/td[6]"), AuditStockUpdate.ItemQuantity);
        }

        closedriver();
        softAssert.assertAll();
    }
}
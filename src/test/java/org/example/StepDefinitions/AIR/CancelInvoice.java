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

public class CancelInvoice extends Page_Options {
    SoftAssert softAssert = new SoftAssert();
    @Given("Login to Search cancelled Invoice")
    public void login_to_search_cancelled_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Cancel Invoice");
    }

    @When("search for cancelled Invoice")
    public void search_for_cancelled_invoice() throws InterruptedException {
        try {
            Thread.sleep(100);
            xpath = "//*[@id=\"search_input\"]";
            waitByxpath(xpath);
            inputbyxpath(xpath, CancelInvoice.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a cancelled Invoice")
    public void description_of_a_cancelled_invoice() throws InterruptedException {
        try{
        Thread.sleep(500);
        // verify the created product
        WebElement table = driver.findElement(By.id("tableData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                WebElement viewButton = row.findElement(By.id("btn_view"));
                viewButton.click();
                break;
            }
        }
        }catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close cancelled Invoice for search")
    public void close_cancelled_invoice_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for cancellation of an Invoice")
    public void login_for_cancellation_of_an_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Cancel Invoice");
    }

    @And("create new regular cancel Invoice")
    public void create_new_cancel_invoice() throws InterruptedException {
        try{
        //click the plus button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[4]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(2000);

        //date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        waitByxpath(xpath);
        SetToday(xpath);

        //invoice list
        Thread.sleep(15000);
        xpath = "//*[@id=\"select2-invoice_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        xpath = "/html/body/span/span/span[1]/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, CancelInvoice.DistributorSearch);
        pressEnterbyXpath(xpath);

        //select the store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, CancelInvoice.Store);
        cssSelectorPressEnter(cssSelector);

        //important notes
        id = "c_notes";
        inputbyid(id, CancelInvoice.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
            softAssert.assertEquals(grandTotalVisible, grandTotalActual);


        //save
        id = "add_region";
        waitById(id);
        clickbyId(id);

        AlertAccept();
        PrintConfirmationMessage();

        closedriver();
        softAssert.assertAll();
        }catch (InterruptedException | TimeoutException | AssertionError e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("verify that the cancelled invoice is searched")
    public void verifyThatTheCancelledInvoiceIsSearched() throws InterruptedException {
        Thread.sleep(1000);

        WebElement table = driver.findElement(By.id("tableData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                softAssert.assertEquals(CancelInvoice.SearchInfo, row.findElement(By.xpath(".//td[8]")).getText());
                break;
            }
        }
        closedriver();
        softAssert.assertAll();
    }

    @And("check grand total calculation of the cancelled invoice")
    public void checkGrandTotalCalculationOfTheCancelledInvoice() throws InterruptedException {
        Thread.sleep(4000);

        int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"view_inv_item_details\"]");
        double[][] gtCacl = new double[itemsRowSize][2];
        for (int i = 0; i < itemsRowSize-4; i++) {
            //get price/ctn
            xpath = "//*[@id=\"view_inv_item_details\"]/tr["+(i+1)+"]/td[5]/p";
            double s1 = Double.parseDouble(getTextbyXpath(xpath).replaceAll("[^\\d.]", ""));
            //get ctn count
            xpath = "//*[@id=\"view_inv_item_details\"]/tr["+(i+1)+"]/td[6]/p";
            double s2 = Double.parseDouble(getTextbyXpath(xpath));

            gtCacl[i][0] = s1;
            gtCacl[i][1] = s2;
            String prodname = getTextbyXpath("//*[@id=\"view_inv_item_details\"]/tr["+(i+1)+"]/td[2]/p");
            System.out.println(prodname + " ==> " + gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
        }
        double grandTotalActual = GrandTotalCalc(gtCacl);
        xpath = "//*[@id=\"view_inv_item_details\"]/tr["+(itemsRowSize-2)+"]/td[2]/p";
        double grandTotalVisible = Double.parseDouble(getTextbyXpath(xpath).replaceAll("[^\\d.]", ""));
        System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
        softAssert.assertEquals(grandTotalVisible, grandTotalActual);

        closedriver();
        softAssert.assertAll();
    }
}

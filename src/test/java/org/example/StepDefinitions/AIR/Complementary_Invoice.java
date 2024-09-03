package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Complementary_Invoice extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    @Given("Login to Search Complementary Invoice")
    public void login_to_search_complementary_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Complimentary Invoice");
    }

    @When("search for Complementary Invoice")
    public void search_for_complementary_invoice() throws InterruptedException {
        try {
            id = "search_input";
            waitById(id);
            Thread.sleep(1000);
            inputbyid(id, ComplementaryInvoice.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a Complementary Invoice")
    public void description_of_a_complementary_invoice() throws InterruptedException {
        try {
            Thread.sleep(500);
            // click the edit button of the displayed product
            WebElement table = driver.findElement(By.id("pending_pro_del_table"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    WebElement view_Button = row.findElement(By.id("btn_view"));
                    view_Button.click();
                    break;
                }
            }

            //verify that the view modal is viewed
            Thread.sleep(100);
            xpath = "//*[@id=\"view_pending_product_delivery_form\"]/div/div/div[3]/h4/u";
            String s = getTextbyXpath(xpath);
            softAssert.assertEquals(s, "Complimentary Invoice");

            closedriver();
            softAssert.assertAll();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close Complementary Invoice for search")
    public void close_complementary_invoice_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


    @Given("login for creation of an Complementary Invoice")
    public void login_for_creation_of_an_complementary_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Complimentary Invoice");
    }

    @And("create new regular Complementary Invoice")
    public void create_new_complementary_invoice() throws InterruptedException {
        Thread.sleep(2000);
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date
        xpath = "//*[@id=\"ch_date\"]";
        waitByxpath(xpath);
        SetToday(xpath);

        //distributors list
        id = "select2-distri_list-container";
        waitById(id);
        clickbyId(id);
        //search for bhai bhai
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, ComplementaryInvoice.DistributorSearch);
        cssSelectorPressEnter(cssSelector);

        //Store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);

        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, ComplementaryInvoice.Store);
        cssSelectorPressEnter(cssSelector);

        //invoice reference no
        id = "c_inv_ref";
        inputbyid(id, ComplementaryInvoice.InvoiceReferenceNo);

        //important notes
        id = "c_notes";
        inputbyid(id, ComplementaryInvoice.Note);
        Thread.sleep(100);

        //click the items bar
        for (int i = 0; i < Order.Items.length+1; i++) {
            xpath = "//*[@id=\"add_pending_product_delivery_form\"]/div/div[4]/div[4]/span/span[1]/span";
            Thread.sleep(10);
            inputbyxpath(xpath, Order.Items[i]);
            Thread.sleep(10);
            pressEnterbyXpath(xpath);
            Thread.sleep(10);

            // press the plus button
            id = "c_add_ch_prod";
            clickbyId(id);
        }

        //click the amount buttons for the quantity of the items
        for (int i = 0; i < ComplementaryInvoice.Items.length; i++) {
            //ctn(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, ComplementaryInvoice.ItemQuantity);
//                //pcs(quantity)
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, ComplementaryInvoice.ItemQuantity);
        }

        //remove an item
        WebElement table = driver.findElement(By.id("c_inv_items_list"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (i % 5 == 0) {
                // Find and click the "delete" button for the visible row
                WebElement delete_Button = row.findElement(By.xpath("//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/button"));
                delete_Button.click();
            }
        }

        //save
        xpath = "//*[@id=\"add_pending_product_delivery_form\"]/div/div[6]/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);


        AlertAccept();
        PrintConfirmationMessage();

        closedriver();
    }

    @And("verify that the complementary invoice is searched")
    public void verifyThatTheComplementaryInvoiceIsSearched() throws InterruptedException {
        Thread.sleep(300);

        // verify the searched  complementary invoice is correct
        Boolean foundResult = false;
        WebElement table = driver.findElement(By.id("pending_pro_del_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "delete" button for the visible row
                xpath = "//*[@id=\"pending_pro_del_table\"]/tr[" + (i + 1) + "]/td[6]/p";
                String s = getTextbyXpath(xpath);
                if (s.contains(ComplementaryInvoice.SearchInfo)) {
                    foundResult = true;
                }
                break;
            }
        }

        softAssert.assertTrue(foundResult);
        closedriver();
        softAssert.assertAll();
    }

    @And("create new regular Complementary Invoice for checking the stock error")
    public void createNewRegularComplementaryInvoiceForCheckingTheStockError() throws InterruptedException {
        Thread.sleep(2000);
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //date
        xpath = "//*[@id=\"ch_date\"]";
        waitByxpath(xpath);
        SetToday(xpath);

        //distributors list
        id = "select2-distri_list-container";
        waitById(id);
        clickbyId(id);
        //search for bhai bhai
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, ComplementaryInvoice.DistributorSearch);
        cssSelectorPressEnter(cssSelector);

        //Store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);

        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, ComplementaryInvoice.Store);
        cssSelectorPressEnter(cssSelector);

        //invoice reference no
        id = "c_inv_ref";
        inputbyid(id, ComplementaryInvoice.InvoiceReferenceNo);

        //important notes
        id = "c_notes";
        inputbyid(id, ComplementaryInvoice.Note);

        //click the items bar
        for (int i = 0; i < Order.Items.length; i++) {
            xpath = "//*[@id=\"add_pending_product_delivery_form\"]/div/div[4]/div[4]/span/span[1]/span";
            Thread.sleep(30);
            inputbyxpath(xpath, Order.Items[i]);
            Thread.sleep(10);
            pressEnterbyXpath(xpath);
            Thread.sleep(10);

            // press the plus button
            id = "c_add_ch_prod";
            clickbyId(id);
        }

        //click the amount buttons for the quantity of the items
        for (int i = 0; i < ComplementaryInvoice.Items.length; i++) {
            //ctn(quantity)
            xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
            waitByxpath(xpath);
            clearByXpath(xpath);
            inputbyxpath(xpath, "99999999");
//                //pcs(quantity)
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, ComplementaryInvoice.ItemQuantity);
        }

        //remove an item
        WebElement table = driver.findElement(By.id("c_inv_items_list"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            if (i % 5 == 0) {
                // Find and click the "delete" button for the visible row
                WebElement delete_Button = row.findElement(By.xpath("//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/button"));
                delete_Button.click();
            }
        }

        //save
        xpath = "//*[@id=\"add_pending_product_delivery_form\"]/div/div[6]/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);


        AlertAccept();
        PrintConfirmationMessage();
    }

    @Then("verify that the complementary invoice is not created")
    public void verifyThatTheComplementaryInvoiceIsNotCreated() throws InterruptedException {
        String s = GetConfirmationMessage();
        softAssert.assertEquals(s,"Store Limit Exceed, Check Product Qty in Stock");

        closedriver();
        softAssert.assertAll();
    }
}
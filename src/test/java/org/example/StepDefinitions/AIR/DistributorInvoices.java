package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DistributorInvoices extends Page_Options {
    SoftAssert softAssert = new SoftAssert();
    String orderNum = null;
    Date date1;
    Date date2;
    String confirmation_msg;

    @Given("Login to Search Invoice")
    public void login_to_search_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Distributor Invoices");
    }

    @When("search for Invoice")
    public void search_for_invoice() {
        try {
            xpath = "//*[@id=\"inv_tableData_filter\"]/label/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, Invoices.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of an Invoice")
    public void description_of_an_invoice() {
        try {
            Thread.sleep(2000);

            id = "btn_view";
            waitById(id);
            clickbyId(id);
            Thread.sleep(2000);

            scrollToTheBottomOfModal();

        } catch (TimeoutException | InterruptedException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Given("login for Invoice")
    public void login_for_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Distributor Invoices");
    }

    @And("create new Invoice and verify the creation")
    public void create_new_invoice() throws InterruptedException {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //if order does not have minimum rows visible for invoice then change the order
            

            //select the store
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);

            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.Store);
            cssSelectorPressEnter(cssSelector);


            //partial invoice or full invoice
            Boolean partialInvoice = Invoices.PartialInvoice;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                int k  = Integer.parseInt(getTextAttributebyXpath(xpath));
                if ((partialInvoice == true && i % 2 == 0 )&& k > Integer.parseInt(Invoices.ItemQuantity)) {
                    //CTN
                    Thread.sleep(20);
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted

//                //PCS(not necessary)
//                Thread.sleep(20);
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted
                }
            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);


            Thread.sleep(200);
            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("the found " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
//                        Thread.sleep(700);
//                        String xpath = "//*[@id=\"showCtn" + (i + 1) + "\"]";
//                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
//                        System.out.println("Default offer quantity is " + quantity + " ctn");
//                        if (quantity > Integer.parseInt(Invoices.OfferCTN)) {
//                            waitByxpath(xpath);
//                            Thread.sleep(300);
//                            clearByXpath(xpath);
//                            inputbyxpath(xpath, (Invoices.OfferCTN));
//                        }
                    }
                }
            }

//            //For Screen Shot
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(100);
//                PageUp();
//            }
//            TakeScreenShot();
//            PageDown();
//            TakeScreenShot();


            //wait for a defined period of time
            Thread.sleep(Invoices.IntervalOfSaveTime);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);


            AlertAccept();
            PrintConfirmationMessage();

            //verify the creation of the invoice
            confirmation_msg = GetConfirmationMessage();
            softAssert.assertEquals(confirmation_msg,"Invoice has been created");

            closedriver();
            softAssert.assertAll();

        } catch (InterruptedException e) {
        }
    }

    @Then("verify if the invoice is searched accordingly")
    public void verifyIfTheInvoiceIsSearchedAccordingly() throws InterruptedException {
        Thread.sleep(1000);

        xpath = "//*[@id=\"inv_tableData\"]/tbody/tr[1]/td[6]";
        String s = getTextbyXpath(xpath);
        Boolean isfound = false;

        if (s.contains(Invoices.SearchInfo)) {
            isfound = true;
        }
        softAssert.assertTrue(isfound);

        closedriver();
        softAssert.assertAll();
    }

    @When("Gather the orders information")
    public void gatherTheOrdersInformation() throws InterruptedException, ParseException {
        Thread.sleep(1000);
        //view 100 rows per page
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/div/button";
        clickbyxpath(xpath);
        Thread.sleep(10);
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/div/div[2]/div/a[4]";
        clickbyxpath(xpath);
        Thread.sleep(4000);

        //object of SimpleDateFormat class
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        date1 = sdf.parse(getregularLastMonth());
        date2 = sdf.parse("13/12/2023");

        //check the date
        WebElement table = driver.findElement(By.id("tableData"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        String dlv_stat;
        // Iterate through rows
        for (int i = 0; i < rows.size(); i++) {
//            WebElement row = rows.get(i);
            date2 = sdf.parse(getTextbyXpath("//*[@id=\"tableData\"]/tbody/tr[" + (i + 1) + "]/td[4]"));
            dlv_stat = getTextbyXpath("//*[@id=\"tableData\"]/tbody/tr[" + (i + 1) + "]/td[8]");
            if (date1.compareTo(date2) > 0 && !Objects.equals(dlv_stat, "Delivered")) {       //date1 comes after date2
                //copy the order number
                xpath = "//*[@id=\"tableData\"]/tbody/tr[" + (i + 1) + "]/td[2]";
                orderNum = getTextbyXpath(xpath);
                break;
            }
            if (orderNum == null && (i + 1) == rows.size()) {
                i = 0;
                //click the next button
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("tableData_next")));
                // Scroll the element into view using JavaScript
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
                Thread.sleep(900);
                nextButton.click();
                Thread.sleep(4000);
            }
        }
        System.out.println(sdf.format(date1) + " is the date range || " + sdf.format(date2) + " is the order date || the order number is " + orderNum);
    }

    @When("check if the orders that are created after the selected date are not visible, while creating an invoice,")
    public void checkIfTheOrdersThatAreCreatedAfterTheSelectedDateAreNotVisibleWhileCreatingAnInvoice() throws InterruptedException {

        //now set the date and order for
        Click_from_leftSideBar("Distributor Invoices");
        Thread.sleep(1000);

        //click the create new button
        xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
        clickbyxpath(xpath);

        Thread.sleep(500);

        //set date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        SimpleDateFormat dtf = new SimpleDateFormat("MM/dd/yyyy");

        String date = dtf.format(date2);
        Setaday(xpath, date);

        //the order should not be visible today
        Thread.sleep(3000);


        // Find the dropdown element by its ID
        WebElement dropdown = driver.findElement(By.id("order_list"));
        // Click on the dropdown to open the options
//        dropdown.click();
        // Find all the options within the dropdown
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        // Flag to track if the desired option is found
        boolean found = false;
        // Iterate over each option to check if it contains the desired text
        for (WebElement option : options) {
            if (option.getText().contains(orderNum)) {
                found = true;
                break;
            }
        }

        softAssert.assertFalse(found);
        closedriver();
        softAssert.assertAll();
    }


    @When("check if the invoice can be created without selecting a store")
    public void checkIfTheInvoiceCanBeCreatedWithoutSelectingAStore() throws InterruptedException {
        Thread.sleep(1000);

        //click the create new button
        xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
        clickbyxpath(xpath);

        Thread.sleep(500);

        //set the date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        SetToday(xpath);

        //order list
        xpath = "//*[@id=\"select2-order_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, Invoices.DistributorSearch);
        cssSelectorPressEnter(cssSelector);

        //dont select store

        //click the save button
        Boolean save_visible = false;
        WebElement savebutton = driver.findElement(By.id("loading_save"));

        // Check if the save button is displayed or not based on the visibility of the div
        if (savebutton.isDisplayed()) {
            save_visible = true;
            System.out.println("Save button is displayed.");
        } else {
            System.out.println("Save button is not displayed.");
        }

        softAssert.assertFalse(save_visible);
        closedriver();
        softAssert.assertAll();
    }

    @And("verify the calculation of prices for an invoice")
    public void verifyTheCalculationOfPricesForAnInvoice() {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);

            //select the store
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);

            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.Store);
            cssSelectorPressEnter(cssSelector);


            //partial invoice or full invoice
            Boolean partialInvoice = false;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                if (partialInvoice == true && i % 2 == 0) {
                    //CTN
                    Thread.sleep(20);
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted
                }
            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                String rowClass = getAttributeByXpath("//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]", "class");
                if (!rowClass.equals("d-none")) {
                    //get price/ctn
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                    double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                    //get ctn count
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                    double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                    gtCacl[i][0] = s1;
                    gtCacl[i][1] = s2;
                    System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
                }else {
                    gtCacl[i][0] = 0;
                    gtCacl[i][1] = 0;
                }
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);
            softAssert.assertEquals(grandTotalVisible, grandTotalActual);


            //get total payable from interface
            xpath = "//*[@id=\"c_total_payable\"]";
            String sd = getTextAttributebyXpath(xpath);
            System.out.println(sd + " : is the Total payable");

            closedriver();
            softAssert.assertAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("verify the creation of invoice")
    public void verifyTheCreationOfInvoice() throws InterruptedException {
        Thread.sleep(5000);

        confirmation_msg = GetConfirmationMessage();


    }

    @And("create a new Invoice with no products in it and verify that it is not created")
    public void createANewInvoiceWithNoProductsInItAndVerifyThatItIsNotCreated() {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //if order does not have minimum rows visible for invoice then change the order


            //select the store
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);

            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.Store);
            cssSelectorPressEnter(cssSelector);


            //partial invoice or full invoice
            Boolean partialInvoice = Invoices.PartialInvoice;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                int k  = Integer.parseInt(getTextAttributebyXpath(xpath));
//                if ((partialInvoice == true && i % 2 == 0 )&& k > Integer.parseInt(Invoices.ItemQuantity)) {
                    //CTN
                    Thread.sleep(20);
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    inputbyxpath(xpath, "0"); //here the number is the quantity that will be deleted

//                //PCS(not necessary)
//                Thread.sleep(20);
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted

            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);


            Thread.sleep(200);
            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("the found " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
//                        Thread.sleep(700);
//                        String xpath = "//*[@id=\"showCtn" + (i + 1) + "\"]";
//                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
//                        System.out.println("Default offer quantity is " + quantity + " ctn");
//                        if (quantity > Integer.parseInt(Invoices.OfferCTN)) {
//                            waitByxpath(xpath);
//                            Thread.sleep(300);
//                            clearByXpath(xpath);
//                            inputbyxpath(xpath, (Invoices.OfferCTN));
//                        }
                    }
                }
            }

//            //For Screen Shot
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(100);
//                PageUp();
//            }
//            TakeScreenShot();
//            PageDown();
//            TakeScreenShot();


            //wait for a defined period of time
            Thread.sleep(Invoices.IntervalOfSaveTime);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);


            AlertAccept();
            PrintConfirmationMessage();

            //verify the creation of the invoice
            confirmation_msg = GetConfirmationMessage();
            softAssert.assertNotEquals(confirmation_msg,"Invoice has been created");

            closedriver();
            softAssert.assertAll();

        } catch (InterruptedException e) {
        }
    }

    @And("creation of an invoice where the product quantity is greater than the order quantity or the stock quantity is less than the invoice quantity")
    public void creationOfAnInvoiceWhereTheProductQuantityIsGreaterThanTheStockQuantity() {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            Thread.sleep(5000);
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //if order does not have minimum rows visible for invoice then change the order


            //select the store
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);

            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.Store);
            cssSelectorPressEnter(cssSelector);


            //partial invoice or full invoice
            Boolean partialInvoice = Invoices.PartialInvoice;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                int k  = Integer.parseInt(getTextAttributebyXpath(xpath));
//                if ((partialInvoice == true && i % 2 == 0 )&& k > Integer.parseInt(Invoices.ItemQuantity)) {
                //CTN
                Thread.sleep(20);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, "9999999"); //here the number is the quantity that will be deleted

//                //PCS(not necessary)
//                Thread.sleep(20);
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted

            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);


            Thread.sleep(200);
            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("the found " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
//                        Thread.sleep(700);
//                        String xpath = "//*[@id=\"showCtn" + (i + 1) + "\"]";
//                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
//                        System.out.println("Default offer quantity is " + quantity + " ctn");
//                        if (quantity > Integer.parseInt(Invoices.OfferCTN)) {
//                            waitByxpath(xpath);
//                            Thread.sleep(300);
//                            clearByXpath(xpath);
//                            inputbyxpath(xpath, (Invoices.OfferCTN));
//                        }
                    }
                }
            }

//            //For Screen Shot
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(100);
//                PageUp();
//            }
//            TakeScreenShot();
//            PageDown();
//            TakeScreenShot();


            //wait for a defined period of time
            Thread.sleep(Invoices.IntervalOfSaveTime);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            AlertAccept();

        } catch (InterruptedException e) {
            System.out.println("There was an exception that is caught");
        }
    }

    @Then("verify that the invoice is not created")
    public void verifyThatTheInvoiceIsNotCreated() throws InterruptedException {
        //the invoice won't be saved and there won't be a confirmation message
        Boolean popUpVisible = false;
        // Wait for the confirmation message to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("swal2-popup")));

        // Check if the confirmation message is visible
        if (confirmationMessage.isDisplayed()) {
            popUpVisible = true;
        }
        softAssert.assertFalse(popUpVisible);

        closedriver();
        softAssert.assertAll();
    }

    @And("creation of an invoice where the product quantity is zero as a total")
    public void creationOfAnInvoiceWhereTheProductQuantityIsAsATotal() {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            Thread.sleep(5000);
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //if order does not have minimum rows visible for invoice then change the order


            //select the store
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);

            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.Store);
            cssSelectorPressEnter(cssSelector);


            //partial invoice or full invoice
            Boolean partialInvoice = Invoices.PartialInvoice;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                int k  = Integer.parseInt(getTextAttributebyXpath(xpath));
//                if ((partialInvoice == true && i % 2 == 0 )&& k > Integer.parseInt(Invoices.ItemQuantity)) {
                //CTN
                Thread.sleep(20);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, "0"); //here the number is the quantity that will be deleted

//                //PCS(not necessary)
//                Thread.sleep(20);
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted

            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);


            Thread.sleep(200);
            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("the found " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
//                        Thread.sleep(700);
//                        String xpath = "//*[@id=\"showCtn" + (i + 1) + "\"]";
//                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
//                        System.out.println("Default offer quantity is " + quantity + " ctn");
//                        if (quantity > Integer.parseInt(Invoices.OfferCTN)) {
//                            waitByxpath(xpath);
//                            Thread.sleep(300);
//                            clearByXpath(xpath);
//                            inputbyxpath(xpath, (Invoices.OfferCTN));
//                        }
                    }
                }
            }

//            //For Screen Shot
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(100);
//                PageUp();
//            }
//            TakeScreenShot();
//            PageDown();
//            TakeScreenShot();


            //wait for a defined period of time
            Thread.sleep(Invoices.IntervalOfSaveTime);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            AlertAccept();

        } catch (InterruptedException e) {
            System.out.println("There was an exception that is caught");
        }
    }

    @And("creation of an invoice with no store selected")
    public void creationOfAnInvoiceWithNoStoreSelected() throws InterruptedException {
        try {
            //click the create new button
            xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //set date
            xpath = "//*[@id=\"c_actual_inv_date\"]";
            waitByxpath(xpath);
            SetToday(xpath);

            //order list
            Thread.sleep(5000);
            xpath = "//*[@id=\"select2-order_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            //search for bhai bhai and hit enter
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Invoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


            //don't select the store



            //partial invoice or full invoice
            Boolean partialInvoice = Invoices.PartialInvoice;

            for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                int k  = Integer.parseInt(getTextAttributebyXpath(xpath));
//                if ((partialInvoice == true && i % 2 == 0 )&& k > Integer.parseInt(Invoices.ItemQuantity)) {
                //CTN
                Thread.sleep(20);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, "0"); //here the number is the quantity that will be deleted

//                //PCS(not necessary)
//                Thread.sleep(20);
//                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                waitByxpath(xpath);
//                clearByXpath(xpath);
//                inputbyxpath(xpath, Invoices.ItemQuantity); //here the number is the quantity that will be deleted

            }

            //notes
            id = "c_notes";
            inputbyid(id, Invoices.Note);


            //calculate the grand total


            int itemsRowSize = getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]");
            double[][] gtCacl = new double[itemsRowSize][2];
            for (int i = 0; i < itemsRowSize; i++) {
                //get price/ctn
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                double s1 = Double.parseDouble(getTextAttributebyXpath(xpath));
                //get ctn count
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[4]/input";
                double s2 = Double.parseDouble(getTextAttributebyXpath(xpath));

                gtCacl[i][0] = s1;
                gtCacl[i][1] = s2;
                System.out.println(gtCacl[i][0] + " * " + gtCacl[i][1] + " = " + gtCacl[i][0] * gtCacl[i][1]);
            }
            double grandTotalActual = GrandTotalCalc(gtCacl);
            double grandTotalVisible = Double.parseDouble(getTextAttributebyXpath("//*[@id=\"c_grand_total\"]"));
            System.out.println("Visible Grand Total = " + grandTotalVisible + newLine + "Actual Grand Total = " + grandTotalActual);


            Thread.sleep(200);
            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("the found " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
//                        Thread.sleep(700);
//                        String xpath = "//*[@id=\"showCtn" + (i + 1) + "\"]";
//                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
//                        System.out.println("Default offer quantity is " + quantity + " ctn");
//                        if (quantity > Integer.parseInt(Invoices.OfferCTN)) {
//                            waitByxpath(xpath);
//                            Thread.sleep(300);
//                            clearByXpath(xpath);
//                            inputbyxpath(xpath, (Invoices.OfferCTN));
//                        }
                    }
                }
            }

//            //For Screen Shot
//            for (int i = 0; i < 5; i++) {
//                Thread.sleep(100);
//                PageUp();
//            }
//            TakeScreenShot();
//            PageDown();
//            TakeScreenShot();


            //wait for a defined period of time
            Thread.sleep(Invoices.IntervalOfSaveTime);

            //save
            xpath = "//*[@id=\"add_region\"]";
            Boolean saveVisible = IsVisibleByXpath(xpath);
            softAssert.assertFalse(saveVisible);

            closedriver();
            softAssert.assertAll();

        } catch (InterruptedException e) {
            System.out.println("There was an exception that is caught");
        }
    }
}
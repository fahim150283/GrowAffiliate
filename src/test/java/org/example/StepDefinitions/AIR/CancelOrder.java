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
import org.testng.asserts.SoftAssert;

import java.util.Objects;

public class CancelOrder extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    public static String CancelNo;

    @Given("Login to Search CancelOrder")
    public void login_to_search_cancel_order() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Cancel Order");
    }

    @When("search for CancelOrder")
    public void search_for_cancel_order() throws InterruptedException {
        try {
            Thread.sleep(2000);
            xpath = "//*[@id=\"tableData_filter\"]/label/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, CancelOrder.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a cancelled Order")
    public void description_of_a_order_to_cancel() {
        try {
            id = "btn_view";
            waitById(id);
            clickbyId(id);

            Thread.sleep(1000);

            Boolean isfound = false;
            xpath = "//*[@id=\"add_invoice_form\"]/div/div/div[2]/h4/u";
            String s = getTextbyXpath(xpath);
            if (s.contains("Cancel Order")) {
                isfound = true;
            }
            softAssert.assertTrue(isfound);

            closedriver();
            softAssert.assertAll();
        } catch (TimeoutException | InterruptedException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Given("login for Cancelling a Order")
    public void login_for_creating_new_order_to_cancel() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Cancel Order");
    }

    @And("create new regular Cancel Order")
    public void create_new_regular_order_to_cancel() throws InterruptedException {
        try {
            //click the create new cancel order button
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
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
            inputbycssselector(cssSelector, CancelOrder.DistributorSearch);
            cssSelectorPressEnter(cssSelector);

            Thread.sleep(1500);

            //partial cancel or full cancel
            Boolean PartialCancel = false;

            if (PartialCancel == true) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                    if (i % 2 == 0) {
                        //CTN
                        Thread.sleep(20);
                        xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                        waitByxpath(xpath);
                        clearByXpath(xpath);
                        inputbyxpath(xpath, CancelOrder.ItemQuantity); //here the number is the quantity that will be deleted

//                    //PCS
//                    Thread.sleep(20);
//                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                    waitByxpath(xpath);
//                    clearByXpath(xpath);
//                    inputbyxpath(xpath, CancelOrder.ItemQuantity); //here the number is the quantity that will be deleted
                    }
                }
            }
            //important notes
            id = "c_notes";
            inputbyid(id, CancelOrder.Note);

            //calculate the grand total
            Thread.sleep(500);

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


            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                System.out.println("offer part is available");
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        //for the offer:products
//                    List<WebElement> rowsWithDropdowns = driver.findElements(By.xpath("//tbody[@id='tbl_data']/tr[td/select]"));
//                        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dis_product" + (1+ i) + "\"]"));
//                        Select dropdown = new Select(dropdownElement);
//                        dropdown.selectByIndex(1);

                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement1 = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown1 = new Select(dropdownElement1);
                            dropdown1.selectByIndex(1);
                        } catch (org.openqa.selenium.NoSuchElementException e) {
                            continue;
                        }
                    }
                }
            }

            //get the cancel no for future search
            xpath = "//*[@id=\"c_inv_number\"]";
            CancelNo = getTextbyXpath(xpath);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            Thread.sleep(100);

            AlertAccept();
            softAssert.assertEquals(GetConfirmationMessage(), "Order Cancelled");

            closedriver();
            softAssert.assertAll();
        } catch (InterruptedException | TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("Verify that the cancel order is searched accordingly")
    public void verifyThatTheCancelOrderIsSearchedAccordingly() throws InterruptedException {
        Thread.sleep(200);

        xpath = "//*[@id=\"tableData\"]/tbody/tr[1]/td[5]";
        String s = getTextbyXpath(xpath);
        Boolean isfound = false;

        if (s.contains(CancelOrder.SearchInfo)) {
            isfound = true;
        }

        softAssert.assertTrue(isfound);

        closedriver();
        softAssert.assertAll();
    }

    @And("create new partial Cancel Order")
    public void createNewPartialCancelOrder() {
        try {
            //click the create new cancel order button
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
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
            inputbycssselector(cssSelector, CancelOrder.DistributorSearch);
            cssSelectorPressEnter(cssSelector);

            Thread.sleep(1500);

            //partial cancel or full cancel
            Boolean PartialCancel = true;

            if (PartialCancel == true) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {

                    //CTN
                    Thread.sleep(20);
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                    int s = Integer.parseInt(getTextAttributebyXpath(xpath));
                    waitByxpath(xpath);
                    if (s > Integer.parseInt(CancelOrder.ItemQuantity)) {
                        clearByXpath(xpath);
                        inputbyxpath(xpath, CancelOrder.ItemQuantity); //here the number is the quantity that will be deleted}
                    }

//                    //PCS
//                    Thread.sleep(20);
//                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                    waitByxpath(xpath);
//                    clearByXpath(xpath);
//                    inputbyxpath(xpath, CancelOrder.ItemQuantity); //here the number is the quantity that will be deleted
                }
            }

            //important notes
            id = "c_notes";
            inputbyid(id, CancelOrder.Note);

            //calculate the grand total
            Thread.sleep(500);

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


            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                System.out.println("offer part is available");
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        //for the offer:products
//                    List<WebElement> rowsWithDropdowns = driver.findElements(By.xpath("//tbody[@id='tbl_data']/tr[td/select]"));
//                        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dis_product" + (1+ i) + "\"]"));
//                        Select dropdown = new Select(dropdownElement);
//                        dropdown.selectByIndex(1);

                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement1 = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown1 = new Select(dropdownElement1);
                            dropdown1.selectByIndex(1);
                        } catch (org.openqa.selenium.NoSuchElementException e) {
                            continue;
                        }
                    }
                }
            }

            //get the cancel no for future search
            xpath = "//*[@id=\"c_inv_number\"]";
            CancelNo = getTextbyXpath(xpath);

            //save
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);
            Thread.sleep(100);

            AlertAccept();
            softAssert.assertEquals(GetConfirmationMessage(), "Order Cancelled");

            closedriver();
            softAssert.assertAll();
        } catch (InterruptedException | TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @When("check the price calculation of cancel order")
    public void checkThePriceCalculationOfCancelOrder() {
        try {
            //click the create new cancel order button
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
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
            inputbycssselector(cssSelector, CancelOrder.DistributorSearch);
            cssSelectorPressEnter(cssSelector);

            Thread.sleep(1500);

            //partial cancel or full cancel
            Boolean PartialCancel = true;

            if (PartialCancel == true) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
                    if (i % 2 == 0) {
                        //CTN
                        Thread.sleep(20);
                        xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                        waitByxpath(xpath);
                        clearByXpath(xpath);
                        inputbyxpath(xpath, CancelOrder.ItemQuantity); //here the number is the quantity that will be deleted

//                    //PCS
//                    Thread.sleep(20);
//                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
//                    waitByxpath(xpath);
//                    clearByXpath(xpath);
//                    inputbyxpath(xpath, CancelOrder.ItemQuantity); //here the number is the quantity that will be deleted
                    }
                }
            }


            //calculate the grand total
            //important notes
            id = "c_notes";
            inputbyid(id, CancelOrder.Note);


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

            closedriver();
            softAssert.assertAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


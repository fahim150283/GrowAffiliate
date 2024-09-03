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

import java.util.Objects;

public class PreInvoice extends Page_Options {


    @Given("^Login to Search PreInvoice$")
    public void login_for_accessing_pre_invoice() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Pre Invoices");
    }

    @When("search for preInvoice")
    public void search_for_pre_invoice() {
        try {
            xpath = "//*[@id=\"tableData_filter\"]/label/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, PreInvoices.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a preinvoice")
    public void description_of_a_preinvoice() throws InterruptedException {
        try {
            Thread.sleep(1000);
            id = "btn_view";
            waitById(id);
            clickbyId(id);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("^close PreInvoice for search$")
    public void closePreInvoice() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

    @Given("login for creating new preInvoice")
//    @Test
    public void login_for_creating_new_pre_invoice() throws InterruptedException {

        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Pre Invoices");
    }

    @Given("^create new preInvoice$")
    public void create_new_pre_invoice() throws InterruptedException {
        try {
            Thread.sleep(2000);
            //click the create new pre invoice
            xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
            clickbyxpath(xpath);
            //pre Invoice date
            xpath = "//*[@id=\"c_ord_date\"]";
            //waitByxpath(xpath);
            clickbyxpath(xpath);
            inputbyxpath(xpath, getToday());

            Thread.sleep(2000);

            //wait and click distributors
            id = "select2-distributor_list-container";
            waitById(id);
            clickbyId(id);
            //search for bhai bhai and hit enter
            cssSelector = ".select2-search--dropdown > .select2-search__field";
            inputbycssselector(cssSelector, PreInvoices.DistributorSearch);
            cssSelectorPressEnter(cssSelector);


//        //wait and click routes
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[2]/div[3]/span";
//        Thread.sleep(2000);
//        clickbyxpath(xpath);
////      //select the first route
////        xpath = "//*[@id=\"select2-c_routes_list-result-4ofp-5\"]";
//        pressDownbyXpath(xpath);
//        pressEnterbyXpath(xpath);
//        //wait and click outlet
//        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[1]/div[4]/span/span[1]/span";
//        waitByxpath(xpath);
//        clickbyxpath(xpath);
//        }

            //click the checkbox for regular or pending
            if (Objects.equals(PreInvoices.CheckBox, "Regular")) {
                xpath = "//*[@id=\"pre_regular\"]";
                WebElement RegularCheckbox = driver.findElement(By.id("pre_regular"));
                if (!RegularCheckbox.isSelected()) {
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                }
            } else if (Objects.equals(PreInvoices.CheckBox, "Pending")) {
                xpath = "//*[@id=\"pre_pending\"]";
                WebElement PendingCheckbox = driver.findElement(By.id("pre_ending"));
                if (!PendingCheckbox.isSelected()) {
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                }
            }

            //pre Invoice date
            xpath = "//*[@id=\"c_exp_delivery_date\"]";
            clickbyxpath(xpath);
            inputbyxpath(xpath, getToday());

            //cash commission
            xpath = "//*[@id=\"c_cash_com\"]";
            clearByXpath(xpath);
            inputbyxpath(xpath, PreInvoices.CashCommission);

            Thread.sleep(1000);
            //click the items bar and add 15 items
            for (int i = 0; i < PreInvoices.Items.length; i++) {
                xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[4]/div[6]/span/span[1]/span";
                Thread.sleep(10);
                inputbyxpath(xpath, PreInvoices.Items[i]);
                Thread.sleep(10);
                pressEnterbyXpath(xpath);
                Thread.sleep(10);

                // press the plus button
                id = "c_add_inv_prod";
                clickbyId(id);
            }
            System.out.println(PreInvoices.Items.length);


            //click the amount buttons for the quantity of the items
            for (int i = 0; i < PreInvoices.Items.length; i++) {
                //ctn(quantity)
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, PreInvoices.ItemQuantity);
                //pcs(quantity)
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[6]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, PreInvoices.ItemQuantity);
                //ctn(COMP)
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[9]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, PreInvoices.ItemQuantity);
                //pcs(COMP)
                xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[10]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, PreInvoices.ItemQuantity);
            }

            Thread.sleep(1000);
            //remove an item
            WebElement table = driver.findElement(By.id("c_inv_items_list"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                if (i % 5 == 0) {
                    // Find and click the "delete" button for the visible row
                    WebElement delete_Button = row.findElement(By.id("delete_table_row"));
                    delete_Button.click();
                    rows = table.findElements(By.xpath(".//tr"));
                }
            }


            //offer part
            if (ElementVisible("//*[@id=\"tbl_data\"]")) {
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"tbl_data\"]"); i++) {
                    String s = getTextbyXpath("//tbody[@id='tbl_data']/tr[" + (i + 1) + "]/td[3]");
                    System.out.println("this is the found string: " + s);
                    if (Objects.equals(s, "Offer Type: Product")) {
                        String dropdownXpath = "//*[@id='tbl_data']/tr[" + (i + 1) + "]/td[5]//select";
                        //Selecting the dropdown options only for where available
                        try {
                            WebElement dropdownElement = driver.findElement(By.xpath(dropdownXpath));
                            Select dropdown = new Select(dropdownElement);
                            dropdown.selectByIndex(1);
                        } catch (org.openqa.selenium.NoSuchElementException e) {
                            continue;
                        }

                        //Quantity CTN
                        Thread.sleep(200);
                        String xpath = "//*[@id=\"tbl_data\"]/tr[" + (i + 1) + "]/td[6]/input[1]";
                        int quantity = Integer.parseInt(getTextAttributebyXpath(xpath));
                        if (quantity > Integer.parseInt(PreInvoices.OfferCTN)) {
                            waitByxpath(xpath);
                            Thread.sleep(300);
                            clearByXpath(xpath);
                            inputbyxpath(xpath, (PreInvoices.OfferCTN));
                        }
                    }
                }
            }

            //notes
            id = "c_notes";
            inputbyid(id, PreInvoices.Notes);

            //Save
            Thread.sleep(3000);
            xpath = "//*[@id=\"add_region\"]";
            clickbyxpath(xpath);

            //Click ok button in the alert
            AlertAccept();
            PrintConfirmationMessage();


        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the PreInvoice window")
    public void close_the_pre_invoice_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }

}
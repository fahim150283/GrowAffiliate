package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GoodsRequisition extends Page_Options {
    @Given("login for creation of a Goods Requisition")
    public void login_for_creation_of_a_goods_requisition() throws InterruptedException {
        Login_AIR2(Users.user_Polash);
        Click_from_leftSideBar("Goods Requisition");
    }

    @And("create new Goods Requisition")
    public void create_new_goods_requisition() throws InterruptedException {
        try {
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //date and time
            id = "requested_on";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getTodaynTime());

            //send request from
            id = "select2-req_from-container";
            waitById(id);
            clickbyId(id);
            //search for comilla and hit enter
            cssSelector = ".select2-search--dropdown > .select2-search__field";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, GROVS.RequestFrom);
            cssSelectorPressEnter(cssSelector);

            //send request to
            id = "select2-req_to-container";
            waitById(id);
            clickbyId(id);
            //search for factory
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, GROVS.RequestTo);
            pressEnterbyXpath(xpath);
            clickbyId(id);

            //click the items bar and add items
            for (int i = 0; i < GROVS.InvoiceItems.length; i++) {
                Thread.sleep(100);
                WebElement multiSelectDropdown = driver.findElement(By.id("goods_list"));
                Select dropdown = new Select(multiSelectDropdown);
                dropdown.selectByVisibleText(GROVS.InvoiceItems[i]);
            }
            xpath = "//*[@id=\"add_goods_table\"]";
            clickbyxpath(xpath);


            //click the amount buttons for the quantity of the items
            for (int i = 0; i < GROVS.InvoiceItems.length; i++) {
                //ctn(quantity)
                xpath = "//*[@id=\"fg_store_goods_table\"]/tr[" + (i + 1) + "]/td[5]/input[1]";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, GROVS.ItemQuantity);
                //pcs(quantity)
                xpath = "//*[@id=\"fg_store_goods_table\"]/tr[" + (i + 1) + "]/td[6]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, GROVS.ItemQuantity);
            }

            //remove an item
            WebElement table = driver.findElement(By.id("fg_store_goods_table"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                if (i % 5 == 0) {
                    // Find and click the "delete" button for the visible row
                    WebElement delete_Button = row.findElement(By.xpath("//*[@id=\"fg_store_goods_table\"]/tr[" + (i + 1) + "]/td[7]/button"));
                    delete_Button.click();
                }
            }

            //save
            xpath = "//button[@id='send_req_fg_store']";
            clickbyxpath(xpath);

            AlertAccept();
            PrintConfirmationMessage();
        } catch (
                TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Goods Requisition window")
    public void close_the_goods_requisition_window() throws InterruptedException {
        closedriver();
    }

    //cancel  a good requisition
    @Given("login for cancellation of a requested Goods Requisition")
    public void login_for_cancellation_of_a_requested_goods_requisition() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Goods Requisition");
    }

    @And("cancel the good requisition")
    public void cancel_the_good_requisition() throws InterruptedException {
        try {
            //click the eye button
            Thread.sleep(2000);
            xpath = "//*[@id=\"received_table\"]/tr[1]/td[2]/a";
            scrollTo_ByXpath(xpath);
            Thread.sleep(500);
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //cancel
            id = "cancel_permission_btn";
            clickbyId(id);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Goods Requisition window for the cancellation of the request")
    public void close_the_goods_requisition_window_for_the_cancellation_of_the_request() throws InterruptedException {
        closedriver();
    }

    //accept a good requisition
    @Given("login for accepting of a requested Goods Requisition")
    public void login_for_accepting_of_a_requested_goods_requisition() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Goods Requisition");
    }

    @And("Accept the good requisition")
    public void accept_the_good_requisition() throws InterruptedException {
        try {
            //click the eye button
            Thread.sleep(2000);
            xpath = "//*[@id=\"received_table\"]/tr[1]/td[2]/a";
            scrollTo_ByXpath(xpath);
            Thread.sleep(2000);
            waitByxpath(xpath);
            clickbyxpath(xpath);


            //accepted quantity
            Boolean acceptfull = false;
            if (acceptfull == false) {
                //click the amount buttons for the quantity of the items
                for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"rcv_pro_data\"]") - 2; i++) {
                    //ctn(quantity)
                    xpath = "//*[@id=\"rcv_pro_data\"]/tr[" + (i + 1) + "]/td[7]/p/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    inputbyxpath(xpath, GROVS.AcceptedQuantity);
                    //pcs(quantity)
                    xpath = "//*[@id=\"rcv_pro_data\"]/tr[" + (i + 1) + "]/td[8]/p/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    inputbyxpath(xpath, GROVS.AcceptedQuantity);
                }

                //Select a vehicle
                id = "select2-select_vehicle-container";
                waitById(id);
                clickbyId(id);
                //search for factory vehicle
                xpath = "/html/body/span/span/span[1]/input";
                waitByxpath(xpath);
                inputbyxpath(xpath, GROVS.Vehicle);
                pressEnterbyXpath(xpath);


                //accepted on date and time
                id = "approved_on";
                waitById(id);
                clickbyId(id);
                inputbyid(id, getTodaynTime());
                pressEnterById(id);

                //Click accept
                id = "accept_permission_btn";
                pressEnterById(id);
                PrintConfirmationMessage();
            }
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Goods Requisition window for accepting the request")
    public void close_the_goods_requisition_window_for_accepting_the_request() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }

    //vehicle load
    @Given("login for vehicle load for a requested Goods Requisition")
    public void login_for_vehicle_load_for_a_requested_goods_requisition() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("On Vehicle Store");
    }

    @And("vehicle load for the good requisition")
    public void vehicle_load_for_the_good_requisition() throws InterruptedException {
        try {
            //select a requisition
            xpath = "//*[@id=\"sent_view2\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //vehicle status
            id = "vehicle_status";
            waitById(id);
            pressDownbyid(id);

            //date
            id = "load_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, "literally anything");
            pressEnterById(id);

            //click save
            id = "send_req_fg_store";
            waitById(id);
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Goods Requisition window for vehicle load")
    public void close_the_goods_requisition_window_for_vehicle_load() throws InterruptedException {
        closedriver();
    }

    //Vehicle unload
    @Given("login for vehicle unload for a requested Goods Requisition")
    public void login_for_vehicle_unload_for_a_requested_goods_requisition() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("On Vehicle Store");
    }

    @And("vehicle unload for the good requisition")
    public void vehicle_unload_for_the_good_requisition() throws InterruptedException {
        try {
            //select a requisition
            xpath = "//*[@id=\"sent_view2\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //vehicle status
            id = "vehicle_status";
            waitById(id);
            pressDownbyid(id);

            //date
            id = "load_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, "literally anything");
            pressEnterById(id);

            //click save
            id = "send_req_fg_store";
            waitById(id);
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Goods Requisition window for vehicle unload")
    public void close_the_goods_requisition_window_for_vehicle_unload() throws InterruptedException {
        closedriver();
    }

    @Given("login for Receiving The Goods")
    public void login_for_receiving_the_goods() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("On Vehicle Store");
    }

    @And("Receive The Goods")
    public void receive_the_goods() throws InterruptedException {
        try {
            //click the eye button
            id = "sent_view1";
            waitById(id);
            clickbyId(id);

            //set date
            id = "load_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, "literally anything");
            pressEnterById(id);

            //click receive button
            xpath = "//*[@id=\"accept_permission_btn\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Goods Requisition window for receiving goods")
    public void close_the_goods_requisition_window_for_receiving_goods() throws InterruptedException {
        closedriver();
    }
}

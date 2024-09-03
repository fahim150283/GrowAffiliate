package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoadingSheet extends Page_Options {

    /*
    Creating a new loading sheet
    */
    @Given("login for creating new  Loading sheet")
    public void login_for_creating_new_loading_sheet() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Loading Sheet");
    }

    @When("create new Loading sheet")
    public void create_new_loading_sheet() throws InterruptedException {
        Thread.sleep(2000);

        //click the create new button
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
        clickbyxpath(xpath);

        Boolean LoadFromStore = false;

        if (LoadFromStore == false) {
            //click load from
            id = "select2-req_from_store-container";
            waitById(id);
            clickbyId(id);
            //search for store or vehicle
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, "4440");
            Thread.sleep(300);
            pressEnterbyXpath(xpath);

            //click load to
            id = "select2-req_to-container";
            waitById(id);
            clickbyId(id);
            //search for store or vehicle
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, "depot store");
            Thread.sleep(300);
            pressEnterbyXpath(xpath);
        } else {
            //click load from
            id = "select2-req_from_store-container";
            waitById(id);
            clickbyId(id);
            //search for store or vehicle
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, "depot store");
            Thread.sleep(300);
            pressEnterbyXpath(xpath);

            //click load to
            id = "select2-req_to-container";
            waitById(id);
            clickbyId(id);
            //search for store or vehicle
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, "4440");
            Thread.sleep(300);
            pressEnterbyXpath(xpath);
        }

        //load start date
        id = "load_start_date";
        inputbyid(id, getlastMonthAndTime());


        //load start date
        id = "load_end_date";
        inputbyid(id, getTodaynTime());

        //SR
        id = "select2-sr_id-container";
        clickbyId(id);
        //search for SR
        xpath = "/html/body/span/span/span[1]/input";
        inputbyxpath(xpath, "siam");
        pressEnterbyXpath(xpath);
        clickbyId(id);

        //driver name
        xpath = "//*[@id=\"driver_name\"]";
        inputbyxpath(xpath, "Test Driver");

        //goods
        // Select an option by its visible text
        WebElement dropdownElement = driver.findElement(By.id("goods_list"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("88083 ~~ Mini ikone - Chocolate -- 72.00ml (MINI -- CONE)");
        dropdown.selectByVisibleText("88162 ~~ Crunchie Bar - Mini -- 52.00ml (MINI -- STICK)");
        dropdown.selectByVisibleText("88086 ~~ ikone - Chocolate -- 121.00ml (REGULAR -- CONE)");
        dropdown.selectByVisibleText("88084 ~~ ikone - Vanilla -- 121.00ml (REGULAR -- CONE)");

        //click the plus(+) button
        xpath = "//*[@id=\"add_goods_table\"]";
        clickbyxpath(xpath);

        //set load quantity for ctn
        for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"fg_store_goods_table\"]"); i++) {
            xpath = "//*[@id=\"fg_store_goods_table\"]/tr["+(i+1)+"]/td[5]/input[1]";
            clearByXpath(xpath);
            inputbyxpath(xpath,"20");
        }

        //set load quantity for pcs
        for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"fg_store_goods_table\"]"); i++) {
            xpath = "//*[@id=\"fg_store_goods_table\"]/tr["+(i+1)+"]/td[6]/input";
            clearByXpath(xpath);
            inputbyxpath(xpath,"20");
        }

        //save
        xpath = "//button[@id='send_req_fg_store']";
        clickbyxpath(xpath);
        PrintConfirmationMessage();
    }

    @Then("close driver for creating Loading sheet")
    public void close_driver_for_creating_loading_sheet() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }

    /*
    view a loading sheet
    */
    @Given("login for viewing new  Loading sheet")
    public void login_for_viewing_new_loading_sheet() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Loading Sheet");
    }
    @When("Search for a loading sheet")
    public void search_for_a_loading_sheet() throws InterruptedException {
        Thread.sleep(300);
        xpath = "//*[@id=\"search_input\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        inputbyxpath(xpath,"10-10-2023 02:47 PM");


    }
    @When("Click the view button of the loading sheet")
    public void click_the_view_button_of_the_loading_sheet() {
        // click the edit button of the displayed product
        WebElement table = driver.findElement(By.id("sent_table"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement view_Button = row.findElement(By.id("btn_view"));
                view_Button.click();
            }
        }
    }
    @Then("close driver for viewing a Loading sheet after printing it")
    public void close_driver_for_viewing_a_loading_sheet() throws InterruptedException {
        Thread.sleep(1000);
        xpath = "//*[@id=\"print_div\"]/form/button";
        clickbyxpath(xpath);
        Thread.sleep(1500);
        closedriver();
    }


    /*
    print the loading sheets
    */
    @Given("login for printing new  Loading sheet")
    public void login_for_printing_new_loading_sheet() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Loading Sheet");
    }
    @Given("Click the print button of the loading sheet")
    public void click_the_print_button_of_the_loading_sheet() throws InterruptedException {
        Thread.sleep(2000);
        xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[1]";
        clickbyxpath(xpath);
    }
    @Then("close driver for printing Loading sheets")
    public void close_driver_for_printing_loading_sheets() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }
}

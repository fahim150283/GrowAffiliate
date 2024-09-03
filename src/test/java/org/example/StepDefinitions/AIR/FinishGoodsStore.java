package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class FinishGoodsStore extends Page_Options {

    public static String randomno = randomnumber() + "";

    @Given("Login to Search a FG Store")
    public void login_to_search_a_fg_store() throws InterruptedException {
        Login_AIR2(Users.user_Polash);

        Click_from_leftSideBar("Finish Goods Store");
    }

    @When("search for FG Store")
    public void search_for_fg_store() throws InterruptedException {
        try {
            Thread.sleep(1000);
            //search a FG store
            id = "search";
            waitById(id);
            inputbyid(id, FGS.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @When("description of a store and print")
    public void description_of_a_store() throws InterruptedException {
        try {
            WebElement table = driver.findElement(By.id("fg_store_table"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "delete" button for the visible row
                    WebElement delete_Button = row.findElement(By.id("btn_view"));
                    delete_Button.click();
                }
            }

            //print
            xpath = "//*[@id=\"print_area_store\"]/a";
            clickbyxpath(xpath);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close window for searching a FG Store")
    public void close_window_for_searching_a_fg_store() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }


    @Given("Login to edit a FG Store")
    public void login_to_edit_a_fg_store() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Finish Goods Store");
    }

    @When("search for a FG Store")
    public void search_for_a_fg_store() throws InterruptedException {
        try {
            Thread.sleep(1000);
            id = "search";
            waitById(id);
            inputbyid(id, FGS.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @When("edit a store")
    public void edit_a_store() throws InterruptedException {
        try {
            WebElement table = driver.findElement(By.id("fg_store_table"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (int i = 0; i < rows.size(); i++) {
                WebElement row = rows.get(i);
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "delete" button for the visible row
                    WebElement delete_Button = row.findElement(By.id("btn_edit"));
                    delete_Button.click();
                }
            }

            Thread.sleep(200);

            //fg store code
            id = "edit_code";
            clearById(id);
            inputbyid(id, FGS.EditedCode + randomno);

            //fg store name
            id = "edit_name";
            clearById(id);
            inputbyid(id, FGS.EditedName + randomno);

            String store = FGS.EditedType;
            System.out.println(store);

            if (Objects.equals(store, "Store")) {
                WebElement dropdownElement = driver.findElement(By.id("edit_type"));
                Select dropdown = new Select(dropdownElement);
                dropdown.selectByValue("Store");
            } else {
                WebElement dropdownElement = driver.findElement(By.id("edit_type"));
                Select dropdown = new Select(dropdownElement);
                dropdown.selectByValue("Vehicle");
            }

            //definition
            id = "edit_defination";
            clearById(id);
            inputbyid(id, FGS.EditedDefinition);

            //address
            id = "edit_address";
            clearById(id);
            inputbyid(id, FGS.EditedAddress);

            //Region
            id = "select2-edit_region-container";
            clickbyId(id);
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, FGS.Region);
            pressEnterbyXpath(xpath);

            //Depots
            id = "select2-edit_depot-container";
            clickbyId(id);
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, FGS.Region);
            pressEnterbyXpath(xpath);

            //status
            boolean active = true;
            System.out.println(active);
            Thread.sleep(200);
            if (active == true) {
                WebElement dropdownElement1 = driver.findElement(By.id("edit_status"));
                Select dropdown1 = new Select(dropdownElement1);
                dropdown1.selectByVisibleText("Active");
            } else {
                WebElement dropdownElement1 = driver.findElement(By.id("edit_status"));
                Select dropdown1 = new Select(dropdownElement1);
                dropdown1.selectByVisibleText("Inactive");
            }

            //save
            Thread.sleep(200);
            xpath = "//*[@id=\"edit_fg_store_form\"]/div/div[2]/div[6]/button";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close window for editing a FG Store")
    public void close_window_for_editing_a_fg_store() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


    @Given("Login to Create a FG Store")
    public void login_to_create_a_fg_store() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Finish Goods Store");
    }

    @Given("create a store new FG Store")
    public void create_a_store_new_fg_store() throws InterruptedException {
        try {
            Thread.sleep(1000);

            //click the plus button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[1]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            Thread.sleep(200);

            //store code
            id = "add_code";
            inputbyid(id, FGS.Code + randomno);

            //store name
            id = "add_name";
            inputbyid(id, FGS.Name + randomno);

            //type
            String store = FGS.Type;
            System.out.println(store);

            if (Objects.equals(store, "Store")) {
                WebElement dropdownElement = driver.findElement(By.id("type"));
                Select dropdown = new Select(dropdownElement);
                dropdown.selectByValue("Store");
            } else {
                WebElement dropdownElement = driver.findElement(By.id("type"));
                Select dropdown = new Select(dropdownElement);
                dropdown.selectByValue("Vehicle");
            }

            //definition
            id = "add_defination";
            clearById(id);
            inputbyid(id, FGS.Definition);

            //address
            id = "add_address";
            clearById(id);
            inputbyid(id, FGS.Address);

            //Region
            Thread.sleep(200);
            xpath = "//*[@id=\"select2-region_list-container\"]";
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, FGS.Region);
            pressEnterbyXpath(xpath);

            //Depot
            Thread.sleep(200);
            xpath = "//*[@id=\"add_fg_store_form\"]/div/div[2]/div[2]/span/span[1]/span";
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, FGS.Region);
            pressEnterbyXpath(xpath);

            //save
            id = "add_fg_store";
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close window for creating a FG Store")
    public void close_window_for_creating_a_fg_store() throws InterruptedException {
        closedriver();
    }

    @Given("Login to add products in a  FG Store")
    public void login_to_add_products_in_a_fg_store() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);

        Click_from_leftSideBar("Finish Goods Store");
    }

    @Given("Add goods to FG Store")
    public void add_goods_to_store() throws InterruptedException {
        try {
            Thread.sleep(1000);

            //click plus button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //select fg store
            xpath = "//*[@id=\"select2-fg_store_list-container\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            xpath = "/html/body/span/span/span[1]/input";
            inputbyxpath(xpath, FGS.StoreToAddProducts);
            pressEnterbyXpath(xpath);
            pressESCbyXpath(xpath);

            //click the items bar and add items
            Thread.sleep(1000);
            for (int i = 0; i < FGS.Items.length; i++) {
                Thread.sleep(10);
                WebElement multiSelectDropdown = driver.findElement(By.id("goods_list"));
                Select dropdown = new Select(multiSelectDropdown);
                dropdown.selectByVisibleText(FGS.Items[i]);
            }

            //click the plus button
            id = "add_goods_table";
            clickbyId(id);

            //click the amount buttons for the quantity of the items
            for (int i = 0; i < FGS.Items.length; i++) {
                //ctn(quantity)
                xpath = "//*[@id=\"fg_store_goods_table\"]/tr[" + (i + 1) + "]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, FGS.ItemQuantity);
                //pcs(quantity)
                xpath = "//*[@id=\"fg_store_goods_table\"]/tr[" + (i + 1) + "]/td[6]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, FGS.ItemQuantity);
            }

            Thread.sleep(100);

            //remove an item
            for (int i = 0; i < FGS.Items.length; i++) {
                if (i % 5 == 0) {
                    // Find and click the "delete" button for the visible row
                    xpath = "//*[@id=\"fg_store_goods_table\"]/tr[" + (i + 1) + "]/td[7]/button";
                    clickbyxpath(xpath);
                }
            }

            //click the save button
            xpath = "//*[@id=\"add_fg_store_pro_form\"]/div/div[3]/div[2]/button";
            clickbyxpath(xpath);

            AlertAccept();
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("Close driver for adding goods to FG Store")
    public void close_driver_for_adding_goods_to_fg_store() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}

package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class SalesReturn extends Page_Options {
    @Given("Login to Search Sales Return")
    public void login_to_search_sales_return() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Sales Return");
    }

    @When("search for Sales Return")
    public void search_for_sales_return() throws InterruptedException {
        try {
            Thread.sleep(1000);
            xpath = "//*[@id=\"search_input\"]";
            waitByxpath(xpath);
            inputbyxpath(xpath, SalesReturn.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("description of a Sales Return")
    public void description_of_a_sales_return() throws InterruptedException {
        try {
            Thread.sleep(2000);
            WebElement table = driver.findElement(By.xpath("//*[@id=\"invoice_table\"]"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    //verify name
                    WebElement element1 = row.findElement(By.id("btn_view"));
                    element1.click();
                }
            }
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close Sales Return")
    public void close_sales_return() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }


    @Given("login for creating Sales Return")
    public void login_for_creating_sales_return() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Sales Return");
    }

    @And("create new Sales Return")
    public void create_new_sales_return() throws InterruptedException {
        try {
            //click the plus button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            Thread.sleep(2000);

            // Invoice date from
            id = "invoice_date_from";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getLastMonth());
            Thread.sleep(1000);


            //Invoice date till
            id = "invoice_date_till";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getToday());
            Thread.sleep(200);

            //invoice list
            id = "select2-order_list-container";
            waitById(id);
            clickbyId(id);
            xpath = "//input[@type='search']";
            waitByxpath(xpath);
            inputbyxpath(xpath, SalesReturn.DistributorSearch);
            pressEnterbyXpath(xpath);

            //select the store
            Thread.sleep(1000);
            id = "select2-c_store_id-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, SalesReturn.Store);
            cssSelectorPressEnter(cssSelector);

            //Return Date
            id = "sales_return_date";
            inputbyid(id, getToday());

            //Important notes
            id = "c_notes";
            inputbyid(id, "Automated Test");


            //Full or partial return
            String s;
            if (Objects.equals(SalesReturn.FullReturn, "yes")) {
                WebElement table = driver.findElement(By.id("c_inv_items_list"));
                java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

                // Iterate through rows
                for (int i = 0; i < rows.size(); i++) {
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]";
                    s = String.valueOf(getText_double_byXpath(xpath));
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[9]/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    waitByxpath(xpath);
                    inputbyxpath(xpath, s);
                }
            } else {
                WebElement table = driver.findElement(By.id("c_inv_items_list"));
                java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));

                // Iterate through rows
                for (int i = 0; i < rows.size(); i++) {
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[5]";
                    s = String.valueOf(getText_double_byXpath(xpath) - 1);
                    xpath = "//*[@id=\"c_inv_items_list\"]/tr[" + (i + 1) + "]/td[9]/input";
                    waitByxpath(xpath);
                    clearByXpath(xpath);
                    waitByxpath(xpath);
                    inputbyxpath(xpath, s);
                }
            }
            id = "add_region";
            waitById(id);
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Sales Return window")
    public void close_the_sales_return_window() throws InterruptedException {
        Thread.sleep(1000);
        closedriver();
    }
}

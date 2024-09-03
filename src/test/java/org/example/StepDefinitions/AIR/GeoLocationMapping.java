package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.TimeoutException;

public class GeoLocationMapping extends Page_Options {
    int matchingRowsCNT;
    String[][] dataGetArray;

    /*
       Create a new  Geo Location Mapping
    */
    @Given("login for creating new  Geo Location Mapping")
    public void login_for_creating_new_geo_location_mapping() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        cssSelector = ".menues-bar:nth-child(25) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new  Geo Location Mapping")
    public void create_new_geo_location_mapping() throws InterruptedException {
        try {
            Thread.sleep(500);

            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div[1]/div[3]/a[2]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //click the employee list
            id = "select2-add_emp_list-container";
            waitById(id);
            clickbyId(id);

            //type int the name of the employee and select
            xpath = "/html/body/span/span/span[1]/input";
            clickbyxpath(xpath);
            inputbyxpath(xpath, "kazi polash");
            pressEnterbyXpath(xpath);

            Thread.sleep(500);

//        int rowCount = 1 + count_row_number_BYID("geo_loc_map_prevData_History_table");


            Thread.sleep(500);

            //click the checkbox
            xpath = "//*[@id=\"record_all\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            //date
            id = "add_eff_start_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getLastMonth());

            for (int i = 0; i < 3; i++) {
                //choose region
                id = "select2-region_" + i + "-container";
                waitById(id);
                clickbyId(id);
                //enter the region name
                xpath = "/html/body/span/span/span[1]/input";
                clickbyxpath(xpath);
                for (int j = 0; j < i + 3; j++) {
                    pressDownbyXpath(xpath);
                }
                pressEnterbyXpath(xpath);

                //choose depot
                id = "select2-depot_" + i + "-container";
                waitById(id);
                clickbyId(id);
                //enter the depot name
                xpath = "/html/body/span/span/span[1]/input";
                clickbyxpath(xpath);
                for (int j = 0; j < i + 3; j++) {
                    pressDownbyXpath(xpath);
                }
                pressEnterbyXpath(xpath);

                //choose area
                id = "select2-area_" + i + "-container";
                waitById(id);
                clickbyId(id);
                //enter the area name
                xpath = "/html/body/span/span/span[1]/input";
                clickbyxpath(xpath);
                for (int j = 0; j < i + 3; j++) {
                    pressDownbyXpath(xpath);
                }
                pressEnterbyXpath(xpath);

                //choose territory
                id = "select2-territory_" + i + "-container";
                waitById(id);
                clickbyId(id);
                //enter the territory name
                xpath = "/html/body/span/span/span[1]/input";
                clickbyxpath(xpath);
                for (int j = 0; j < i + 3; j++) {
                    pressDownbyXpath(xpath);
                }
                pressEnterbyXpath(xpath);

                if (i < 2) {
                    //click plus button
                    id = "add-row";
                    waitById(id);
                    clickbyId(id);
                }
            }

            //click the checkbox of the last row
            id = "rwdr_record_2";
            waitById(id);
            clickbyId(id);

            //delete last row by clicking delete button
            id = "delete-row";
            waitById(id);
            clickbyId(id);

            //click save
            id = "add_distributors";
            clickbyId(id);

            AlertAccept();
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Geo Location Mapping window")
    public void close_the_geo_location_mapping_window() throws InterruptedException {
        closedriver();
    }


    /*
       Create a new  Geo Location Mapping
    */
    @Given("Login to Search  Geo Location Mapping")
    public void login_to_search_geo_location_mapping() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        cssSelector = ".menues-bar:nth-child(25) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Geo Location Mappings of an user and copy important elements from Geo Location Mapping")
    public void search_for_geo_location_mappings_of_an_user_and_copy_important_elements_from_geo_location_mapping() throws InterruptedException {
        try {
            xpath = "//*[@id=\"geo_location_mapping_table\"]";
            dataGetArray = viewButtonClickForMatchingRowsByXpathAndName(xpath, "Kazi Polash (1153)");

            int rows = dataGetArray.length;
            int cols = dataGetArray[0].length;
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < cols; i++) {
                    System.out.print(dataGetArray[j][i] + "  ");
                }
                System.out.println();
            }
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close  Geo Location Mapping for search")
    public void close_geo_location_mapping_for_search() throws InterruptedException {
        closedriver();
    }

    /*
           verify the new  Geo Location Mapping in orders
    */
    @Given("Login to copy the data for ordering by an user")
    public void login_to_copy_the_data_for_ordering_by_an_user() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        cssSelector = ".menues-bar:nth-child(25) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("in create new order, copy the elements of order location")
    public void in_create_new_order_copy_the_elements_of_order_location() {
        try{


    }catch (TimeoutException e) {
        // Handle the TimeoutException
        System.out.println("TimeoutException occurred: " + e.getMessage());
    }
    }

    @Then("close  Geo Location Mapping for verification")
    public void close_geo_location_mapping_for_verification() {
        try{


        }catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("assert if the information is correct or not")
    public void assert_if_the_information_is_correct_or_not() {
        try{


        }catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }
}

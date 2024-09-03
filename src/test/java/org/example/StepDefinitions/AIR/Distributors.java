package org.example.StepDefinitions.AIR;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class Distributors extends Page_Options {
    @Given("login for Distributor")
    public void login_for_creation_of_a_distributor() {
        Login_AIR2_AIR(Users.user_Fahim);

        cssSelector = ".menues-bar:nth-child(14) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Distributor")
    public void create_new_distributor() throws InterruptedException {
        try {
            //click the create new button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a[2]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            Thread.sleep(1500);

            //Add photo or image
            id = "add_o_image";
            waitById(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\testing.png");
            Thread.sleep(1000);

            //Reference
            id = "add_ref";
            inputbyid(id, Distributors.Reference);
            //SDF
            id = "add_sdf";
            inputbyid(id, Distributors.SDF);
            //RDF
            id = "add_rdf";
            inputbyid(id, Distributors.RDF);
            //date
            id = "add_start_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getToday());
            //Region
            id = "select2-region_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.Region);
            cssSelectorPressEnter(cssSelector);

            //depot
            id = "select2-depot_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.depot);
            cssSelectorPressEnter(cssSelector);

            //Area
            id = "select2-area_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.Area);
            cssSelectorPressEnter(cssSelector);

            //territory
            id = "select2-add_territory_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.territory);
            cssSelectorPressEnter(cssSelector);


            //B P code
            id = "add_code";
            waitById(id);
            inputbyid(id, Distributors.B_P_code + randomnumber());

            //RSM
            Thread.sleep(1500);
            id = "select2-add_rsm_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.RSM);
            cssSelectorPressEnter(cssSelector);

            //  ASM / Sr. ASM
            id = "select2-add_asm_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.ASM_Sr_ASM);
            cssSelectorPressEnter(cssSelector);

            //FPR
            id = "select2-add_fpr_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.FPR);
            cssSelectorPressEnter(cssSelector);

            //Running FPR
            id = "select2-add_running_fpr_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.Running_FPR);
            cssSelectorPressEnter(cssSelector);

            //Effective date
            xpath = "//*[@id=\"add_eff_running_fpr_start_date\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            inputbyxpath(xpath, getToday());

            //Proposed distributors information

            //Identity Of Distributor
            id = "select2-add_distri_identity-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.Identity_Of_Distributor);
            cssSelectorPressEnter(cssSelector);

            //Type Of Distributorship
            id = "select2-add_distri_type-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.Type_Of_Distributorship);
            cssSelectorPressEnter(cssSelector);

            //distributor info
            id = "add_dist_info";
            waitById(id);
            inputbyid(id, Distributors.distributor_info);


            //Name Of Distributor/Firm
            String name = Distributors.Name_Of_Distributor_Firm + randomnumber();
            id = "add_name";
            waitById(id);
            inputbyid(id, name);

            //Proprietor Name
            id = "add_o_name";
            waitById(id);
            inputbyid(id, Distributors.Proprietor_Name);

            //Proprietor Mobile Number
            id = "add_o_mobile";
            waitById(id);
            inputbyid(id, Distributors.Proprietor_Mobile_Number + randomnumber());

            //Contact Person & Mobile Number
            id = "add_cp_mobile";
            waitById(id);
            inputbyid(id, Distributors.Contact_Person_Mobile_Number + randomnumber());

            //Farm Address
            id = "add_address";
            waitById(id);
            inputbyid(id, Distributors.Farm_Address);


            //Proprietor Permanent Address
            id = "add_o_address";
            waitById(id);
            inputbyid(id, Distributors.Proprietor_Permanent_Address);

            //Proprietor Present Address
            id = "add_o_pre_address";
            waitById(id);
            inputbyid(id, Distributors.Proprietor_Present_Address);

            //Proprietor National ID Number
            id = "add_o_nid";
            waitById(id);
            inputbyid(id, Distributors.Proprietor_National_ID_Number + randomnumber());

            //Trade License Number & Last Date
            id = "add_tl_number";
            waitById(id);
            inputbyid(id, Distributors.Trade_License_Number_Last_Date + randomnumber());
            id = "add_tl_lastDate";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getFutureDate());

            //Bank Name & Branch
            id = "add_b_name_b_branch";
            clickbyId(id);
            inputbyid(id, Distributors.Bank_Name_Branch);

            //Bank Account Number
            id = "add_b_account";
            clickbyId(id);
            inputbyid(id, Distributors.Bank_Account_Number + randomnumber());

            //Name Of Existing Business
            id = "add_exist_bus_name1";
            clickbyId(id);
            inputbyid(id, Distributors.Name_Of_Existing_Business1);
            id = "add_exist_bus_name2";
            clickbyId(id);
            inputbyid(id, Distributors.Name_Of_Existing_Business2);


            //Existing Business Starting Year
            id = "add_exist_start1";
            clickbyId(id);
            inputbyid(id, Distributors.Existing_Business1_Starting_Year);
            id = "add_exist_start2";
            clickbyId(id);
            inputbyid(id, Distributors.Existing_Business2_Starting_Year);

            //No. Of Existing Van Puller & Or DSR
            id = "add_exist_van_puller";
            clickbyId(id);
            inputbyid(id, Distributors.No_Of_Existing_Van_Puller_Or_DSR);

            //Number Of Existing Ice Cream Van
            id = "add_exist_ice_van";
            clickbyId(id);
            inputbyid(id, Distributors.Number_Of_Existing_Ice_Cream_Van);

            //Existing Godown Size (SQFT)
            id = "add_exist_gd_size";
            clickbyId(id);
            inputbyid(id, Distributors.Existing_Godown_Size_SQFT);

            //Relation With Golden Group Entity
            id = "add_rel_gge";
            waitById(id);
            inputbyid(id, Distributors.Relation_With_Golden_Group_Entity);

            //Market information

            //Area Demarcation
            xpath = "//*[@id=\"add_distributors_form\"]/div/div/div/div/div[3]/div/table/tbody/tr[1]/td[3]/span/span[1]/span";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.Area_Demarcation);
            pressEnterbyXpath(xpath);
            pressESCbyXpath(xpath);

            //Point Name
            id = "add_point_name";
            inputbyid(id, Distributors.Point_Name);

            //Routes
            xpath = "//*[@id=\"add_distributors_form\"]/div/div/div/div/div[3]/div/table/tbody/tr[3]/td[3]/span/span[1]/span";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.Routes);
            pressEnterbyXpath(xpath);
            pressESCbyXpath(xpath);


            //Key Markets
            id = "add_k_market";
            waitById(id);
            inputbyid(id, Distributors.Key_Markets);

            //Ice Cream Selling Outlets Territory
            id = "add_ice_outlets";
            waitById(id);
            inputbyid(id, Distributors.Ice_Cream_Selling_Outlets_Territory);

            //Existing Avg Market Size (Tk) : (Yearly)
            id = "add_exist_avg_m_size";
            waitById(id);
            inputbyid(id, Distributors.Existing_Avg_Market_Size_Tk_Yearly);

            //Discount Information

            //Special Discount

            //discount type
            id = "select2-special_discount_type-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.discount_type);
            cssSelectorPressEnter(cssSelector);
            //discount amount
            id = "special_discount";
            waitById(id);
            clearById(id);
            inputbyid(id, Distributors.discount_amount);

            //Competitors Intelligence : (Yearly)

            //Existing Market Contribution (Taka)
            //Igloo
            id = "add_ig_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Igloo);
            // Polar
            id = "add_po_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Polar);
            // Lovello
            id = "add_lo_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Lovello);
            // Kazi
            id = "add_ka_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Kazi);
            // Bloop
            id = "add_bl_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Bloop);
            // Kwality
            id = "add_kw_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Kwality);
            // Others
            id = "add_others_cont";
            waitById(id);
            inputbyid(id, Distributors.C_Others);


            //D/F Quantity Of The Competitors
            //Igloo
            id = "add_ig_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Igloo);
            // Polar
            id = "add_po_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Polar);
            // Lovello
            id = "add_lo_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Lovello);
            // Kazi
            id = "add_ka_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Kazi);
            // Bloop
            id = "add_bl_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Bloop);
            // Kwality
            id = "add_kw_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Kwality);
            // Others
            id = "add_others_comp";
            waitById(id);
            inputbyid(id, Distributors.D_F_Others);


            //Expected Sales


            //Expected Monthly Sales(in taka)
            id = "add_m1_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Igloo);
            id = "add_m2_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Polar);
            id = "add_m3_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Lovello);
            id = "add_m4_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Kazi);
            id = "add_m5_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Bloop);
            id = "add_m6_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Kwality);
            id = "add_m7_sales";
            waitById(id);
            inputbyid(id, Distributors.S_Others);

            //Expected Number Of Freezers Injection
            id = "add_m1_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Igloo);
            id = "add_m2_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Polar);
            id = "add_m3_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Lovello);
            id = "add_m4_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Kazi);
            id = "add_m5_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Bloop);
            id = "add_m6_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Kwality);
            id = "add_m7_inj";
            waitById(id);
            inputbyid(id, Distributors.F_Others);


            //Investment Information


            //Total Investment (Tk)
            id = "add_total_inv";
            waitById(id);
            inputbyid(id, Distributors.Total_Investment_Tk);

            //Initial Lifting (In Tk)
            id = "add_init_lifting";
            waitById(id);
            inputbyid(id, Distributors.Initial_Lifting_In_Tk);

            //Number Of SDFs :
            id = "add_num_SDF";
            waitById(id);
            inputbyid(id, Distributors.Number_Of_SDFs);

            //Godown Advance (Tk) :
            id = "add_gd_adv";
            waitById(id);
            inputbyid(id, Distributors.Godown_Advance);

            //Value Of SDFs (Tk) :
            id = "add_val_SDF";
            waitById(id);
            inputbyid(id, Distributors.Value_Of_SDFs);

            //Market Credit :
            id = "add_m_credit";
            waitById(id);
            inputbyid(id, Distributors.Market_Credit);

            //Number Of Van(S) :
            id = "add_num_vans";
            waitById(id);
            inputbyid(id, Distributors.Number_Of_Van_S);

            //Running Capital :
            id = "add_run_capital";
            waitById(id);
            inputbyid(id, Distributors.Running_Capital);

            //Value Of Vans (Tk) :
            id = "add_val_vans";
            waitById(id);
            inputbyid(id, Distributors.Value_Of_Vans_Tk);

            //Type Of Transaction :
            id = "add_transac_type";
            waitById(id);
            inputbyid(id, Distributors.Type_Of_Transaction);

            //RSM's (or ASM in absence of RSM) Recommendation
            id = "add_rsm_recom";
            waitById(id);
            inputbyid(id, Distributors.RSMs_or_ASM_in_absence_of_RSM_Recommendation);

            //GM/DGM/AGM's Recommendation
            id = "add_gm_recom";
            waitById(id);
            inputbyid(id, Distributors.GM_DGM_AGMs_Recommendation);


            //Agreement Image
            //Add photo or image
            id = "add_agree_image";
            waitById(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\agreement.jpg");
            Thread.sleep(500);

            //Approval Image
            //Add photo or image
            id = "add_approval_image";
            waitById(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\approved.jpg");
            Thread.sleep(500);

            //Trade License Image
            //Add photo or image
            id = "add_tl_image";
            waitById(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\trade licence.png");
            Thread.sleep(500);


            //Status
            boolean active = true;
            id = "add_status";
            waitById(id);
            clickbyId(id);
            if (active == true) {
                xpath = "//option[. = 'Active']";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            } else {
                xpath = "//option[. = 'In Active']";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            }


            //Approve
            boolean approve = true;
            id = "add_is_approve";
            waitById(id);
            clickbyId(id);
            if (approve == true) {
                xpath = "//*[@id=\"add_is_approve\"]/option[1]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            } else {
                xpath = "//*[@id=\"add_is_approve\"]/option[2]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            }


            //Approval Date
            id = "add_appr_start_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getLastMonth());

            //Closing Date:
            id = "add_appr_close_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getFutureDate());


            //Save button
            id = "add_distributors";
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("close the Distributor window")
    public void close_the_distributor_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


    @When("search for Distributor")
    public void search_for_distributor() throws InterruptedException {
        try {
            Thread.sleep(2000);

            //search
            xpath = "//*[@id=\"search_input1\"]";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.SearchInfo);
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @When("description of a Distributor")
    public void description_of_a_distributor() throws InterruptedException {
        try {
            //click the eye button
            Thread.sleep(500);
            WebElement table = driver.findElement(By.id("distribution_table"));
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
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @Then("print the distributor info")
    public void print_the_distributor_info() throws InterruptedException {
        //print the diistributor info
        Thread.sleep(200);
        xpath = "//*[@id=\"print_div\"]/a";
        clickbyxpath(xpath);
    }

    @Then("close Distributor for search")
    public void close_distributor_for_search() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }


    @And("edit distributor")
    public void editDistributor() throws InterruptedException {
        try {
            //click the edit button
            Thread.sleep(500);
            WebElement table = driver.findElement(By.id("distribution_table"));
            java.util.List<WebElement> rows = table.findElements(By.xpath(".//tr"));
            // Iterate through rows
            for (WebElement row : rows) {
                // Check if the row is displayed
                if (!row.getAttribute("style").contains("display: none;")) {
                    // Find and click the "Add App Permissions" button for the visible row
                    WebElement btn_edit = row.findElement(By.id("btn_edit"));
                    btn_edit.click();
                }
            }


            Thread.sleep(500);

            //Add photo or image
            id = "edit_o_image";
            waitById(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\testing_E.png");
            Thread.sleep(100);

            //Reference
            id = "edit_ref";
            clearByid(id);
            inputbyid(id, Distributors.E_Reference);
            //SDF
            id = "edit_sdf";
            clearByid(id);
            inputbyid(id, Distributors.E_SDF);
            //RDF
            id = "edit_rdf";
            clearByid(id);
            inputbyid(id, Distributors.E_RDF);
            //date
            id = "edit_start_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getToday());
            //Region
            id = "select2-edit_region_list-container";
            waitById(id);
            clickbyId(id);
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.E_Region);
            pressEnterbyXpath(xpath);

            //depot
            id = "select2-edit_depot_list-container";
            waitById(id);
            clickbyId(id);
            xpath = "/html/body/span/span/span[1]/input";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.E_depot);
            pressEnterbyXpath(xpath);

            //Area
            id = "select2-edit_area_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_Area);
            cssSelectorPressEnter(cssSelector);

            //territory
            id = "select2-edit_territory_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_territory);
            cssSelectorPressEnter(cssSelector);


            //B P code
            id = "edit_code";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_B_P_code + randomnumber());

            //RSM
            Thread.sleep(500);
            id = "select2-edit_rsm_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_RSM);
            cssSelectorPressEnter(cssSelector);

            //  ASM / Sr. ASM
            id = "select2-edit_asm_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_ASM_Sr_ASM);
            cssSelectorPressEnter(cssSelector);

            //FPR
            id = "select2-edit_fpr_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_FPR);
            cssSelectorPressEnter(cssSelector);

            //Running FPR
            id = "select2-edit_running_fpr_list-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_Running_FPR);
            cssSelectorPressEnter(cssSelector);

            //Effective date
            xpath = "//*[@id=\"edit_eff_running_fpr_start_date\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);
            inputbyxpath(xpath, getToday());

            //Proposed distributors information

            //Identity Of Distributor
            id = "select2-edit_distri_identity-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_Identity_Of_Distributor);
            cssSelectorPressEnter(cssSelector);

            //Type Of Distributorship
            id = "select2-edit_distri_type-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_Type_Of_Distributorship);
            cssSelectorPressEnter(cssSelector);

            //distributor info
            id = "edit_dist_info";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_distributor_info);


            //Name Of Distributor/Firm
            String name = Distributors.E_Name_Of_Distributor_Firm + randomnumber();
            id = "edit_name";
            waitById(id);
//        clearByid(id);            //dont want to change this field now. To change it please uncomment these lines
//        inputbyid(id, name);

            //Proprietor Name
            id = "edit_o_name";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Proprietor_Name);

            //Proprietor Mobile Number
            id = "edit_o_mobile";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Proprietor_Mobile_Number + randomnumber());

            //Contact Person & Mobile Number
            id = "edit_cp_mobile";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Contact_Person_Mobile_Number + randomnumber());

            //Farm Address
            id = "edit_address";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Farm_Address);


            //Proprietor Permanent Address
            id = "edit_o_address";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Proprietor_Permanent_Address);

            //Proprietor Present Address
            id = "edit_o_pre_address";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Proprietor_Present_Address);

            //Proprietor National ID Number
            id = "edit_o_nid";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Proprietor_National_ID_Number + randomnumber());

            //Trade License Number & Last Date
            id = "edit_tl_number";
            waitById(id);
            inputbyid(id, Distributors.E_Trade_License_Number_Last_Date + randomnumber());
            id = "edit_tl_lastDate";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getFutureDate());

            //Bank Name & Branch
            id = "edit_b_name_b_branch";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Bank_Name_Branch);

            //Bank Account Number
            id = "edit_b_account";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Bank_Account_Number + randomnumber());

            //Name Of Existing Business
            id = "edit_exist_bus_name1";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Name_Of_Existing_Business1);
            id = "edit_exist_bus_name2";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Name_Of_Existing_Business2);


            //Existing Business Starting Year
            id = "edit_exist_start1";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Existing_Business1_Starting_Year);
            id = "edit_exist_start2";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Existing_Business2_Starting_Year);

            //No. Of Existing Van Puller & Or DSR
            id = "edit_exist_van_puller";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_No_Of_Existing_Van_Puller_Or_DSR);

            //Number Of Existing Ice Cream Van
            id = "edit_exist_ice_van";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Number_Of_Existing_Ice_Cream_Van);

            //Existing Godown Size (SQFT)
            id = "edit_exist_gd_size";
            clickbyId(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Existing_Godown_Size_SQFT);

            //Relation With Golden Group Entity
            id = "edit_rel_gge";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Relation_With_Golden_Group_Entity);

            //Market information


            //clear Area Demarcation
            int listAreaDemarcation = getTotalLiCountByXpath("//*[@id=\"select2-edit_area_dem-container\"]");
            for (int i = 0; i < listAreaDemarcation; i++) {
                Thread.sleep(10);
                xpath = "//*[@id=\"select2-edit_area_dem-container\"]/li/button";
                clickbyxpath(xpath);
            }
            //clear Routes
            int listRoutes = getTotalLiCountByXpath("//*[@id=\"select2-edit_routes-container\"]");
            for (int i = 0; i < listRoutes; i++) {
                Thread.sleep(10);
                xpath = "//*[@id=\"select2-edit_routes-container\"]/li/button";
                clickbyxpath(xpath);
            }

            //Area Demarcation
            xpath = "//*[@id=\"edit_distributors_form\"]/div/div/div/div/div[3]/div/table/tbody/tr[1]/td[3]/span/span[1]/span";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.E_Area_Demarcation);
            pressEnterbyXpath(xpath);
            pressESCbyXpath(xpath);

            //Routes
            xpath = "//*[@id=\"edit_distributors_form\"]/div/div/div/div/div[3]/div/table/tbody/tr[3]/td[3]/span/span[1]/span";
            waitByxpath(xpath);
            inputbyxpath(xpath, Distributors.E_Routes);
            pressEnterbyXpath(xpath);
            pressESCbyXpath(xpath);

            //Point Name
            id = "edit_point_name";
            clearByid(id);
            inputbyid(id, Distributors.E_Point_Name);

            //Key Markets
            id = "edit_k_market";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Key_Markets);

            //Ice Cream Selling Outlets Territory
            id = "edit_ice_outlets";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Ice_Cream_Selling_Outlets_Territory);

            //Existing Avg Market Size (Tk) : (Yearly)
            id = "edit_exist_avg_m_size";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Existing_Avg_Market_Size_Tk_Yearly);

            //Discount Information

            //Special Discount

            //discount type
            id = "select2-edit_special_discount_type-container";
            waitById(id);
            clickbyId(id);
            cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
            waitByCssSelector(cssSelector);
            inputbycssselector(cssSelector, Distributors.E_discount_type);
            cssSelectorPressEnter(cssSelector);
            //discount amount
            id = "edit_special_discount";
            waitById(id);
            clearById(id);
            inputbyid(id, Distributors.E_discount_amount);

            //Competitors Intelligence : (Yearly)

            //Existing Market Contribution (Taka)
            //Igloo
            id = "edit_ig_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Igloo);
            // Polar
            id = "edit_po_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Polar);
            // Lovello
            id = "edit_lo_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Lovello);
            // Kazi
            id = "edit_ka_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Kazi);
            // Bloop
            id = "edit_bl_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Bloop);
            // Kwality
            id = "edit_kw_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Kwality);
            // Others
            id = "edit_others_cont";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_C_Others);


            //D/F Quantity Of The Competitors
            //Igloo
            id = "edit_ig_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Igloo);
            // Polar
            id = "edit_po_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Polar);
            // Lovello
            id = "edit_lo_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Lovello);
            // Kazi
            id = "edit_ka_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Kazi);
            // Bloop
            id = "edit_bl_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Bloop);
            // Kwality
            id = "edit_kw_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Kwality);
            // Others
            id = "edit_others_comp";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_D_F_Others);


            //Expected Sales


            //Expected Monthly Sales(in taka)
            id = "edit_m1_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Igloo);
            id = "edit_m2_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Polar);
            id = "edit_m3_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Lovello);
            id = "edit_m4_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Kazi);
            id = "edit_m5_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Bloop);
            id = "edit_m6_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Kwality);
            id = "edit_m7_sales";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_S_Others);

            //Expected Number Of Freezers Injection
            id = "edit_m1_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Igloo);
            id = "edit_m2_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Polar);
            id = "edit_m3_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Lovello);
            id = "edit_m4_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Kazi);
            id = "edit_m5_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Bloop);
            id = "edit_m6_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Kwality);
            id = "edit_m7_inj";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_F_Others);


            //Investment Information


            //Total Investment (Tk)
            id = "edit_total_inv";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Total_Investment_Tk);

            //Initial Lifting (In Tk)
            id = "edit_init_lifting";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Initial_Lifting_In_Tk);

            //Number Of SDFs :
            id = "edit_num_SDF";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Number_Of_SDFs);

            //Godown Advance (Tk) :
            id = "edit_gd_adv";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Godown_Advance);

            //Value Of SDFs (Tk) :
            id = "edit_val_SDF";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Value_Of_SDFs);

            //Market Credit :
            id = "edit_m_credit";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Market_Credit);

            //Number Of Van(S) :
            id = "edit_num_vans";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Number_Of_Van_S);

            //Running Capital :
            id = "edit_run_capital";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Running_Capital);

            //Value Of Vans (Tk) :
            id = "edit_val_vans";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Value_Of_Vans_Tk);

            //Type Of Transaction :
            id = "edit_transac_type";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_Type_Of_Transaction);

            //RSM's (or ASM in absence of RSM) Recommendation
            id = "edit_rsm_recom";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_RSMs_or_ASM_in_absence_of_RSM_Recommendation);

            //GM/DGM/AGM's Recommendation
            id = "edit_gm_recom";
            waitById(id);
            clearByid(id);
            inputbyid(id, Distributors.E_GM_DGM_AGMs_Recommendation);


            //Agreement Image
            //Add photo or image
            id = "edit_agree_image";
            waitById(id);
            clearByid(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\agreement_E.jpg");
            Thread.sleep(500);

            //Approval Image
            //Add photo or image
            id = "edit_approval_image";
            waitById(id);
            clearByid(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\approved_E.jpg");
            Thread.sleep(500);

            //Trade License Image
            //Add photo or image
            id = "edit_tl_image";
            waitById(id);
            clearByid(id);
            inputbyid(id, "G:\\Abul Hossain Chowdhury\\Projects\\Ultimate_Cucumber_learning\\src\\main\\trade licence_E.png");
            Thread.sleep(500);


            //Status
            boolean active = true;
            id = "edit_status";
            waitById(id);
            clickbyId(id);
            if (active == true) {
                xpath = "//*[@id=\"edit_status\"]/option[1]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            } else {
                xpath = "//*[@id=\"edit_status\"]/option[2]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            }


            //Approve
            boolean approve = true;
            id = "edit_is_approve";
            waitById(id);
            clickbyId(id);
            if (approve == true) {
                xpath = "//*[@id=\"edit_is_approve\"]/option[1]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            } else {
                xpath = "//*[@id=\"edit_is_approve\"]/option[2]";
                waitByxpath(xpath);
                clickbyxpath(xpath);
            }


            //Approval Date
            id = "edit_appr_start_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getLastMonth());

            //Closing Date:
            id = "edit_appr_close_date";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getFutureDate());


            //Save button
            id = "edit_distributors";
            clickbyId(id);
            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }


}

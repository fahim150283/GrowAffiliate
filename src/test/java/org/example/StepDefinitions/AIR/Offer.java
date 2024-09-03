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

public class Offer extends Page_Options {

    String offer_type = Offer.Type;
    String offerName = offer_type + "" + randomTestString();
    int Num_Cat = Integer.parseInt(Offer.NumOfCategory);
    String temporary_Offer_Name;
    String temporary_Offer_Type1;
    String temporary_Offer_Type2;
    String temporary_Product1;
    String temporary_Product2;
    String temporary_Region_territory;


    /*
    creation of an offer
    */
    @Given("login for creation of an offer")
    public void login_for_creation_of_an_offer() throws InterruptedException {
        Login_AIR2(Users.user_Haseeb);
        Click_from_leftSideBar("Offer");
        System.out.println("The Expected page is : AIR - Offer");
        PrintPageTitle();
    }

    @When("create new offer")
    public void create_new_offer() throws InterruptedException {
        try {
            //click create new button
            xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div/div/div[3]/a";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            Thread.sleep(500);

            //offer info

            //offer name
            id = "add_offer_name";
            waitById(id);
            inputbyid(id, offerName);

            //valid from
            id = "valid_from";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getTodaynTime());
            pressEnterById(id);

            //valid to
            id = "valid_to";
            waitById(id);
            clickbyId(id);
            inputbyid(id, getFutureDatenTime());

            //Products Included in the Offer
            for (int k = 0; k < Num_Cat; k++) {
                //category
                Thread.sleep(50);
                xpath = "//*[@id=\"inc_prod_cat" + (k + 1) + "\"]";
//
                WebElement CatgDropdown = driver.findElement(By.xpath(xpath));
                Select CatgSelect = new Select(CatgDropdown);
                CatgSelect.selectByVisibleText(Offer.ItemCatg[k]);


                //sub category
                Thread.sleep(50);
                id = "inc_prod_sub_cat" + (k + 1);
                WebElement SubCatgDropdown = driver.findElement(By.id(id));
                CatgSelect = new Select(SubCatgDropdown);
                CatgSelect.selectByVisibleText(Offer.ItemSubCatg[k]);

                //product
                Thread.sleep(50);
                id = "inc_prod" + (k + 1);
                WebElement ProdDropdown = driver.findElement(By.id(id));
                CatgSelect = new Select(ProdDropdown);
                CatgSelect.selectByVisibleText(Offer.ItemProd[k]);

                //Excluded items

                //sub category
                Thread.sleep(50);
                id = "ex_sub_cat" + (k + 1);
                WebElement Dropdown = driver.findElement(By.id(id));
                CatgSelect = new Select(Dropdown);
                CatgSelect.selectByVisibleText(Offer.EItemSubCatg[k]);

                //products
                Thread.sleep(50);
                xpath = "//*[@id=\"raw-row-id" + (21 + k) + "\"]/td[6]/span/span[1]/span";
                inputbyxpath(xpath, Offer.EItemProd[k]);
                Thread.sleep(10);
                pressEnterbyXpath(xpath);

                //click the plus button to add another row
                if (k < Num_Cat - 1) {
                    Thread.sleep(20);
                    xpath = "//*[@id=\"prod_table\"]/tfoot/tr/td/span[1]";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    Thread.sleep(200);
                }

                //remove last category
                if ((k + 1 == Num_Cat) && k > 1) {
                    //click the checkbox
                    Thread.sleep(50);
                    xpath = "//tr[@id=\'raw-row-id" + (21 + k) + "\']/td/label/span";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    //click the delete button
                    xpath = "//table[@id=\'prod_table\']/tfoot/tr/td/span[2]/i";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                }
            }

            //offer type
            id = "offer_type";
            clickbyId(id);
            WebElement Dropdown = driver.findElement(By.id(id));
            Select CatgSelect = new Select(Dropdown);
            CatgSelect.selectByVisibleText(Offer.Type);
            Thread.sleep(200);


            int numOfOffers = Integer.parseInt(Offer.NumOfOffers);
            //Number of offers
            int cnt = 0;
            if (Num_Cat > 1) {
                cnt = 1;
            } else {
                cnt = numOfOffers;
            }

            //If cash
            if (Objects.equals(offer_type, "Cash")) {

                for (int k = 0; k < cnt; k++) {

                    //BDT or Precentage
                    if (k % 2 == 0) {
                        //select percentage
                        xpath = "//*[@id=\"amount_type" + (k + 1) + "\"]";
                        Dropdown = driver.findElement(By.xpath(xpath));
                        CatgSelect = new Select(Dropdown);
                        CatgSelect.selectByVisibleText("BDT");


                        //min amount
                        id = "c_min_amnt" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + (1000 * (k + 1)));

                        //Discount amount
                        id = "discount_amount" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + ((k + 1) * 10));

                    } else {

                        //select percentage
                        xpath = "//*[@id=\"amount_type" + (k + 1) + "\"]";
                        Dropdown = driver.findElement(By.xpath(xpath));
                        CatgSelect = new Select(Dropdown);
                        CatgSelect.selectByVisibleText("Percentage");

                        //min amount
                        id = "c_min_amnt" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + (1000 * (k + 1)));

                        //Discount amount
                        id = "discount_amount" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + (100 * (k + 1)));
                    }

                    //click plus button
                    if ((k < cnt - 1) && driver.findElement(By.xpath("//*[@id=\"amount_group\"]/div/table/tfoot/tr/td/span[1]")).isDisplayed()) {
                        Thread.sleep(100);
                        xpath = "//*[@id=\"amount_group\"]/div/table/tfoot/tr/td/span[1]";
                        waitByxpath(xpath);
                        clickbyxpath(xpath);
                        Thread.sleep(50);
                    }
                }

                if (cnt > 1) {
                    //delete the last category
                    //click the checkbox
                    xpath = "//tr[@id=\'raw-row-id33\']/td/label/span";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    //click delete button
                    xpath = "//div[2]/div/table/tfoot/tr/td/span[2]/i";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                }

            }
            //If Product
            else if (Objects.equals(offer_type, "Product")) {

                //category
                for (int k = 0; k < cnt; k++) {

                    if (Objects.equals(Offer.ProductGiftCondition, "Amount")) {
                        //min inv amount
                        id = "min_amnt" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + (1000 * (k + 1)));

                        //min prod qty
                        id = "min_prod_qty" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + (0));
                    } else {
                        //min inv amount
                        id = "min_amnt" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + (0));

                        //min prod qty
                        id = "min_prod_qty" + (k + 1);
                        waitById(id);
                        inputbyid(id, "" + ((k + 1) * 10));

                    }

                    //prod type
                    id = "min_prod_type" + (k + 1);
                    if (k % 2 == 0) {
                        Dropdown = driver.findElement(By.id(id));
                        CatgSelect = new Select(Dropdown);
                        CatgSelect.selectByVisibleText("BDT");
                        Thread.sleep(90);
                    } else {
                        Dropdown = driver.findElement(By.id(id));
                        CatgSelect = new Select(Dropdown);
                        CatgSelect.selectByVisibleText("Ctn");
                        Thread.sleep(90);
                    }

                    //product category
                    id = "prod_cat" + (k + 1);
                    Dropdown = driver.findElement(By.id(id));
                    CatgSelect = new Select(Dropdown);
                    CatgSelect.selectByVisibleText(Offer.ItemCatg[k]);
                    Thread.sleep(90);

                    //product
                    id = "product" + (k + 1);
                    Dropdown = driver.findElement(By.id(id));
                    CatgSelect = new Select(Dropdown);
                    CatgSelect.selectByVisibleText(Offer.ItemProd[k]);
                    Thread.sleep(90);

                    //ctn
                    id = "ctn" + (k + 1);
                    clearByid(id);
                    inputbyid(id, "" + (k + 1));

//                //pcs (not necessary)
//                id = "pcs" + (k + 1);
//                clearByid(id);
//                inputbyid(id, "" + (k + 1));

                    //click plus button
                    if ((k + 1 < cnt) && driver.findElement(By.xpath("//*[@id=\"prod_cat_group\"]/div/table/tfoot/tr/td/span[1]")).isDisplayed()) {
                        Thread.sleep(100);
                        xpath = "//*[@id=\"prod_cat_group\"]/div/table/tfoot/tr/td/span[1]";
                        waitByxpath(xpath);
                        clickbyxpath(xpath);
                        Thread.sleep(50);
                    }
                }

                if (cnt > 1) {
                    //delete the last category
                    //click the checkbox
                    xpath = "//tr[@id=\'raw-row-id33\']/td/label/span";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    //click delete button
                    xpath = "//div[2]/div/table/tfoot/tr/td/span[2]/i";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                }

            }
            //If Gift
            else if (Objects.equals(offer_type, "Gift")) {

                for (int k = 0; k < cnt; k++) {
                    //min amount
                    id = "g_min_amnt" + (k + 1);
                    waitById(id);
                    inputbyid(id, "" + (1000 * (k + 1)));

                    //gift name
                    Thread.sleep(50);
                    id = "gift_name" + (k + 1);
                    Dropdown = driver.findElement(By.id(id));
                    CatgSelect = new Select(Dropdown);
                    CatgSelect.selectByVisibleText(Offer.GiftItem[k]);
                    Thread.sleep(90);

                    //quantity
                    id = "quantity" + (k + 1);
                    waitById(id);
                    inputbyid(id, "" + (k + 1));

                    //click plus button
                    if ((k + 1 < cnt) && driver.findElement(By.xpath("//*[@id=\"gift_grp\"]/div/table/tfoot/tr/td/span[1]")).isDisplayed()) {
                        Thread.sleep(100);
                        xpath = "//*[@id=\"gift_grp\"]/div/table/tfoot/tr/td/span[1]";
                        waitByxpath(xpath);
                        clickbyxpath(xpath);
                        Thread.sleep(50);
                    }
                }

                if (cnt > 1) {
                    //delete the last category
                    //click the checkbox
                    xpath = "//tr[@id=\'raw-row-id33\']/td/label/span";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                    //click delete button
                    xpath = "//div[2]/div/table/tfoot/tr/td/span[2]/i";
                    waitByxpath(xpath);
                    clickbyxpath(xpath);
                }
            }

            //Eligibility
            {
                Thread.sleep(20);
                //choose the region
                xpath = "//*[@id=\"add_offer_form\"]/div/div[4]/div[1]/span/span[1]/span/span/textarea";
                waitByxpath(xpath);
                inputbyxpath(xpath, Offer.Region);
                pressEnterbyXpath(xpath);
                pressESCbyXpath(xpath);

                //choose the depot
                Thread.sleep(20);
                xpath = "//*[@id=\"depot_grp\"]/span/span[1]/span/span/textarea";
                waitByxpath(xpath);
                inputbyxpath(xpath, Offer.Depot);
                pressEnterbyXpath(xpath);
                pressESCbyXpath(xpath);

                //choose the area
                Thread.sleep(20);
                xpath = "//*[@id=\"area_grp\"]/span/span[1]/span/span/textarea";
                waitByxpath(xpath);
                inputbyxpath(xpath, Offer.Area);
                pressEnterbyXpath(xpath);
                pressESCbyXpath(xpath);

                //choose the territory
                Thread.sleep(20);
                xpath = "//*[@id=\"territory_grp\"]/span/span[1]/span/span/textarea";
                waitByxpath(xpath);
                inputbyxpath(xpath, Offer.Territory);
                pressEnterbyXpath(xpath);
                pressESCbyXpath(xpath);

                //choose the Distributor
                Thread.sleep(20);
                xpath = "//*[@id=\"distributor_grp\"]/span/span[1]/span/span/textarea";
                waitByxpath(xpath);
                inputbyxpath(xpath, Offer.Distributor);
                pressEnterbyXpath(xpath);
                pressESCbyXpath(xpath);

                //choose the Excluded Distributors
                Thread.sleep(20);
                xpath = "//*[@id=\"ex_distributor_grp\"]/span/span[1]/span/span/textarea";
                waitByxpath(xpath);
                inputbyxpath(xpath, Offer.ExDistributor);
                pressEnterbyXpath(xpath);
                pressESCbyXpath(xpath);
            }

            //Active or inactive
            id = "is_active";
            WebElement checkbox = driver.findElement(By.id(id));
            if (Objects.equals(Offer.Active, "YES")) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            } else if (Objects.equals(Offer.Active, "NO")) {
                if (checkbox.isSelected()) {
                    checkbox.click();
                }
            }

            //credit allowed
            id = "credit_allowed";
            checkbox = driver.findElement(By.id(id));
            if (Objects.equals(Offer.CreditAllowed, "YES")) {
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            } else if (Objects.equals(Offer.CreditAllowed, "NO")) {
                if (checkbox.isSelected()) {
                    checkbox.click();
                }
            }

            //save and send for approval
            xpath = "//*[@id=\"submit_offer_add_sent\"]";
            waitByxpath(xpath);
            clickbyxpath(xpath);

            PrintConfirmationMessage();
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }


    /*
    check the created offer
    */
    @And("search for the offer")
    public void search_for_the_offer() throws InterruptedException {
        try {
            Thread.sleep(4000);
            id = "search";
            waitById(id);
            inputbyid(id, offerName);

            Thread.sleep(2000);
            row_element_click_By_xpath_and_id("//tbody[@id='offer_table']//tr[./td[contains(text(),'" + (offerName) + "')]]", "btn_view");
        } catch (TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
        }
    }

    @And("Copy required elements")
    public void copyRequiredElements() throws InterruptedException {
        Thread.sleep(1000);

        //copy
        temporary_Offer_Name = getTextAttributebyXpath("//*[@id=\"view_offer_name\"]");
        temporary_Offer_Type1 = getTextAttributebyXpath("//*[@id=\"view_offr_prod\"]/tr[1]/td[1]");
        temporary_Offer_Type2 = getTextAttributebyXpath("//*[@id=\"view_offr_prod\"]/tr[2]/td[1]");
        temporary_Product1 = getTextAttributebyXpath("//*[@id=\"view_inc_prod\"]/tr[1]/td[3]");
        temporary_Product2 = getTextAttributebyXpath("//*[@id=\"view_inc_prod\"]/tr[2]/td[3]");
        temporary_Region_territory = getTextAttributebyXpath("//*[@id=\"td_territory\"]");

        System.out.println(temporary_Offer_Name + " , " + temporary_Offer_Type2 + " , " + temporary_Offer_Type2 + " , " + temporary_Product1 + " , " + temporary_Product2 + " , " + temporary_Region_territory);
        closedriver();
    }

    @When("navigate to order and click new order button")
    public void navigateToOrderAndClickNewOrderButton() throws InterruptedException {
        Login_AIR2_AIR(Users.user_Polash);
        cssSelector = ".menues-bar:nth-child(17) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);

        //click the create new button
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        clickbyxpath(xpath);
    }

    @And("populate the fields")
    public void populateTheFields() throws InterruptedException {
        //set date
        id = "c_inv_date";
        waitById(id);
        clickbyId(id);
        inputbyid(id, getToday());

        //wait and click distributors
        xpath = "//*[@id=\"select2-distributor_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //search for the distributor and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, temporary_Region_territory);
        pressDownbyCssSelector(cssSelector);
        cssSelectorPressEnter(cssSelector);

        //
        scrollToTheBottom();

        //click the items bar
        cssSelector = "#add_invoice_form > div > div.row.mt-3 > div.col-md-11 > span > span.selection > span";
        Thread.sleep(0500);
        clickbycssselector(cssSelector);
        Thread.sleep(0500);
        inputbycssselector(cssSelector, temporary_Product1);
        cssSelectorPressEnter(cssSelector);
        clickbycssselector(cssSelector);
        Thread.sleep(3500);
        inputbycssselector(cssSelector, temporary_Product2);
        cssSelectorPressEnter(cssSelector);

        //click the plus button
        id = "c_add_inv_prod";
        clickbyId(id);

        //product quantity
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[5]/input";
        waitByxpath(xpath);
        clearByXpath(xpath);
        waitByxpath(xpath);
        inputbyxpath(xpath, "10");

        //important notes
        id = "c_notes";
        inputbyid(id, "Automated Test");
    }

    @Then("close the offer window")
    public void close_the_offer_window() throws InterruptedException {
        closedriver();
    }
}

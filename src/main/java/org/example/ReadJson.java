package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static class Users {
        public static String AIR_2_AIR;
        public static String AIR_2;
        public static String AIR;
        public static String BPU;
        public static String ItemsArray[] = new String[15];

        public static String user_Fahim;
        public static String L1Tester;
        public static String L2Tester;
        public static String user_Haseeb;
        public static String user_Polash;
        public static String user_Ashik;
        public static String user_Siam;
        public static String password;
    }

    public static String ContactsSearchInfo;

    public static class PreInvoices {
        public static String SearchInfo;
        public static String DistributorSearch;
        public static String ItemQuantity;
        public static String CheckBox;
        public static String CashCommission;
        public static String Items[] = new String[15];
        public static String OfferCTN;
        public static String OfferPCS;
        public static String Notes;
    }

    public static class AuditStockUpdate {
        public static String SearchInfo;
        public static String StoreSearch;
        public static String DepotSearch;
        public static String ItemQuantity;
    }

    public static class PreviousPendingDelivery {
        public static String Items[] = new String[15];
        public static String DistributorSearch;
        public static String ItemQuantity;
        public static String SearchInfo;
        public static String Store;
        public static String Inv_Ref;
        public static String ImportantNotes;
    }

    public static class Apps {
        public static String SearchInfo;
        public static String DisplayName;
        public static String Name;
        public static Boolean AppActive;
        public static String EditedDisplayName;
        public static String EditedName;
        public static String Link;
        public static String EmployeeInfo[] = new String[10];
    }

    public static class Order {
        public static String Items[] = new String[15];
        public static long IntervalOfSaveTime;
        public static String SearchInfo;
        public static String ItemQuantity;
        public static String DistributorSearch;
        public static String Refference_No;
        public static String Note;
        public static String CashCommission;
    }

    public static class CancelOrder {
        public static String SearchInfo;
        public static String DistributorSearch;
        public static String ItemQuantity;
        public static String Note;
        public static boolean partialCancel;
    }

    public static class Invoices {
        public static String SearchInfo;
        public static String DistributorSearch;
        public static String Store;
        public static String Note;
        public static String OfferQuantity;
        public static String ItemQuantity;
        public static String OfferCTN;
        public static boolean PartialInvoice;
        public static long IntervalOfSaveTime;
    }

    public static class CancelInvoice {
        public static String SearchInfo;
        public static String DistributorSearch;
        public static String Store;
        public static String Note;
        public static int Gift;
        public static int Quantity;
        public static int Comp;
    }

    public static class ComplementaryInvoice {
        public static String SearchInfo;
        public static String ItemQuantity;
        public static String DistributorSearch;
        public static String Store;
        public static String Note;
        public static String InvoiceReferenceNo;
        public static String Items[] = new String[15];
    }

    public static class Collection {
        public static String SearchInfo;
        public static String DistributorSearch;
        public static String CollectedBy;
        public static String CollectionAmount;
        public static String MoneyReceipt;
        public static String InstrumentType;
        public static String Field1;
        public static String Field2;
        public static String Field3;
        public static String Field4;
        public static String Field5;
        public static Boolean AdvanceCollection;
        public static Boolean AdjustFromAdvance;
        public static Boolean CollectionInCash;
    }

    public static class GROVS {
        public static String InvoiceItems[] = new String[15];
        public static String SearchInfo;
        public static String RequestFrom;
        public static String RequestTo;
        public static String Vehicle;
        public static String AcceptedQuantity;
        public static String ItemQuantity;
    }

    public static class FGS {
        public static String SearchInfo;
        public static String EditedCode;
        public static String EditedName;
        public static String Name;
        public static String EditedType;
        public static String Type;
        public static String Code;
        public static String Definition;
        public static String EditedDefinition;
        public static String EditedAddress;
        public static String Region;
        public static String Depots;
        public static String Address;
        public static String Store;
        public static String StoreToAddProducts;
        public static String ItemQuantity;
        public static String[] Items = new String[15];
    }

    public static class Distributors {
        public static String Reference;
        public static String SDF;
        public static String RDF;
        public static String Region;
        public static String depot;
        public static String Area;
        public static String territory;
        public static String B_P_code;
        public static String RSM;
        public static String ASM_Sr_ASM;
        public static String FPR;
        public static String Running_FPR;
        public static String Identity_Of_Distributor;
        public static String Type_Of_Distributorship;
        public static String distributor_info;
        public static String Name_Of_Distributor_Firm;
        public static String Proprietor_Name;
        public static String Proprietor_Mobile_Number;
        public static String Contact_Person_Mobile_Number;
        public static String Farm_Address;
        public static String Proprietor_Permanent_Address;
        public static String Proprietor_Present_Address;
        public static String Proprietor_National_ID_Number;
        public static String Trade_License_Number_Last_Date;
        public static String Bank_Name_Branch;
        public static String Bank_Account_Number;
        public static String Name_Of_Existing_Business1;
        public static String Name_Of_Existing_Business2;
        public static String Existing_Business1_Starting_Year;
        public static String Existing_Business2_Starting_Year;
        public static String No_Of_Existing_Van_Puller_Or_DSR;
        public static String Number_Of_Existing_Ice_Cream_Van;
        public static String Existing_Godown_Size_SQFT;
        public static String Relation_With_Golden_Group_Entity;
        public static String Area_Demarcation;
        public static String Point_Name;
        public static String Routes;
        public static String Key_Markets;
        public static String Ice_Cream_Selling_Outlets_Territory;
        public static String Existing_Avg_Market_Size_Tk_Yearly;
        public static String discount_type;
        public static String discount_amount;
        public static String C_Igloo;
        public static String C_Polar;
        public static String C_Lovello;
        public static String C_Kazi;
        public static String C_Bloop;
        public static String C_Kwality;
        public static String C_Others;
        public static String D_F_Igloo;
        public static String D_F_Polar;
        public static String D_F_Lovello;
        public static String D_F_Kazi;
        public static String D_F_Bloop;
        public static String D_F_Kwality;
        public static String D_F_Others;
        public static String S_Igloo;
        public static String S_Polar;
        public static String S_Lovello;
        public static String S_Kazi;
        public static String S_Bloop;
        public static String S_Kwality;
        public static String S_Others;
        public static String F_Igloo;
        public static String F_Polar;
        public static String F_Lovello;
        public static String F_Kazi;
        public static String F_Bloop;
        public static String F_Kwality;
        public static String F_Others;
        public static String Total_Investment_Tk;
        public static String Initial_Lifting_In_Tk;
        public static String Number_Of_SDFs;
        public static String Godown_Advance;
        public static String Value_Of_SDFs;
        public static String Market_Credit;
        public static String Number_Of_Van_S;
        public static String Running_Capital;
        public static String Value_Of_Vans_Tk;
        public static String Type_Of_Transaction;
        public static String RSMs_or_ASM_in_absence_of_RSM_Recommendation;
        public static String GM_DGM_AGMs_Recommendation;
        public static String SearchInfo;
        public static String E_Reference;
        public static String E_SDF;
        public static String E_RDF;
        public static String E_Region;
        public static String E_depot;
        public static String E_Area;
        public static String E_territory;
        public static String E_B_P_code;
        public static String E_RSM;
        public static String E_ASM_Sr_ASM;
        public static String E_FPR;
        public static String E_Running_FPR;
        public static String E_Identity_Of_Distributor;
        public static String E_Type_Of_Distributorship;
        public static String E_distributor_info;
        public static String E_Name_Of_Distributor_Firm;
        public static String E_Proprietor_Name;
        public static String E_Proprietor_Mobile_Number;
        public static String E_Contact_Person_Mobile_Number;
        public static String E_Farm_Address;
        public static String E_Proprietor_Permanent_Address;
        public static String E_Proprietor_Present_Address;
        public static String E_Proprietor_National_ID_Number;
        public static String E_Trade_License_Number_Last_Date;
        public static String E_Bank_Name_Branch;
        public static String E_Bank_Account_Number;
        public static String E_Name_Of_Existing_Business1;
        public static String E_Name_Of_Existing_Business2;
        public static String E_Existing_Business1_Starting_Year;
        public static String E_Existing_Business2_Starting_Year;
        public static String E_No_Of_Existing_Van_Puller_Or_DSR;
        public static String E_Number_Of_Existing_Ice_Cream_Van;
        public static String E_Existing_Godown_Size_SQFT;
        public static String E_Relation_With_Golden_Group_Entity;
        public static String E_Area_Demarcation;
        public static String E_Point_Name;
        public static String E_Routes;
        public static String E_Key_Markets;
        public static String E_Ice_Cream_Selling_Outlets_Territory;
        public static String E_Existing_Avg_Market_Size_Tk_Yearly;
        public static String E_discount_type;
        public static String E_discount_amount;
        public static String E_C_Igloo;
        public static String E_C_Polar;
        public static String E_C_Lovello;
        public static String E_C_Kazi;
        public static String E_C_Bloop;
        public static String E_C_Kwality;
        public static String E_C_Others;
        public static String E_D_F_Igloo;
        public static String E_D_F_Polar;
        public static String E_D_F_Lovello;
        public static String E_D_F_Kazi;
        public static String E_D_F_Bloop;
        public static String E_D_F_Kwality;
        public static String E_D_F_Others;
        public static String E_S_Igloo;
        public static String E_S_Polar;
        public static String E_S_Lovello;
        public static String E_S_Kazi;
        public static String E_S_Bloop;
        public static String E_S_Kwality;
        public static String E_S_Others;
        public static String E_F_Igloo;
        public static String E_F_Polar;
        public static String E_F_Lovello;
        public static String E_F_Kazi;
        public static String E_F_Bloop;
        public static String E_F_Kwality;
        public static String E_F_Others;
        public static String E_Total_Investment_Tk;
        public static String E_Initial_Lifting_In_Tk;
        public static String E_Number_Of_SDFs;
        public static String E_Godown_Advance;
        public static String E_Value_Of_SDFs;
        public static String E_Market_Credit;
        public static String E_Number_Of_Van_S;
        public static String E_Running_Capital;
        public static String E_Value_Of_Vans_Tk;
        public static String E_Type_Of_Transaction;
        public static String E_RSMs_or_ASM_in_absence_of_RSM_Recommendation;
        public static String E_GM_DGM_AGMs_Recommendation;
    }

    public static class Offer {
        public static String Type;
        public static String ProductGiftCondition;
        public static String NumOfCategory;
        public static String NumOfOffers;
        public static String[] ItemCatg = new String[5];
        public static String[] ItemSubCatg = new String[5];
        public static String[] ItemProd = new String[5];
        public static String[] EItemSubCatg = new String[5];
        public static String[] EItemProd = new String[5];
        public static String[] GiftItem = new String[5];
        public static String Region;
        public static String Depot;
        public static String Area;
        public static String Territory;
        public static String Distributor;
        public static String ExDistributor;
        public static String Active;
        public static String CreditAllowed;
    }

    public static class PRODCAT {
        public static String SearchInfo;
        public static String Name;
        public static String MainCategory;
        public static String Status;
        public static String E_Name;
    }

    public static class product {
        public static String SearchInfo;
        public static String Code;
        public static String Name;
        public static String Category;
        public static String flavor;
        public static String sizeML;
        public static String CtnPCS;
        public static String RetailPrice;
        public static String TradePrice;
        public static String DistributorPrice;
        public static String E_Code;
        public static String E_Name;
        public static String E_Category;
        public static String E_flavor;
        public static String E_sizeML;
        public static String E_CtnPCS;
        public static String E_RetailPrice;
        public static String E_TradePrice;
        public static String E_DistributorPrice;
    }

    public static class SalesReturn {
        public static String SearchInfo;
        public static String DistributorSearch;
        public static String Store;
        public static String Note;
        public static String FullReturn;
    }
    public static class StoreType{
        public static String SearchInfo;
        public static String FullName;
        public static String E_FullName;
        public static String E_ShortName;
        public static String ShortName;
    }


    public static String[] readJsonData() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/Test_Data.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            {// Read data from the "Login" object
                JSONObject loginObject = (JSONObject) jsonObject.get("Login");
//                url_AIR = (String) loginObject.get("url_AIR");
                Users.BPU = (String) loginObject.get("url_BPU");
                Users.L1Tester = (String) loginObject.get("L1Tester");
                Users.L2Tester = (String) loginObject.get("L2Tester");
                Users.AIR_2 = (String) loginObject.get("url_AIR_2");
                Users.AIR_2_AIR = (String) loginObject.get("url_AIR_2_AIR");
                Users.user_Fahim = (String) loginObject.get("user_Fahim");
                Users.user_Polash = (String) loginObject.get("user_Polash");
                Users.user_Siam = (String) loginObject.get("user_Siam");
                Users.user_Ashik = (String) loginObject.get("user_Ashik");
                Users.user_Haseeb = (String) loginObject.get("user_Haseeb");
                Users.password = (String) loginObject.get("password");
            }
            {// Read data from the "Contacts" object
                JSONObject ContactsObject = (JSONObject) jsonObject.get("Contacts");
                ContactsSearchInfo = (String) ContactsObject.get("SearchInfo");
            }
            {// Read data from the "Items" object
                JSONObject ItemsObject = (JSONObject) jsonObject.get("Items");
                for (int i = 0; i < Users.ItemsArray.length; i++) {
                    Users.ItemsArray[i] = (String) ItemsObject.get("Item" + (i + 1));
                }
            }
            {// Read data from the "PreInvoice" object
                JSONObject PreInvoiceObject = (JSONObject) jsonObject.get("PreInvoice");
                PreInvoices.SearchInfo = (String) PreInvoiceObject.get("SearchInfo");
                PreInvoices.ItemQuantity = (String) PreInvoiceObject.get("ItemQuantity");
                PreInvoices.DistributorSearch = (String) PreInvoiceObject.get("DistributorSearch");
                PreInvoices.CheckBox = (String) PreInvoiceObject.get("Checkbox");
                PreInvoices.CashCommission = (String) PreInvoiceObject.get("Cash Commission");
                PreInvoices.Items = Users.ItemsArray;
                PreInvoices.OfferCTN = (String) PreInvoiceObject.get("OfferCTN");
                PreInvoices.OfferPCS = (String) PreInvoiceObject.get("OfferPCS");
                PreInvoices.Notes = (String) PreInvoiceObject.get("Notes");
            }
            {// Read data from the "Audit Stock Update" object
                JSONObject AuditStockUpdateObject = (JSONObject) jsonObject.get("Audit Stock Update");
                AuditStockUpdate.SearchInfo = (String) AuditStockUpdateObject.get("SearchInfo");
                AuditStockUpdate.ItemQuantity = (String) AuditStockUpdateObject.get("ItemQuantity");
                AuditStockUpdate.StoreSearch = (String) AuditStockUpdateObject.get("StoreSearch");
                AuditStockUpdate.DepotSearch = (String) AuditStockUpdateObject.get("DepotSearch");
            }
            {// Read data from the "PreviousPendingDelivery" object
                JSONObject PreviousPendingDeliveryObject = (JSONObject) jsonObject.get("PreviousPendingDelivery");
                PreviousPendingDelivery.SearchInfo = (String) PreviousPendingDeliveryObject.get("SearchInfo");
                PreviousPendingDelivery.ItemQuantity = (String) PreviousPendingDeliveryObject.get("ItemQuantity");
                PreviousPendingDelivery.DistributorSearch = (String) PreviousPendingDeliveryObject.get("DistributorSearch");
                PreviousPendingDelivery.Store = (String) PreviousPendingDeliveryObject.get("Store");
                PreviousPendingDelivery.Inv_Ref = (String) PreviousPendingDeliveryObject.get("Inv_Ref");
                PreviousPendingDelivery.ImportantNotes = (String) PreviousPendingDeliveryObject.get("ImportantNoted");
                PreviousPendingDelivery.Items = Users.ItemsArray;
            }
            {// Read data from the "Apps" object
                JSONObject AppsObject = (JSONObject) jsonObject.get("Apps");
                Apps.SearchInfo = (String) AppsObject.get("SearchInfo");
                Apps.Name = (String) AppsObject.get("Name");
                Apps.AppActive = (Boolean) AppsObject.get("AppActive");
                Apps.DisplayName = (String) AppsObject.get("Display Name");
                Apps.Link = (String) AppsObject.get("Link");
                Apps.EditedName = (String) AppsObject.get("Edited Name");
                Apps.EditedDisplayName = (String) AppsObject.get("Edited Display Name");
                for (int i = 0; i < Apps.EmployeeInfo.length; i++) {
                    Apps.EmployeeInfo[i] = (String) AppsObject.get("Employee info" + (i + 1));
                }
            }
            {// Read data from the "Order" object
                JSONObject OrderObject = (JSONObject) jsonObject.get("Order");
                Order.SearchInfo = (String) OrderObject.get("SearchInfo");
                Order.ItemQuantity = (String) OrderObject.get("ItemQuantity");
                Order.DistributorSearch = (String) OrderObject.get("DistributorSearch");
                Order.Note = (String) OrderObject.get("Note");
                Order.Refference_No = (String) OrderObject.get("Refference No");
                Order.CashCommission = (String) OrderObject.get("CashCommission");
                Order.Items = Users.ItemsArray;
            }
            {// Read data from the "CancelOrder" object
                JSONObject CancelOrderObject = (JSONObject) jsonObject.get("CancelOrder");
                CancelOrder.SearchInfo = (String) CancelOrderObject.get("SearchInfo");
                CancelOrder.ItemQuantity = (String) CancelOrderObject.get("ItemQuantity");
                CancelOrder.DistributorSearch = (String) CancelOrderObject.get("DistributorSearch");
                CancelOrder.Note = (String) CancelOrderObject.get("Note");
            }
            {// Read data from the "DistributorInvoice" object
                JSONObject DistributorInvoiceObject = (JSONObject) jsonObject.get("DistributorInvoice");
                Invoices.SearchInfo = (String) DistributorInvoiceObject.get("SearchInfo");
                Invoices.DistributorSearch = (String) DistributorInvoiceObject.get("DistributorSearch");
                Invoices.Store = (String) DistributorInvoiceObject.get("Store");
                Invoices.Note = (String) DistributorInvoiceObject.get("Note");
                Invoices.ItemQuantity = (String) DistributorInvoiceObject.get("ItemQuantity");
                Invoices.OfferQuantity = (String) DistributorInvoiceObject.get("OfferQuantity");
                Invoices.OfferCTN = (String) DistributorInvoiceObject.get("OfferCTN");
                Invoices.PartialInvoice = (boolean) DistributorInvoiceObject.get("PartialInvoice");
                Invoices.IntervalOfSaveTime = (long) DistributorInvoiceObject.get("IntervalOfSaveTime");

            }
            {// Read data from the "CancelInvoice" object
                JSONObject CancelInvoiceObject = (JSONObject) jsonObject.get("Cancel Invoice");
                CancelInvoice.SearchInfo = (String) CancelInvoiceObject.get("SearchInfo");
                CancelInvoice.DistributorSearch = (String) CancelInvoiceObject.get("DistributorSearch");
                CancelInvoice.Store = (String) CancelInvoiceObject.get("Store");
                CancelInvoice.Note = (String) CancelInvoiceObject.get("Note");
            }
            {// Read data from the "Complementary Invoice" object
                JSONObject ComplementaryInvoiceObject = (JSONObject) jsonObject.get("Complementary Invoice");
                ComplementaryInvoice.SearchInfo = (String) ComplementaryInvoiceObject.get("SearchInfo");
                ComplementaryInvoice.ItemQuantity = (String) ComplementaryInvoiceObject.get("ItemQuantity");
                ComplementaryInvoice.DistributorSearch = (String) ComplementaryInvoiceObject.get("DistributorSearch");
                ComplementaryInvoice.Store = (String) ComplementaryInvoiceObject.get("Store");
                ComplementaryInvoice.Note = (String) ComplementaryInvoiceObject.get("Note");
                ComplementaryInvoice.InvoiceReferenceNo = (String) ComplementaryInvoiceObject.get("InvoiceReferenceNo");
                ComplementaryInvoice.Items = Users.ItemsArray;
            }
            {// Read data from the "Collection" object
                JSONObject CollectionObject = (JSONObject) jsonObject.get("Collection");
                Collection.SearchInfo = (String) CollectionObject.get("SearchInfo");
                Collection.DistributorSearch = (String) CollectionObject.get("DistributorSearch");
                Collection.CollectedBy = (String) CollectionObject.get("CollectedBy");
                Collection.CollectionAmount = (String) CollectionObject.get("CollectionAmount");
                Collection.MoneyReceipt = (String) CollectionObject.get("MoneyReceipt");
                Collection.AdvanceCollection = (Boolean) CollectionObject.get("AdvanceCollection");
                Collection.AdjustFromAdvance = (Boolean) CollectionObject.get("AdjustFromAdvance");
                Collection.CollectionInCash = (Boolean) CollectionObject.get("CollectionInCash");
                Collection.InstrumentType = (String) CollectionObject.get("InstrumentType");
                Collection.MoneyReceipt = (String) CollectionObject.get("MoneyReceipt");
                Collection.Field1 = (String) CollectionObject.get("Field1");
                Collection.Field2 = (String) CollectionObject.get("Field2");
                Collection.Field3 = (String) CollectionObject.get("Field3");
                Collection.Field4 = (String) CollectionObject.get("Field4");
                Collection.Field5 = (String) CollectionObject.get("Field5");
            }
            {// Read data from the "Good Requisition and On Vehicle Store" object
                JSONObject GROVS_Object = (JSONObject) jsonObject.get("Good Requisition and On Vehicle Store");
                GROVS.SearchInfo = (String) GROVS_Object.get("SearchInfo");
                GROVS.Vehicle = (String) GROVS_Object.get("Vehicle");
                GROVS.RequestFrom = (String) GROVS_Object.get("RequestFrom");
                GROVS.RequestTo = (String) GROVS_Object.get("RequestTo");
                GROVS.ItemQuantity = (String) GROVS_Object.get("ItemQuantity");
                GROVS.AcceptedQuantity = (String) GROVS_Object.get("AcceptedQuantity");
                GROVS.InvoiceItems = Users.ItemsArray;
            }
            {// Read data from the "FG Store" object
                JSONObject FGS_Object = (JSONObject) jsonObject.get("FG Store");
                FGS.SearchInfo = (String) FGS_Object.get("SearchInfo");
                FGS.EditedCode = (String) FGS_Object.get("EditedCode");
                FGS.Name = (String) FGS_Object.get("Name");
                FGS.Code = (String) FGS_Object.get("Code");
                FGS.Type = (String) FGS_Object.get("Type");
                FGS.EditedType = (String) FGS_Object.get("EditedType");
                FGS.Definition = (String) FGS_Object.get("Definition");
                FGS.EditedDefinition = (String) FGS_Object.get("EditedDefinition");
                FGS.EditedAddress = (String) FGS_Object.get("EditedAddress");
                FGS.Region = (String) FGS_Object.get("Region");
                FGS.Depots = (String) FGS_Object.get("Depots");
                FGS.Address = (String) FGS_Object.get("Address");
                FGS.EditedName = (String) FGS_Object.get("EditedName");
                FGS.Store = (String) FGS_Object.get("Store");
                FGS.StoreToAddProducts = (String) FGS_Object.get("StoreToAddProducts");
                FGS.Items = Users.ItemsArray;
                FGS.ItemQuantity = (String) FGS_Object.get("Quantity");
            }
            {// Read data from the "Distributors" object
                JSONObject distributorsObject = (JSONObject) jsonObject.get("Distributors");

                Distributors.SearchInfo = (String) distributorsObject.get("SearchInfo");
                //Creation
                JSONObject DistributorCreationObject = (JSONObject) distributorsObject.get("Creation");
                Distributors.Reference = (String) DistributorCreationObject.get("Reference");
                Distributors.SDF = (String) DistributorCreationObject.get("SDF");
                Distributors.RDF = (String) DistributorCreationObject.get("RDF");
                Distributors.Region = (String) DistributorCreationObject.get("Region");
                Distributors.depot = (String) DistributorCreationObject.get("depot");
                Distributors.Area = (String) DistributorCreationObject.get("Area");
                Distributors.territory = (String) DistributorCreationObject.get("territory");
                Distributors.B_P_code = (String) DistributorCreationObject.get("B P code");
                Distributors.RSM = (String) DistributorCreationObject.get("RSM");
                Distributors.ASM_Sr_ASM = (String) DistributorCreationObject.get("ASM / Sr. ASM");
                Distributors.FPR = (String) DistributorCreationObject.get("FPR");
                Distributors.Running_FPR = (String) DistributorCreationObject.get("Running FPR");
                Distributors.Identity_Of_Distributor = (String) DistributorCreationObject.get("Identity Of Distributor");
                Distributors.Type_Of_Distributorship = (String) DistributorCreationObject.get("Type Of Distributorship");
                Distributors.distributor_info = (String) DistributorCreationObject.get("distributor info");
                Distributors.Name_Of_Distributor_Firm = (String) DistributorCreationObject.get("Name Of Distributor/Firm");
                Distributors.Proprietor_Name = (String) DistributorCreationObject.get("Proprietor Name");
                Distributors.Proprietor_Mobile_Number = (String) DistributorCreationObject.get("Proprietor Mobile Number");
                Distributors.Contact_Person_Mobile_Number = (String) DistributorCreationObject.get("Contact Person & Mobile Number");
                Distributors.Farm_Address = (String) DistributorCreationObject.get("Farm Address");
                Distributors.Proprietor_Permanent_Address = (String) DistributorCreationObject.get("Proprietor Permanent Address");
                Distributors.Proprietor_Present_Address = (String) DistributorCreationObject.get("Proprietor Present Address");
                Distributors.Proprietor_National_ID_Number = (String) DistributorCreationObject.get("Proprietor National ID Number");
                Distributors.Trade_License_Number_Last_Date = (String) DistributorCreationObject.get("Trade License Number & Last Date");
                Distributors.Bank_Name_Branch = (String) DistributorCreationObject.get("Bank Name & Branch");
                Distributors.Bank_Account_Number = (String) DistributorCreationObject.get("Bank Account Number");
                Distributors.Name_Of_Existing_Business1 = (String) DistributorCreationObject.get("Name Of Existing Business1");
                Distributors.Name_Of_Existing_Business2 = (String) DistributorCreationObject.get("Name Of Existing Business2");
                Distributors.Existing_Business1_Starting_Year = (String) DistributorCreationObject.get("Existing Business1 Starting Year");
                Distributors.Existing_Business2_Starting_Year = (String) DistributorCreationObject.get("Existing Business2 Starting Year");
                Distributors.No_Of_Existing_Van_Puller_Or_DSR = (String) DistributorCreationObject.get("No. Of Existing Van Puller & Or DSR");
                Distributors.Number_Of_Existing_Ice_Cream_Van = (String) DistributorCreationObject.get("Number Of Existing Ice Cream Van");
                Distributors.Existing_Godown_Size_SQFT = (String) DistributorCreationObject.get("Existing Godown Size (SQFT)");
                Distributors.Relation_With_Golden_Group_Entity = (String) DistributorCreationObject.get("Relation With Golden Group Entity");
                Distributors.Area_Demarcation = (String) DistributorCreationObject.get("Area Demarcation");
                Distributors.Point_Name = (String) DistributorCreationObject.get("Point Name");
                Distributors.Routes = (String) DistributorCreationObject.get("Routes");
                Distributors.Key_Markets = (String) DistributorCreationObject.get("Key Markets");
                Distributors.Ice_Cream_Selling_Outlets_Territory = (String) DistributorCreationObject.get("Ice Cream Selling Outlets Territory");
                Distributors.Existing_Avg_Market_Size_Tk_Yearly = (String) DistributorCreationObject.get("Existing Avg Market Size (Tk) : (Yearly)");
                Distributors.discount_type = (String) DistributorCreationObject.get("discount type");
                Distributors.discount_amount = (String) DistributorCreationObject.get("discount amount");
                Distributors.C_Igloo = (String) DistributorCreationObject.get("C_Igloo");
                Distributors.C_Polar = (String) DistributorCreationObject.get("C_Polar");
                Distributors.C_Lovello = (String) DistributorCreationObject.get("C_Lovello");
                Distributors.C_Kazi = (String) DistributorCreationObject.get("C_Kazi");
                Distributors.C_Bloop = (String) DistributorCreationObject.get("C_Bloop");
                Distributors.C_Kwality = (String) DistributorCreationObject.get("C_Kwality");
                Distributors.C_Others = (String) DistributorCreationObject.get("C_Others");
                Distributors.D_F_Igloo = (String) DistributorCreationObject.get("D/F_Igloo");
                Distributors.D_F_Polar = (String) DistributorCreationObject.get("D/F_Polar");
                Distributors.D_F_Lovello = (String) DistributorCreationObject.get("D/F_Lovello");
                Distributors.D_F_Kazi = (String) DistributorCreationObject.get("D/F_Kazi");
                Distributors.D_F_Bloop = (String) DistributorCreationObject.get("D/F_Bloop");
                Distributors.D_F_Kwality = (String) DistributorCreationObject.get("D/F_Kwality");
                Distributors.D_F_Others = (String) DistributorCreationObject.get("D/F_Others");
                Distributors.S_Igloo = (String) DistributorCreationObject.get("S_Igloo");
                Distributors.S_Polar = (String) DistributorCreationObject.get("S_Polar");
                Distributors.S_Lovello = (String) DistributorCreationObject.get("S_Lovello");
                Distributors.S_Kazi = (String) DistributorCreationObject.get("S_Kazi");
                Distributors.S_Bloop = (String) DistributorCreationObject.get("S_Bloop");
                Distributors.S_Kwality = (String) DistributorCreationObject.get("S_Kwality");
                Distributors.S_Others = (String) DistributorCreationObject.get("S_Others");
                Distributors.F_Igloo = (String) DistributorCreationObject.get("F_Igloo");
                Distributors.F_Polar = (String) DistributorCreationObject.get("F_Polar");
                Distributors.F_Lovello = (String) DistributorCreationObject.get("F_Lovello");
                Distributors.F_Kazi = (String) DistributorCreationObject.get("F_Kazi");
                Distributors.F_Bloop = (String) DistributorCreationObject.get("F_Bloop");
                Distributors.F_Kwality = (String) DistributorCreationObject.get("F_Kwality");
                Distributors.F_Others = (String) DistributorCreationObject.get("F_Others");
                Distributors.Total_Investment_Tk = (String) DistributorCreationObject.get("Total Investment (Tk)");
                Distributors.Initial_Lifting_In_Tk = (String) DistributorCreationObject.get("Initial Lifting (In Tk)");
                Distributors.Number_Of_SDFs = (String) DistributorCreationObject.get("Number Of SDFs");
                Distributors.Godown_Advance = (String) DistributorCreationObject.get("Godown Advance");
                Distributors.Value_Of_SDFs = (String) DistributorCreationObject.get("Value Of SDFs");
                Distributors.Market_Credit = (String) DistributorCreationObject.get("Market Credit");
                Distributors.Number_Of_Van_S = (String) DistributorCreationObject.get("Number Of Van(S)");
                Distributors.Running_Capital = (String) DistributorCreationObject.get("Running Capital");
                Distributors.Value_Of_Vans_Tk = (String) DistributorCreationObject.get("Value Of Vans (Tk)");
                Distributors.Type_Of_Transaction = (String) DistributorCreationObject.get("Type Of Transaction");
                Distributors.RSMs_or_ASM_in_absence_of_RSM_Recommendation = (String) DistributorCreationObject.get("RSM's (or ASM in absence of RSM) Recommendation");
                Distributors.GM_DGM_AGMs_Recommendation = (String) DistributorCreationObject.get("GM/DGM/AGM's Recommendation");
                //Editing
                JSONObject DistributorEditingObject = (JSONObject) distributorsObject.get("Editing");
                Distributors.E_Reference = (String) DistributorEditingObject.get("Reference");
                Distributors.E_SDF = (String) DistributorEditingObject.get("SDF");
                Distributors.E_RDF = (String) DistributorEditingObject.get("RDF");
                Distributors.E_Region = (String) DistributorEditingObject.get("Region");
                Distributors.E_depot = (String) DistributorEditingObject.get("depot");
                Distributors.E_Area = (String) DistributorEditingObject.get("Area");
                Distributors.E_territory = (String) DistributorEditingObject.get("territory");
                Distributors.E_B_P_code = (String) DistributorEditingObject.get("B P code");
                Distributors.E_RSM = (String) DistributorEditingObject.get("RSM");
                Distributors.E_ASM_Sr_ASM = (String) DistributorEditingObject.get("ASM / Sr. ASM");
                Distributors.E_FPR = (String) DistributorEditingObject.get("FPR");
                Distributors.E_Running_FPR = (String) DistributorEditingObject.get("Running FPR");
                Distributors.E_Identity_Of_Distributor = (String) DistributorEditingObject.get("Identity Of Distributor");
                Distributors.E_Type_Of_Distributorship = (String) DistributorEditingObject.get("Type Of Distributorship");
                Distributors.E_distributor_info = (String) DistributorEditingObject.get("distributor info");
                Distributors.E_Name_Of_Distributor_Firm = (String) DistributorEditingObject.get("Name Of Distributor/Firm");
                Distributors.E_Proprietor_Name = (String) DistributorEditingObject.get("Proprietor Name");
                Distributors.E_Proprietor_Mobile_Number = (String) DistributorEditingObject.get("Proprietor Mobile Number");
                Distributors.E_Contact_Person_Mobile_Number = (String) DistributorEditingObject.get("Contact Person & Mobile Number");
                Distributors.E_Farm_Address = (String) DistributorEditingObject.get("Farm Address");
                Distributors.E_Proprietor_Permanent_Address = (String) DistributorEditingObject.get("Proprietor Permanent Address");
                Distributors.E_Proprietor_Present_Address = (String) DistributorEditingObject.get("Proprietor Present Address");
                Distributors.E_Proprietor_National_ID_Number = (String) DistributorEditingObject.get("Proprietor National ID Number");
                Distributors.E_Trade_License_Number_Last_Date = (String) DistributorEditingObject.get("Trade License Number & Last Date");
                Distributors.E_Bank_Name_Branch = (String) DistributorEditingObject.get("Bank Name & Branch");
                Distributors.E_Bank_Account_Number = (String) DistributorEditingObject.get("Bank Account Number");
                Distributors.E_Name_Of_Existing_Business1 = (String) DistributorEditingObject.get("Name Of Existing Business1");
                Distributors.E_Name_Of_Existing_Business2 = (String) DistributorEditingObject.get("Name Of Existing Business2");
                Distributors.E_Existing_Business1_Starting_Year = (String) DistributorEditingObject.get("Existing Business1 Starting Year");
                Distributors.E_Existing_Business2_Starting_Year = (String) DistributorEditingObject.get("Existing Business2 Starting Year");
                Distributors.E_No_Of_Existing_Van_Puller_Or_DSR = (String) DistributorEditingObject.get("No. Of Existing Van Puller & Or DSR");
                Distributors.E_Number_Of_Existing_Ice_Cream_Van = (String) DistributorEditingObject.get("Number Of Existing Ice Cream Van");
                Distributors.E_Existing_Godown_Size_SQFT = (String) DistributorEditingObject.get("Existing Godown Size (SQFT)");
                Distributors.E_Relation_With_Golden_Group_Entity = (String) DistributorEditingObject.get("Relation With Golden Group Entity");
                Distributors.E_Area_Demarcation = (String) DistributorEditingObject.get("Area Demarcation");
                Distributors.E_Point_Name = (String) DistributorEditingObject.get("Point Name");
                Distributors.E_Routes = (String) DistributorEditingObject.get("Routes");
                Distributors.E_Key_Markets = (String) DistributorEditingObject.get("Key Markets");
                Distributors.E_Ice_Cream_Selling_Outlets_Territory = (String) DistributorEditingObject.get("Ice Cream Selling Outlets Territory");
                Distributors.E_Existing_Avg_Market_Size_Tk_Yearly = (String) DistributorEditingObject.get("Existing Avg Market Size (Tk) : (Yearly)");
                Distributors.E_discount_type = (String) DistributorEditingObject.get("discount type");
                Distributors.E_discount_amount = (String) DistributorEditingObject.get("discount amount");
                Distributors.E_C_Igloo = (String) DistributorEditingObject.get("C_Igloo");
                Distributors.E_C_Polar = (String) DistributorEditingObject.get("C_Polar");
                Distributors.E_C_Lovello = (String) DistributorEditingObject.get("C_Lovello");
                Distributors.E_C_Kazi = (String) DistributorEditingObject.get("C_Kazi");
                Distributors.E_C_Bloop = (String) DistributorEditingObject.get("C_Bloop");
                Distributors.E_C_Kwality = (String) DistributorEditingObject.get("C_Kwality");
                Distributors.E_C_Others = (String) DistributorEditingObject.get("C_Others");
                Distributors.E_D_F_Igloo = (String) DistributorEditingObject.get("D/F_Igloo");
                Distributors.E_D_F_Polar = (String) DistributorEditingObject.get("D/F_Polar");
                Distributors.E_D_F_Lovello = (String) DistributorEditingObject.get("D/F_Lovello");
                Distributors.E_D_F_Kazi = (String) DistributorEditingObject.get("D/F_Kazi");
                Distributors.E_D_F_Bloop = (String) DistributorEditingObject.get("D/F_Bloop");
                Distributors.E_D_F_Kwality = (String) DistributorEditingObject.get("D/F_Kwality");
                Distributors.E_D_F_Others = (String) DistributorEditingObject.get("D/F_Others");
                Distributors.E_S_Igloo = (String) DistributorEditingObject.get("S_Igloo");
                Distributors.E_S_Polar = (String) DistributorEditingObject.get("S_Polar");
                Distributors.E_S_Lovello = (String) DistributorEditingObject.get("S_Lovello");
                Distributors.E_S_Kazi = (String) DistributorEditingObject.get("S_Kazi");
                Distributors.E_S_Bloop = (String) DistributorEditingObject.get("S_Bloop");
                Distributors.E_S_Kwality = (String) DistributorEditingObject.get("S_Kwality");
                Distributors.E_S_Others = (String) DistributorEditingObject.get("S_Others");
                Distributors.E_F_Igloo = (String) DistributorEditingObject.get("F_Igloo");
                Distributors.E_F_Polar = (String) DistributorEditingObject.get("F_Polar");
                Distributors.E_F_Lovello = (String) DistributorEditingObject.get("F_Lovello");
                Distributors.E_F_Kazi = (String) DistributorEditingObject.get("F_Kazi");
                Distributors.E_F_Bloop = (String) DistributorEditingObject.get("F_Bloop");
                Distributors.E_F_Kwality = (String) DistributorEditingObject.get("F_Kwality");
                Distributors.E_F_Others = (String) DistributorEditingObject.get("F_Others");
                Distributors.E_Total_Investment_Tk = (String) DistributorEditingObject.get("Total Investment (Tk)");
                Distributors.E_Initial_Lifting_In_Tk = (String) DistributorEditingObject.get("Initial Lifting (In Tk)");
                Distributors.E_Number_Of_SDFs = (String) DistributorEditingObject.get("Number Of SDFs");
                Distributors.E_Godown_Advance = (String) DistributorEditingObject.get("Godown Advance");
                Distributors.E_Value_Of_SDFs = (String) DistributorEditingObject.get("Value Of SDFs");
                Distributors.E_Market_Credit = (String) DistributorEditingObject.get("Market Credit");
                Distributors.E_Number_Of_Van_S = (String) DistributorEditingObject.get("Number Of Van(S)");
                Distributors.E_Running_Capital = (String) DistributorEditingObject.get("Running Capital");
                Distributors.E_Value_Of_Vans_Tk = (String) DistributorEditingObject.get("Value Of Vans (Tk)");
                Distributors.E_Type_Of_Transaction = (String) DistributorEditingObject.get("Type Of Transaction");
                Distributors.E_RSMs_or_ASM_in_absence_of_RSM_Recommendation = (String) DistributorEditingObject.get("RSM's (or ASM in absence of RSM) Recommendation");
                Distributors.E_GM_DGM_AGMs_Recommendation = (String) DistributorEditingObject.get("GM/DGM/AGM's Recommendation");
            }
            {// Read data from the "Offer" object
                JSONObject Offer_Object = (JSONObject) jsonObject.get("Offer");
                Offer.Type = (String) Offer_Object.get("OfrType");
                Offer.ProductGiftCondition = (String) Offer_Object.get("ProductGiftCondition");
                Offer.NumOfCategory = (String) Offer_Object.get("NumOfCategory");
                Offer.NumOfOffers = (String) Offer_Object.get("NumOfOffers");
                for (int i = 0; i < Offer.ItemCatg.length; i++) {
                    Offer.ItemCatg[i] = (String) Offer_Object.get("ItemCatg" + (i + 1));
                }
                for (int i = 0; i < Offer.ItemSubCatg.length; i++) {
                    Offer.ItemSubCatg[i] = (String) Offer_Object.get("ItemSubCatg" + (i + 1));
                }
                for (int i = 0; i < Offer.ItemProd.length; i++) {
                    Offer.ItemProd[i] = (String) Offer_Object.get("ItemProd" + (i + 1));
                }
                for (int i = 0; i < Offer.EItemSubCatg.length; i++) {
                    Offer.EItemSubCatg[i] = (String) Offer_Object.get("EItemSubCatg" + (i + 1));
                }
                for (int i = 0; i < Offer.EItemProd.length; i++) {
                    Offer.EItemProd[i] = (String) Offer_Object.get("EItemProd" + (i + 1));
                }
                for (int i = 0; i < Offer.GiftItem.length; i++) {
                    Offer.GiftItem[i] = (String) Offer_Object.get("GiftItem" + (i + 1));
                }

                Offer.Region = (String) Offer_Object.get("Region");
                Offer.Depot = (String) Offer_Object.get("Depot");
                Offer.Area = (String) Offer_Object.get("Area");
                Offer.Territory = (String) Offer_Object.get("Territory");
                Offer.Distributor = (String) Offer_Object.get("Distributor");
                Offer.ExDistributor = (String) Offer_Object.get("ExDistributor");
                Offer.Active = (String) Offer_Object.get("Active");
                Offer.CreditAllowed = (String) Offer_Object.get("CreditAllowed");
            }
            {// Read data from the "Products Category" object
                JSONObject PRODCAT_Object = (JSONObject) jsonObject.get("Products Category");
                PRODCAT.SearchInfo = (String) PRODCAT_Object.get("SearchInfo");
                PRODCAT.Name = (String) PRODCAT_Object.get("name");
                PRODCAT.MainCategory = (String) PRODCAT_Object.get("maincategory");
                PRODCAT.Status = (String) PRODCAT_Object.get("status");
                PRODCAT.E_Name = (String) PRODCAT_Object.get("E_Name");
            }
            {// Read data from the "Products" object
                JSONObject PROD_Object = (JSONObject) jsonObject.get("Products");
                product.SearchInfo = (String) PROD_Object.get("SearchInfo");
                product.Code = (String) PROD_Object.get("Code");
                product.Name = (String) PROD_Object.get("Name");
                product.Category = (String) PROD_Object.get("Category");
                product.flavor = (String) PROD_Object.get("flavor");
                product.sizeML = (String) PROD_Object.get("sizeML");
                product.CtnPCS = (String) PROD_Object.get("CtnPCS");
                product.RetailPrice = (String) PROD_Object.get("RetailPrice");
                product.TradePrice = (String) PROD_Object.get("TradePrice");
                product.DistributorPrice = (String) PROD_Object.get("DistributorPrice");
                product.E_Code = (String) PROD_Object.get("E_Code");
                product.E_Name = (String) PROD_Object.get("E_Name");
                product.E_Category = (String) PROD_Object.get("E_Category");
                product.E_flavor = (String) PROD_Object.get("E_flavor");
                product.E_sizeML = (String) PROD_Object.get("E_sizeML");
                product.E_CtnPCS = (String) PROD_Object.get("E_CtnPCS");
                product.E_RetailPrice = (String) PROD_Object.get("E_RetailPrice");
                product.E_TradePrice = (String) PROD_Object.get("E_TradePrice");
                product.E_DistributorPrice = (String) PROD_Object.get("E_DistributorPrice");
            }
            {// Read data from the "Sales Return" object
                JSONObject PROD_Object = (JSONObject) jsonObject.get("Sales Return");
                SalesReturn.SearchInfo = (String) PROD_Object.get("SearchInfo");
                SalesReturn.DistributorSearch = (String) PROD_Object.get("DistributorSearch");
                SalesReturn.Store = (String) PROD_Object.get("Store");
                SalesReturn.Note = (String) PROD_Object.get("Note");
                SalesReturn.FullReturn = (String) PROD_Object.get("Full Return");
            }
            {JSONObject StoreType_Object = (JSONObject) jsonObject.get("Store Type");
                StoreType.SearchInfo = (String) StoreType_Object.get("Search_info");
                StoreType.FullName = (String) StoreType_Object.get("FullName");
                StoreType.ShortName = (String) StoreType_Object.get("ShortName");
                StoreType.E_ShortName = (String) StoreType_Object.get("E_FullName");
                StoreType.E_FullName = (String) StoreType_Object.get("E_ShortName");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new String[]{};
    }
}

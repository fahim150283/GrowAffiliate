package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    public static class Signup {
        public static String url;
        public static String password;
        public static String ItemsArray[] = new String[15];
    }


    public static String[] readJsonData() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/Test_Data.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            {// Read data from the "Signup" object
                JSONObject loginObject = (JSONObject) jsonObject.get("Signup");
                Signup.url = (String) loginObject.get("url");

            }
            {// Read data from the "Items" object
                JSONObject ItemsObject = (JSONObject) jsonObject.get("Items");
                for (int i = 0; i < Signup.ItemsArray.length; i++) {
                    Signup.ItemsArray[i] = (String) ItemsObject.get("Item" + (i + 1));
                }
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return new String[]{};
    }
}

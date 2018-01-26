package org.sergiogarcia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.sergiogarcia.quickconnectfamily.json.JSONUtilities;


public class Main {

    public static String clean_json(String json_input) {
        return json_input.replace(System.getProperty("line.separator"), "");
    }

    public static void test_json_file(String filepath) {
        System.out.println("Testing: " + filepath);

        try {

            // Object Classes
            HashMap parsedJSONMap = null;
            TestObject readObject = null;

            // Read String from file ...
            String jsonString = new String(Files.readAllBytes(Paths.get(filepath)));
            // jsonString = clean_json(jsonString);
            System.out.println("Contents: " + jsonString);

            // Parse String
            parsedJSONMap = (HashMap)JSONUtilities.parse(jsonString);
            readObject = new TestObject(parsedJSONMap);
            System.out.println("Parsed Object: " + parsedJSONMap.toString());

            // Stringify ...
            System.out.println("Stringified Object JSON: " + JSONUtilities.stringify(readObject));

        } catch (Exception e) {
            System.out.println("Exception when parsing json file:  " + e.toString());
        }
    }

    public static void main(String[] args){
        for(int i = 0; i < args.length; i++) {
            System.out.println("\n\nArgument " + i + ": " + args[i]);
            test_json_file(args[i].toString());
        }
    }

}
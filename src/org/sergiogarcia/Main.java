package org.sergiogarcia;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import org.sergiogarcia.quickconnectfamily.json.JSONUtilities;


public class Main {
    private static String json_endpoint = "http://api.timezonedb.com/v2/get-time-zone?key=27WXQFIWV7UQ&format=json&by=zone&zone=";

    private static String read_url_string(String url_input_string) throws IOException {
        System.out.println("Reading Data From: " + url_input_string);
        URL url = new URL(url_input_string);
        Scanner scan = new Scanner(url.openStream());
        String content = new String();
        while (scan.hasNext()) content += scan.nextLine();
        scan.close();

        return content;
    }

    public static String parse_json(String jsonString) {
        // Object Classes
        HashMap parsedJSONMap = null;
        CurrentTimeZone readObject = null;
        try {
            parsedJSONMap = (HashMap) JSONUtilities.parse(jsonString);
            readObject = new CurrentTimeZone(parsedJSONMap);
            return parsedJSONMap.toString();
        } catch (Exception e) {
            System.out.println("Failed to Parse Json String: " + e.toString());
            return null;
        }
    }

    public static CurrentTimeZone parse_json_timezone(String jsonString) {
        // Object Classes
        HashMap parsedJSONMap = null;
        CurrentTimeZone readObject = null;
        try {
            parsedJSONMap = (HashMap) JSONUtilities.parse(jsonString);
            readObject = new CurrentTimeZone(parsedJSONMap);
            return readObject;
        } catch (Exception e) {
            System.out.println("Failed to Parse Json String: " + e.toString());
            return null;
        }
    }




    public static void main(String[] args){

        String[] time_zones = {"America/Chicago", "America/New_York", "Asia/Dubai", "Asia/Tokyo"};


        for(String tz:time_zones) {
            System.out.println("------------------------------------------------------------------------------------\n\n");
            // First We gather the Hour
            System.out.println("First We gather the Hour for " + tz + "\n\n");
            try {
                // Download
                String json_time = read_url_string(json_endpoint + tz);
                System.out.println("Response JSON: " + json_time + "\n\n");

                // Parse
                CurrentTimeZone tx = parse_json_timezone(json_time);

                // Stringify
                System.out.println("Stringified Object JSON: " + JSONUtilities.stringify(tx) + "\n\n");

                // Output
                System.out.println("Current Date/Time in: " + tx.zoneName + " is " + tx.formatted + "\n\n");

                // Sleep
                Thread.sleep(2000); // This should be enough time for the request to finish
            } catch (Exception e) {
                System.out.println("Failed to gather JSON data: " + e.toString());
            }
        }
    }

}
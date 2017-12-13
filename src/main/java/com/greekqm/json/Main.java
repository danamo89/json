package com.greekqm.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author David Navarro Mora <david.navarro.mora@gmail.com>
 */
public class Main {

    public static void main(String[] args) {
        try {
            Main.call_me();
        } catch (Exception e) {
        }
    }

    public static void call_me() throws Exception {
        String url = "https://api.fixer.io/latest";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + con.getResponseCode());
        
        StringBuilder response;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        
        System.out.println(response.toString());
        
        //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
        System.out.println("result after Reading JSON Response");
        System.out.println("base: " + myResponse.getString("base"));
    }

}

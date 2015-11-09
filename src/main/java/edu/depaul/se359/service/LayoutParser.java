package edu.depaul.se359.service;

import com.google.gson.Gson;
import edu.depaul.se359.model.HomeLayoutPlanMap;

import java.io.*;

/**
 * Created on 10/10/15.
 * Class: LayoutParser.java
 * Author: eric
 * Assignment: SE459
 */
public class LayoutParser {
    public static HomeLayoutPlanMap parseHomeLayout(String filename) throws FileNotFoundException {
        if (filename == null) {
            throw new FileNotFoundException("File could not be found.");
        }

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        return gson.fromJson(br, HomeLayoutPlanMap.class);
    }

    public static HomeLayoutPlanMap parseHomeLayout(InputStream file) {

        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new InputStreamReader(file));

        return gson.fromJson(br, HomeLayoutPlanMap.class);
    }
}

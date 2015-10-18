package edu.depaul.se359.service;

import com.google.gson.Gson;
import edu.depaul.se359.model.HomeLayoutPlanMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created on 10/10/15.
 * Class: LayoutParser.java
 * Author: eric
 * Assignment: SE459
 */
public class LayoutParser {
    public static HomeLayoutPlanMap parseHomeLayout(String filename) throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        return gson.fromJson(br, HomeLayoutPlanMap.class);
    }
}

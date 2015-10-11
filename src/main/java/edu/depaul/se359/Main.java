package edu.depaul.se359;


import edu.depaul.se359.model.HomeLayoutList;
import edu.depaul.se359.service.LayoutParser;

import java.io.IOException;

/**
 * Created on 10/10/15.
 * Class: main.java.edu.depaul.se359.Main.java
 * Author: eric
 * Assignment: SE459
 */
public class Main {
    public static void main(String[] args) throws IOException {
        HomeLayoutList layouts = LayoutParser.parseHomeLayout("./assets/test.json");

        System.out.println(layouts);
    }
}

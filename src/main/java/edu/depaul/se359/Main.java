package main.java.edu.depaul.se359;

import main.java.edu.depaul.se359.model.HomeLayoutList;
import main.java.edu.depaul.se359.service.LayoutParser;

import java.io.IOException;

/**
 * Created on 10/10/15.
 * Class: main.java.edu.depaul.se359.Main.java
 * Author: eric
 * Assignment: SE459
 */
public class Main {
    public static void main(String[] args) throws IOException {
        HomeLayoutList layouts = LayoutParser.parse("./assets/test.json");

        System.out.println(layouts);
    }
}

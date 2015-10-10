package main;

import main.model.HomeLayoutList;
import main.service.LayoutParser;

import java.io.IOException;

/**
 * Created on 10/10/15.
 * Class: main.Main.java
 * Author: eric
 * Assignment: SE459
 */
public class Main {
    public static void main(String[] args) throws IOException {
        HomeLayoutList layouts = LayoutParser.parse("./assets/test.json");

        System.out.println(layouts);
    }
}

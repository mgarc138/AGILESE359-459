package edu.depaul.se359;


import edu.depaul.se359.model.HomeLayoutPlanMap;
import edu.depaul.se359.service.LayoutParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created on 10/10/15.
 * Class: main.java.edu.depaul.se359.Main.java
 * Author: eric
 * Assignment: SE459
 */
public class Main extends Application {

    public static void main(String[] args) throws IOException {

        try {
            URL file = Main.class.getClassLoader().getResource("FloorPlans/FloorPlanLayoutHome2.json");

            HomeLayoutPlanMap layouts = LayoutParser.parseHomeLayout(
                    file.getFile()
            );

        } catch (NullPointerException e) {
            e.printStackTrace();
            return;
        }

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new GridPane()));
        stage.show();
    }
}

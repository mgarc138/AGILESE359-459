package edu.depaul.se359;


import edu.depaul.se359.exception.InvalidFloorCodeException;
import edu.depaul.se359.exception.InvalidRoomCodeException;
import edu.depaul.se359.model.HomeLayoutPlanMap;
import edu.depaul.se359.service.LayoutParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created on 10/10/15.
 * Class: main.java.edu.depaul.se359.Main.java
 * Author: eric
 * Assignment: SE459
 */
public class Main extends Application {
    public static void main(String[] args) throws IOException {
        HomeLayoutPlanMap layouts = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome2.json");

        try {
            System.out.println(layouts.getHomeLayout().getFloor(1).getRoom("roomA").getCells());

        } catch (InvalidFloorCodeException e) {
            e.printStackTrace();
        } catch (InvalidRoomCodeException e) {
            e.printStackTrace();
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new GridPane()));
        stage.show();
    }
}

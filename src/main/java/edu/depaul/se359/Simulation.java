package edu.depaul.se359;

import edu.depaul.se359.exception.InvalidFloorCodeException;
import edu.depaul.se359.exception.InvalidRoomCodeException;
import edu.depaul.se359.model.*;
import edu.depaul.se359.sensor.DirtDetector;
import edu.depaul.se359.service.LayoutParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.logging.Level;

/**
 * Created by eric on 10/30/15.
 */
public class Simulation extends Application {
    Scene scene;
    GridPane gridPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        gridPane = new GridPane();

        try {
            HomeLayoutPlanMap layouts = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome2.json");
            Cell chargeStation = null;
            // Get the charge station
            for (Floor floor : layouts.getHomeLayout().getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Cell cell : room.getCells()) {
                        if (cell.CheckisaChargingStation()) {
                            chargeStation = cell;
                            LogFile.getInstance().writeLogFile(Level.INFO, "Charge station was found!");
                        }

                        gridPane.add(new MyNode(cell), cell.getX(), cell.getY());
                    }
                }
            }


            CleanSweep cleanSweep = new CleanSweep(chargeStation);
            cleanSweep.cleanHome(layouts.getHomeLayout());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFloorCodeException e) {
            e.printStackTrace();
        } catch (InvalidRoomCodeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        scene = new Scene(gridPane);
        stage.setScene(scene);

        stage.show();
    }

    class MyNode extends StackPane {
        private Rectangle rectangle = new Rectangle();
        private Text text;

        public MyNode(Cell cell) {
            text = new Text();

            rectangle.setWidth(48);
            rectangle.setHeight(48);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.LIGHTBLUE);

            if (cell.CheckisaChargingStation()) {
                text.setText("C");
            }

            if (DirtDetector.isDirty(cell)) {
                text.setText(String.valueOf(cell.getDirt()));

                switch (cell.getDirt()) {
                    case 1:
                        rectangle.setFill(Color.LIGHTGRAY);
                        break;
                    case 2:
                        rectangle.setFill(Color.DARKGRAY);
                        break;
                    case 3:
                        text.setStroke(Color.WHITE);
                        rectangle.setFill(Color.BLACK);
                        break;
                }
            }

            getChildren().addAll(rectangle, text);
        }
    }
}

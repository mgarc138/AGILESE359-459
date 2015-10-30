package edu.depaul.se359;

import edu.depaul.se359.model.*;
import edu.depaul.se359.sensor.DirtDetector;
import edu.depaul.se359.service.LayoutParser;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;

/**
 * Created by eric on 10/30/15.
 */
public class Simulation extends Application implements Observer {
    Scene scene;
    GridPane gridPane;
    CleanSweep cleanSweep;
    HomeLayoutPlanMap layouts;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        gridPane = new GridPane();

        try {
            layouts = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome2.json");
            Cell chargeStation = null;
            // Get the charge station
            for (Floor floor : layouts.getHomeLayout().getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Cell cell : room.getCells()) {
                        if (cell.CheckisaChargingStation()) {
                            chargeStation = cell;
                            LogFile.getInstance().writeLogFile(Level.INFO, "Charge station was found!");
                        }

                        // add the cells to the GUI
                        gridPane.add(new MyNode(cell), cell.getX(), cell.getY());
                    }
                }
            }


            cleanSweep = new CleanSweep(chargeStation, layouts.getHomeLayout());
            cleanSweep.addObserver(this);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        scene = new Scene(gridPane);
        stage.setScene(scene);

        stage.show();

        Thread thread = new Thread(cleanSweep);
        thread.start();
    }

    public void update(Observable observable, Object o) {
        CleanSweep cs = (CleanSweep) observable;
        LogFile.getInstance().writeLogFile(Level.INFO, cs.getCurrentPosition().getPoint().toString());

        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == cs.getCurrentPosition().getX() && GridPane.getRowIndex(node) == cs.getCurrentPosition().getY()) {
                // DO Not Clean charging station
                if (cs.getCurrentPosition().CheckisaChargingStation()) {
                    return;
                }

                // If cell was cleaned, draw the changes
                if (!DirtDetector.isDirty(cs.getCurrentPosition())) {
                    ((MyNode) node).setClean();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // gridPane.add(node, cs.getCurrentPosition().getX(), cs.getCurrentPosition().getY());
            }
        }
    }

    class MyNode extends StackPane {
        private Rectangle rectangle = new Rectangle();
        private Text text = new Text();

        public MyNode(Cell cell) {

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

        public void setText(String text) {
            this.text.setText(text);
        }

        public void setClean() {
            rectangle.setFill(Color.YELLOW);
            text.setText("0");
            text.setStroke(Color.BLACK);
        }
    }
}

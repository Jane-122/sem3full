import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class ShapeDrawer extends Application {

    GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("ComboBox Shape Drawer");

        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 450, 450);
        myStage.setScene(myScene);

        Canvas myCanvas = new Canvas(400, 400);
        gc = myCanvas.getGraphicsContext2D();

        ObservableList<String> shapesList = FXCollections.observableArrayList("Circle", "Rectangle", "Line");

        ComboBox<String> shapeComboBox = new ComboBox<>(shapesList);
        shapeComboBox.setValue("Circle");

        Label selectedShapeLabel = new Label("Selected shape: " + shapeComboBox.getValue());

        drawShape(shapeComboBox.getValue());

        shapeComboBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                String selectedShape = shapeComboBox.getValue();
                selectedShapeLabel.setText("Selected shape: " + selectedShape);
                drawShape(selectedShape);
            }
        });

        rootNode.getChildren().addAll(shapeComboBox, selectedShapeLabel, myCanvas);

        myStage.show();
    }

    private void drawShape(String shape) {
        gc.clearRect(0, 0, 400, 400);

        switch (shape) {
            case "Circle":
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeOval(150, 150, 100, 100);
                break;
            case "Rectangle":
                gc.setStroke(Color.BLUE);
                gc.setLineWidth(2);
                gc.strokeRect(100, 100, 200, 100);
                break;
            case "Line":
                gc.setStroke(Color.RED);
                gc.setLineWidth(2);
                gc.strokeLine(50, 50, 350, 350);
                break;
            default:
                break;
        }
    }
}

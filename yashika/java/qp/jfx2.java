import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class RectangleDrawer extends Application {

    GraphicsContext gc;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("Rectangle Drawer");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);

        Scene myScene = new Scene(grid, 400, 400);
        myStage.setScene(myScene);

        Label lengthLabel = new Label("Length:");
        TextField lengthField = new TextField();

        Label breadthLabel = new Label("Breadth:");
        TextField breadthField = new TextField();

        Label colorLabel = new Label("Color (red, green, blue):");
        TextField colorField = new TextField();

        Button renderButton = new Button("Render");

        Canvas canvas = new Canvas(300, 300);
        gc = canvas.getGraphicsContext2D();

        renderButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                String lengthText = lengthField.getText();
                String breadthText = breadthField.getText();
                String colorText = colorField.getText().toLowerCase();

                try {
                    double length = Double.parseDouble(lengthText);
                    double breadth = Double.parseDouble(breadthText);

                    Color color = Color.BLACK;
                    switch (colorText) {
                        case "red":
                            color = Color.RED;
                            break;
                        case "green":
                            color = Color.GREEN;
                            break;
                        case "blue":
                            color = Color.BLUE;
                            break;
                        default:
                            color = Color.BLACK;
                            break;
                    }

                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.setFill(color);
                    gc.fillRect(50, 50, length, breadth);
                } catch (NumberFormatException e) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.setFill(Color.BLACK);
                    gc.fillText("Invalid input", 100, 150);
                }
            }
        });

        grid.add(lengthLabel, 0, 0);
        grid.add(lengthField, 1, 0);
        grid.add(breadthLabel, 0, 1);
        grid.add(breadthField, 1, 1);
        grid.add(colorLabel, 0, 2);
        grid.add(colorField, 1, 2);
        grid.add(renderButton, 1, 3);
        grid.add(canvas, 0, 4, 2, 1);

        myStage.show();
    }
}

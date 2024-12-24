import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class RadioButtonDemo extends Application
{
	Label response;
	public static void main(String args[])
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Demonstrate Radio Butoons");

		FlowPane rootNode=new FlowPane(10,10);

		rootNode.setAlignment(Pos.CENTER);

		Scene myScene=new Scene(rootNode,300,200);

		myStage.setScene(myScene);

		response=new Label("");

		RadioButton Train=new RadioButton("Train");
		RadioButton Car=new RadioButton("Car");
		RadioButton Plane=new RadioButton("Airplane");

		ToggleGroup tg=new ToggleGroup();

		Train.setToggleGroup(tg);
		Car.setToggleGroup(tg);
		Plane.setToggleGroup(tg);

		Train.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("Transport selected is Train");
			}
		})

		//Event handling for car and plane

		Train.fire();

		rootNode.getChildren().addAll(Train, Car, Plane, response);

		myStage.show();
	}
}




















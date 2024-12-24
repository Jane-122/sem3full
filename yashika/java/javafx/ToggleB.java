import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ToggleButton extends Application
{
	ToggleButton tb;
	Label response;
	public static void main(String args[])
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Demonstrate a JavaFX Buttons and Events");

		//vertical and horizontal gaps of 10
		FlowPane rootNode=new FlowPane(10,10);
		rootNode.setAlignment(Pos.CENTER);

		Scene myScene=new Scene(rootNode,300,200);

		myStage.setScene(myScene);

		response=new Label("Push a Button");

		tb=new ToggleButton("On/Off");

		tb.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				if(tb.isSelected())
					response.setText("Button is on");

				else
					response.setText("Button is off");
			}
		});


		rootNode.getChildren().addAll(tb,response);

		myStage.show();
	}
}




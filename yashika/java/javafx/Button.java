import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class Button extends Application
{
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

		Button alpha=new Button("Alpha");
		Button beta=new Button("Beta");

		alpha.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("Alpha was pressed ");
			}
		});

		beta.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("Beta was pressed ");
			}
		});

		rootNode.getChildren().addAll(alpha,beta,response);

		myStage.show();
	}
}











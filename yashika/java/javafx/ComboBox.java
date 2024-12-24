import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.collections.*;

public class ComboBox extends Application
{
	ComboBox<String> Transport;
	Label response;

	public static void main(String args[])
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("ComboBox Demo");

		FlowPane rootNode=new FlowPane(10,10);

		rootNode.setAalignment(Pos.CENTER);

		Scene myScene=new Scene(rootNode,280,120);

		myStage.setScene(myScene);

		response=new Label();

		ObservableList<String> transportTypes=FXCollections.obsercableArrayList("Train","Car","Airplane");

		Transport=new ComboBox<String>(transportTypes);

		Transport.setValue("Train");

		response.setText("Selected Transport is "+Transport.getValue());

		Transport.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("Selected Transport is "+Transport.getValue());
			}
		});

		rootNode.getChildren().addAll(Transport,response);

		myStage.show();
	}
}




















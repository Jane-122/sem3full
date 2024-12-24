import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafcx.collections.*;

public class ListViewDemo extends Application
{
	Label response;

	public static void main(String args[])
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("ListViewDemo");

		//vertical and horizontal gaps of 10
		FlowPane rootNode=new FlowPane(10,10);
		rootNode.setAlignment(Pos.CENTER);

		Scene myScene=new Scene(rootNode,300,200);

		myStage.setScene(myScene);

		response=new Label("Select computer type");

		ObservableList<String> computerTypes=FXCollections.observableArrayList("Smartphone","Tablet"..........)

		ListView<String> Computers=new ListView<String>(computerTypes);
		Compugters.setPrefSize(100,70);

		MultipleSelectionModel<String SelModel=Computers.getSelectionModel());
		
		SelModel.selectedItemProperty.addListener(new ChangeListener<Sting>()
		{
			public void changed(ObserbvaleValue<? extends String> changed, String oldVal, String newVal)
			{
				response.setText("Computer selected is "+newVal);
			}
		})
		

		rootNode.getChildren().addAll(Computers, response);

		myStage.show();
	}
}

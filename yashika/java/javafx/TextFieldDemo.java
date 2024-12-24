import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class TextFieldDemo extends Application
{
	TextField tf;
	Label response;

	public static void main(String args[])
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Demonstrate a TextField");

		//vertical and horizontal gaps of 10
		FlowPane rootNode=new FlowPane(10,10);
		rootNode.setAlignment(Pos.CENTER);

		Scene myScene=new Scene(rootNode,300,200);

		myStage.setScene(myScene);

		response=new Label("Search String ");

		Button getText=new Button("Get search string");

		tf=new TextField();

		tf.setPromptText("Enter search string");

		tf.setPrefColumnCount(15);

		tf.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("Search string "+tf.getText());
			}
		});

		getText.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				response.setText("Search String "+tf.getText());
			}
		});

		Separator separator=new Separator();
		separator.setPrefWidth(180);

		rootNode.getChildren().addAll(tf, getText, separator, response);

		myStage.show();
	}
}



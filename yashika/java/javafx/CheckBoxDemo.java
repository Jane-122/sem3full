import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class CheckBoxDemo extends Application
{
	CheckBox Smartphone;
	CheckBox Tablet;
	CheckBox Notebook;
	CheckBox Desktop;
	Label response;
	Label selected;
	String computers;
	public static void main(String args[])
	{
		launch(args);
	}

	public void start(Stage myStage)
	{
		myStage.setTitle("Demonstrate Check Boxes");

		FlowPane rootNode=new FlowPane(Orientation.VERTICAL,10,10);

		rootNode.setAlignment(Pos.CENTER);

		Scene myScene=new Scene(rootNode,300,200);

		myStage.setScene(myScene);

		Label heading=new Label("What computers do you own?");

		response=new Label("");

		selected=new Label("");

		Smartphone=new ChceckBox("Smartphone");
		Tablet = new CheckBox("Tablet");
		Notebook = new CheckBox("Notebook");
		Desktop = new CheckBox("Desktop");

		Smartphone.setOnAction(new EventHandler<ActionEvent>()
		{
			public void handle(ActionEvent ae)
			{
				if(Smartphone.isSelected())
					response.setText("Smartphone was just selected");
				else{
					response.setText("Smartphone was just cleared");
				}
				showAll();
			}

		});

		cbTablet.setOnAction(new EventHandler<ActionEvent>() 
		{
    		public void handle(ActionEvent ae) 
    		{
        		if (cbTablet.isSelected())
            		response.setText("Tablet was just selected.");
        		else
            		response.setText("Tablet was just cleared.");
        		showAll();
    	}
		});

cbNotebook.setOnAction(new EventHandler<ActionEvent>() 
{
    public void handle(ActionEvent ae) 
    {
        if (cbNotebook.isSelected())
            response.setText("Notebook was just selected.");
        else
            response.setText("Notebook was just cleared.");
        showAll();
    }
});

cbDesktop.setOnAction(new EventHandler<ActionEvent>() 
{
    public void handle(ActionEvent ae) 
    {
        if (cbDesktop.isSelected())
            response.setText("Desktop was just selected.");
        else
            response.setText("Desktop was just cleared.");
        showAll();
    }
});

//fixxxxxxxxxxxxxxx

		rootNode.getChildren().addAll(Train, Car, Plane, response);

		myStage.show();

		voidshowAll()
		{
			computers="";
			if (Smartphone.isSlected())
				computers="Smartphone";
			if (Tablet.isSelected())
				computers+"Tablet";
			//rest
			selected.setText("Computers selected "+computers);
		}
	}
}




















import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class Drawing extends Application
{
	GraphicsContext gc;

	Color colors[]={Color.RED, Color.BLUE, Color.GREEN, Color.BLACK};
	int colorIdx=0;

	public static void man(String args[])
	{
		launch(args);
	}
}

public void start(Stage myStage)
{
	myStage.setTitle("Draw directly on canvas ");

	FlowPane rootNode=new FlowPane();

	rootNode.setAlignment(Pos.CENTER);

	Scene myScene=new Scene(rootNode,450,450);

	myStage.setScene(myScene);

	Canvas myCanvas=new Canvas(400,400);

	gc=myCanvas.getGraphicsContext2D();

	Button changeColor=new Button("Change color");

	changeColor.setOnAction(new EventHandler<ActionEvent>()
	{
		public void handle(ActionEvent ae)
		{
			gc.setStroke(colors[colorsIdx]);
			gc.setFill(colors[colorsIdx]);

			gc.strokeLine(0,0,200,200);
			gc.fillText("This is drawn on the canvas",60,50);
			gc.fillRect(100,320,300,40);

			colorIdx++;
			if (colorIdx==colors.length) colorIdx=0;
		}
	});

	gc.strokeLine(0,0,200,200);
	gc.strokeOval(100,100,200,200);
	gc.strokeRect(0,200,50,200);
	gc.fillOval(0,0,20,20);
	gc.fillRect(100,320,300,40);

	gc.setFont(new Font(20));
	gc.fillText("This is drawn on the canvas",60,50);

	rootNode.getChildren().addAll(myCanvas,changeColor);

	myStage.show();
}


















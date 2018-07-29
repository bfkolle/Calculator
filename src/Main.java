import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class Main extends Application
{
	private Calculator calculator = new Calculator();

    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(calculator);

        primaryStage.setScene(scene);
		primaryStage.setMinHeight(450);
		primaryStage.setMinWidth(425);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}


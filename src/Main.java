import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class Main extends Application
{
	private final int STAGE_HEIGHT = 400;
	private final int STAGE_WIDTH = 310;
	private Calculator calculator = new Calculator();

    @Override
    public void start(Stage primaryStage)
    {
        Scene scene = new Scene(calculator);

        primaryStage.setScene(scene);
		primaryStage.setMinHeight(STAGE_HEIGHT);
		primaryStage.setMinWidth(STAGE_WIDTH);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}


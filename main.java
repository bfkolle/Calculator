import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Created by Brandon Kolle on 12/22/2016.
 * This is a calculator program using the public class main as the main class,
 * and the Calculator class for
 */

public class main extends Application {

    final int WIDTH = 400; //width of calculator

    final int HEIGHT = 400; //height of calculator

    Calculator calculator = new Calculator(WIDTH, HEIGHT); //Declare object for calculator front end

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(calculator, WIDTH, HEIGHT);

        primaryStage.setResizable(false);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


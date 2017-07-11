import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Created by Brandon Kolle on 12/22/2016.
 * This is a calculator program using the public class main as the main class,
 * and the Calculator class for
 */

public class main extends Application {

    private final int WIDTH = 400; //width of scene

    private final int HEIGHT = 400; //height of scene

    private final double NUMROWS = 6.0; //number of rows

    private final double NUMCOLS = 4.0; //number of columns

    private Calculator calculator = new Calculator(WIDTH, HEIGHT); //Declare object for calculator front end

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(calculator, 450, 450);

        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


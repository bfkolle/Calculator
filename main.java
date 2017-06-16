import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Created by Brandon Kolle on 12/22/2016.
 * This is a calculator program using the public class main as the main class,
 * and the sub class for the frontend and backend.
 */

public class main extends Application {

     public Calculator frontend = new Calculator(); //Declare object for calculator front end

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(frontend, 400, 400);

        frontend.prefWidthProperty().bind(scene.widthProperty()); //Bind min width of calculator to scene's width
        frontend.prefHeightProperty().bind(scene.heightProperty()); //Bind min height of calculator to scene's height

        primaryStage.setMinHeight(425);
        primaryStage.setMinWidth(425);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


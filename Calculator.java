import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * Created by Brandon Kolle on 12/22/2016.
 * This is a calculator program using the public class main as the main class,
 * and the Calculator class for
 */

public class Calculator extends Application {

    private VBox container = new VBox();

    private CalculatorButtons buttons = new CalculatorButtons();

    @Override
    public void start(Stage primaryStage) {

        buttons.minWidthProperty().bind(container.widthProperty());
        buttons.minHeightProperty().bind(container.heightProperty());

        container.getChildren().add(buttons);

        Scene scene = new Scene(container, 450, 450);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


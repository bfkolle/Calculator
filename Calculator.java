import javafx.scene.layout.VBox;

/**
 * Created by bfkol on 6/14/2017.
 */

public class Calculator extends VBox {

    //Constructor sets up calculator graphics
    public Calculator(int width, int height) {

        CalculatorButtons buttons = new CalculatorButtons(width, height); //object to manage calculator buttons

        buttons.minWidthProperty().bind(this.widthProperty());
        buttons.minHeightProperty().bind(this.heightProperty());

        //Add the rows
        this.getChildren().add(buttons);
    }
}
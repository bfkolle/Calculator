import javafx.scene.layout.VBox;

/**
 * Created by bfkol on 6/14/2017.
 */

public class Calculator extends VBox {

    //Constructor sets up calculator graphics
    public Calculator(int width, int height) {

        CalculatorDisplay display = new CalculatorDisplay(width, height); //object to manage calculator display

        CalculatorButtons buttons = new CalculatorButtons(width, height, display); //object to manage calculator buttons

        //Add the rows
        this.getChildren().addAll(display, buttons);
    }
}
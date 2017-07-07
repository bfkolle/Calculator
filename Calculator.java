import javafx.scene.layout.VBox;

/**
 * Created by bfkol on 6/14/2017.
 */

public class Calculator extends VBox {

    //Constructor sets up calculator graphics
    public Calculator(int width, int height) {

        CalculatorButtons buttons = new CalculatorButtons(width, height);

        CalculatorDisplay display = new CalculatorDisplay(width, height);

        //Add all rows
        this.getChildren().addAll(display, buttons);
    }


}
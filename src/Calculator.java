import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class Calculator extends BorderPane
{
    private CalculatorDisplay display;
    private CalculatorButtons buttons;

    public Calculator()
	{
		display = new CalculatorDisplay();
		buttons = new CalculatorButtons();

		this.setTop(display);
		setAlignment(display, Pos.CENTER_RIGHT);

		this.setCenter(buttons);

		//Modify look
		this.setStyle("-fx-background-color: #353535");
		this.setPadding(new Insets(0, 2.5, 0, 2.5));
	}
}


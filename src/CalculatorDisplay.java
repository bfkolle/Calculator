import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.text.TextAlignment;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class CalculatorDisplay extends VBox
{
	private StringProperty topText;
	private StringProperty bottomText;
	private Label topDisplay;
	private Label bottomDisplay;

	public CalculatorDisplay()
	{
		//Top display is for displaying entered numbers and operation
		//Bottom display is for displaying the result
		topDisplay = new Label();
		bottomDisplay = new Label();
		topText = new SimpleStringProperty("");
		bottomText = new SimpleStringProperty("0");

		topDisplay.textProperty().bind(topText);
		bottomDisplay.textProperty().bind(bottomText);

		topDisplay.setTextAlignment(TextAlignment.RIGHT);
		topDisplay.getStyleClass().add("topDisplay");

		bottomDisplay.setTextAlignment(TextAlignment.RIGHT);
		bottomDisplay.getStyleClass().add("bottomDisplay");

		this.setAlignment(Pos.CENTER_RIGHT);
		this.getChildren().addAll(topDisplay, bottomDisplay);
	}

	public String getDisplay()
	{
		return topText.get() + " " + bottomText.get();
	}

	public String getTopDisplay()
	{
		return topText.get();
	}

	public String getBottomDisplay()
	{
		return bottomText.get();
	}

	public void setTopDisplay(String exp)
	{
		topText.setValue(exp.trim());
	}

	public void setBottomDisplay(String exp)
	{
		bottomText.setValue(exp.trim());
	}

	public void resetDisplay()
	{
		topText.setValue("");
		bottomText.setValue("0");
	}

	public void resetTopDisplay()
	{
		topText.setValue("0");
	}

	public void resetBottomDisplay()
	{
		bottomText.setValue("0");
	}
}
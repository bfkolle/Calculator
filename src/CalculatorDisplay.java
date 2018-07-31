import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/*
	Author: Brandon Kolle
	7/29/2018
 */

class CalculatorDisplay extends VBox
{
    private Text topText;
    private Text bottomText;

    CalculatorDisplay()
    {
        //Top text is for displaying entered numbers and operation
        //Bottom text is for displaying the result
        topText = new Text();
        bottomText = new Text("0");

        topText.setTextAlignment(TextAlignment.RIGHT);
        topText.setStyle("-fx-font-size: 18px; -fx-fill: white");

        bottomText.setTextAlignment(TextAlignment.RIGHT);
        bottomText.setStyle("-fx-font-size: 40px; -fx-fill: white");

        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(topText, bottomText);
    }
}

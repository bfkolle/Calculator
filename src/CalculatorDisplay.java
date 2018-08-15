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
    boolean resultFlag;

    CalculatorDisplay()
    {
        //Top text is for displaying entered numbers and operation
        //Bottom text is for displaying the result
        topText = new Text();
        bottomText = new Text("0");
        resultFlag = false;

        topText.setTextAlignment(TextAlignment.RIGHT);
        topText.getStyleClass().add("topDisplay");

        bottomText.setTextAlignment(TextAlignment.RIGHT);
        bottomText.getStyleClass().add("bottomDisplay");

        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(topText, bottomText);
    }

    String getDisplay()
    {
        return topText.getText() + " " + bottomText.getText();
    }

    String getTopDisplay()
    {
        return topText.getText();
    }

    String getBottomDisplay()
    {
        return bottomText.getText();
    }

    void setTopDisplay(String exp)
    {
        topText.setText(exp.trim());
    }

    void setBottomDisplay(String exp)
    {
        bottomText.setText(exp.trim());
    }

    void resetDisplay()
    {
        topText.setText("");
        bottomText.setText("0");
    }

    void resetTopDisplay()
    {
        topText.setText("0");
    }

    void resetBottomDisplay()
    {
        bottomText.setText("0");
    }
}
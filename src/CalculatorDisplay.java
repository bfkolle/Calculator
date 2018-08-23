import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class CalculatorDisplay extends VBox
{
    private Text topText;
    private Text bottomText;
    boolean resultFlag;

    public CalculatorDisplay()
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

    public String getDisplay()
    {
        return topText.getText() + " " + bottomText.getText();
    }

    public String getTopDisplay()
    {
        return topText.getText();
    }

    public String getBottomDisplay()
    {
        return bottomText.getText();
    }

    public void setTopDisplay(String exp)
    {
        topText.setText(exp.trim());
    }

    public void setBottomDisplay(String exp)
    {
        bottomText.setText(exp.trim());
    }

    public void resetDisplay()
    {
        topText.setText("");
        bottomText.setText("0");
    }

    public void resetTopDisplay()
    {
        topText.setText("0");
    }

    public void resetBottomDisplay()
    {
        bottomText.setText("0");
    }
}
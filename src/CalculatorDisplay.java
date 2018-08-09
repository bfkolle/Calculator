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

    void updateDisplay(String exp)
    {
        String bottomDisplay = removeZero(bottomText.getText());
        String topDisplay = topText.getText();

        //If the input is an operator, move displayed expression to top display and reset bottom
        if(isOperator(exp))
        {
            topText.setText(topDisplay + " " + bottomDisplay + " " + exp);
            bottomText.setText("0");

            if(resultFlag)
            {
                resultFlag = false;
            }
        }
        else if(resultFlag)
        {
            bottomText.setText(exp);
            resultFlag = false;
        }
        else
        {
            bottomText.setText(bottomDisplay + exp);
        }
    }

    String getDisplay()
    {
        return topText.getText() + " " + bottomText.getText();
    }

    void resetDisplay()
    {
        topText.setText("");
        bottomText.setText("0");
    }

    void clearBottom()
    {
        bottomText.setText("0");
    }

    void toggleResultFlag()
    {
        resultFlag = !resultFlag;
    }

    //Returns an empty string if the starting value of bottom text is 0
    private String removeZero(String exp)
    {
        if(exp == "0")
        {
            return "";
        }
        return exp;
    }

    private boolean isOperator(String exp)
    {
        exp = exp.trim();

        switch(exp)
        {
            case "+": case "-": case "*": case "/":
                return true;
        }
        return false;
    }
}
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by bfkolle on 7/7/2017.
 */

class CalculatorDisplay extends HBox{

    private Text display = new Text("0");

    private Text displaySecondary = new Text("");

    CalculatorDisplay() {
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 50));

        displaySecondary.setFont(Font.font("sans serif", FontWeight.BOLD, 50));

        this.setAlignment(Pos.BOTTOM_RIGHT);

        this.getChildren().addAll(display, displaySecondary);
    }

    //Manually set display
    void setDisplay(String s) {
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 50));

        if (isWholeNumber(Double.parseDouble(s))) {
            display.setText(Integer.toString((int)Double.parseDouble(s)));
        }
        else {
            display.setText(s);
        }

        displaySecondary.setText("");
    }

    //Set display according to 'operand operator operand' notation
    void setDisplay(double opOne, String operator, double opTwo) {
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 30));

        if (isWholeNumber(opOne)) {
            display.setText(Integer.toString((int)opOne) + " " + operator + "  ");
        }
        else {
            display.setText(Double.toString(opOne) + " " + operator + "  ");
        }

        if (opTwo == 0) {
            displaySecondary.setText("");
        }
        else if (isWholeNumber(opTwo)){
            displaySecondary.setText(Integer.toString((int)opTwo));

        }
        else {
            displaySecondary.setText(Double.toString(opTwo));
        }

    }

    private boolean isWholeNumber(double num) {
        boolean isWholeNumber = false;

        if (num % 1.0 == 0) {
            isWholeNumber = true;
        }

        return isWholeNumber;
    }
}

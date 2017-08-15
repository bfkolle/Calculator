import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by bfkol on 7/7/2017.
 */

class CalculatorDisplay extends HBox{

    private Text display = new Text("");

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
        display.setText(s);
        displaySecondary.setText("");

    }

    //Set display according to 'operand operator operand' notation
    void setDisplay(double opOne, String operator, double opTwo) {
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 30));
        display.setText(Double.toString(opOne) + " " + operator + "  ");

        if (opTwo == 0) {
            displaySecondary.setText("");
        }
        else {
            displaySecondary.setText(Double.toString(opTwo));
        }

    }

    //Set display according to 'Answer operator operand' notation
    void setDisplay(String operator, double opTwo) {
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 30));
        display.setText("ANS" + " " + operator + "  ");

        if (opTwo == 0) {
            displaySecondary.setText("");
        }
        else {
            displaySecondary.setText(Double.toString(opTwo));
        }
    }

    String getDisplay() {
        return display.getText();

    }

}

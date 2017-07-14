import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by bfkol on 7/7/2017.
 */

class CalculatorDisplay extends HBox{

    private Text display = new Text("0");

    CalculatorDisplay() {

        display.setFont(Font.font("sans serif", FontWeight.BOLD, 50));

        this.setAlignment(Pos.BOTTOM_RIGHT);

        this.getChildren().add(display);
    }

    void setDisplay(String s) {
        display.setText(s);
    }

    String getDisplay() {
        return display.getText();
    }
}

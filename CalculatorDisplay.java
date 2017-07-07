import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by bfkol on 7/7/2017.
 */
public class CalculatorDisplay extends VBox{

    private Text display = new Text("0");

    public CalculatorDisplay(int width, int height) {
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 45));

        HBox displayRow = new HBox();
        displayRow.alignmentProperty().setValue(Pos.BOTTOM_RIGHT);
        displayRow.minWidthProperty().setValue(width);
        displayRow.minHeightProperty().setValue(height / 6.0);
        displayRow.getChildren().add(display);
    }

}

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/*
	Author: Brandon Kolle
	7/29/2018
 */

class CalculatorDisplay extends Text
{
    public CalculatorDisplay()
    {
        this.setTextAlignment(TextAlignment.RIGHT);
        this.setFont(Font.font("sans serif", FontWeight.BOLD, 40));
        this.setText("0");
    }
}

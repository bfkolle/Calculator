import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Collections;

/*
	Author: Brandon Kolle
	7/29/2018
 */

class CalculatorButtons extends GridPane
{
    private Button btCE, btC, btDel, btDiv, bt7, bt8, bt9, btMult,
			bt4, bt5, bt6, btSub, bt1, bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve;

    public CalculatorButtons()
    {
		ArrayList<Button> buttonHolder = new ArrayList<>();

        //Declare each button of calculator
        btCE = new Button("CE"); btC = new Button("C"); btDel = new Button("<-");
        btDiv = new Button("/"); bt7 = new Button("7"); bt8 = new Button("8");
        bt9 = new Button("9"); btMult = new Button("x"); bt4 = new Button("4");
        bt5 = new Button("5"); bt6 = new Button("6"); btSub = new Button("-");
        bt1 = new Button("1"); bt2 = new Button("2"); bt3 = new Button("3");
        btAdd = new Button("+"); btNeg = new Button("Neg"); bt0 = new Button("0");
        btDec = new Button("."); btSolve = new Button("=");

        Collections.addAll(buttonHolder, btCE, btC, btDel, btDiv, bt7, bt8, bt9, btMult, bt4, bt5, bt6, btSub, bt1,
                bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve);

        //Set each button so it will grow to fit space, and set to bold
		for (Button currentButton : buttonHolder)
		{
			currentButton.prefWidthProperty().bind(this.widthProperty().divide(4.0));
			currentButton.prefHeightProperty().bind(this.heightProperty().divide(5.0));
			currentButton.setStyle("-fx-background-color: #707172; -fx-text-fill: white; " +
					"-fx-background-radius: 0; -fx-font-size: 22px");
		}

		//Set the operator buttons to a separate styling scheme
		for (int i = 3; i < buttonHolder.size(); i += 4)
		{
			buttonHolder.get(i).setStyle("-fx-background-color: #f4ab35; -fx-background-radius: 0;" +
					" -fx-font-size: 22px");
		}

		//Add buttons by column
		this.addColumn(0, btCE, bt7, bt4, bt1, btNeg);
		this.addColumn(1, btC, bt8, bt5, bt2, bt0);
		this.addColumn(2, btDel, bt9, bt6, bt3, btDec);
		this.addColumn(3, btDiv, btMult, btSub, btAdd, btSolve);

		//Set spacing between buttons
		this.setHgap(2.5);
		this.setVgap(2.5);
    }
}

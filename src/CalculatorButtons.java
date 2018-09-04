import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Collections;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class CalculatorButtons extends GridPane
{
	private Button btCE, btC, btExp, btDiv, bt7, bt8, bt9, btMult,
			bt4, bt5, bt6, btSub, bt1, bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve;
	private ArrayList<Button> rightSideOperatorButtonGroup, miscOperatorButtonGroup, numberButtonGroup;

	public CalculatorButtons()
	{
		rightSideOperatorButtonGroup = new ArrayList<>();
		miscOperatorButtonGroup = new ArrayList<>();
		numberButtonGroup = new ArrayList<>();

		btCE = new Button("CE"); btC = new Button("C"); btExp = new Button("^");
		btDiv = new Button("/"); bt7 = new Button("7"); bt8 = new Button("8");
		bt9 = new Button("9"); btMult = new Button("x"); bt4 = new Button("4");
		bt5 = new Button("5"); bt6 = new Button("6"); btSub = new Button("-");
		bt1 = new Button("1"); bt2 = new Button("2"); bt3 = new Button("3");
		btAdd = new Button("+"); btNeg = new Button("Neg"); bt0 = new Button("0");
		btDec = new Button("."); btSolve = new Button("=");

		Collections.addAll(rightSideOperatorButtonGroup, btDiv, btMult, btSub, btAdd, btSolve);
		Collections.addAll(miscOperatorButtonGroup, btCE, btC, btExp, btNeg, btDec);
		Collections.addAll(numberButtonGroup, bt7, bt8, bt9, bt4, bt5, bt6, bt1, bt2, bt3, bt0);

		bindToGridPane(rightSideOperatorButtonGroup);
		bindToGridPane(miscOperatorButtonGroup);
		bindToGridPane(numberButtonGroup);

		setStyleClass(rightSideOperatorButtonGroup, "rightSideOperatorButton");
		setStyleClass(miscOperatorButtonGroup, "miscOperatorButton");
		setStyleClass(numberButtonGroup, "numberButton");

		this.addColumn(0, btCE, bt7, bt4, bt1, btNeg);
		this.addColumn(1, btC, bt8, bt5, bt2, bt0);
		this.addColumn(2, btExp, bt9, bt6, bt3, btDec);
		this.addColumn(3, btDiv, btMult, btSub, btAdd, btSolve);
	}


	private void setStyleClass(ArrayList<Button> buttonGroup, String styleClass)
	{
		for (Button currentButton : buttonGroup)
		{
			currentButton.getStyleClass().add(styleClass);
		}
	}

	private void bindToGridPane(ArrayList<Button> buttonGroup)
	{
		for (Button currentButton : buttonGroup)
		{
			bindHeightAndWidthToGridPane(currentButton);
		}
	}

	private void bindHeightAndWidthToGridPane(Button button)
	{
		button.prefWidthProperty().bind(this.widthProperty().divide(4.0));
		button.prefHeightProperty().bind(this.heightProperty().divide(5.0));
	}
}

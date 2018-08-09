import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Runtime;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class Calculator extends BorderPane
{
	private String infixExpression;
    private CalculatorDisplay display;
    private ComputationEngine compEngine;
    private GridPane buttons;
    private Button btCE, btC, btExp, btDiv, bt7, bt8, bt9, btMult,
			bt4, bt5, bt6, btSub, bt1, bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve;


    public Calculator()
	{
		ArrayList<Button> buttonHolder = new ArrayList<>();
		infixExpression = "";
		display = new CalculatorDisplay();
		buttons = new GridPane();
		compEngine = new ComputationEngine();

		//Declare each button of calculator
        btCE = new Button("CE"); btC = new Button("C"); btExp = new Button("^");
        btDiv = new Button("/"); bt7 = new Button("7"); bt8 = new Button("8");
        bt9 = new Button("9"); btMult = new Button("x"); bt4 = new Button("4");
        bt5 = new Button("5"); bt6 = new Button("6"); btSub = new Button("-");
        bt1 = new Button("1"); bt2 = new Button("2"); bt3 = new Button("3");
        btAdd = new Button("+"); btNeg = new Button("Neg"); bt0 = new Button("0");
        btDec = new Button("."); btSolve = new Button("=");

		//Add nodes
		this.setTop(display);
		this.setCenter(buttons);

		//Modify look of calculator
		this.getStyleClass().add("calculator");
		this.setPadding(new Insets(0, 1.25, 0, 1.25));
		setAlignment(display, Pos.CENTER_RIGHT);

        Collections.addAll(buttonHolder, btCE, btC, btExp, btDiv, bt7, bt8, bt9, btMult, bt4, bt5, bt6, btSub, bt1,
                bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve);

        //Set each button so it will grow to fit space, and set its style class
		for (Button currentButton : buttonHolder)
		{
			currentButton.prefWidthProperty().bind(this.widthProperty().divide(4.0));
			currentButton.prefHeightProperty().bind(this.heightProperty().divide(5.0));
			
			switch(currentButton.getText())
			{
				case "+": case "-": case "x": case "/": case "=":
					currentButton.getStyleClass().add("operatorButton");
					break;
				default:
					currentButton.getStyleClass().add("otherButton");
			}
		}

		//Set spacing between buttons
		buttons.setHgap(2.5);
		buttons.setVgap(2.5);

		//Add buttons by column
		buttons.addColumn(0, btCE, bt7, bt4, bt1, btNeg);
		buttons.addColumn(1, btC, bt8, bt5, bt2, bt0);
		buttons.addColumn(2, btExp, bt9, bt6, bt3, btDec);
		buttons.addColumn(3, btDiv, btMult, btSub, btAdd, btSolve);

		//Number event managers
		bt0.setOnAction(e -> display.updateDisplay("0"));
		bt1.setOnAction(e -> display.updateDisplay("1"));
		bt2.setOnAction(e -> display.updateDisplay("2"));
		bt3.setOnAction(e -> display.updateDisplay("3"));
		bt4.setOnAction(e -> display.updateDisplay("4"));
		bt5.setOnAction(e -> display.updateDisplay("5"));
		bt6.setOnAction(e -> display.updateDisplay("6"));
		bt7.setOnAction(e -> display.updateDisplay("7"));
		bt8.setOnAction(e -> display.updateDisplay("8"));
		bt9.setOnAction(e -> display.updateDisplay("9"));

		//Operator event managers
		btDiv.setOnAction(e -> display.updateDisplay("/"));
		btMult.setOnAction(e -> display.updateDisplay("*"));
		btSub.setOnAction(e -> display.updateDisplay("-"));
		btAdd.setOnAction(e -> display.updateDisplay("+"));
		btSolve.setOnAction(e -> {
			infixExpression = display.getDisplay();
			display.resetDisplay();
			display.updateDisplay(compEngine.computeExpression(infixExpression));
			});

		//Other event managers
		btC.setOnAction(e -> display.resetDisplay());
		btCE.setOnAction(e -> display.clearBottom());
		}
}
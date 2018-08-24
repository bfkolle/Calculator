import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Collections;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class Calculator extends BorderPane
{
	private String infixExpression;

	//Operation flags
	private boolean isNewExp; //If the displayed number is a new expression
	private boolean isResult; //If the displayed number is the result of a solve operation

	//Calculator components
	private CalculatorDisplay display;
	private ComputationEngine compEngine;
	private GridPane buttons;
	private Button btCE, btC, btExp, btDiv, bt7, bt8, bt9, btMult,
			bt4, bt5, bt6, btSub, bt1, bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve;

	public Calculator()
	{
		ArrayList<Button> buttonHolder = new ArrayList<>();
		infixExpression = "";
		isNewExp = true;
		isResult = false;
		display = new CalculatorDisplay();
		buttons = new GridPane();
		compEngine = new ComputationEngine();

		this.setPadding(new Insets(0, 2.5, 2.5, 2.5));
		this.getStyleClass().add("calculator");

		//Add nodes
		this.setTop(display);
		this.setCenter(buttons);

		//Declare each button of calculator
		btCE = new Button("CE"); btC = new Button("C"); btExp = new Button("^");
		btDiv = new Button("/"); bt7 = new Button("7"); bt8 = new Button("8");
		bt9 = new Button("9"); btMult = new Button("x"); bt4 = new Button("4");
		bt5 = new Button("5"); bt6 = new Button("6"); btSub = new Button("-");
		bt1 = new Button("1"); bt2 = new Button("2"); bt3 = new Button("3");
		btAdd = new Button("+"); btNeg = new Button("Neg"); bt0 = new Button("0");
		btDec = new Button("."); btSolve = new Button("=");

		Collections.addAll(buttonHolder, btCE, btC, btExp, btDiv, bt7, bt8, bt9, btMult, bt4, bt5, bt6, btSub, bt1,
				bt2, bt3, btAdd, btNeg, bt0, btDec, btSolve);

		//Set each button so it will grow to fit space, and set its style class
		for (Button currentButton : buttonHolder)
		{
			currentButton.prefWidthProperty().bind(buttons.widthProperty().divide(4.0));
			currentButton.prefHeightProperty().bind(buttons.heightProperty().divide(5.0));
			
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
		bt0.setOnAction(e -> updateDisplay(bt0.getText()));
		bt1.setOnAction(e -> updateDisplay(bt1.getText()));
		bt2.setOnAction(e -> updateDisplay(bt2.getText()));
		bt3.setOnAction(e -> updateDisplay(bt3.getText()));
		bt4.setOnAction(e -> updateDisplay(bt4.getText()));
		bt5.setOnAction(e -> updateDisplay(bt5.getText()));
		bt6.setOnAction(e -> updateDisplay(bt6.getText()));
		bt7.setOnAction(e -> updateDisplay(bt7.getText()));
		bt8.setOnAction(e -> updateDisplay(bt8.getText()));
		bt9.setOnAction(e -> updateDisplay(bt9.getText()));
		btDec.setOnAction(e -> handleDecimal()); //Decimal is considered number input for computation purposes
		btNeg.setOnAction(e -> handleNegative()); //Negative is also considered a number input 

		//Operator event managers
		btDiv.setOnAction(e -> updateDisplay("/"));
		btMult.setOnAction(e -> updateDisplay("*"));
		btSub.setOnAction(e -> updateDisplay("-"));
		btAdd.setOnAction(e -> updateDisplay("+"));
		btExp.setOnAction(e -> updateDisplay("^"));
		btSolve.setOnAction(e -> {
			infixExpression = display.getDisplay();
			display.resetDisplay();		
			updateDisplay(compEngine.computeExpression(infixExpression));
			isResult = true;
		});

		//Other event managers
		btC.setOnAction(e -> {
			display.resetDisplay();
			resetFlags();
		});
		
		btCE.setOnAction(e -> {
			display.resetBottomDisplay();
			resetFlags();
		});
	}

	//To handle the logic with updating the calculator display
	private void updateDisplay(String exp)
	{
		String topDisplay = display.getTopDisplay();
		String bottomDisplay = removeZero(display.getBottomDisplay());
		
		//Check that input is an operator and is not a new expression
		if(isOperator(exp))
		{
			if(!isNewExp)
			{
				display.setTopDisplay(topDisplay + " " + bottomDisplay + " " + exp);
				display.setBottomDisplay("0");
			}
			isNewExp = true;
		}
		//If displayed number is a result, don't append numbers, override the whole number
		else if(isResult)
		{
			display.setBottomDisplay(exp);
			isNewExp = false;
			isResult = false;
		}
		//Append inputted number to the end of the displayed number
		else
		{
			display.setBottomDisplay(bottomDisplay + exp);
			isNewExp = false;
		}
	}
	
	//Returns an empty string if the starting value of bottom display is 0
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
			case "+": case "-": case "*": case "/": case "^":
				return true;
		}
		return false;
	}

	//Reset expression flags to starting values when CE or C buttons are pressed
	private void resetFlags()
	{
		isNewExp = true;
		isResult = false;
	}

	//Handles logic with adding a decimal to a number
	private void handleDecimal()
	{
		boolean isDecimal = display.getBottomDisplay().contains(".");

		//If displayed number is '0', write '0.' instead of '.'
		if(display.getBottomDisplay().equals("0") && !isDecimal)
		{
			updateDisplay("0.");
		}
		else if(!isDecimal)
		{
			updateDisplay(".");
		}
	}

	//Handles logic associated with making a number negative
	private void handleNegative()
	{
		double num = Double.parseDouble(display.getBottomDisplay());

		if(!(num == 0))
		{
			num = num * -1;
			display.setBottomDisplay(Double.toString(num));
		}
	}
}
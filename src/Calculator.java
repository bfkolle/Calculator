import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class Calculator extends BorderPane
{
	private String infixExpression;
	private boolean isNewExp;
	private boolean isResult;
	private CalculatorDisplay display;
	private ComputationEngine compEngine;
	private CalculatorButtons buttons;

	public Calculator()
	{
		infixExpression = "";
		isNewExp = true;
		isResult = false;
		display = new CalculatorDisplay();
		buttons = new CalculatorButtons();
		compEngine = new ComputationEngine();

		this.setPadding(new Insets(0, 2.5, 0, 2.5));
		this.getStyleClass().add("calculator");

		buttons.setHgap(2.5);
		buttons.setVgap(2.5);

		this.setTop(display);
		this.setCenter(buttons);

		this.addEventFilter(KeyEvent.ANY, e -> filterOutKeyClicks(e));
		this.addEventHandler(ActionEvent.ANY, e -> updateDisplay("1"));
	}

	private void filterOutKeyClicks(KeyEvent event)
	{
		System.out.println("1");
		event.consume();
	}

	private void updateDisplay(String exp)
	{
		String topDisplay = display.getTopDisplay();
		String bottomDisplay = removeZero(display.getBottomDisplay());

		if(isOperator(exp))
		{
			if(!isNewExp)
			{
				display.setTopDisplay(topDisplay + " " + bottomDisplay + " " + exp);
				display.setBottomDisplay("0");
			}
			isNewExp = true;
		}
		else if(isResult)
		{
			display.setBottomDisplay(exp);
			isNewExp = false;
			isResult = false;
		}
		else
		{
			display.setBottomDisplay(bottomDisplay + exp);
			isNewExp = false;
		}
	}

	private String removeZero(String exp)
	{
		if(exp.equals("0"))
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

	private void resetFlags()
	{
		isNewExp = true;
		isResult = false;
	}

	private void handleDecimal()
	{
		String bottomDisplay = display.getBottomDisplay();
		boolean isDecimal = bottomDisplay.contains(".");

		if(bottomDisplay.equals("0") && !isDecimal)
		{
			updateDisplay("0.");
		}
		else if(!isDecimal)
		{
			updateDisplay(".");
		}
	}

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
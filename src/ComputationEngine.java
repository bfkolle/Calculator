import java.util.ArrayDeque;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class ComputationEngine
{
	public String computeExpression(String infixExpression)
	{
		ArrayDeque<String> stack = new ArrayDeque<>();
		String postfixExpression = convertToPostfix(infixExpression);
		String[] postfixArray = postfixExpression.split("\\s");

		for(String s : postfixArray)
		{
			if(isNumeric(s))
			{
				stack.push(s);
			}
			else
			{
				String result;
				double operandTwo = Double.parseDouble(stack.pop());
				double operandOne = Double.parseDouble(stack.pop());

				switch(s)
				{
					case "+":
						result = Double.toString(operandOne + operandTwo);
						stack.push(result);
						break;
					case "-":
						result = Double.toString(operandOne - operandTwo);
						stack.push(result);
						break;
					case "*":
						result = Double.toString(operandOne * operandTwo);
						stack.push(result);
						break;
					case "/":
						result = Double.toString(operandOne / operandTwo);
						stack.push(result);
						break;	
					default:
						break;
				}
			}
		}
		return stack.pop();
	}

	//Converts and infix expression to postfix
	private String convertToPostfix(String infixExpression)
	{
		ArrayDeque<String> stack = new ArrayDeque<>();
		String postfixString = "";
		String[] infixArray = infixExpression.split("\\s");

		//Convert the expression character by character
		for(String s : infixArray)
		{
			//Append to postfix string if the character is an operand
			if(isNumeric(s))
			{
				postfixString += s + " ";
			}

			//Push onto stack if the operator is a '('
			else if(s == "(")
			{
				stack.push(s);
			}

			//If the operator is a ')' pop from stack until a '('
			else if(s == ")")
			{
				while(!stack.isEmpty() && stack.peek() != "(")
				{
					postfixString += stack.pop() + " ";
				}

				//Get rid of '('
				stack.pop();
			}

			//The character is an operator
			else
			{
				while(!stack.isEmpty() && getPrecedence(s) <= getPrecedence(stack.peek()))
				{
					postfixString += stack.pop() + " ";
				}
				stack.push(s);
			}
		}

		//Pop all remaining operators from the stack
		while(!stack.isEmpty())
		{
			postfixString += stack.pop() + " ";
		}
		return postfixString;
	}

	//Gets the precedence of an infix operator for postfix conversion
	private int getPrecedence(String operator)
	{
			switch(operator)
			{
				case "+":
				case "-":
					return 1;
				case "*":
				case "/":
					return 2;
				case "^":
					return 3;
			}
			return -1;
	}

	private boolean isNumeric(String exp)
	{
		try
		{
			Double.parseDouble(exp);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
}
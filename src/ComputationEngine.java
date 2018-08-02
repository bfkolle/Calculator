import java.util.ArrayDeque;

/*
	Author: Brandon Kolle
	7/29/2018
 */

public class ComputationEngine
{
	public ComputationEngine()
	{

	}

	public String computeExpression(String infixExpression)
	{
		ArrayDeque<String> stack = new ArrayDeque<>();
		String postfixExpression = convertToPostfix(infixExpression).trim();

		for(int i = 0; i < postfixExpression.length(); i++)
		{
			char temp = postfixExpression.charAt(i);

			if(Character.isDigit(temp))
			{
				stack.push(Character.toString(temp));
			}
			else
			{
				String result;
				double operandTwo = Double.parseDouble(stack.pop());
				double operandOne = Double.parseDouble(stack.pop());

				switch(temp)
				{
					case '+':
						result = Double.toString(operandOne + operandTwo);
						stack.push(result);
						break;
					case '-':
						result = Double.toString(operandOne - operandTwo);
						stack.push(result);
						break;
					case '*':
						result = Double.toString(operandOne * operandTwo);
						stack.push(result);
						break;
					case '/':
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
		ArrayDeque<Character> stack = new ArrayDeque<>();
		String postfixString = "";

		//Convert the expression character by character
		for(int i = 0; i < infixExpression.length(); i++)
		{
			char temp = infixExpression.charAt(i);

			//Append to postfix string if the character is an operand
			if(Character.isDigit(temp))
			{
				postfixString += temp;
			}

			//Push onto stack if the operator is a '('
			else if(temp == '(')
			{
				stack.push(temp);
			}

			//If the operator is a ')' pop from stack until a '('
			else if(temp == ')')
			{
				while(!stack.isEmpty() && stack.peek() != '(')
				{
					postfixString += stack.pop();
				}

				//Get rid of '('
				stack.pop();
			}

			//The character is an operator
			else
			{
				while(!stack.isEmpty() && getPrecedence(temp) <= getPrecedence(stack.peek()))
				{
					postfixString += stack.pop();
				}
				stack.push(temp);
			}
		}

		//Pop all remaining operators from the stack
		while(!stack.isEmpty())
		{
			postfixString += stack.pop();
		}
		return postfixString;
	}

	//Gets the precedence of an infix operator for postfix conversion
	private int getPrecedence(char operator)
	{
			switch(operator)
			{
				case '+':
				case '-':
					return 1;
				case '*':
				case '/':
					return 2;
				case '^':
					return 3;
			}
			return -1;
	}
}
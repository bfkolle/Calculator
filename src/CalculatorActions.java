import java.math.BigDecimal;

/**
 * @author Brandon Kolle
 * 7/9/2017
 */

class CalculatorActions {

    private double operandOne; //First operand in add,sub, div, or mult problem

    private double operandTwo; //Second operand in add, sub, div, or mult problem

    private double result = 0; //Arithmetic result from performing an operation

    private String operationIndicator = ""; //Indicates which operation to perform

    private boolean resultFlag = false; //Indicates whether an operation has previously been committed

    private boolean decimalFlag = false; //Indicates whether a decimal is being appended to a number

    private boolean operandFlag = false; //False = operandOne, True = operandTwo

    private int powerOfTen = 1;

    private CalculatorDisplay display;


    //Constructor to retrieve display object
    CalculatorActions(CalculatorDisplay display)
	{
        this.display = display;
    }

    /*Event Actions*********************
    ************************************/

    void setOperator(String s)
	{
        operationIndicator = s;
        operandFlag = true;
        decimalFlag = false;
        powerOfTen = 1;

        if (resultFlag)
        {
            operandOne = result;
            resultFlag = false;

        }

        display.setDisplay(operandOne, operationIndicator, operandTwo);
    }

    void numberInput(String s)
	{
        //First operand
        if (!operandFlag)
        {
            if (resultFlag)
            {
                this.increasePowerOfTen();
                operandOne = Double.parseDouble(s);
                display.setDisplay(Double.toString(operandOne));
                resultFlag = false;

            }
            else
			{
                this.increasePowerOfTen();
                operandOne = this.appendInput(s, operandOne);
                display.setDisplay(Double.toString(operandOne));

            }
        }
        //Second operand
        else
		{
            this.increasePowerOfTen();
            operandFlag = true;
            operandTwo = this.appendInput(s, operandTwo);
            display.setDisplay(operandOne, operationIndicator, operandTwo);

        }
    }

    void equals()
	{
        switch (operationIndicator)
		{

            case "+": result = this.add(operandOne, operandTwo);
                display.setDisplay(Double.toString(result));
                this.reset();
                break;

            case "-": result = this.subtract(operandOne, operandTwo);
                display.setDisplay(Double.toString(result));
                this.reset();
                break;

            case "*": result = this.multiply(operandOne, operandTwo);
                display.setDisplay(Double.toString(result));
                this.reset();
                break;

            case "/": result = this.divide(operandOne, operandTwo);
                display.setDisplay(Double.toString(result));
                this.reset();
                break;

            case "^": result = this.exponent(operandOne, operandTwo);
                display.setDisplay(Double.toString(result));
                this.reset();
                break;

            default: break;
        }
    }

    void negative()
	{
        if (!operandFlag && !resultFlag)
        {
            operandOne = operandOne * -1.0;
            display.setDisplay(Double.toString(operandOne));
        }
        else if (resultFlag)
        {
            result = result * -1.0;
            display.setDisplay(Double.toString(result));
        }
        else
		{
        	operandTwo = operandTwo * -1.0;
            display.setDisplay(operandOne, operationIndicator, operandTwo);
        }
    }

    void clear()
	{
        this.reset();
        result = 0;
        display.setDisplay("0");
    }

    void clearEntry()
	{
        operandOne = result;
        operandTwo = 0;
        operandFlag = false;
        decimalFlag = false;
        powerOfTen = 1;
        operationIndicator = "";
        display.setDisplay("0");
    }

    void decimal()
	{
        decimalFlag = true;
    }

    /*End Event Actions ******************
    **************************************/

    //Appends passed string to passed double
    private double appendInput(String s, double operand)
	{
        double returnOperand;

        if (operand % 1.0 == 0)
        {
            if (decimalFlag)
            {
                returnOperand = appendExactDecimal(s, operand);
            }
            else
			{
                String temp = Integer.toString((int)operand);
                temp += s;
                returnOperand= Double.parseDouble(temp);
            }

        }
        else
		{
            if (decimalFlag)
            {
                returnOperand = appendExactDecimal(s, operand);
            }
            else
			{
                String temp = Double.toString(operand);
                temp += s;
                returnOperand = Double.parseDouble(temp);
            }

        }

        return returnOperand;
    }

    private double appendExactDecimal(String s, double operand)
	{
        s = Double.toString(Double.parseDouble(s) / powerOfTen);
        BigDecimal operandDec = new BigDecimal(Double.toString(operand));
        BigDecimal sDec = new BigDecimal(s);

        sDec = sDec.setScale(operandDec.scale() + 1, BigDecimal.ROUND_HALF_EVEN);
        sDec = sDec.add(operandDec);

        return sDec.doubleValue();
    }

	private double computeExactDecimal(double opOne, double opTwo)
	{
		double decOpOne = opOne - Math.floor(opOne);
		double decOpTwo = opTwo - Math.floor(opTwo);

		BigDecimal bigOpOne = new BigDecimal(Double.toString(opOne));
		BigDecimal bigOpTwo = new BigDecimal(Double.toString(opTwo));

		if (Double.toString(decOpOne).length() > Double.toString(decOpTwo).length())
		{
			if (operationIndicator.equals("*"))
			{
				bigOpOne = bigOpOne.multiply(bigOpTwo);
				bigOpOne = bigOpOne.setScale(Double.toString(decOpOne).length(), BigDecimal.ROUND_HALF_EVEN);

			}
			else if (operationIndicator.equals("/"))
			{
				bigOpOne = bigOpOne.divide(bigOpTwo);
				bigOpOne = bigOpOne.setScale(Double.toString(decOpOne).length(), BigDecimal.ROUND_HALF_EVEN);

			}
			else
			{
				bigOpOne = bigOpOne.pow(bigOpTwo.intValue());
				bigOpOne = bigOpOne.setScale(Double.toString(decOpOne).length(), BigDecimal.ROUND_HALF_EVEN);

			}
		}
		else
		{
			if (operationIndicator.equals("*"))
			{
				bigOpOne = bigOpOne.multiply(bigOpTwo);
				bigOpOne = bigOpOne.setScale(Double.toString(decOpTwo).length(), BigDecimal.ROUND_HALF_EVEN);

			}
			else if (operationIndicator.equals("/"))
			{
				bigOpOne = bigOpOne.divide(bigOpTwo);
				bigOpOne = bigOpOne.setScale(Double.toString(decOpTwo).length(), BigDecimal.ROUND_HALF_EVEN);

			}
			else
			{
				bigOpOne = bigOpOne.pow(bigOpTwo.intValue());
				bigOpOne = bigOpOne.setScale(Double.toString(decOpTwo).length(), BigDecimal.ROUND_HALF_EVEN);
			}
		}

		return bigOpOne.doubleValue();
	}

    private double exponent(double opOne, double opTwo)
	{
        return this.computeExactDecimal(operandOne, operandTwo);
    }

    private double add(double opOne, double opTwo) {
        return opOne + opTwo;
    }

    private double subtract(double opOne, double opTwo) {
        return opOne - opTwo;
    }

    private double multiply(double opOne, double opTwo) {
        return computeExactDecimal(opOne, opTwo);
    }

    private double divide(double opOne, double opTwo) {
        return computeExactDecimal(opOne, opTwo);
    }

    private void reset()
	{
        operationIndicator = "";
        operandOne = 0;
        operandTwo = 0;
        resultFlag = true;
        operandFlag = false;
        decimalFlag = false;
        powerOfTen = 1;

    }

    private void increasePowerOfTen()
	{
        if (decimalFlag)
        {
            powerOfTen *= 10;
        }

    }


}
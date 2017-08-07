/**
 * Created by bfkol on 7/9/2017.
 */

class CalculatorActions {

    private double operandOne; //First operand in add,sub, div, or mult problem

    private double operandTwo; //Second operand in add, sub, div, or mult problem

    private double result = 0; //Arithmetic result from performing an operation

    private int operationIndicator = 0; //indicates which operation to perform

    private boolean resultFlag = false; //indicates whether an operation has previously been committed

    private boolean operandOneFlag = false; //operand one is currently being filled

    private boolean operandTwoFlag = false; //operand two is currently being filled

    private CalculatorDisplay display; //holder for passed display object declared in CalculatorButtons class


    CalculatorActions(CalculatorDisplay display) { //constructor to retrieve display object
        this.display = display;
    }

    void add() {
        if (!resultFlag) {
            operationIndicator = 1;
            display.setDisplay(display.getDisplay() + " + ");
        }
    }

    void subtract() {
        if (!resultFlag) {
            operationIndicator = 2;
            display.setDisplay(display.getDisplay() + " - ");
        }
    }

    void multiply() {
        if (!resultFlag) {
            operationIndicator = 3;
            display.setDisplay(display.getDisplay() + " * ");
        }
    }

    void divide() {
        if (!resultFlag) {
            operationIndicator = 4;
            display.setDisplay(display.getDisplay() + " / ");
        }

    }

    void negative() {
        if (operandOneFlag) {
            operandOne = operandOne * -1.0;
        }

        else if (operandTwoFlag) {
            operandTwo = operandTwo * -1.0;
        }
    }

    void equals() {
        switch (operationIndicator) {

            //Addition
            case 1: result = operandOne + operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = 0;
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            //Subtraction
            case 2: result = operandOne - operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = 0;
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            //Multiplication
            case 3: result = operandOne * operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = 0;
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            //Division
            case 4: result = operandOne / operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = 0;
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            default: break;

        }
    }

    void clear() {
        operandOne = 0;
        operandTwo = 0;
        result = 0;
        resultFlag = false;
        operationIndicator = 0;
        display.setDisplay("0");

    }

    void number(String s) {
        if (operationIndicator == 0) { //First operand
            operandOneFlag = true;
            operandTwoFlag = false;

            if (display.getDisplay().equals("0") || resultFlag) { //Prevent existing text from being attached to the number
                display.setDisplay(s);
                operandOne = Double.parseDouble(display.getDisplay());
                resultFlag = false;

            } else {
                display.setDisplay(display.getDisplay() + s);
                operandOne = Double.parseDouble(display.getDisplay());

            }

        } else { //Second operand
            operandOneFlag = false;
            operandTwoFlag = true;

            display.setDisplay(display.getDisplay() + s);

            String temp = Integer.toString((int)operandTwo);
            temp += s;

            operandTwo = Double.parseDouble(temp);

        }

    }
}
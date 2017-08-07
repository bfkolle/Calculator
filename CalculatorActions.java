/**
 * Created by bfkol on 7/9/2017.
 */

class CalculatorActions {

    private double operandOne; //First operand in add,sub, div, or mult problem

    private double operandTwo; //Second operand in add, sub, div, or mult problem

    private double result = 0; //Arithmetic result from performing an operation

    private String operationIndicator = ""; //indicates which operation to perform

    private boolean resultFlag = false; //indicates whether an operation has previously been committed

    private boolean operandOneFlag = false; //operand one is currently being filled

    private boolean operandTwoFlag = false; //operand two is currently being filled

    private CalculatorDisplay display; //holder for passed display object declared in CalculatorButtons class


    CalculatorActions(CalculatorDisplay display) { //constructor to retrieve display object
        this.display = display;
    }

    void add() {
        if (!resultFlag) {
            operationIndicator = "+";
            display.setDisplay(display.getDisplay() + "+");
        }
    }

    void subtract() {
        if (!resultFlag) {
            operationIndicator = "-";
            display.setDisplay(display.getDisplay() + "-");
        }
    }

    void multiply() {
        if (!resultFlag) {
            operationIndicator = "*";
            display.setDisplay(display.getDisplay() + "*");
        }
    }

    void divide() {
        if (!resultFlag) {
            operationIndicator = "*";
            display.setDisplay(display.getDisplay() + "/");
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

            case "+": result = operandOne + operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            case "-": result = operandOne - operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            case "*": result = operandOne * operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            case "/": result = operandOne / operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
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
        operationIndicator = "";
        display.setDisplay("0");

    }

    void number(String s) {
        if (operationIndicator.equals("")) { //First operand
            operandOneFlag = true;
            operandTwoFlag = false;

            if (display.getDisplay().equals("0") || resultFlag) {
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
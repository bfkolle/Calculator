/**
 * Created by bfkol on 7/9/2017.
 */

class CalculatorActions {

    private double operandOne; //First operand in add,sub, div, or mult problem

    private double operandTwo; //Second operand in add, sub, div, or mult problem

    private double result = 0; //Arithmetic result from performing an operation

    private int operationFlag = 0; //indicates which operation to perform

    private CalculatorDisplay display; //holder for passed display object declared in CalculatorButtons class


    CalculatorActions(CalculatorDisplay display) { //constructor to retrieve display object
        this.display = display;
    }

    void add() {
        operationFlag = 1;
        display.setDisplay(display.getDisplay() + " + ");

    }

    void subtract() {
        operationFlag = 2;
        display.setDisplay(display.getDisplay() + " - ");

    }

    void multiply() {
        operationFlag = 3;
        display.setDisplay(display.getDisplay() + " * ");

    }

    void divide() {
        operationFlag = 4;
        display.setDisplay(display.getDisplay() + " / ");

    }

    void equal() {
        switch (operationFlag) {
            case 1: result = operandOne + operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationFlag = 0;
                    break;

            case 2: result = operandOne - operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationFlag = 0;
                    break;

            case 3: result = operandOne * operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationFlag = 0;
                    break;

            case 4: result = operandOne / operandTwo;
                    display.setDisplay(Double.toString(result));
                    operationFlag = 0;
                    break;

            default:
                    operationFlag = 0;
                    break;

        }
    }

    void clearEntry() {
        operationFlag = 0;
        display.setDisplay("0");

    }

    void clear() {
        operandOne = 0;
        operandTwo = 0;
        operationFlag = 0;
        display.setDisplay("0");

    }

    void number(String s) {
        if (operationFlag == 0) { //checks which operand to fill

            if (display.getDisplay().equals("0")) { //will prevent the starting zero from being attached to the number
                display.setDisplay(s);
                operandOne = Double.parseDouble(display.getDisplay());

            } else {
                display.setDisplay(display.getDisplay() + s);
                operandOne = Double.parseDouble(display.getDisplay());

            }

        } else {
            display.setDisplay(display.getDisplay() + s);

            if(operandTwo == 0) {
                operandTwo = Double.parseDouble(s);

            } else {
                String temp = Integer.toString((int)operandTwo);

                temp += s;

                operandTwo = Double.parseDouble(temp);

            }

        }

    }
}
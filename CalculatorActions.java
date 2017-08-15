/**
 * Created by bfkol on 7/9/2017.
 */

class CalculatorActions {

    private double operandOne; //First operand in add,sub, div, or mult problem

    private double operandTwo; //Second operand in add, sub, div, or mult problem

    private double result = 0; //Arithmetic result from performing an operation

    private String operationIndicator = ""; //Indicates which operation to perform

    private boolean resultFlag = false; //Indicates whether an operation has previously been committed

    private boolean operandOneFlag = false; //Operand one is currently being filled

    private CalculatorDisplay display;


    CalculatorActions(CalculatorDisplay display) { //constructor to retrieve display object
        this.display = display;
    }

    /*Event Actions*********************
    ************************************/

    void setOperator(String s) {
        operandOneFlag = false;
        operationIndicator = s;

        if (resultFlag) {
            display.setDisplay(operationIndicator, operandTwo);
            operandOne = result;

        }
        else {
            display.setDisplay(operandOne, operationIndicator, operandTwo);

        }

    }

    void negative() {
        if (operandOneFlag) {
            operandOne = operandOne * -1.0;
            display.setDisplay(Double.toString(operandOne));
        }
        else if (!operandOneFlag) {
            operandTwo = operandTwo * -1.0;
            display.setDisplay(Double.toString(operandOne) + operationIndicator + Double.toString(operandTwo));
        }
    }

    void equals() {
        switch (operationIndicator) {

            case "+": result = this.add(operandOne, operandTwo);
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            case "-": result = this.subtract(operandOne, operandTwo);
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            case "*": result = this.multiply(operandOne, operandTwo);
                    display.setDisplay(Double.toString(result));
                    operationIndicator = "";
                    operandOne = 0;
                    operandTwo = 0;
                    resultFlag = true;
                    break;

            case "/": result = this.divide(operandOne, operandTwo);
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
        display.setDisplay("");

    }

    void number(String s) {
        //First operand
        if (operationIndicator.equals("")) {
            operandOneFlag = true;

            if (resultFlag) {
                operandOne = Double.parseDouble(s);
                display.setDisplay(Double.toString(operandOne));
                resultFlag = false;

            }
            else {
                operandOne = this.appendInput(s, operandOne);
                display.setDisplay(Double.toString(operandOne));

            }

        }
        //Second operand
        else {
            if (resultFlag) {
                operandTwo = this.appendInput(s, operandTwo);
                display.setDisplay(operationIndicator, operandTwo);

            }
            else {
                operandTwo = this.appendInput(s, operandTwo);
                display.setDisplay(operandOne, operationIndicator, operandTwo);

            }

        }
    }
    /*End Event Actions ******************
    **************************************/

    //Appends passed string to passed double
    private double appendInput(String s, double operand) {
        double returnOperand;

        if (operand % 1.0 == 0) {
            String temp = Integer.toString((int)operand);
            temp += s;
            returnOperand= Double.parseDouble(temp);

        }
        else {
            String temp = Double.toString(operand);
            temp += s;
            returnOperand = Double.parseDouble(temp);

        }
        return returnOperand;

    }

    private double add(double opOne, double opTwo) {
        return opOne + opTwo;

    }

    private double subtract(double opOne, double opTwo) {
        return opOne - opTwo;

    }

    private double multiply(double opOne, double opTwo) {
        return opOne * opTwo;

    }

    private double divide(double opOne, double opTwo) {
        return opOne / opTwo;

    }

}
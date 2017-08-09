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
            operationIndicator = "/";
            display.setDisplay(display.getDisplay() + "/");
        }

    }

    void negative() {
        if (operandOneFlag) {
            operandOne = operandOne * -1.0;
        }
        else if (!operandOneFlag) {
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
            operandOneFlag = false;
            operandTwo = this.appendInput(s,operandTwo);
            display.setDisplay(Double.toString(operandOne) + operationIndicator + operandTwo);

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
}
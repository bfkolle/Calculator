/**
 * Created by bfkol on 7/9/2017.
 */

public class CalculatorActions {

    private String displayValue = ""; //Value to be displayed

    private double operandOne = 0; //First operand in add,sub, div, or mult problem

    private double operandTwo = 0; //Second operand in add, sub, div, or mult problem

    private int operationIndicator = 0; //tells equals method which operation to perform

    private CalculatorDisplay display; //holder for passed display object declared in Calculator class


    public CalculatorActions(CalculatorDisplay display) { //constructor to retrieve display object
        this.display = display;
    }

    public int getOperationIndicator() {
        return operationIndicator;
    }

    void add() {
        operationIndicator = 1;
        displayValue += " + ";
        display.setDisplay(displayValue);
        displayValue = "";
    }

    void subtract() {

    }

    void multiply() {

    }

    void divide() {

    }

    void equal(int num) {

        switch(num) {

            case 0: break;

            case 1:
                operandOne = operandOne + operandTwo; //store result in operandOne
                operandTwo = 0; //clear operandTwo

                //will remove trailing zero if there is one
                if (operandOne % Math.floor(operandOne) == 0) {
                    int x = (int)operandOne;
                    displayValue = Integer.toString(x);
                    display.setDisplay(displayValue);
                    break;
                }
                else {
                    displayValue = Double.toString(operandOne);
                    display.setDisplay(displayValue);
                    break;
                }

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;
        }
    }

    void clearEntry() {
        operationIndicator = 0;
        displayValue = "";
        display.setDisplay("0");
    }

    void clear() {
        operandOne = 0;
        operandTwo = 0;
        operationIndicator = 0;
        displayValue = "";
        display.setDisplay("0");
    }

    void number(String s) {
        displayValue += s;
        display.setDisplay(displayValue);

        if (operationIndicator != 0) {
            operandOne = Double.parseDouble(displayValue);
        }
        else {
            operandTwo = Double.parseDouble(displayValue);
        }
    }
}

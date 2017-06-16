import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bfkol on 6/14/2017.
 */
public class Calculator extends VBox {

    private Text display = new Text("0"); //Text box for display

    private double value = 0; //Value for arithmetic and storage purposes

    private double valueTwo; //Secondary value for arithmetic and storage purposes

    private int operationIndicator = 0; //tells equals method which operation to perform

    //Default constructor sets up calculator graphics
    public Calculator() {

        //ArrayList to hold all of the buttons
        ArrayList<Button> buttonHolder = new ArrayList<>();

        //Declare each button of calculator
        Button btCE = new Button("CE"), btC = new Button("C"), btBack = new Button("<--"),
                btDiv = new Button("/"),  bt7 = new Button("7"), bt8 = new Button("8"),
                bt9 = new Button("9"), btMult = new Button("*"), bt4 = new Button("4"),
                bt5 = new Button("5"), bt6 = new Button("6"), btSub = new Button("-"),
                bt1 = new Button("1"), bt2 = new Button("2"), bt3 = new Button("3"),
                btAdd = new Button("+"), btNeg = new Button("Neg"), bt0 = new Button("0"),
                btDec = new Button("."), btEquals = new Button("=");

        //Add all buttons to buttonHolder arrayList
        Collections.addAll(buttonHolder, btCE, btC, btBack, btDiv, bt7, bt8, bt9, btMult, bt4, bt5, bt6, btSub, bt1,
                bt2, bt3, btAdd, btNeg, bt0, btDec, btEquals);

        //Set each button so it will grow to fit space, and set to bold
        for (int i = 0; i < buttonHolder.size(); i++) {
            buttonHolder.get(i).minWidthProperty().bind(this.prefWidthProperty().divide(4.0));
            buttonHolder.get(i).minHeightProperty().bind(this.prefHeightProperty().divide(6.0));
            buttonHolder.get(i).setFont(Font.font("sans serif", FontWeight.BOLD, 30 ));
        }

        //Create each row of the calculator as a hbox
        //Each row holds 4 buttons of the calculator
        HBox row1 = new HBox();
        row1.getChildren().addAll(btCE, btC, btBack, btDiv);

        HBox row2 = new HBox();
        row2.getChildren().addAll(bt7, bt8, bt9, btMult);

        HBox row3 = new HBox();
        row3.getChildren().addAll(bt4, bt5, bt6, btSub);

        HBox row4 = new HBox();
        row4.getChildren().addAll(bt1, bt2, bt3, btAdd);

        HBox row5 = new HBox();
        row5.getChildren().addAll(btNeg, bt0, btDec, btEquals);

        //Set text box as first row
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 45));

        HBox row0 = new HBox();

        row0.alignmentProperty().setValue(Pos.BOTTOM_RIGHT);
        row0.minHeightProperty().bind(this.prefHeightProperty().divide(6.0));
        row0.minWidthProperty().bind(this.prefWidthProperty());

        row0.getChildren().add(display);

        //Add all hboxes
        this.getChildren().addAll(row0, row1, row2, row3, row4, row5);

        //Assign lambda event handler to each button
        btCE.setOnAction(e -> this.clearScreen());

        btC.setOnAction(e -> this.clearAll());

        btDiv.setOnAction(e -> this.divide());

        btMult.setOnAction(e -> this.multiply());

        btSub.setOnAction(e -> this.subtract());

        btAdd.setOnAction(e -> this.add());

        btEquals.setOnAction(e -> this.equal(operationIndicator));

        bt9.setOnAction(e -> this.number(9));

        bt8.setOnAction(e -> this.number(8));

        bt7.setOnAction(e -> this.number(7));

        bt6.setOnAction(e -> this.number(6));

        bt5.setOnAction(e -> this.number(5));

        bt4.setOnAction(e -> this.number(4));

        bt3.setOnAction(e -> this.number(3));

        bt2.setOnAction(e -> this.number(2));

        bt1.setOnAction(e -> this.number(1));

        bt0.setOnAction(e -> this.number(0));
    }

    private void changeDisplay(double num) {
        display.setText(Double.toString(num));
    }

    private void add() {
        operationIndicator = 4;
        display.setText(display.getText() + " + ");
    }

    private void subtract() {
        operationIndicator = 3;
        display.setText(display.getText() + " - ");
    }

    private void multiply() {
        operationIndicator = 2;
        display.setText(display.getText() + " * ");
    }

    private void divide() {
        operationIndicator = 1;
        display.setText(display.getText() + " / ");
    }

    private void equal(int num) {

        switch(num) {

            case 0: break;

            case 1:
                if(valueTwo == 0) {
                    display.setText("Divide by Zero");
                    value = 0;
                    operationIndicator = 0;
                    break;
                }
                else {
                    valueTwo /= value;
                    this.changeDisplay(valueTwo);
                    operationIndicator = 0;
                    break;
                }

            case 2:
                valueTwo *= value;
                this.changeDisplay(valueTwo);
                operationIndicator = 0;
                break;

            case 3:
                valueTwo -= value;
                this.changeDisplay(valueTwo);
                operationIndicator = 0;
                break;

            case 4:
                valueTwo += value;
                this.changeDisplay(valueTwo);
                operationIndicator = 0;
                break;
        }
    }

    private void clearScreen() {
        operationIndicator = 0;
        this.changeDisplay(0);
    }

    private void clearAll() {
        value = 0;
        valueTwo = 0;
        operationIndicator = 0;
        this.changeDisplay(value);
    }

    private void number(double num) {
        valueTwo = value;
        value = num;
        this.changeDisplay(value);
    }

}
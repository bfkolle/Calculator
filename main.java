import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.*;

/**
 * Created by Brandon Kolle on 12/22/2016.
 * This is a calculator program using the public class main as the main class,
 * and the sub class for the frontend and backend.
 */

public class main extends Application {

     public Calculator frontend = new Calculator(); //Declare object for calculator front end

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(frontend, 400, 400);

        frontend.prefWidthProperty().bind(scene.widthProperty()); //Bind min width of calculator to scene's width
        frontend.prefHeightProperty().bind(scene.heightProperty()); //Bind min height of calculator to scene's height

        primaryStage.setMinHeight(425);
        primaryStage.setMinWidth(425);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

class Calculator extends VBox {

    private Text display = new Text("0"); //Text box for display

    private double value = 0; //Value for arithmetic purposes

    private double input; //Secondary value for arithmetic purposes

    private int operatorIndicator = 0; //tells equals method which operation to perform

    //Default constructor sets up calculator graphics
    public Calculator() {

        //Declare each button of calculator
        Button btCE = new Button("CE"), btC = new Button("C"), btBack = new Button("<--"),
                btDiv = new Button("/"),  bt7 = new Button("7"), bt8 = new Button("8"),
                bt9 = new Button("9"), btMult = new Button("*"), bt4 = new Button("4"),
                bt5 = new Button("5"), bt6 = new Button("6"), btSub = new Button("-"),
                bt1 = new Button("1"), bt2 = new Button("2"), bt3 = new Button("3"),
                btAdd = new Button("+"), btNeg = new Button("Neg"), bt0 = new Button("0"),
                btDec = new Button("."), btEquals = new Button("=");

        ArrayList<Button> buttonHolder = new ArrayList<>(); //ArrayList to hold all of the buttons


        //Add all buttons to buttonHolder arrayList
        Collections.addAll(buttonHolder, btCE, btC, btBack, btDiv, bt7, bt8, bt9, btMult, bt4, bt5, bt6, btSub, bt1,
                            bt2, bt3, btAdd, btNeg, bt0, btDec, btEquals);

        //Set each button so it will grow to fit space, and set to bold
        for (int i = 0; i < buttonHolder.size(); i++) {
            buttonHolder.get(i).minWidthProperty().bind(this.prefWidthProperty().divide(4.0));
            buttonHolder.get(i).minHeightProperty().bind(this.prefHeightProperty().divide(6.0));
            buttonHolder.get(i).setFont(Font.font("sans serif", FontWeight.BOLD, 30 ));
        }

        /*Create each row of the calculator as a hbox.
         * Each row holds 4 buttons of the calculator.*/
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

        //set text as first row
        display.setFont(Font.font("sans serif", FontWeight.BOLD, 45));

        HBox row0 = new HBox();

        row0.alignmentProperty().setValue(Pos.BOTTOM_RIGHT);
        row0.minHeightProperty().bind(this.prefHeightProperty().divide(6.0));
        row0.minWidthProperty().bind(this.prefWidthProperty());

        row0.getChildren().add(display);

        //add all hboxes
        this.getChildren().addAll(row0, row1, row2, row3, row4, row5);

        //assign event handler to each button
        btCE.setOnAction(e -> this.clearScreen());

        btC.setOnAction(e -> this.clearAll());

        btDiv.setOnAction(e -> this.divide());

        btMult.setOnAction(e -> this.multiply());

        btSub.setOnAction(e -> this.subtract());

        btAdd.setOnAction(e -> this.add());

        btEquals.setOnAction(e -> this.equal(operatorIndicator));

        bt9.setOnAction(e -> this.nine(9));

        bt8.setOnAction(e -> this.eight(8));

        bt7.setOnAction(e -> this.seven(7));

        bt6.setOnAction(e -> this.six(6));

        bt5.setOnAction(e -> this.five(5));

        bt4.setOnAction(e -> this.four(4));

        bt3.setOnAction(e -> this.three(3));

        bt2.setOnAction(e -> this.two(2));

        bt1.setOnAction(e -> this.one(1));
    }

    private void changeDisplay(double num) {
        display.setText(Double.toString(num));
    }

    private void add() {
        operatorIndicator = 4;
        display.setText(display.getText() + " + ");
    }

    private void subtract() {
        operatorIndicator = 3;
        display.setText(display.getText() + " - ");
    }

    private void multiply() {
        operatorIndicator = 2;
        display.setText(display.getText() + " * ");
    }

    private void divide() {
        operatorIndicator = 1;
        display.setText(display.getText() + " / ");
    }

    private void equal(int num) {

        switch(num) {

            case 0: break;

            case 1:
                if(input == 0) {
                    display.setText("Divide by Zero");
                    value = 0;
                    operatorIndicator = 0;
                    break;
                }
                else {
                    input /= value;
                    this.changeDisplay(input);
                    operatorIndicator = 0;
                    break;
                }

            case 2:
                input *= value;
                this.changeDisplay(input);
                operatorIndicator = 0;
                break;

            case 3:
                input -= value;
                this.changeDisplay(input);
                operatorIndicator = 0;
                break;

            case 4:
                input += value;
                this.changeDisplay(input);
                operatorIndicator = 0;
                break;
        }
    }

    private void clearScreen() {
        this.changeDisplay(0);
    }

    private void clearAll() {
        value = 0;
        operatorIndicator = 0;
        this.changeDisplay(value);
    }

    private void nine(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void eight(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void seven(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void six(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void five(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void four(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void three(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void two(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }

    private void one(double num) {
        input = value;
        value = num;
        this.changeDisplay(value);
    }
}

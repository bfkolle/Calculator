import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Brandon Kolle on 12/22/2016.
 * This is a calculator program using this public class Calculator as the main class,
 * and two sub classes for the Front-End and the Back-End.
 */
public class Calculator extends Application {
    double WIDTH = 400;/**Constant for scene width*/
    double HEIGHT = 400;/**Constant for scene height*/
    CalcFrontEnd calc = new CalcFrontEnd();/**Declare object for calculator front end graphics*/

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(calc, WIDTH, HEIGHT);/**Declare scene with width and height constants and calc vbox*/
        calc.prefWidthProperty().bind(scene.widthProperty());/**Binds min width of vbox to scene's width*/
        calc.prefHeightProperty().bind(scene.heightProperty());/**Binds min height of vbox to scene's height*/

        /**Sets scene and displays the stage*/
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    /**main method to launch program*/
    public static void main(String[] args) {
        Application.launch(args);
    }
}

class CalcFrontEnd extends VBox {

    public CalcFrontEnd() {
        /**ArrayList to hold all of the buttons*/
        ArrayList<Button> buttonHolder = new ArrayList<>();

        /**Declare each button of the calculator**/
        Button btCE = new Button("CE"), btC = new Button("C"), btBack = new Button("<--"),
                btDiv = new Button("/"),  bt7 = new Button("7"), bt8 = new Button("8"),
                bt9 = new Button("9"), btMult = new Button("*"), bt4 = new Button("4"),
                bt5 = new Button("5"), bt6 = new Button("6"), btSub = new Button("-"),
                bt1 = new Button("1"), bt2 = new Button("2"), bt3 = new Button("3"),
                btAdd = new Button("+"), btNeg = new Button("Neg"), bt0 = new Button("0"),
                btDec = new Button("."), btEquals = new Button("=");

        /**Add all buttons to buttonholder arrayList*/
        Collections.addAll(buttonHolder, btCE, btC, btBack, btDiv, bt7, bt8, bt9, btMult, bt4, bt5, bt6, btSub, bt1,
                            bt2, bt3, btAdd, btNeg, bt0, btDec, btEquals);

        /**Set each button so it will grow to fit space*/
        for (int i = 0; i < buttonHolder.size(); i++) {
            buttonHolder.get(i).minWidthProperty().bind(this.prefWidthProperty().divide(4.0));
            buttonHolder.get(i).minHeightProperty().bind(this.prefHeightProperty().divide(6.0));
        }

        /**Create text box as first row.
         * Add to HBox, set specifications for HBox*/
        Text display = new Text();
        display.textAlignmentProperty().set(TextAlignment.RIGHT);
        display.setText("Hello");
        HBox row0 = new HBox();
        row0.minHeightProperty().bind(this.prefHeightProperty().divide(6.0));
        row0.minWidthProperty().bind(this.prefWidthProperty());
        row0.getChildren().add(display);

        /**Create each row of the calculator as a hbox.
         * Each row holds 4 buttons of the calculator.
         * Each row is set to be centered.*/
        HBox row1 = new HBox();
        row1.getChildren().addAll(btCE, btC, btBack, btDiv);
        row1.alignmentProperty().set(Pos.CENTER);

        HBox row2 = new HBox();
        row2.getChildren().addAll(bt7, bt8, bt9, btMult);
        row2.alignmentProperty().set(Pos.CENTER);

        HBox row3 = new HBox();
        row3.getChildren().addAll(bt4, bt5, bt6, btSub);
        row3.alignmentProperty().set(Pos.CENTER);

        HBox row4 = new HBox();
        row4.getChildren().addAll(bt1, bt2, bt3, btAdd);
        row4.alignmentProperty().set(Pos.CENTER);

        HBox row5 = new HBox();
        row5.getChildren().addAll(btNeg, bt0, btDec, btEquals);
        row5.alignmentProperty().set(Pos.CENTER);

        /**Set Vbox to bet centered and add all hboxes*/
        this.alignmentProperty().set(Pos.CENTER);
        this.getChildren().addAll(row0, row1, row2, row3, row4, row5);
    }
}
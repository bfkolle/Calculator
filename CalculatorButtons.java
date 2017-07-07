import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by bfkol on 7/7/2017.
 */
public class CalculatorButtons extends VBox {

    public CalculatorButtons(int width, int height) {

        CalculatorActions actions = new CalculatorActions();

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
            buttonHolder.get(i).minWidthProperty().setValue(width / 4.0);
            buttonHolder.get(i).minHeightProperty().setValue(height / 6.0);
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

        this.getChildren().addAll(row1, row2, row3, row4, row5);

        //Assign lambda event handler to each button
        btCE.setOnAction(e -> actions.clearEntry());

        btC.setOnAction(e -> actions.clear());

        btDiv.setOnAction(e -> actions.divide());

        btMult.setOnAction(e -> actions.multiply());

        btSub.setOnAction(e -> actions.subtract());

        btAdd.setOnAction(e -> actions.add());

        btEquals.setOnAction(e -> actions.equal(operationIndicator));

        bt9.setOnAction(e -> actions.number("9"));

        bt8.setOnAction(e -> actions.number("8"));

        bt7.setOnAction(e -> actions.number("7"));

        bt6.setOnAction(e -> actions.number("6"));

        bt5.setOnAction(e -> actions.number("5"));

        bt4.setOnAction(e -> actions.number("4"));

        bt3.setOnAction(e -> actions.number("3"));

        bt2.setOnAction(e -> actions.number("2"));

        bt1.setOnAction(e -> actions.number("1"));

        bt0.setOnAction(e -> actions.number("0"));

        btDec.setOnAction(e -> actions.number("."));

    }
}

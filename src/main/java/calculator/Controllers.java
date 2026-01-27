package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controllers {

    @FXML private TextField result; //for showing input and calculation result
    @FXML private Button One;
    @FXML private Button Zero;
    @FXML private Button Add;
    @FXML private Button Subtract;
    @FXML private Button Multiply;
    @FXML private Button Divide;
    @FXML private Button Equals;
    @FXML private Button Clear;
    @FXML private Button Backspace;

    // For tracking what current operation is
    private models.Binaryoperations currentOperation;
    private StringBuilder inputA = new StringBuilder();
    private StringBuilder inputB = new StringBuilder();
    private boolean enteringSecondOperand = false;

    private void appendDigit(String digit) {
        if (!enteringSecondOperand) {
            inputA.append(digit);
            result.setText(inputA.toString());
        } else {
            inputB.append(digit);
            result.setText(inputB.toString());
        }
    }

    private void performOperation() {
        try {
            int a = Integer.parseInt(inputA.toString(), 2);
            int b = Integer.parseInt(inputB.toString(), 2);
            int res = (int) currentOperation.apply(a, b);
            result.setText(Integer.toBinaryString(res));
            // Reset for the next calculation
            inputA = new StringBuilder(Integer.toBinaryString(res));
            inputB = new StringBuilder();
            enteringSecondOperand = false;
        } catch (NumberFormatException e) {
            result.setText("Invalid binary input");
        } catch (ArithmeticException e) {
            result.setText(e.getMessage());
        } catch (NullPointerException e) {
            result.setText("No operation selected");
        }
    }

//    for C button
    private void clearFields() {
        inputA.setLength(0);
        inputB.setLength(0);
        result.setText("0");
        currentOperation = null;
        enteringSecondOperand = false;
    }

//    for backspace button
    private void backspace() {
        if (!enteringSecondOperand) {
            if (inputA.length() > 0) {
                inputA.deleteCharAt(inputA.length() - 1);
                result.setText(inputA.length() > 0 ? inputA.toString() : "0");
            }
        } else {
            if (inputB.length() > 0) {
                inputB.deleteCharAt(inputB.length() - 1);
                result.setText(inputB.length() > 0 ? inputB.toString() : "0");
            }
        }
    }

    @FXML
    private void initialize() {
        One.setOnAction(e -> appendDigit("1"));
        Zero.setOnAction(e -> appendDigit("0"));
        Add.setOnAction(e -> { currentOperation = new models.Addition(); enteringSecondOperand = true; });
        Subtract.setOnAction(e -> { currentOperation = new models.Subtraction(); enteringSecondOperand = true; });
        Multiply.setOnAction(e -> { currentOperation = new models.Multiplication(); enteringSecondOperand = true; });
        Divide.setOnAction(e -> { currentOperation = new models.Division(); enteringSecondOperand = true; });
        Equals.setOnAction(e -> performOperation());
        Clear.setOnAction(e -> clearFields());
        Backspace.setOnAction(e -> backspace());
    }
}
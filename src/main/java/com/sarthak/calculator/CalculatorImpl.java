/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

import javax.swing.*;

public class CalculatorImpl {
    public static void main(String[] args) {
        boolean wantToRetry = false;
        // Create and object for the calculator class
        Calculator calculator = new Calculator();
        // Prompt the user to enter the number using JOptionPane
        JTextField firstNumber = new JTextField();
        JTextField operator = new JTextField();
        JTextField secondNumber = new JTextField();
        Object[] message = {
                "First Number : ", firstNumber,
                "Operator : ", operator,
                "Second Number : ", secondNumber
        };
        do {
            int calculatorOption = JOptionPane.showConfirmDialog(
                    null,
                    message,
                    "Calculator",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    Calculator.getIcon()
            );
            if (calculatorOption == JOptionPane.OK_OPTION) {
                boolean isOperationSetSuccess = calculator.setOperation(operator.getText());
                if (isOperationSetSuccess) {
                    if (calculator.getOperation().equals("ADD")) {
                        calculator.add(Integer.parseInt(firstNumber.getText()), Integer.parseInt(secondNumber.getText()));
                        calculator.displayDetails();
                    } else if (calculator.getOperation().equals("SUBTRACT")) {


                    } else if (calculator.getOperation().equals("MULTIPLY")) {

                    } else if (calculator.getOperation().equals("DIVIDE")) {

                    } else {
                        wantToRetry = calculator.wantToRetry();
                    }
                } else {
                    wantToRetry = calculator.wantToRetry();
                }
            }
        } while (wantToRetry);
    }
}

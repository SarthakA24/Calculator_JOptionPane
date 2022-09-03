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
        JTextField secondNumber = new JTextField();
        Object[] message = {
                "First Number : ", firstNumber,
                "Second Number : ", secondNumber
        };
        do {
            String operation = String.valueOf(JOptionPane.showInputDialog(
                    null,
                    "Select the operation you need to perform",
                    "Calculator",
                    JOptionPane.ERROR_MESSAGE,
                    Calculator.getIcon(),
                    new String[]{"Add", "Subtract", "Multiply", "Divide"},
                    "Add"));
            int calculatorOption = JOptionPane.showConfirmDialog(
                    null,
                    message,
                    "Calculator",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    Calculator.getIcon()
            );
            if (calculatorOption == JOptionPane.OK_OPTION) {
                boolean isOperationSetSuccess = calculator.setOperation(operation);
                if (isOperationSetSuccess) {
                    switch (calculator.getOperation()) {
                        case "ADD":
                            calculator.add(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText()));
                            calculator.displayDetails();
                            wantToRetry = calculator.wantToRetry();
                            break;
                        case "SUBTRACT":
                            calculator.subtract(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText()));
                            calculator.displayDetails();
                            wantToRetry = calculator.wantToRetry();
                            break;
                        case "MULTIPLY":
                            calculator.multiply(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText()));
                            calculator.displayDetails();
                            wantToRetry = calculator.wantToRetry();
                            break;
                        case "DIVIDE":
                            calculator.divide(Double.parseDouble(firstNumber.getText()), Double.parseDouble(secondNumber.getText()));
                            calculator.displayDetails();
                            wantToRetry = calculator.wantToRetry();
                            break;
                        default:
                            wantToRetry = calculator.wantToRetry();
                            break;
                    }
                } else {
                    wantToRetry = calculator.wantToRetry();
                }
            }
        } while (wantToRetry);
    }
}

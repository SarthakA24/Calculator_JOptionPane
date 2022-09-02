/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

import javax.swing.*;

public class CalculatorImpl {
    public static void main(String[] args) {
        int error;
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
                error = 0;
                if (operator.getText().equalsIgnoreCase("ADD") || operator.getText().equals("+")) {
                    calculator.setOperation("ADD");
                    calculator.add(Integer.parseInt(firstNumber.getText()), Integer.parseInt(secondNumber.getText()));
                } else if (operator.getText().equalsIgnoreCase("SUBTRACT") || operator.getText().equals("-")) {
                    calculator.setOperation("SUBTRACT");
                } else if (operator.getText().equalsIgnoreCase("MULTIPLY") || operator.getText().equals("*")
                        || operator.getText().equalsIgnoreCase("X")) {
                    calculator.setOperation("MULTIPLY");
                } else if (operator.getText().equalsIgnoreCase("DIVIDE") || operator.getText().equals("/")
                        || operator.getText().equals("÷")) {
                    calculator.setOperation("DIVIDE");
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Input for Operator. Please try again",
                            "Calculator",
                            JOptionPane.ERROR_MESSAGE,
                            Calculator.getIcon()
                    );
                    error = -1;
                }
            } else {
                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Do you want to re-try?",
                        "Calculator",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        Calculator.getIcon()
                );
                if (response == JOptionPane.YES_OPTION)
                    error = -1;
                else
                    error = 0;
            }
        } while (error != 0);
    }
}

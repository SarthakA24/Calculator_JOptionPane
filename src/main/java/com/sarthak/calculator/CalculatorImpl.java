/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

import javax.swing.*;

public class CalculatorImpl {
    public static void main(String[] args) {
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
        int calculatorOption = JOptionPane.showConfirmDialog(
                null,
                message,
                "Calculator",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                Calculator.getIcon());
        calculator.setOperation(operator.getText());
//        if (calculatorOption == JOptionPane.OK_OPTION) {
//            // Start the if condition to check the operation and call the respective method
//            if (calculator.getOperation().equals("Add")) {
//                calculator.add(Integer.parseInt(firstNumber.getText()),Integer.parseInt(secondNumber.getText()));
//                calculator.displayDetails();
//            }
//        }
//        double input = Double.parseDouble((String) JOptionPane.showInputDialog(
//                null,
//                "Enter the number",
//                "Calculator",
//                JOptionPane.PLAIN_MESSAGE,
//                Calculator.getIcon(),
//                null,
//                null
//        ));
//        calculator.setOperation((String) JOptionPane.showInputDialog(
//                null,
//                "Enter the operation",
//                "Calculator",
//                JOptionPane.PLAIN_MESSAGE,
//                Calculator.getIcon(),
//                new String[]{"Add", "Subtract", "Multiply", "Divide"},
//                null)
//        );

    }
}

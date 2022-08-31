/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

import javax.swing.*;
import java.util.Scanner;

public class CalculatorImpl {
    public static void main(String[] args) {
        // Create and object for the calculator class
        Calculator calculator = new Calculator();
        // Initialise the scanner
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter the number using JOptionPane
        double input = Double.parseDouble((String) JOptionPane.showInputDialog(
                null,
                "Enter the number",
                "Calculator",
                JOptionPane.PLAIN_MESSAGE,
                Calculator.getIcon(),
                null,
                null
        ));
        // Prompt the user to enter the operation using JOptionPane
//        String operation = (String) JOptionPane.showInputDialog(
//                null,
//                "Enter the operation",
//                "Calculator",
//                JOptionPane.PLAIN_MESSAGE,
//                Calculator.getIcon(),
//                new String[]{"Add", "Subtract", "Multiply", "Divide"},
//                null
//        );
        calculator.setOperation((String) JOptionPane.showInputDialog(
                null,
                "Enter the operation",
                "Calculator",
                JOptionPane.PLAIN_MESSAGE,
                Calculator.getIcon(),
                new String[]{"Add", "Subtract", "Multiply", "Divide"},
                null)
        );
        // Close the scanner
        scanner.close();
    }
}

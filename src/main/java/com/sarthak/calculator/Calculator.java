/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

import javax.swing.*;

public class Calculator {
    private final static Icon icon = new ImageIcon("src/main/resources/images/Calculator-icon.png");
    private double sum;
    private double subtract;
    private double multiply;
    private double divide;
    private String operation;

    enum Operations {
        ADD("ADD"),
        SUBTRACT("SUBTRACT"),
        MULTIPLY("MULTIPLY"),
        DIVIDE("DIVIDE");

        Operations(String operation) {
        }
    }


    /**
     * Default / No-Args Constructor
     */
    public Calculator() {
    }

    /**
     * Constructor with parameters
     *
     * @param sum       The sum of the two numbers
     * @param subtract  The difference of the two numbers
     * @param multiply  The product of the two numbers
     * @param divide    The quotient of the two numbers
     * @param operation The operation to be performed
     */
    public Calculator(double sum, double subtract, double multiply, double divide, String operation) {
        this.sum = sum;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
        this.operation = operation;
    }

    /**
     * This method is used to get the icon for JOptionPane operations
     *
     * @return The icon for JOptionPane operations
     */
    public static Icon getIcon() {
        return icon;
    }

    /**
     * This method is used to add two numbers
     *
     * @param firstNumber  First number for the operation
     * @param secondNumber Second Number for the operation
     */
    public void add(double firstNumber, double secondNumber) {
        this.sum = firstNumber + secondNumber;
    }

    /**
     * This method subtracts the second number from the first number
     *
     * @param firstNumber  First number for the operation
     * @param secondNumber Second Number for the operation
     */
    public void subtract(double firstNumber, double secondNumber) {
        this.subtract = firstNumber - secondNumber;
    }

    /**
     * This method multiplies the two numbers
     *
     * @param firstNumber  First number for the operation
     * @param secondNumber Second Number for the operation
     */
    public void multiply(double firstNumber, double secondNumber) {
        this.multiply = firstNumber * secondNumber;
    }


    /**
     * This method divides the first number by the second number
     *
     * @param firstNumber  First number for the operation
     * @param secondNumber Second Number for the operation
     */
    public void divide(double firstNumber, double secondNumber) {
        this.divide = firstNumber / secondNumber;
    }

    /**
     * This method is used to display the details of the operation based on the operation
     */
    public void displayDetails() {
        switch (operation) {
            case "ADD":
                JOptionPane.showMessageDialog(null, "The sum of the numbers is " + sum, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case "SUBTRACT":
                JOptionPane.showMessageDialog(null, "The difference of the numbers is " + subtract, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case "MULTIPLY":
                JOptionPane.showMessageDialog(null, "The product of the numbers is " + multiply, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case "DIVIDE":
                JOptionPane.showMessageDialog(null, "The quotient of the numbers is " + divide, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
        }
        programEndDisplay();
    }

    /**
     * This method is used to display the details of the operation based on the operation
     *
     * @return The boolean response of the user for retrying the operation
     */
    public boolean wantToRetry() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to re-try?", "Calculator", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Calculator.getIcon());
        if (response == JOptionPane.NO_OPTION) programEndDisplay();
        return response == JOptionPane.YES_OPTION;
    }

    /**
     * This method is just an indication if the program executed successfully or not
     */
    public void programEndDisplay() {
        System.out.println("Program Ended Successfully!");
    }

    /**
     * This method is used to get the operation to be performed
     *
     * @return The operation to be performed
     */
    public String getOperation() {
        return operation;
    }

    /**
     * This method is used to set the operation to be performed
     *
     * @param operation The operation to be performed
     * @return The boolean response if the method is executed successfully or not
     */
    public boolean setOperation(String operation) {
        if (operation.equalsIgnoreCase("ADD")) {
            this.operation = "ADD";
            return true;
        } else if (operation.equalsIgnoreCase("SUBTRACT")) {
            this.operation = "SUBTRACT";
            return true;
        } else if (operation.equalsIgnoreCase("MULTIPLY")) {
            this.operation = "MULTIPLY";
            return true;
        } else if (operation.equalsIgnoreCase("DIVIDE")) {
            this.operation = "DIVIDE";
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input for Operator. Please try again", "Calculator", JOptionPane.ERROR_MESSAGE, Calculator.getIcon());
            return false;
        }
    }
}

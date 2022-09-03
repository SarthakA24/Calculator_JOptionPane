/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

import javax.swing.*;
import java.util.Objects;

public class Calculator {
    private final static Icon icon = new ImageIcon("src/main/resources/images/Calculator-icon.png");
    private double sum;
    private double subtract;
    private double multiply;
    private double divide;
    Operations operations;

    enum Operations {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }


    /**
     * Default / No-Args Constructor
     */
    public Calculator() {
    }

    /**
     * Constructor with parameters
     *
     * @param sum        The sum of the two numbers
     * @param subtract   The difference of the two numbers
     * @param multiply   The product of the two numbers
     * @param divide     The quotient of the two numbers
     * @param operations The operation to be performed
     */
    public Calculator(double sum, double subtract, double multiply, double divide, Operations operations) {
        this.sum = sum;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
        this.operations = operations;
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
        switch (operations) {
            case ADD:
                JOptionPane.showMessageDialog(null, "The sum of the numbers is " + sum, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case SUBTRACT:
                JOptionPane.showMessageDialog(null, "The difference of the numbers is " + subtract, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case MULTIPLY:
                JOptionPane.showMessageDialog(null, "The product of the numbers is " + multiply, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case DIVIDE:
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

    public Operations getOperations() {
        return operations;
    }

    /**
     * This method is used to set the operation to be performed
     *
     * @param operation The operation to be performed
     * @return The boolean response if the method is executed successfully or not
     */
    public boolean setOperation(String operation) {
        if (operation.equalsIgnoreCase(String.valueOf(Operations.ADD))) {
            this.operations = Operations.ADD;
            return true;
        } else if (operation.equalsIgnoreCase(String.valueOf(Operations.SUBTRACT))) {
            this.operations = Operations.SUBTRACT;
            return true;
        } else if (operation.equalsIgnoreCase(String.valueOf(Operations.MULTIPLY))) {
            this.operations = Operations.MULTIPLY;
            return true;
        } else if (operation.equalsIgnoreCase(String.valueOf(Operations.DIVIDE))) {
            this.operations = Operations.DIVIDE;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input for Operator. Please try again", "Calculator", JOptionPane.ERROR_MESSAGE, Calculator.getIcon());
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calculator)) return false;
        Calculator that = (Calculator) o;
        return Double.compare(that.sum, sum) == 0 && Double.compare(that.subtract, subtract) == 0 && Double.compare(that.multiply, multiply) == 0 && Double.compare(that.divide, divide) == 0 && getOperations() == that.getOperations();
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, subtract, multiply, divide, getOperations());
    }

    @Override
    public String
    toString() {
        return "Calculator{" +
                "sum=" + sum +
                ", subtract=" + subtract +
                ", multiply=" + multiply +
                ", divide=" + divide +
                ", operations=" + operations +
                '}';
    }
}

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
    Operations operations;
    private double sum;
    private double subtract;
    private double multiply;
    private double divide;
    private double power;
    private double firstNumber;
    private double secondNumber;

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
     * @param power      The power of the number
     */
    public Calculator(double sum, double subtract, double multiply, double divide, Operations operations, double power) {
        this.sum = sum;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
        this.operations = operations;
        this.power = power;
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
     */
    public void add() {
        this.sum = this.firstNumber + this.secondNumber;
    }

    /**
     * This method subtracts the second number from the first number
     */
    public void subtract() {
        this.subtract = this.firstNumber - this.secondNumber;
    }

    /**
     * This method multiplies the two numbers
     */
    public void multiply() {
        this.multiply = this.firstNumber * this.secondNumber;
    }

    /**
     * This method divides the first number by the second number
     */
    public void divide() {
        this.divide = this.firstNumber / this.secondNumber;
    }

    /**
     * This method is used to get the power of the first number raised to the second number
     */
    public void power() {
        this.power = Math.pow(this.firstNumber, this.secondNumber);
    }

    /**
     * This method is used to display the details of the operation based on the operation
     */
    public void displayDetails() {
        switch (operations) {
            case ADD:
                JOptionPane.showMessageDialog(null, "The result of " + this.firstNumber + " + " + this.secondNumber + " is = " + sum, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case SUBTRACT:
                JOptionPane.showMessageDialog(null, "The result of " + this.firstNumber + " - " + this.secondNumber + " is = " + subtract, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case MULTIPLY:
                JOptionPane.showMessageDialog(null, "The result of " + this.firstNumber + " * " + this.secondNumber + " is = " + multiply, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case DIVIDE:
                JOptionPane.showMessageDialog(null, "The result of " + this.firstNumber + " / " + this.secondNumber + " is = " + divide, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
                break;
            case POWER:
                JOptionPane.showMessageDialog(null, "The result of " + this.firstNumber + " ^ " + this.secondNumber + " is = " + power, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
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
        } else if (operation.equalsIgnoreCase(String.valueOf(Operations.POWER))) {
            this.operations = Operations.POWER;
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
        return Double.compare(that.sum, sum) == 0 && Double.compare(that.subtract, subtract) == 0 && Double.compare(that.multiply, multiply) == 0 && Double.compare(that.divide, divide) == 0 && Double.compare(that.power, power) == 0 && getOperations() == that.getOperations();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperations(), sum, subtract, multiply, divide, power);
    }

    @Override
    public String toString() {
        return "Calculator{" + "operations=" + operations + ", sum=" + sum + ", subtract=" + subtract + ", multiply=" + multiply + ", divide=" + divide + ", power=" + power + '}';
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    enum Operations {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, POWER
    }
}

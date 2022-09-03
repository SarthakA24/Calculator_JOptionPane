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

    public Calculator() {
    }

    public Calculator(double sum, double subtract, double multiply, double divide, String operation) {
        this.sum = sum;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
        this.operation = operation;
    }

    public static Icon getIcon() {
        return icon;
    }

    public void add(double... numbers) {
        for (double number : numbers) {
            this.sum += number;
        }
    }

    public void subtract(double... numbers) {
        for (double number : numbers) {
            this.subtract -= number;
        }
    }

    public void displayDetails() {
        if (operation.equals("ADD")) {
            JOptionPane.showMessageDialog(null, "The sum of the numbers is " + sum, "Calculator", JOptionPane.PLAIN_MESSAGE, icon);
        }
        programEndDisplay();
    }

    public boolean wantToRetry() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to re-try?", "Calculator", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Calculator.getIcon());
        if (response == JOptionPane.NO_OPTION) programEndDisplay();
        return response == JOptionPane.YES_OPTION;
    }

    public void programEndDisplay() {
        System.out.println("Program Ended Successfully!");
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getSubtract() {
        return subtract;
    }

    public void setSubtract(double subtract) {
        this.subtract = subtract;
    }

    public double getMultiply() {
        return multiply;
    }

    public void setMultiply(double multiply) {
        this.multiply = multiply;
    }

    public String getOperation() {
        return operation;
    }

    public boolean setOperation(String operation) {
        if (operation.equalsIgnoreCase("ADD") || operation.equals("+")) {
            this.operation = "ADD";
            return true;
        } else if (operation.equalsIgnoreCase("SUBTRACT") || operation.equals("-")) {
            this.operation = "SUBTRACT";
            return true;
        } else if (operation.equalsIgnoreCase("MULTIPLY") || operation.equals("*") || operation.equalsIgnoreCase("X")) {
            this.operation = "MULTIPLY";
            return true;
        } else if (operation.equalsIgnoreCase("DIVIDE") || operation.equals("/") || operation.equals("÷")) {
            this.operation = "DIVIDE";
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Input for Operator. Please try again", "Calculator", JOptionPane.ERROR_MESSAGE, Calculator.getIcon());
            return false;
        }
    }

    public double getDivide() {
        return divide;
    }

    public void setDivide(double divide) {
        this.divide = divide;
    }
}

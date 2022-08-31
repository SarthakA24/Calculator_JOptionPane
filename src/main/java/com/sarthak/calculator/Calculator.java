/*
 * Author Name: Sarthak Agarwal
 * Date: 31/08/22
 * Created With: IntelliJ IDEA Community Edition
 */
package com.sarthak.calculator;

public class Calculator {
    private double sum;
    private double subtract;
    private double multiply;
    private double divide;

    public double add(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    public Calculator() {
    }

    public Calculator(double sum, double subtract, double multiply, double divide) {
        this.sum = sum;
        this.subtract = subtract;
        this.multiply = multiply;
        this.divide = divide;
    }
}

package com.example.calculator;

import java.util.Scanner;

/**
 * Simple Calculator with basic operations: add, subtract, multiply, divide.
 * This implementation follows clean code principles.
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.print("Enter first number: ");
        double firstNumber = readDouble(scanner);

        System.out.print("Enter second number: ");
        double secondNumber = readDouble(scanner);

        System.out.println("Choose operation: +, -, *, /");
        String operation = scanner.next();

        try {
            double result = calculate(firstNumber, secondNumber, operation);
            System.out.printf("Result: %.2f%n", result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    /**
     * Reads a valid double from scanner
     */
    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number:");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }

    /**
     * Performs calculation based on operation
     *
     * @param a first number
     * @param b second number
     * @param op operation (+, -, *, /)
     * @return result of calculation
     */
    public static double calculate(double a, double b, String op) {
        switch (op) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}

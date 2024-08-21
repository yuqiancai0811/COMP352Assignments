//Comp 352 Assignment 2

import java.io.*;

public class Stack {
    public int t; // index of the top element
    public int capacity;
    private Object[] stack; // Expandable array to hold elements

    public int size() {
        return t + 1;
    }

    public Stack() {
        stack = createArray(1);
        t = -1;
        capacity = 1;
    }

    // Function to push a value from the stack
    public void push(Object value) {
        if (t == capacity - 1) {
            resize(2 * capacity);
        }
        t = t + 1;
        stack[t] = value;
    }

    // Function to pop a value from the stack
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object value = stack[t];
        t = t - 1;
        return value;
    }

    // Function to peek the top value of the stack
    public Object peek() {
        if (isEmpty()) {
            return null; // Stack is empty
        } else {
            return stack[t];
        }
    }

    // Function to resize the stack array
    private void resize(int newCapacity) {
        Object[] newArray = createArray(newCapacity);
        if (t + 1 >= 0) System.arraycopy(stack, 0, newArray, 0, t + 1);
        stack = newArray;
        capacity = newCapacity;
    }

    // Function to create a new array with a given size
    private Object[] createArray(int size) {
        return new Object[size];
    }

    // Function to check if the stack is empty
    public boolean isEmpty() {
        return t == -1;
    }

    // Function to evaluate an arithmetic expression
    public int evaluateExpression(String expression) {
        Stack operandStack = new Stack(); // Stack to store operands
        Stack operatorStack = new Stack(); // Stack to store operators

        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);

            // Handle digits
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                operandStack.push(num);
                i--;
            }
            // Handle opening parenthesis
            else if (ch == '(') {
                operatorStack.push("(");
            }
            // Handle closing parenthesis
            else if (ch == ')') {
                while (!operatorStack.peek().equals("(")) {
                    String operator = (String) operatorStack.pop();
                    int operand2 = (int) operandStack.pop();
                    int operand1 = (int) operandStack.pop();
                    int result = applyOperator(operator, operand1, operand2);
                    operandStack.push(result);
                }
                operatorStack.pop(); // Remove '('
            }
            // Handle two-character operators
            else if (i < expression.length() - 1 && isTwoCharacterOperator(expression.substring(i, i + 2))) {
                while (!operatorStack.isEmpty() &&
                        precedence((String) operatorStack.peek()) >= precedence(expression.substring(i, i + 2))) {
                    String operator = (String) operatorStack.pop();
                    int operand2 = (int) operandStack.pop();
                    int operand1 = (int) operandStack.pop();
                    int result = applyOperator(operator, operand1, operand2);
                    operandStack.push(result);
                }
                operatorStack.push(expression.substring(i, i + 2));
                i++; // Skip next character as it's part of the current operator
            }
            // Handle single-character operators
            else if (isOperator(ch)) {
                String operator = Character.toString(ch);
                while (!operatorStack.isEmpty() &&
                        precedence((String) operatorStack.peek()) >= precedence(operator)) {
                    String topOperator = (String) operatorStack.pop();
                    int operand2 = (int) operandStack.pop();
                    int operand1 = (int) operandStack.pop();
                    int result = applyOperator(topOperator, operand1, operand2);
                    operandStack.push(result);
                }
                operatorStack.push(operator);
            }

            i++;
        }

        while (!operatorStack.isEmpty()) {
            String operator = (String) operatorStack.pop();
            int operand2 = (int) operandStack.pop();
            int operand1 = (int) operandStack.pop();
            int result = applyOperator(operator, operand1, operand2);
            operandStack.push(result);
        }

        return (int) operandStack.pop();
    }

    // Function to check the precedence of operators
    private int precedence(String operator) {
        return switch (operator) {
            case "^" -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            case ">", ">=", "<", "<=" -> 0;
            case "==", "!=" -> -1;
            default -> -2; // For parentheses and invalid operators
        };
    }

    // Function to apply the operator on operands
    private int applyOperator(String operator, int operand1, int operand2) {
        return switch (operator) {
            case "^" -> (int) Math.pow(operand1, operand2);
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case ">" -> operand1 > operand2 ? 1 : 0;
            case ">=" -> operand1 >= operand2 ? 1 : 0;
            case "<" -> operand1 < operand2 ? 1 : 0;
            case "<=" -> operand1 <= operand2 ? 1 : 0;
            case "==" -> operand1 == operand2 ? 1 : 0;
            case "!=" -> operand1 != operand2 ? 1 : 0;
            default -> 0; // Invalid operator
        };
    }

    // Function to check if a character is an operator
    private boolean isOperator(char character) {
        return character == '+' || character == '-' || character == '*' || character == '/' ||
                character == '^' || character == '>' || character == '=' || character == '<' ||
                character == '!';
    }

    // Function to check if a string is a two-character operator
    private boolean isTwoCharacterOperator(String operator) {
        return operator.equals(">=") || operator.equals("<=") || operator.equals("==") || operator.equals("!=");
    }

    // Function to read expressions from a file, evaluate them, and write results to another file
    public void evaluateExpressionsFromFile(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int result = evaluateExpression(line);
                writer.write(line + "\n");
                writer.write("Result: " + result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Stack arithmeticCalculator = new Stack();
        String inputFilePath = "input.txt"; // Input file path
        String outputFilePath = "output.txt"; // Output file path
        arithmeticCalculator.evaluateExpressionsFromFile(inputFilePath, outputFilePath);
    }
}

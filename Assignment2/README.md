# COMP 352 - Programming Assignment 2

## Overview
This assignment involves implementing an arithmetic calculator using two custom stack structures (without using built-in Java types) to evaluate mathematical expressions. The calculator handles various binary operators with proper precedence and supports parentheses. The main focus is on implementing expandable stacks with optimal amortized time complexity and exact space complexity.

## Features
- Custom stack implementation using expandable arrays with O(1) amortized time complexity for adding elements.
- Support for standard arithmetic operators (`+`, `-`, `*`, `/`, `^`) and comparison operators (`>`, `>=`, `<=`, `<`, `==`, `!=`).
- Correct handling of operator precedence and parentheses (including nested ones).
- Reads multiple expressions from a text file and outputs the results to another text file.

## Requirements
1. **Stacks Implementation**:
   - Custom stack data structure using expandable arrays.
   - Ensure that the space complexity is O(n), where `n` is the number of elements pushed to the stack.

2. **Arithmetic Calculator**:
   - The calculator must evaluate expressions using two stacks: one for operators and one for operands.
   - Support for standard operator precedence:
     - Parentheses: `()`
     - Power function: `^`
     - Multiplication and Division: `*`, `/`
     - Addition and Subtraction: `+`, `-`
     - Comparison Operators: `>`, `>=`, `<=`, `<`, `==`, `!=`
   - Left-to-right evaluation for operators with the same precedence.

3. **Input and Output**:
   - Read arithmetic expressions from a text file (one expression per line).
   - For each expression, compute the result and output it to a file along with the original expression.

## Files
- **`ArithmeticCalculator.java`**: 
   - Contains the implementation of the custom stack and the calculator logic.
   
- **`input.txt`**: 
   - A file containing multiple arithmetic expressions, each on a new line.

- **`output.txt`**: 
   - The output file where the program records the expressions and their computed results.

- **`pseudo_code.txt`**: 
   - A text file containing the pseudo code of the implemented algorithm, and explaining the time and space complexity of the solution.

## How to Run
1. **Compile the Program**:
   ```bash
   javac Stack.java

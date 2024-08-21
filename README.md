# COMP 352 - Programming Assignments Summary
Data Structures and Algorithms 

This repository contains three assignments completed as part of the COMP 352 Data Structures and Algorithms course. Each assignment focuses on implementing different data structures and algorithmic concepts in Java, reinforcing theoretical knowledge through practical coding exercises.

## Assignment 1 - Oddonacci Sequence (Recursive Algorithms)
### Description
The goal of this assignment was to implement and compare two recursive algorithms for calculating the Oddonacci sequence: an **exponential** version and a **linear** version. The Oddonacci sequence is similar to the Fibonacci sequence, but each term is the sum of the previous three terms. The assignment required measuring the performance of both algorithms across various input sizes.

### Key Features
- Implemented recursive Oddonacci calculators (exponential and linear versions).
- Measured runtime performance for input sizes ranging from Oddonacci(5) to Oddonacci(200).
- Analyzed time and space complexities.

### Files
- **`OddonacciCalculator.java`**: Contains both the exponential and linear Oddonacci implementations.
- **`OddoOut.txt`**: Logs of performance measurements.
- **`Analysis.txt`**: Discusses the time and space complexities of both implementations.

## Assignment 2 - Arithmetic Calculator Using Stacks
### Description
This assignment involved creating an arithmetic calculator using custom-built stack data structures (implemented with expandable arrays). The calculator supports integer arithmetic with standard operators (`+`, `-`, `*`, `/`, `^`) and comparison operators (`>`, `>=`, `<=`, `<`, `==`, `!=`), while respecting operator precedence and handling nested parentheses.

### Key Features
- Custom expandable stack implementation (no built-in Java lists/arrays allowed).
- Evaluates complex arithmetic expressions from a text file.
- Outputs results to a file, demonstrating proper operator precedence and parentheses handling.

### Files
- **`ArithmeticCalculator.java`**: Implements the calculator using custom stack data structures.
- **`input.txt`**: Input file containing arithmetic expressions.
- **`output.txt`**: Output file containing the results of the evaluated expressions.
- **`pseudo_code.txt`**: Pseudocode for the stack-based calculator.
- **`complexity_analysis.txt`**: Time and space complexity analysis.

## Assignment 3 - Smarter Priority Queue (SPQ)
### Description
This assignment focused on implementing a flexible Priority Queue (SPQ) that can toggle between min-heap and max-heap modes. The SPQ is adaptable, allowing key and value replacements, removals, and dynamic array expansions, all implemented from scratch without using built-in Java data structures.

### Key Features
- **toggle()**: Switch between min-heap and max-heap.
- Supports insertion, removal, and key/value modification operations.
- Dynamically extends the array-based heap while maintaining optimal space and time complexity.

### Files
- **`SmarterPriorityQueue.java`**: Implements the adaptable SPQ using custom dynamic arrays.
- **`Main.java`**: Contains test cases demonstrating the functionality of the SPQ.
- **`Pseudocode.txt`**: Pseudocode describing the implementation of the SPQ.
- **`TimeComplexities.txt`**: Discusses the time complexities of various SPQ operations.

## Conclusion
Each assignment explores different aspects of data structures and algorithms, from recursive functions and custom stack implementations to adaptable priority queues. These projects reinforced the practical application of theoretical concepts learned in the course and provided hands-on experience with optimizing time and space complexity.

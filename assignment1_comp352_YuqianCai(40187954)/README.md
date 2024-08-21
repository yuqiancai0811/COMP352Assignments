# COMP 352 - Programming Assignment 1

## Overview
This assignment explores two recursive implementations of the Oddonacci sequence: one with exponential time complexity and the other with linear time complexity. The goal is to compare the runtime performance of both algorithms, analyze their complexities, and optionally implement a tail-recursive version for bonus marks.

### Oddonacci Sequence:
The Oddonacci sequence is similar to the Fibonacci sequence but with a twist: each term is the sum of the three preceding terms. The sequence starts with three predetermined values: `1, 1, 1`. For example, the first few Oddonacci numbers are:  
`1, 1, 1, 3, 5, 9, 17, 31, 57, 105, 193, ...`

## Assignment Requirements

1. **Implement Two Recursive Algorithms:**
   - **Exponential Oddonacci Calculator**: This version uses a recursive approach similar to the binary Fibonacci implementation with exponential complexity.
   - **Linear Oddonacci Calculator**: This version optimizes the recursion, leading to linear time complexity.

2. **Measure Performance**:
   - Run both algorithms for Oddonacci(n) where `n` is from 5 to 200 in increments of 5.
   - Measure and log the execution times for each algorithm.
   - Redirect output to a file `OddoOut.txt`.

3. **Analysis**:
   - Explain why the first algorithm is exponential and the second is linear.
   - Discuss whether either algorithm uses tail recursion and if a tail-recursive version is feasible.
   - Submit the analysis in a separate text file.

## Project Files

1. **`ExponentialOddonacci.java`**  
   Contains the implementation of the recursive Oddonacci calculator with exponential complexity.
   
2. **`LinearOddonacci.java`**  
   Contains the implementation of the recursive Oddonacci calculator with linear complexity.
   
3. **`OddoOut.txt`**  
   Output file containing the execution times for both algorithms.
   
4. **`Analysis.txt`**  
   Written analysis explaining the time complexities, tail recursion potential, and observations from the runtime performance measurements.

## How to Run

1. **Compile the Java Files**:
   ```bash
   javac Oddonacci.java

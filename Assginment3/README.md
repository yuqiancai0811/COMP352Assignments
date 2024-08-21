# COMP 352 - Programming Assignment 3

## Overview
This assignment involves implementing a new Priority Queue (PQ) data structure, referred to as the **Smarter PQ (SPQ)**. The SPQ is adaptable and flexible, allowing for dynamic toggling between a min-heap and a max-heap, as well as supporting key modifications, removals, and efficient heap operations. The PQ is built from scratch using dynamically extendable arrays, without the use of any built-in Java data structures.

## Features
- **toggle()**: Switches the priority queue between a min-heap and a max-heap.
- **insert(k, v)**: Inserts a key-value pair into the priority queue.
- **removeTop()**: Removes and returns the entry with the smallest or largest key depending on the current state (min or max).
- **top()**: Returns the top entry without removing it.
- **remove(e)**: Removes a specific entry from the priority queue.
- **replaceKey(e, k)**: Replaces the key of a specific entry.
- **replaceValue(e, v)**: Replaces the value of a specific entry.
- **state()**: Returns whether the priority queue is currently a min-heap or max-heap.
- **isEmpty()**: Checks if the priority queue is empty.
- **size()**: Returns the current number of entries in the priority queue.

## Requirements
- Implement the priority queue using dynamically extendable arrays. No built-in Java lists, vectors, or heaps are allowed.
- Minimize code duplication by using a flexible, parameterized approach for both min- and max-heaps.
- Provide pseudocode for the implementation, focusing on a higher-level abstract representation.

## Project Files
- **`Main.java`**: Contains the main program and test cases for the Smarter PQ.
- **`SmarterPriorityQueue.java`**: Implements the Smarter Priority Queue (SPQ) data structure.
- **`Pseudocode.txt`**: Contains the high-level pseudocode for the SPQ implementation.
- **`TimeComplexities.txt`**: Discusses the Big-O time complexities for key methods, including `toggle()`, `remove(e)`, `replaceKey(e, k)`, and `replaceValue(e, v)`.

## How to Run
1. **Compile the Java Files**:
   ```bash
   javac Main.java SmarterPriorityQueue.java

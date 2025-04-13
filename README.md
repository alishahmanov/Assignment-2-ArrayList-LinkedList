# Assignment 2 ArrayList & LinkedList

## Project Overview

This project is a custom implementation of basic data structures in Java **without using `java.util.*` collections**, except for `Iterator`.

Implemented structures include:

- `MyList<T>` — custom interface (like Java's `List<T>`)
- `MyArrayList<T>` — array-based list
- `MyLinkedList<T>` — doubly linked list
- `MyStack<T>` — stack based on `MyArrayList`
- `MyQueue<T>` — queue based on `MyLinkedList`
- `MyMinHeap<T>` — min-heap based on `MyArrayList`

The goal was to understand how internal logic of standard Java collections works, and to build our own simplified versions of them.

---

## Key Features

### 1) `MyList<T>`
Custom interface that defines core list operations like `add`, `get`, `remove`, `sort`, `indexOf`, `exists`, `toArray`, etc.

### 2) `MyArrayList<T>`
- Based on raw array (`Object[]`)
- Dynamically resizes when full
- Supports all methods from `MyList<T>`
- Efficient random access (`O(1)`)

### 3) `MyLinkedList<T>`
- Doubly linked list using `MyNode`
- Efficient insertions/removals from both ends
- Slower access by index (linear search)

### 4) `MyStack<T>`
- Built on top of `MyArrayList`
- LIFO structure: push, pop, peek
- Simple implementation for working with backtracking, undo, etc.

### 5) `MyQueue<T>`
- Built on top of `MyLinkedList`
- FIFO structure: enqueue, dequeue, peek
- Great for task scheduling and line simulation

### 6) `MyMinHeap<T>`
- Binary heap stored in an array
- Always keeps the **minimum element at the top**
- Supports `add`, `removeMin`, `getMin`
- Useful for priority queues and algorithms like Dijkstra




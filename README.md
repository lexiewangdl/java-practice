# Data Structures and Algorithms
This repository contains Java coding practices aimed at practicing algorithms, data structures, and the Java programming language.

## Cousera: Algorithmic Toolbox
The following are solutions to programming assignments of the online course [Algorithmic Toolbox](https://www.coursera.org/learn/algorithmic-toolbox). This course is part of the [Data Structures and Algorithms Specialization](https://www.coursera.org/specializations/data-structures-algorithms).

### Week 2
- [Least Common Multiple](/practice-project/src/coursera/algorithmic/LeastCommonMultiple.java)
- [Greatest Common Divisor](/practice-project/src/coursera/algorithmic/GreatestCommonDivisor.java)
- [Fibonacci Number](/practice-project/src/coursera/algorithmic/Fibonacci.java): Find the *n*th Fibonacci number F<sub>n</sub>.
- [Fibonacci Number's Last Digit](/practice-project/src/coursera/algorithmic/FibonacciLastDigit.java): Find the last digit of a larger Fibonacci number.
- [Fibonacci Modulo M](/practice-project/src/coursera/algorithmic/FibModuloM.java): (1) Given two integers *n* and *m*, find F<sub>n</sub> mod *m*. (2) Given an integer *n*, find the last digit of the sum *F<sub>0</sub> + F<sub>1</sub> + ... + F<sub>n</sub>*. (3) Given two non-negative integers *m* and *n* (*m* is smaller than or equal to *n*), find the last digit of the sum *F<sub>m</sub> + F<sub>m+1</sub> + ... + F<sub>n</sub>*. (4) Find the last digit of the sum of squares of Fibonacci numbers.

### Week 3: Greedy Algorithms
- [Greedy Algorithms Part 1](/practice-project/src/coursera/algorithmic/GreedyAlgorithms.java): (1) **Money Change**: find the minimum number of coins needed to change the input value into coins with different denominations. (2) **Maximum Value of the Loot**: fractional knapsack problem. (3) **Car Fueling**: find minimum number of refills needed.
- [Greedy Algorithms Part 2](/practice-project/src/coursera/algorithmic/GreedyAlgorithm.java): **Maximum Advertisement Revenue**.
- [Greedy Algorithms Part 3](/practice-project/src/coursera/algorithmic/CoveringSegments.java): **Collecting Signature** (Covering Segments).
- [Greedy Algorithms Part 4](/practice-project/src/coursera/algorithmic/DifferentSummands.java): **Maximum Number of Prizes** (Different Summands).
- [Greedy Algorithms Part 5](/practice-project/src/coursera/algorithmic/LargestNumber.java): **Maximum Salary** (Largest Number).

### Week 4: Divide and Conquer
- [Binary Search (with and without duplicates)](/practice-project/src/coursera/algorithmic/BinarySearch.java): (1) Implement binary search algorithm on sorted, huge lists. (2) Implement binary search algorithm on sorted sequence of integers with duplicates.
- [Find Majority Element](/practice-project/src/coursera/algorithmic/MajorityElement.java): Design an *O(n log n)* algorithm to check whether an input sequence contains a majority element.
- [Quick Sort with Three-Way Partitioning](/practice-project/src/coursera/algorithmic/Sorting.java): Re-design a given randomized quick sort algorithm so that it works fast even on sequences containing many equal elements.
- [Number of Inversions](/practice-project/src/coursera/algorithmic/Inversions.java): Count the number of inversions of a given sequence, using merge sort.
- [Organize a Lottery](/practice-project/src/coursera/algorithmic/PointsAndSegments.java)

### Week 5: Dynamic Programming
- Primitive Calculator
- [Edit Distance](/practice-project/src/coursera/algorithmic/EditDistance.java)
- [Longest Common Subsequence of 2 or 3 Sequences of Numbers](/practice-project/src/coursera/algorithmic/LCS2.java)

## Coursera: Data Structures
This section contains solutions to programming assignments of the online course [Data Structures](https://www.coursera.org/learn/data-structures) on Coursera. This course is part of the [Data Structures and Algorithms Specialization](https://www.coursera.org/specializations/data-structures-algorithms).

### Week 1: Basic Data Structures
- [Check Brackets in the Code](/practice-project/src/coursera/ds/CheckBrackets.java): Implement a feature for a text editor to find errors in the usage of brackets in the code.
- Tree height
- [Network Packet Processing Simulation](/practice-project/src/coursera/ds/ProcessPackages.java): Simulate the processing of network packets.
- Stack with Maximum

### Week 3: Prioirity Queues and Heap Sort
- [Make Heap](/practice-project/src/coursera/ds/BuildHeap.java): Convert an array of integers into a min-heap using only *O(n)* swaps.
- [Parallel Processing](/practice-project/src/coursera/ds/JobQueue.java): Simulate a program that processes a list of jobs in parallel. Use priority queues to determine for each job which thread will process it and when will it start processing.
- [Merging Tables](/practice-project/src/coursera/ds/MergingTables.java): Simulate a sequence of merge operations with tables in a data base.

### Week 4: Hash Tables
- [Phone Book](/practice-project/src/coursera/ds/PhoneBook2.java): Implement a simple phone book manager, use the direct addressing scheme.
- [Phone Book](/practice-project/src/coursera/ds/PhoneBook.java): Another solution to the phone book problem using HashMap.
- [Hash Chains](/practice-project/src/coursera/ds/HashChains.java): Implement a hash table using the chaining scheme. The hash function is a polynomial hash function.
- [Find Pattern in Text](/practice-project/src/coursera/ds/HashSubstring.java): Implement the Rabin-Karp's algorithm.

### Week 6: Binary Search Trees
- [Tree Traversal](/practice-project/src/coursera/ds/TreeOrder.java): Implement in-order, pre-order, and post-order traversals of a binary tree.
- [Is It a Binary Search Tree?](/practice-project/src/coursera/ds/IsBinarySearchTree.java): Test whether a given data structure is a correct binary search tree. A correct binary search tree must satisfy the following: for any node of the tree, if its key is *x*, then for any node in its left subtree its key must be strictly less than *x*, and for any node in its right subtree its key must be strictly greater than *x*.
- [Is It a Binary Search Tree? (Hard Version)](/practice-project/src/coursera/ds/IsBSTHard.java): Solve the same problem as the previous one, but for a more general case, when binary search tree may contain equal keys.

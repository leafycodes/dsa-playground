# Backtracking

## Overview
Backtracking is an **extension of recursion** that systematically explores potential solutions by incrementally building candidates and abandoning ("backtracking") paths that fail constraints.

### Three Primary Types of Backtracking:
1. **Decision Problems**
   - *Goal*: Find a valid solution (if one exists).
   - *Example*: Sudoku, N-Queens (checking feasibility).

2. **Enumeration Problems**
   - *Goal*: Find *all* valid solutions.
   - *Example*: Generating all permutations/subsets.

3. **Optimization Problems**
   - *Goal*: Find the *best* solution (by pruning suboptimal paths early).
   - *Example*: Knapsack problem, Traveling Salesman (with bounds).

### Key Traits:
- **Recursion-Based**: Builds solutions step-by-step via recursive calls.
- **Pruning**: Discards invalid/inefficient paths to reduce search space.
- **Flexibility**: Adapts to decision, enumeration, or optimization needs.

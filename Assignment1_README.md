# Assignment 1 — Comparison of TimSort and QuickSort

> **CME 2204 Algorithm Analysis** | 2025–2026 Spring

## Overview

This project implements and benchmarks two sorting algorithms — **TimSort** and **QuickSort** — across four different input types with 1,000,000 integers each. The goal is to compare their real-world performance and understand when each algorithm excels or struggles.

## Algorithms Implemented

### TimSort
A hybrid, stable sorting algorithm derived from Merge Sort and Insertion Sort (designed by Tim Peters in 2002). Steps:
1. Break the array into small chunks called **runs** (size 32 or 64).
2. Sort each run using **Insertion Sort**.
3. Merge all runs using **Merge Sort**, doubling the merged subarray size each iteration.
4. If the array is smaller than 64 elements, use Insertion Sort directly.

### QuickSort (5 pivot strategies)
A divide-and-conquer algorithm that partitions the array around a pivot element. Implemented with the following pivot selection strategies:
- First element
- Last element
- Middle element
- Random element
- Median element

## Input Files

| File | Description |
|------|-------------|
| `random.txt` | 1,000,000 random integers |
| `semi_ordered.txt` | 1,000,000 semi-ordered integers |
| *(generated in code)* | 1,000,000 increasing integers |
| *(generated in code)* | 1,000,000 decreasing integers |

> Place `random.txt` and `semi_ordered.txt` in the project root directory.

## Output Files

24 output files are generated using the naming convention:

```
(algorithm)_(data_type)_out.txt
```

**Examples:**
```
timsort_random_out.txt
quicksort_first_random_out.txt
quicksort_median_decreasing_out.txt
```

**Algorithm names:** `timsort`, `quicksort_first`, `quicksort_last`, `quicksort_middle`, `quicksort_random`, `quicksort_median`  
**Data types:** `random`, `semi_ordered`, `increasing`, `decreasing`

## How to Run

```bash
javac Main.java
java Main
```

> **Note:** Array creation time and file I/O time are excluded from sorting benchmarks. Only the sorting algorithm's execution time is measured (in milliseconds).

## Performance Comparison Table

| Algorithm | Random | Semi-Ordered | Increasing | Decreasing |
|-----------|--------|--------------|------------|------------|
| TimSort | | | | |
| QuickSort (First) | | | | |
| QuickSort (Last) | | | | |
| QuickSort (Middle) | | | | |
| QuickSort (Random) | | | | |
| QuickSort (Median) | | | | |

## Grading

| Component | Weight |
|-----------|--------|
| TimSort implementation | 30% |
| QuickSort implementation | 30% |
| File I/O | 10% |
| Report | 30% |

# Comparison of TimSort and QuickSort

> **CME 2204 Algorithm Analysis** | Dokuz Eylül University | 2025–2026 Spring

## Overview

Empirical performance comparison of **TimSort** and **QuickSort** (5 pivot strategies) on 1,000,000 integers across four input distributions. Execution times are measured in milliseconds, excluding file I/O. All sorted outputs are written to disk as `.txt` files.

---

## Algorithms

### TimSort
A hybrid, stable sorting algorithm combining Insertion Sort and Merge Sort.

- `minrun = 64` — sub-arrays of 64 or fewer elements are sorted with Insertion Sort.
- Larger arrays are recursively merged with Merge Sort.
- If the full array fits within `minrun`, only Insertion Sort is applied.

| Complexity | Value |
|------------|-------|
| Best case  | O(n) |
| Average / Worst | O(n log n) |
| Space | O(n) |

### QuickSort
A divide-and-conquer algorithm using a pivot to partition the array. Five pivot strategies are implemented:

| Strategy | Description |
|----------|-------------|
| `FIRST` | Always picks `arr[low]` |
| `LAST` | Always picks `arr[high]` |
| `MIDDLE` | Picks `arr[low + (high−low)/2]` |
| `RANDOM` | Picks a uniformly random index in `[low, high]` |
| `MEDIAN` | Median-of-three: `arr[low]`, `arr[mid]`, `arr[high]` |

> ⚠️ `FIRST` and `LAST` strategies degrade to **O(n²)** on sorted/reverse-sorted inputs. The JVM stack was expanded with `-Xss200m` to prevent `StackOverflowError` at n = 1,000,000.

---

## Project Structure

```
├── src/
│   ├── Main.java               # Entry point; timing, cloning, output
│   ├── SortingAlgorithms.java  # TimSort + QuickSort implementations
│   └── FileOperations.java     # File reading and writing utilities
├── random.txt                  # Input: 1,000,000 random integers
├── semi_ordered.txt            # Input: 1,000,000 semi-ordered integers
└── output/                     # 24 sorted output files
```

---

## Input Datasets

| Dataset | Source |
|---------|--------|
| Random | Loaded from `random.txt` |
| Semi-ordered | Loaded from `semi_ordered.txt` |
| Increasing | Generated in code: `arr[i] = i` |
| Decreasing | Generated in code: `arr[n−i−1] = i` |

Each array is **cloned** before every sort call to ensure all algorithms operate on identical input.

---

## Output Files

24 output files are generated using this naming convention:

```
(algorithm)_(data_type)_out.txt
```

**Examples:**
```
timsort_random_out.txt
quicksort_first_increasing_out.txt
quicksort_median_decreasing_out.txt
```

**Algorithm names:** `timsort`, `quicksort_first`, `quicksort_last`, `quicksort_middle`, `quicksort_random`, `quicksort_median`  
**Data types:** `random`, `semi_ordered`, `increasing`, `decreasing`

---

## How to Run

Place `random.txt` and `semi_ordered.txt` in the project root, then:

```bash
javac src/*.java -d out/
java -Xss200m -cp out/ Main
```

> The `-Xss200m` flag is required to handle the deep recursion of worst-case QuickSort (first/last pivot on sorted inputs).

---

## Results

Performance comparison matrix (in milliseconds):

| Algorithm | Random | Semi-Ordered | Increasing | Decreasing |
|-----------|-------:|-------------:|-----------:|-----------:|
| **TimSort** | 192 | 94 | 46 | 60 |
| QuickSort – First | 131 | 112 | 366,672 | 522,964 |
| QuickSort – Last | 119 | 94 | 866,110 | 606,434 |
| QuickSort – Middle | 127 | 100 | 26 | 29 |
| QuickSort – Random | 141 | 111 | 62 | 68 |
| QuickSort – Median | 127 | 94 | **26** | 57 |

> Hardware: AMD Ryzen 7 7840HS, 32 GB RAM, SSD, Windows 11, OpenJDK 25.0.2

---

## Key Findings

- **Fastest overall:** QuickSort Middle & QuickSort Median — both at **26 ms** on increasing input.
- **Slowest overall:** QuickSort Last on increasing input — **866,110 ms (~14.4 min)** due to O(n²) degeneration.
- **Most consistent:** Median-of-three never degenerates across any tested distribution.
- **Best for unknown/partially sorted input:** TimSort — predictable range of 46–192 ms across all distributions.
- **Best for random data:** QuickSort Last at 119 ms, benefiting from cache efficiency on uniform distributions.
- **Avoid:** First and Last pivot strategies for any input that may be sorted or reverse-sorted.

---

## References

1. T. Peters, *timsort.txt*, CPython source tree, 2002. [Online](https://github.com/python/cpython/blob/main/Objects/listsort.txt)
2. C. A. R. Hoare, "Algorithm 64: Quicksort," *Communications of the ACM*, vol. 4, no. 7, p. 321, 1961.

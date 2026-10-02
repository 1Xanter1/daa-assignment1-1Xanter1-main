### Problem 3 - Largest Subrange (20 points)

+ Given an integer array $A$ of size $n$, find the index pair $i$ and $j$ that maximizes $S = \sum_{k=i}^{j}A[k]$, return $S$ as the answer.
+ **5pts.** Implement a brute-force solution as `maxSumBrute()` method in [src/Problem3.java](src/Problem3.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `maxSumSmart()` method in [src/Problem3.java](src/Problem3.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem3.java](src/Problem3.java).

#### Example
+ Input: `A={-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4}`
+ Output: `17`

#### Constraints
+ $1 \leq n \leq 10^5$
+ $-10^4 \leq A[i] \leq 10^4$

#### References
1. Chapter 5.6, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. [maximum-subarray](https://leetcode.com/problems/maximum-subarray/description/)

### Report - Largest Subrange
1. Solutions
   Brute Force

The brute-force solution checks every possible subrange and calculates its sum. It keeps the largest sum found.

Time complexity: $O(n^2)$
Space complexity: $O(1)$

Divide and Conquer

The smart solution divides the array into two halves. It finds the maximum subrange in the left half, the right half, and the subrange that crosses the middle.

The largest of these three sums is returned as the answer.

Time complexity: $\Theta(n\log n)$
Space complexity: $O(\log n)$ due to recursion.

2. Empirical Comparison

Both methods were tested using:

A = {1,2,3,4,5,6,7,8,9,10}

Both methods return:

Brute result: 55
Smart result: 55

Execution time was measured using System.nanoTime().

Brute-force time: 9200 ns
Smart time: 37200 ns

For a small array, the difference in execution time may be small. For larger arrays, the divide-and-conquer solution requires fewer operations.

3. Conclusion

The brute-force solution has quadratic time complexity $O(n^2)$ because it checks all possible subranges. The divide-and-conquer solution has $\Theta(n\log n)$ complexity because the array is recursively divided into two halves and the crossing sum is calculated in linear time.
### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
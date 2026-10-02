### Problem 2 - Median of Two Sorted Arrays (20 points)

+ Given two sorted arrays $A$ and $B$ of sizes $n$ and $m$ respectively, return the median of the two sorted arrays. If there are two medians return the average of them. 
+ **5pts.** Implement a brute-force solution as `getMedianBrute()` method in [src/Problem2.java](src/Problem2.java). 
+ **5pts.** Implement a divide-and-conquer efficient solution as `getMedianSmart()` method in [src/Problem2.java](src/Problem2.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem2.java](src/Problem2.java).

#### Example 1
+ Input: `A={2,4}, B={3}`
+ Output: `3.0`

#### Example 2
+ Input: `A={2,4}, B={3,5}`
+ Output: `3.5`

#### Constraints
+ $0 \leq n,m \leq 1000$
+ $1 \leq (n+m) \leq 2000$
+ $-10^6 \leq A[i],B[i] \leq 10^6$
+ $A$ and $B$ are sorted in non-descending order

#### References
1. Exercise 5-8, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. [median-of-two-sorted-arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)

### Report - Median of Two Sorted Arrays
1. Solutions
   Brute Force

The brute-force solution combines the two sorted arrays into one array and sorts it. Then it finds the middle element or the average of the two middle elements.

Time complexity: $O((m+n)\log(m+n))$
Space complexity: $O(m+n)$

Divide and Conquer

The smart solution uses binary search to find the correct partition between the two sorted arrays. It searches for a partition where all elements on the left are smaller than all elements on the right.

If the total length is even, the median is the average of the largest left element and the smallest right element. Otherwise, the median is the largest element on the left.

Time complexity: $O(\log(\min(m,n)))$
Space complexity: $O(1)$

2. Empirical Comparison

Both methods were tested using the arrays:

A = {2, 4}
B = {3}

Both methods returned:

Brute result: 3.0
Smart result: 3.0


Execution time was measured using System.nanoTime().

Brute-force time: 3000500 ns

Smart time: 93500 ns

For small arrays, the time difference may be small because of Java's method-call and sorting overhead. For larger arrays, the binary-search solution becomes much more efficient.

3. Conclusion

The brute-force solution sorts all elements and has $O((m+n)\log(m+n))$ time complexity. The divide-and-conquer solution uses binary search and has $O(\log(\min(m,n)))$ time complexity, making it more efficient for large sorted arrays.
### Defense Interview 
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
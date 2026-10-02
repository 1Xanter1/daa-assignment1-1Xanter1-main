### Problem 1 - Number of Occurrences (20 points)

+ Count the number of times a given key $k$ occurs in a given sorted array $A$.
+ **5pts.** Implement a brute-force solution as `countFreqBrute()` method in [src/Problem1.java](src/Problem1.java). 
+ **5pts.** Implement a divide-and-conquer efficient solution as `countFreqSmart()` method in [src/Problem1.java](src/Problem1.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem1.java](src/Problem1.java).
#### Example 1
+ Input: `A = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,5,5}, key = 4`
+ Output: `3`

#### Example 2
+ Input:  `A = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,5,5}, key = 3`
+ Output: `0`

#### Constraints
+ $0 \leq A.length \leq 10^5$
+ $-10^9 \leq A[i] \leq 10^9$
+ $-10^9 \leq key \leq 10^9$
+ $A$ is sorted in non-descending order

#### References
1. Chapter 5.1.1 Counting Occurrences, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. [find-first-and-last-position-of-element-in-sorted-array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)

### Report - Number of Occurrences
1. Solutions
   Brute Force

The brute-force solution checks every element of the array and counts how many elements are equal to the given key.

Time complexity: $\Theta(n)$
Space complexity: $O(1)$

Divide and Conquer

The smart solution uses two binary searches. leftBound() finds the first occurrence of the key, while rightBound() finds the last occurrence.

The number of occurrences is calculated as:

$$
\text{count} = \text{rightBound} - \text{leftBound} + 1
$$

Time complexity: $\Theta(\log n)$
Space complexity: $O(1)$

2. Empirical Comparison

For testing, an array of 100,000,000 random integers was generated and sorted. The key 500000 was searched using both methods. Execution time was measured with System.nanoTime().

Example output:

Brute result: 101

Smart result: 101

Brute-force time: 52135300 ns

Smart time: 32300 ns

Both methods return the same result. The smart solution is much faster for large arrays because it uses binary search instead of checking every element.

3. Conclusion

The brute-force method has linear complexity $\Theta(n)$, while the divide-and-conquer method has logarithmic complexity $\Theta(\log n)$. Therefore, the smart solution scales much better for large sorted arrays.

### Defense Interview 
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs. 

Good Luck!
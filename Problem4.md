### Problem 4 - Closest Pair (20 points)

+ Given an array of point coordinates $P$, find the minimum distance between two points in the array, return the distance.
+ **5pts.** Implement a brute-force solution as `minDistBrute()` method in [src/Problem4.java](src/Problem4.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `minDistSmart()` method in [src/Problem4.java](src/Problem4.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem4.java](src/Problem4.java).

#### Example
+ Input: `P = {{0,0},{3,4},{-5,-3}}`
+ Output: `5.0`

#### Constraints
+ $1 \leq P.length \leq 10^5$
+ $P[i][j]$ is of type `double`

#### References
1. Chapter 5.6, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. Chapter 3.4, Algorithms Illuminated Part1, 2017 - Tim Roughgarden

### Report - Largest Subrange
1. Solutions
   Brute Force

The brute-force solution checks every pair of points and calculates the Euclidean distance between them. It keeps the smallest distance found.

Time complexity: $O(n^2)$
Space complexity: $O(1)$

Divide and Conquer

The smart solution first sorts the points by their x-coordinate and divides them into two halves. It recursively finds the closest pair in each half and then checks points near the middle line to find a closer pair crossing the two halves.

The smallest distance from the left half, right half, and middle strip is returned.

Time complexity: $O(n\log^2 n)$
Space complexity: $O(n)$

The $O(n\log^2 n)$ complexity occurs because the points in the strip are sorted by their y-coordinate at each recursive level.

2. Empirical Comparison

Both methods were tested using:

P = {{0,0}, {3,4}, {5,-3}}

Both methods return the same minimum distance:

Brute result: 5.0
Smart result: 5.0

Execution time was measured using System.nanoTime().

Brute-force time: 27700 ns
Smart time: 7161000 ns

For a small number of points, the difference may be small. For larger arrays, the divide-and-conquer approach reduces the number of distance comparisons.

3. Conclusion

The brute-force solution has quadratic complexity $O(n^2)$ because it checks every pair of points. The divide-and-conquer solution is more efficient and has $O(n\log^2 n)$ complexity in the current implementation. Compare empirically (using `System.nanoTime()`) running times of brute-force and divide-and-conquer solutions and reflect the results in this report.

### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
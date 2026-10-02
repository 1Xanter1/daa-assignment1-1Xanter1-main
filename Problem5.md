### Problem 5 - Integer Multiplication (20 points)

+ Given two long integer $A$ and $B$ represented as `String` objects, output the product of the two numbers.
+ Do not use `java.math.BigInteger`. But you can use it to test that your solutions are correct.
+ **5pts.** Implement a brute-force solution as `multBrute` method in [src/Problem5.java](src/Problem5.java).
+ **5pts.** Implement a divide-and-conquer efficient solution as `multSmart` method in [src/Problem5.java](src/Problem5.java).
+ **5pts.** Describe in written form your solution ideas in the **Report** section below.
+ **5pts.** Defend your solutions to your instructor in live during practice sessions.
+ Your code will be tested against various inputs using `JUnit6` testing framework.
+ **Don't change API** of the solutions in [src/Problem5.java](src/Problem5.java).

#### Example
+ Input: `A = "12345678987654321", B="98765432123456789"`
+ Output: `"1219326320073159566072245112635269"`

#### Constraints
+ $1 \leq A.length(), B.length() \leq 10^4$

#### References
1. Chapter 5.5, The Algorithm Design Manual, 3rd Edition, 2020 - Steven H. Skiena
2. Chapter 1.3, Algorithms Illuminated Part1, 2017 - Tim Roughgarden

### Report - Largest Subrange
1. Solutions
   Brute Force

The brute-force solution uses the standard multiplication algorithm. It multiplies each digit of the first number by each digit of the second number and stores the results in an integer array.

Time complexity: $O(n^2)$
Space complexity: $O(n)$

Divide and Conquer

The smart solution uses the Karatsuba algorithm. The numbers are split into two halves and three recursive multiplications are performed instead of four.

For:

$$
A = A_L10^m + A_R
$$

and

$$
B = B_L10^m + B_R
$$

the algorithm calculates:

$$
z_1=A_LB_L,\quad z_2=A_RB_R
$$

$$
z_3=(A_L+A_R)(B_L+B_R)
$$

Then the middle part is:

$$
z_3-z_1-z_2
$$

The final result is constructed using these three values.

Time complexity: $O(n^{\log_2 3}) \approx O(n^{1.585})$
Space complexity: $O(n)$

2. Empirical Comparison

Both methods were tested with:

A = "12345678987654321"
B = "98765432123456789"

Both methods produced:

1219326320073159566072245112635269

Execution time was measured using System.nanoTime():

Brute-force time: 181800 ns
Smart time: 7464800 ns

The brute-force method performs multiplication for every pair of digits, while Karatsuba reduces the number of recursive multiplications. The difference becomes more noticeable for larger numbers.

3. Conclusion

The brute-force solution has quadratic complexity $O(n^2)$. The Karatsuba divide-and-conquer solution has approximately $O(n^{1.585})$ complexity, making it more efficient for multiplying large integers represented as strings.
### Defense Interview
+ Be ready to justify running times, for example using **Master method** for divide-and-conquer algorithms.
+ Be ready to answer questions on algorithms and your code.
+ Be ready to run your code and test it on various inputs.

Good Luck!
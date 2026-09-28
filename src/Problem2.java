import java.util.Arrays;

public class Problem2 {
    public double getMedianBrute(int[] A, int[] B) {
        int[] combined = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            combined[i] = A[i];
        }
        for (int i = 0; i < B.length; i++) {
            combined[A.length + i] = B[i];
        }
        Arrays.sort(combined);
        int length = combined.length;
        if (length % 2 == 0) {
            return (double) (combined[length / 2] + combined[(length / 2) - 1]) / 2;
        } else {
            return combined[length / 2];
        }
    }

    public double getMedianSmart(int[] A, int[] B) {
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int m = A.length;
        int n = B.length;

        int left = 0;
        int right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA;
            int minRightA;
            int maxLeftB;
            int minRightB;

            if (partitionA == 0) {
                maxLeftA = Integer.MIN_VALUE;
            } else {
                maxLeftA = A[partitionA - 1];
            }

            if (partitionA == m) {
                minRightA = Integer.MAX_VALUE;
            } else {
                minRightA = A[partitionA];
            }

            if (partitionB == 0) {
                maxLeftB = Integer.MIN_VALUE;
            } else {
                maxLeftB = B[partitionB - 1];
            }

            if (partitionB == n) {
                minRightB = Integer.MAX_VALUE;
            } else {
                minRightB = B[partitionB];
            }

            if (maxLeftA <= minRightB &&
                    maxLeftB <= minRightA) {

                if ((m + n) % 2 == 0) {

                    int leftMax = Math.max(maxLeftA, maxLeftB);
                    int rightMin = Math.min(minRightA, minRightB);

                    return (leftMax + rightMin) / 2.0;

                } else {

                    return Math.max(maxLeftA, maxLeftB);
                }
            }
            else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            }
            else {
                left = partitionA + 1;
            }

        }
        return 0.0;
    }

    public static void main() {
//        long startBrute = System.nanoTime();
//        System.out.println(new Problem2().getMedianBrute(new int[]{2, 4}, new int[]{3}));
//        long endBrute = System.nanoTime();

        long startSmart = System.nanoTime();
        System.out.println(new Problem2().getMedianSmart(new int[]{2, 4}, new int[]{3}));
        long endSmart = System.nanoTime();

    }
}

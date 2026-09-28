import java.util.Arrays;

public class Problem2 {
    public double getMedianBrute(int[]A, int [] B){
        int [] combined = new int[A.length + B.length];
        for(int i = 0; i < A.length; i++){
            combined[i] = A[i];
        }
        for(int i = 0; i < B.length; i++){
            combined[A.length + i] = B[i];
        }
        Arrays.sort(combined);
        int length = combined.length;
        if(length % 2 == 0){
            return (double) (combined[length / 2] + combined[(length / 2) - 1]) / 2;
        } else{
            return combined[length / 2];
        }
    }

//    private double findMedian(int[] arr){
//        double median = 0.0;
//        int arrLength = arr.length;
//        if(arrLength % 2 == 0){
//            median = (double) (arr[arrLength / 2] + arr[(arrLength / 2) - 1]) / 2;
//        } else{
//            median = arr[arrLength / 2];
//        }
//        return median;
//    }
    public double getMedianSmart(int[]A, int [] B){
        // your code here
        return 0.0;
    }

    public static void main() {
        long startBrute = System.nanoTime();
        System.out.println(new Problem2().getMedianBrute(new int[]{2,4},new int[]{3}));
        long endBrute = System.nanoTime();
    }
}

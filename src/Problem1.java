import java.util.Arrays;
import java.util.Random;

public class Problem1 {
    public int countFreqBrute(int key, int [] A){
        int res = 0;
        for (int i = 0; i < A.length; i++){
            if(A[i] == key){
                res++;
            }
        }
        return res;
    }

    public int countFreqSmart(int key, int[] A) {
        int left = leftBound(A,key);
        int right = rightBound(A,key);
        if (left == -1 || right == -1){
            return 0;
        }
        return right-left+1;
    }

    private int leftBound(int[] A, int key){
        int low = 0;
        int high = A.length - 1;
        int res = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (A[mid] == key){
                res = mid;
                high = mid - 1;
            }
            else if (A[mid] < key){
                low = mid + 1;
            }
            else  {
                high = mid - 1;
            }
        }
        return res;
    }
    private int  rightBound(int[] A, int key){
        int low = 0;
        int high = A.length - 1;
        int res = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (A[mid] == key){
                res = mid;
                low = mid + 1;
            } else if (A[mid] < key){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return res;
    }


    static void main() {
        Problem1 p = new Problem1();

        int n = 100000000;
        int[] A = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            A[i] = random.nextInt(1000000);
        }

        Arrays.sort(A);

        int key = 500000;

        long startBrute = System.nanoTime();
        int resultBrute = p.countFreqBrute(key, A);
        long endBrute = System.nanoTime();

        long startSmart = System.nanoTime();
        int resultSmart = p.countFreqSmart(key, A);
        long endSmart = System.nanoTime();

        long bruteTime = endBrute - startBrute;
        long smartTime = endSmart - startSmart;

        System.out.println("Brute result: " + resultBrute);
        System.out.println("Smart result: " + resultSmart);

        System.out.println("Brute-force time: " + bruteTime + " ns");
        System.out.println("Smart time: " + smartTime + " ns");
    }
}

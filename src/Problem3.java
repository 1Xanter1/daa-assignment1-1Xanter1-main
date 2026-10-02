public class Problem3 {
    public int maxSumBrute(int [] A){
        int max = A[0];
        for (int i = 0; i <A.length; i++) {
            int sum = 0;
            for (int j = i;j<A.length;j++){
                sum += A[j];
                if(sum>max){
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSumSmart(int [] A){
        return maxSumDivide(A,0,A.length-1);
    }

    private int maxSumDivide(int [] A, int left, int right){

        if(right==left){
            return A[left];
        }

        int mid = (left+right)/2;
        int leftSum = maxSumDivide(A,left,mid);
        int rightSum = maxSumDivide(A, mid+1, right);
        int crossSum = findCrossingSum(A, left, mid, right);
        return Math.max(Math.max(leftSum,rightSum),crossSum);
    }
    private int findCrossingSum(int[] A, int left, int mid, int right){
        int sum = 0;
        int bestLeft = Integer.MIN_VALUE;
        for(int i = mid; i >= left; i--){
            sum += A[i];
            if(sum>bestLeft){
                bestLeft = sum;
            }
        }
        sum = 0;
        int bestRight = Integer.MIN_VALUE;
        for(int i = mid+1; i <= right; i++){
            sum += A[i];
            if(sum>bestRight){
                bestRight = sum;
            }
        }
        return bestLeft+bestRight;
    }

    static void main() {
        Problem3 p = new Problem3();
        long startBrute = System.nanoTime();
        int resultBrute = p.maxSumBrute(new int[]{1,2,3,4,5,6,7,8,9,10});
        long endBrute = System.nanoTime();

        long startSmart = System.nanoTime();
        int resultSmart = p.maxSumSmart(new int[]{1,2,3,4,5,6,7,8,9,10});
        long endSmart = System.nanoTime();

        long bruteTime = endBrute - startBrute;
        long smartTime = endSmart - startSmart;

        System.out.println("Brute result: " + resultBrute);
        System.out.println("Smart result: " + resultSmart);

        System.out.println("Brute-force time: " + bruteTime + " ns");
        System.out.println("Smart time: " + smartTime + " ns");
    }
}
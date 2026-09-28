public class Problem3 {
    public int maxSumBrute(int [] A){
        int max = A[0];
        for (int i = 0; i <A.length; i++) {
            int sum = 0;
            for (int j = i+1;j<A.length;j++){
                sum += A[j];
                if(sum>max){
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSumSmart(int [] A){
        // your code here
        return 0;
    }

    static void main() {
        // you can test your code here
        System.out.println(new Problem3().maxSumBrute(new int[]{-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4}));
    }
}

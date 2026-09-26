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
        int[] A = {1,1,1,2,2,2,2,2,2,4,4,4,5,5,5,5};
        Problem1 p = new Problem1();
//        System.out.println(p.countFreqBrute(3, A));
        System.out.println(p.countFreqSmart(5, A));
    }
}

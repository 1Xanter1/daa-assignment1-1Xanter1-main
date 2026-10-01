import java.math.BigInteger;

public class Problem5 {
    public String multBrute(String A, String B){
        int [] result = new int[A.length() + B.length()];
        for(int i = 0; i < A.length(); i++){
            for(int j = 0; j < B.length(); j++){
                int numA = A.charAt(i) - '0';
                int numB = B.charAt(j) - '0';

                int multiplication = numA * numB;
                int pos = i+j+1;

                result[pos] += multiplication;
                result[pos-1] += result[pos]/10;
                result[pos] %= 10;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int digit : result){
            answer.append(digit);
        }
        int start = 0;
        while(start < answer.length()-1 && answer.charAt(start) == '0'){
            start++;
        }
        return answer.substring(start);
    }

    public String multSmart(String A, String B){
        // your code here
        return "0";
    }

    static void main() {
        // you can test your code here
        BigInteger a = new BigInteger("12345678987654321");
        BigInteger b = new BigInteger("98765432123456789");
        System.out.println(a.multiply(b));
    }
}

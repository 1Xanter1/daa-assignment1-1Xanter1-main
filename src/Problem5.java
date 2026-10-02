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

    public String multSmart(String A, String B) {

        A = removeLeadingZeros(A);
        B = removeLeadingZeros(B);

        if (A.equals("0") || B.equals("0")) {
            return "0";
        }

        if (A.length() == 1 && B.length() == 1) {
            return simpleMultiplication(A, B);
        }

        int n = Math.max(A.length(), B.length());

        A = padZeros(A, n);
        B = padZeros(B, n);

        if (n % 2 != 0) {
            n++;
            A = padZeros(A, n);
            B = padZeros(B, n);
        }

        int mid = n / 2;

        String leftA = A.substring(0, mid);
        String rightA = A.substring(mid);

        String leftB = B.substring(0, mid);
        String rightB = B.substring(mid);

        String z1 = multSmart(leftA, leftB);
        String z2 = multSmart(rightA, rightB);

        String sumA = addition(leftA, rightA);
        String sumB = addition(leftB, rightB);

        String z3 = multSmart(sumA, sumB);

        String middle = subtraction(
                subtraction(z3, z1),
                z2
        );

        String part1 = addZeros(z1, 2 * mid);
        String part2 = addZeros(middle, mid);

        return addition(
                addition(part1, part2),
                z2
        );
    }

    private String addition(String A, String B){
        int i = A.length()-1;
        int j = B.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while(i>=0 || j>=0 || carry > 0){
            int digitA = 0;
            int digitB = 0;
            if(i>=0){
                digitA = A.charAt(i)-'0';
            }
            if(j>=0){
                digitB = B.charAt(j)-'0';
            }
            int sum  = digitA+digitB+carry;
            result.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
    private String subtraction(String A, String B){
        int i = A.length()-1;
        int j = B.length()-1;
        int borrow = 0;
        StringBuilder result = new StringBuilder();
        while(i>=0 ){
            int digitA = (A.charAt(i)-'0') -  borrow;
            int digitB = 0;

            if(j>=0){
                digitB = B.charAt(j)-'0';
            }
            if(digitA < digitB){
                digitA += 10;
                borrow = 1;
            } else{
                borrow = 0;
            }

            int difference = digitA - digitB;

            result.append(difference);
            i--;
            j--;
        }
        result.reverse();
        while(result.length() > 1 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
    private String addZeros(String number, int count) {
        return number + "0".repeat(count);
    }
    private String padZeros(String number, int length) {

        StringBuilder result = new StringBuilder();

        for (int i = number.length(); i < length; i++) {
            result.append("0");
        }

        result.append(number);

        return result.toString();
    }
    private String removeLeadingZeros(String number) {

        int i = 0;

        while (i < number.length() - 1 && number.charAt(i) == '0') {
            i++;
        }

        return number.substring(i);
    }

    private String simpleMultiplication(String A, String B){
        int x = Integer.parseInt(A);
        int y = Integer.parseInt(B);
        int result = x*y;
        return String.valueOf(result);
    }

    static void main() {
//        BigInteger a = new BigInteger("12345678987654321");
//        BigInteger b = new BigInteger("98765432123456789");
//        System.out.println(a.multiply(b));

        Problem5 p = new Problem5();
        String a = "12345678987654321";
        String b = "98765432123456789";
        System.out.println(p.multSmart(a, b));
    }
}

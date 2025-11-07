package algorithmicWarmup;

import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

public class FibonacciLastDigit {

    public static BigInteger calcFibLastDigitHelper(BigInteger[] memo, int n) {
        if(n <= 1) return BigInteger.valueOf(n);
        if(memo[n].compareTo(new BigInteger("-1")) != 0) return memo[n];

        memo[n] = calcFibLastDigitHelper(memo, n-1).add(calcFibLastDigitHelper(memo, n-2));

        return memo[n];
    }

    public static BigInteger calcFibLastDigit(int n) {
        BigInteger[] memo = new BigInteger[n+1];
        Arrays.fill(memo, new BigInteger("-1"));

        return calcFibLastDigitHelper(memo, n).mod(BigInteger.valueOf(10));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(calcFibLastDigit(n));
    }
}

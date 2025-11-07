package algorithmicWarmup;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    public static int calcFib(int n) {
        if(n <= 1) return n;

        return calcFib(n-1) + calcFib(n-2);
    }

    public static BigInteger getFibonacciHelper(Map<Long, BigInteger> memo, long n) {
        if(n <= 1) return BigInteger.valueOf(n);
        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, getFibonacciHelper(memo, n-1).add(getFibonacciHelper(memo, n-2)));

        return memo.get(n);
    }

    public static BigInteger calcFibFast(long n) {
        Map<Long, BigInteger> memo = new HashMap<>();

        return getFibonacciHelper(memo, n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(calcFibFast(n));
    }
}

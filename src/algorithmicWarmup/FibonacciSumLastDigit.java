package algorithmicWarmup;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciSumLastDigit {
    public static BigInteger getFibonacciHelper(Map<Long, BigInteger> memo, long n) {
        if(n <= 1) return BigInteger.valueOf(n);
        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, getFibonacciHelper(memo, n-1).add(getFibonacciHelper(memo, n-2)));

        return memo.get(n);
    }

    public static BigInteger calcFibSum(long m, long n) {
        Map<Long, BigInteger> memo = new HashMap<>();
        memo.put(0L,BigInteger.valueOf(0));
        memo.put(1L, BigInteger.valueOf(1));
        BigInteger result = BigInteger.valueOf(0);

        getFibonacciHelper(memo, n);

        for(long i = m; i <= n; i++) result = result.add(memo.get(i));

        return result.mod(BigInteger.valueOf(10));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long m = input.nextLong();
        long n = input.nextLong();

        System.out.println(calcFibSum(m, n));
    }
}

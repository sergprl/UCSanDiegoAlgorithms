package algorithmicWarmup;

import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    public static BigInteger fibonacciHelper(Map<Long, BigInteger> memo, long n){
        if(n <= 1) return BigInteger.valueOf(n);
        if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, fibonacciHelper(memo, n-1).add(fibonacciHelper(memo, n-2)));

        return memo.get(n);
    }

    public static BigInteger fibonacciNumberMod(long n, int mod) {
        Map<Long, BigInteger> memo = new HashMap<>();

        return fibonacciHelper(memo, n).mod(BigInteger.valueOf(mod));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(fibonacciNumberMod(input.nextLong(), input.nextInt()));
    }
}

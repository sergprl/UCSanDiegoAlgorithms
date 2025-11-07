package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Fibonacci {
    public static int fibRecurs(int n) {
        if(n <= 1) return n;
        else return fibRecurs(n-1) + fibRecurs(n-2);
    }

    static int nthFibonacci(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return nthFibonacciUtil(n, memo);
    }

    static int nthFibonacciUtil(int n, int[] memo) {
        if(n <= 1) return n;
        if(memo[n] != -1) return memo[n];

        memo[n] = nthFibonacciUtil(n-1, memo) + nthFibonacciUtil(n-2, memo);

        return memo[n];
    }


    public static void main(String[] args) {
        FastScanner input = new FastScanner(System.in);
        for(int i = 0; i < 50; i++) {
//            int n = input.nextInt();
            int n = i;

            long start = System.nanoTime();
            System.out.println(fibRecurs(n));
            long durationFirst = System.nanoTime() - start;

            start = System.nanoTime();
            System.out.println(nthFibonacci(n));
            long durationSecond = System.nanoTime() - start;

            System.out.println("Duration of first: " + durationFirst + "ns");
            System.out.println("Duration of second: " + durationSecond + "ns");
            System.out.println("Difference: " + (durationFirst-durationSecond) + "ns\n");
        }


    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PairwiseProduct {
//    public static long maxPairWiseProduct(long[] numbers) {
//        long result = 0;
//        int n = numbers.length;
//
//        for(int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (numbers[i] * numbers[j] > result) result = numbers[i] * numbers[j];
//            }
//        }
//
//        return  result;
//    }

    public static long maxPairWiseProductFast(long[] numbers) {
        int n = numbers.length;
        int maxIndexFirst = -1;
        int maxIndexSecond = -1;

        for (int i = 0; i < n; i++)
            if((maxIndexFirst == -1) || numbers[i] > numbers[maxIndexFirst])
                maxIndexFirst = i;

        for (int j = 0; j < n; j++)
            if((j != maxIndexFirst) && ((maxIndexSecond == -1) || numbers[j] > numbers[maxIndexSecond]))
                maxIndexSecond = j;

        return numbers[maxIndexFirst] * numbers[maxIndexSecond];

    }

    public static void main(String[] args) {
//        while(true) {
//            int n = (int) (Math.random()*10 + 2);
//            System.out.println(n);
//
//            long[] numbers = new long[n];
//            for(int i = 0; i < numbers.length; i++) numbers[i] = (long) (Math.random()*10 + 2143489639);
//            System.out.println(Arrays.toString(numbers));
//
//            long start = System.nanoTime();
//            long resA = maxPairWiseProduct(numbers);
//            long durationA = System.nanoTime() - start;
//
//            start = System.nanoTime();
//            long resB = maxPairWiseProductFast(numbers);
//            long durationB = System.nanoTime() - start;
//
//            if (resA != resB) {
//                System.out.println("Wrong answer " + resA + " " + resB);
//                break;
//            }
//
//            else System.out.println("Ok");
//
//            System.out.printf("Method A took %d ns%n", durationA);
//            System.out.printf("Method B took %d ns%n", durationB);
//        }

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(maxPairWiseProductFast(numbers));

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

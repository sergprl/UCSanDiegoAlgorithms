package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD {

    public static int getNaiveGCD(int a, int b) {
        int best = 0;
        for(int d = 1; d <= Math.min(a,b); d++)
            if(a%d == 0 && b%d == 0)
                best = d;

        return best;
    }

    public static void main(String[] args) {
        FastScanner input = new FastScanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println(getNaiveGCD(a, b));
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

package algorithmicWarmup;

import java.util.Scanner;

public class LCM {
    public static int getGCD(int a, int b) {
        if(a == 0) return b;
        return getGCD(b%a, a);
    }

    public static int getLCM(int a, int b) {
        return a*b/getGCD(a,b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println(getLCM(a, b));
    }
}

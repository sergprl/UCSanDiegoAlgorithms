package algorithmicWarmup;

import java.util.Scanner;

public class GCD {
    public static int findGCD(int a, int b) {
        if(a == 0) return b;
        return findGCD(b%a, a);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println(findGCD(a, b));
    }
}

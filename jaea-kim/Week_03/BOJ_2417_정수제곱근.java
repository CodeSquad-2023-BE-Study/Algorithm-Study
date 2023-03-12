package Week_03;

import java.util.Scanner;

public class BOJ_2417_정수제곱근 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        long q = (long)Math.sqrt(num);

        if((q*q) < num) {
            q++;
        }

        System.out.println(q);
    }
}

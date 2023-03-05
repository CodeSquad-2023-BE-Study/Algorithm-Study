package Week_02;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2752_세수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = new int[3];

        for (int i = 0; i < 3; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        for (int i = 0; i < 3; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

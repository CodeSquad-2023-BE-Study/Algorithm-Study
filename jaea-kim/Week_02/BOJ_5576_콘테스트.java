package Week_02;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5576_콘테스트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] wScores = new int[10];
        int[] kScores = new int[10];

        for (int i = 0; i < 10; i++) {
            wScores[i] = sc.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            kScores[i] = sc.nextInt();
        }

        Arrays.sort(wScores);
        Arrays.sort(kScores);

        int wScore = wScores[7] + wScores[8] + wScores[9];
        int kScore = kScores[7] + kScores[8] + kScores[9];

        System.out.println(wScore + " " + kScore);

    }
}

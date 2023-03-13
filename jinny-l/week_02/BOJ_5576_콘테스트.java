package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] wUniv = readScores(br);
        int[] kUniv = readScores(br);
        Arrays.sort(wUniv);
        Arrays.sort(kUniv);
        System.out.println(calculateScores(wUniv) + " " + calculateScores(kUniv));
    }

    /*
     * BufferedReader를 주석처리한 것 처럼 메서드 내에서 쓰면 에러남, 이유를 모르겠음
     * 인자로 받으면 괜찮음
     */
    public static int[] readScores(BufferedReader br) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[10];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        return scores;
    }

    public static int calculateScores(int[] sorted) {
        int sum = 0;
        for (int i = sorted.length - 1; i > sorted.length - 4; i--) {
            sum += sorted[i];
        }
        return sum;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wScore[] = new int[10];
        int kScore[] = new int[10];
        readScores(br, wScore);
        readScores(br, kScore);

        Arrays.sort(wScore);
        Arrays.sort(kScore);
        int wMaxScore = wScore[7] + wScore[8] + wScore[9];
        int kMaxScore = kScore[7] + kScore[8] + kScore[9];
        System.out.println(wMaxScore+" "+kMaxScore);
    }

    private static void readScores(BufferedReader br, int[] score) throws IOException {
        for (int i=0;i<10; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
    }

}

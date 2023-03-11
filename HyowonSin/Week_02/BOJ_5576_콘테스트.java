package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int W = printScore(br);
        int K = printScore(br);

        System.out.println(W + " " + K);
    }

    public static int printScore(BufferedReader br) throws IOException {
        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<10; i++) {
            int score = Integer.parseInt(br.readLine());
            if (arr.isEmpty()) {
                arr.add(score);
                continue;
            }
            for (int j=0; j<arr.size(); j++) {
                if (j > 2) {
                    break;
                }
                if (score > arr.get(j)) {
                    arr.add(j, score);
                    break;
                }
                if (j+1 == arr.size()) {
                    arr.add(score);
                    break;
                }
            }
        }
        return arr.get(0)+arr.get(1)+arr.get(2);
    }
}
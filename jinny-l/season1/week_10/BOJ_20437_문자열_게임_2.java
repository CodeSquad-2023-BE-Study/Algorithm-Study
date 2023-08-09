package season1.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * substring 사용했을 때 시간 초과
 * https://moonsbeen.tistory.com/351 여기랑 똑같이 했는데 왜 틀렸는지 모르겠음
 */
public class BOJ_20437_문자열_게임_2 {

    private static int[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 테케 반복
        for (int i = 0; i < N; i++) {
            // 입력
            String word = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if (K == 1) {
                System.out.println("1 1");
                continue;
            }

            // 단어의 알파벳 별 개수 저장
            toAlphabet(word);

            // 결과 계산
            sb.append(parse(word, K));
        }
        System.out.println(sb);
    }

    private static void toAlphabet(String word) {
        alphabet = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 97; // 알파벳 a부터 z까지 인덱스에 저장, a = 0 ... z = 25
            alphabet[index]++;
        }
    }

    private static String parse(String word, int K) {
        int min = Integer.MAX_VALUE;
        int max = -1;

        for (int i = 0; i < word.length(); i++) {
            char parsed = word.charAt(i);
            int index = parsed - 97;

            if (alphabet[index] >= K) { // 단어 안의 알파벳 개수가 K개 보다 많으면 검사

                int count = 1;
                for (int j = i + 1; j < word.length(); j++) {  // 알파벳 개수가 K가 될때까지 반복

                    if (word.charAt(j) == parsed) {
                        count++;
                    }

                    if (count == K) { // K개가 됐을 때 길이 검사
                        int length = j - i + 1;
                        min = Math.min(min, length);
                        max = Math.max(max, length);
                        break;
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE || max == -1) { // 만족하는 조건이 없을 때
            return "-1";
        }
        return min + " " + max + "\n";
    }
}

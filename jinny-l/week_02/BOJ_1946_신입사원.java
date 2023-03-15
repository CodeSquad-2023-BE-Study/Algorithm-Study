package week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 풀이 방법:
 * 1. 서류 성적에 따라 정렬
 * 2. 면접 성적이 최소 성적과 비교했을 때 낮으면 탈락
 */
public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = 1; // 서류 1등은 무조건 합격

            Score[] scores = new Score[N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                scores[j] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 정렬
            Arrays.sort(scores, (o1, o2) -> {
                return o1.document - o2.document;
            });

            // 선발 인원 체크
            int min = scores[0].interview;
            for (int k = 1; k < scores.length; k++) {
                if (scores[k].interview < min) {
                    count++;
                    min = scores[k].interview;
                }
            }
            System.out.println(count);
        }
    }

    // 점수 객체
    public static class Score {
        int document;
        int interview;

        public Score(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
}

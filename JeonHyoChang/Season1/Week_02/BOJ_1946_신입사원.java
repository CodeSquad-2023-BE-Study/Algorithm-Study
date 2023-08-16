package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Grade {
    int fg;
    int sg;

    public Grade(int fg, int sg) {
        this.fg = fg;
        this.sg = sg;
    }
}

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            List<Grade> grade_List = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int fg = Integer.parseInt(st.nextToken());
                int sg = Integer.parseInt(st.nextToken());

                grade_List.add(new Grade(fg, sg));
            }

            // 기존 방식에서 list.sort()로 변경
            grade_List.sort((o1, o2) -> {
                return o1.fg - o2.fg;
            });

            // 합격자 수 & 기준이 되는 2차 성적
            int passer_Count = 1;
            int standard = grade_List.get(0).sg;

            // 기준보다 등수가 높을시 합격자에 추가하며, 기준을 그사람으로 변경
            for (int x = 1; x < N; x++) {
                if (standard > grade_List.get(x).sg) {
                    passer_Count++;
                    standard = grade_List.get(x).sg;
                }
            }

            result.add(passer_Count);
        }

        for (int temp : result) {
            System.out.println(temp);
        }
    }
}
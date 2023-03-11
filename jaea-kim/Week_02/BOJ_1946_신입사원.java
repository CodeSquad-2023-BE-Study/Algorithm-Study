package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
    /*
    문제를 이해가 잘 되어서 예저 입력과 출력을 보고 끼워 맞춰서 생각함
    서류성적이나 면접성적이 동시에 못 보면 안됨 -> 서류성적을 기준으로 면접성적 비교

    1. 케이스별 성적 데이터 넣어야함 [서류순위, 면접순위] - 케이스 객체
    2. 서류 등수 기준으로 정렬
    3. 서류 1등은 무조건 통과
    4. 그 외 등수는 윗 등수들보다 면접 점수가 높아야 통과

     */
    static class TestCase {
        int[][] data;
        int passCount = 1;

        TestCase(int[][] data) {
            this.data = data;
        }

        public void sortByDocument() {
            Arrays.sort(data, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[0], o2[0]);
                }
            });
        }

        public int getPassCount() {
            int passStandard = data[0][1];
            for (int i = 1; i < data.length; i++) {
                if (data[i][1] < passStandard) {
                    passCount++;
                    passStandard = data[i][1];
                }
            }
            return passCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = Integer.parseInt(br.readLine());
        TestCase[] testCases = new TestCase[caseNum];
        for (int i = 0; i < caseNum; i++) {
            int memberNum = Integer.parseInt(br.readLine());
            int[][] input = new int[memberNum][2];
            for (int j = 0; j < memberNum; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                input[j][0] = Integer.parseInt(st.nextToken());
                input[j][1] = Integer.parseInt(st.nextToken());
            }
            testCases[i] = new TestCase(input);
            testCases[i].sortByDocument();
            System.out.println(testCases[i].getPassCount());
        }

    }
}

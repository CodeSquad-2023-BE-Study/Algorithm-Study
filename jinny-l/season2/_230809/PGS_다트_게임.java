package season2._230809;

import java.util.Arrays;

public class PGS_다트_게임 {
    public int solution(String dartResult) {
        int[] scores = new int[3];

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (Character.isDigit(c)) { // 숫자일 떄 변수에 숫자 저장
                sb.append(c);

            } else if (Character.isAlphabetic(c)) { // S, D, T일 때 점수 계산
                int number = Integer.parseInt(sb.toString());

                if (c == 'S') {
                    scores[index++] = (int) Math.pow(number, 1);
                }

                if (c == 'D') {
                    scores[index++] = (int) Math.pow(number, 2);
                }

                if (c == 'T') {
                    scores[index++] = (int) Math.pow(number, 3);
                }

                sb = new StringBuilder();

            } else if (c == '*') {
                scores[index - 1] *= 2;

                if (index - 1 != 0) {
                    scores[index - 2] *= 2;
                }

            } else if (c == '#') {
                scores[index - 1] *= -1;
            }

        }
        return Arrays.stream(scores).sum();
    }
}

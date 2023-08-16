package season1.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21314_민겸_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String input = br.readLine();

        // 최대값은 K가 나올 때까지 기준으로 파싱
        // 최소값은 M이 연속되지 않을 때 파싱

        // 결과 출력
        System.out.println(parseToMax(input));
        System.out.println(parseToMin(input));
    }

    private static String parseToMax(String numMK) {
        StringBuilder result = new StringBuilder();
        boolean isPreviousM = false;
        int countOfM = 0;

        for (int i = 0; i < numMK.length(); i++) {
            char parsed = numMK.charAt(i);

            if (!isPreviousM && parsed == 'K') {
                result.append("5");
            }

            if (parsed == 'M') {
                countOfM++;
                isPreviousM = true;
            }

            if (isPreviousM && parsed == 'K') {
                result.append("5")
                        .append("0".repeat(countOfM));
                countOfM = 0;
                isPreviousM = false;
            }
        }
        if (countOfM != 0) {
            result.append("1".repeat(countOfM));
        }
        return result.toString();
    }

    private static String parseToMin(String numMK) {
        StringBuilder result = new StringBuilder();
        boolean isPreviousM = false;

        for (int i = 0; i < numMK.length(); i++) {
            char parsed = numMK.charAt(i);

            if (parsed == 'K') {
                result.append("5");
                isPreviousM = false;
            }

            if (isPreviousM && parsed == 'M') {
                result.append("0");
            }

            if (!isPreviousM && parsed == 'M') {
                result.append("1");
                isPreviousM = true;
            }
        }
        return result.toString();
    }
}

package season1.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20115_에너지_드링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 드링크 수 입력
        int count = Integer.parseInt(br.readLine());

        // 각 드링크 양 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double drinks[] = new double[count];
        for (int i = 0; i < count; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
        }

        // 정렬
        Arrays.sort(drinks);

        // 최대값을 뺀 나머지를 각 1/2하고 더하기
        double sum = 0;
        for (int i = 0; i < count - 1; i++) {
            sum += drinks[i] / 2;
        }

        System.out.println(drinks[count - 1] + sum);
    }
}

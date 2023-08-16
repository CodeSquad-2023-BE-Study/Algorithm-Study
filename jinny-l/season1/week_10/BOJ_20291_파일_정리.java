package season1.week_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BOJ_20291_파일_정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // 파일이름 입력, 입력받으면서 확장자 별 개수 저장
        Map<String, Integer> result = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] file = br.readLine().split("\\.");
            String fileType = file[1];
            result.put(fileType, result.getOrDefault(fileType, 0) + 1);
        }

        // 출력
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}

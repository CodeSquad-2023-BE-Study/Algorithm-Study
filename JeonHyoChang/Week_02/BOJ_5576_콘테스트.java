package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> university_W = new ArrayList<>();
        List<Integer> university_K = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            // 10번을 기준으로 2개의 List에 값을 저장
            if (i < 10) university_W.add(Integer.parseInt(br.readLine()));
            else university_K.add(Integer.parseInt(br.readLine()));
        }

        // 정렬뒤 앞 3개의 값을 더한값을 출력
        Collections.sort(university_W, Collections.reverseOrder());
        Collections.sort(university_K, Collections.reverseOrder());

        int sum_W = university_W.get(0) + university_W.get(1) + university_W.get(2);
        int sum_K = university_K.get(0) + university_K.get(1) + university_K.get(2);

        System.out.println(sum_W + " " + sum_K);
    }
}

package week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2531_회전_초밥 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력
        int dishAmount = Integer.parseInt(st.nextToken());
        int type = Integer.parseInt(st.nextToken()); // 이 친구는 어디에 쓰는건지 모르겠음
        int continuousDish = Integer.parseInt(st.nextToken());
        int couponDish = Integer.parseInt(st.nextToken());

        List<Integer> sushi = new ArrayList<>();
        for (int i = 0; i < dishAmount; i++) {
            sushi.add(Integer.parseInt(br.readLine()));
        }
        sushi.addAll(sushi.subList(0, continuousDish - 1)); // 배열 끝에 왔을 때 순환해서 앞의 값 확인할 수 있도록 추가

        // 알고리즘
        int max = 0;
        for (int i = 0; i < dishAmount; i++) {
            Set<Integer> uniqueDishAmount = new HashSet<>(
                    sushi.subList(i, i + continuousDish)); // 한칸씩 이동하며 연속된 접시의 중복 제거된 스시 종류 확인
            if (uniqueDishAmount.size() + 1 > max
                    && !uniqueDishAmount.contains(couponDish)) { // 쿠폰 접시가 포함되어 있고 접시 개수 +1 했을 때 max 값 보다 크면 저장
                max = uniqueDishAmount.size() + 1;
            }
            if (uniqueDishAmount.size() > max
                    && uniqueDishAmount.contains(couponDish)) {  // 쿠폰 접시가 없고, 접시 개수가 max 값 보다 크면 저장
                max = uniqueDishAmount.size();
            }
        }
        // 출력
        System.out.println(max);
    }
}

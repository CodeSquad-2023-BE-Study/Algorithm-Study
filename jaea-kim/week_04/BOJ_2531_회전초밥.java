package week_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2531_회전초밥 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int plateNum = Integer.parseInt(st.nextToken());
        int sushiNum = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] sushi = new int[plateNum];

        for (int i = 0; i < plateNum; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int maxNum = 0;
        int left = 0;
        Set<Integer> eatedSushi = new HashSet<>();

        while (left < plateNum) {
            eatedSushi.clear();
            eatedSushi.add(coupon);

            for (int i = 0; i < k; i++) {
                eatedSushi.add(sushi[(left + i) % plateNum]);
            }

            if (eatedSushi.size() > maxNum) {
                maxNum = eatedSushi.size();
            }
            left++;
        }
        System.out.println(maxNum);
    }
}

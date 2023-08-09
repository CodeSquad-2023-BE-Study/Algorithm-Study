package week_24;

import java.util.Arrays;

public class LTC_2300_Successful_Pairs_of_Spells_and_Potions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] answer = new int[spells.length];
        // 이분 탐색을 위해 정렬
        Arrays.sort(potions);

        // spells 길이 만큼 반복
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;

            // 이분탐색
            while (left <= right) {
                int mid = (left + right) / 2;

                if ((long) potions[mid] * (long) spells[i] < success) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            answer[i] = potions.length - left;
        }
        return answer;
    }
}

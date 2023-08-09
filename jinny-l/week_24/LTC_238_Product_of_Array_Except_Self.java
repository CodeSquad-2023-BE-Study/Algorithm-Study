package week_24;

import java.util.Arrays;

public class LTC_238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // 1로 초기화
        Arrays.fill(answer, 1);

        // 왼쪽 곱셈
        for(int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 오른쪽 곱셈
        int total = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            total *= nums[i];
            answer[i - 1] *= total;
        }
        return answer;
    }
}

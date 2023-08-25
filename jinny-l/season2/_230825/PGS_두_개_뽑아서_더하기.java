package season2._230825;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PGS_두_개_뽑아서_더하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5,0,2,7})));
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> answer = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}

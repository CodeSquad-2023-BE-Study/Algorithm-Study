package season2._230816;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PGS_실패율_ver2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 2, 1, 1})));
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> rates = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            double total = 0;
            double fail = 0;

            for (int stage : stages) {
                if (stage > i) {
                    total++;
                }
                if (stage == i) {
                    total++;
                    fail++;
                }
            }
            if (total == 0) {
                rates.put(i, 0.0);
            } else {
                rates.put(i, fail / total);
            }
        }

        // 정렬
        List<Integer> result = new ArrayList<>(rates.keySet());
        Collections.sort(result, ((o1, o2) -> Double.compare(rates.get(o2), rates.get(o1))));
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}

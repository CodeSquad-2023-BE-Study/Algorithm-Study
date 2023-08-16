package season2._230809;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class PGS_뉴스_클러스터링 {

    public int solution(String str1, String str2) {
        // 일괄 소문자 처리
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 문자 2개씩 파싱
        Map<String, Integer> first = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String word = str1.substring(i, i + 2);

            if (!Pattern.matches("^[a-zA-Z]*$", word)) {
                continue;
            }

            first.put(word, first.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> second = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            String word = str2.substring(i, i + 2);

            if (!Pattern.matches("^[a-zA-Z]*$", word)) {
                continue;
            }

            second.put(word, second.getOrDefault(word, 0) + 1);
        }

        if (first.isEmpty() && second.isEmpty()) {
            return 65536;
        }

        // (계산용) 중복 제거된 단어 구하기
        Set<String> words = new HashSet<>(){
            {
                addAll(first.keySet());
                addAll(second.keySet());
            }
        };

        // 교집합 구하기
        double intersection = 0;
        double union = 0;
        for (String word : words) {
            if (first.containsKey(word) && second.containsKey(word)) {
                intersection += Math.min(first.get(word), second.get(word));
                union += Math.max(first.get(word), second.get(word));

            } else {
                union += first.getOrDefault(word, 0);
                union += second.getOrDefault(word, 0);
            }
        }

        return (int) (intersection / union * (double) 65536);
    }
}

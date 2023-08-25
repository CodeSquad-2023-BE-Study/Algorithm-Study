package season2._230816;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PGS_실패율_ver1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, new int[]{1,1,1,1})));
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Record> records = new HashMap<>();

        // 스테이지에 도달안 플레이어 수, 클리어하지 못한 플레이어 수 계산
        for (int i = 0; i < stages.length; i++) {
            int stage = stages[i];

            Record record = records.getOrDefault(stage, new Record(0, 0));
            record.challengers++;
            records.put(stage, record);

            for (int j = 1; j < stage; j++) {
                Record lowerStage = records.getOrDefault(j, new Record(0, 0));
                lowerStage.challengers++;
                lowerStage.passers++;
                records.put(j, lowerStage);
            }

        }

        // 실패율 계산
        Map<Integer, Double> rates = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (!records.containsKey(i)) { // 마지막 스테이지에 도전한 사람이 없을 경우 객체가 null이라서 처리
                rates.put(i, 0.0);

            } else if (records.get(i).challengers == 0 || (records.get(i).challengers - records.get(i).passers) == 0) { // 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
                rates.put(i, 0.0);

            } else {
                rates.put(i, calculate(records.get(i)));
            }
        }

        // 정렬
        List<Integer> sortedKeys = rates.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    int compare = Double.compare(entry2.getValue(), entry1.getValue());
                    if (compare == 0) {
                        return Integer.compare(entry1.getKey(), entry2.getKey());
                    }
                    return compare;
                })
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return sortedKeys.stream().mapToInt(Integer::intValue).toArray();
    }

    private static double calculate(Record record) {
        return (record.challengers - record.passers) / record.challengers;
    }

    static class Record {
        private double challengers;
        private double passers;

        public Record(int challengers, int passers) {
            this.challengers = challengers;
            this.passers = passers;
        }
    }

}

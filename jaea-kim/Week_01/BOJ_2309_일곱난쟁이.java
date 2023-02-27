package Week_01;

import java.util.*;

public class BOJ_2309_일곱난쟁이 {
    public static boolean result = false;
    public static void main(String[] args) {
        /*
        7 난쟁이 키의 합 100
        9개 중 7개 선택 -> 순서 x -> 조합?

        정답이 여러가지 : 아무거나 1개의 경우 출력
        ! 오름차순으로 출력
         */
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            input.add(scanner.nextInt());
        }
        input.sort(Comparator.naturalOrder());
        List<Integer> answer = new ArrayList<>();
        combination(input, answer, 0,0);
    }

    public static void combination(List<Integer> list, List<Integer> answer, int startNum, int depth) {
        if (answer.size() == 7) {
            if (sum(answer)) {
                answer.forEach(System.out::println);
                result = true;
            }
            answer.remove(depth - 1);
            return;
        }

        for (int i = startNum; i < 9; i++) {
            answer.add(list.get(i));
            combination(list, answer, ++startNum, ++depth);
            if (result) {
                return;
            }
            depth--;
        }

        if (!answer.isEmpty()) {
            answer.remove(depth - 1);
        }
    }

    public static boolean sum(List<Integer> answer) {
        return answer.stream().mapToInt(i -> i).sum() == 100;
    }
}

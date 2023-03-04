import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1946_신입사원 {
    /**
     * 문제 풀이
     *
     * 한 점수로 오름차순 정렬을 하면,
     * 다른 점수는 반드시 앞 사람보다 등수가 낮아야 합격할 수 있습니다.
     * 따라서 두번째 시험 성적의 최소 값을 가지는 변수를 선언하여, 최소 값이 갱신될 때마다 count를 증가시켜줍니다.
     *
     * 예시)
     * 1 4 - O
     * 2 5 - X
     * 3 6 - X
     * 4 2 - O
     * 5 7 - X
     * 6 1 - O
     * 7 3 - X
     *
     * 문제 풀이
     * 1. 등수 a,b를 가지는 Person Class
     * 2. compareTo를 override하여 a의 등수로 오름차순 정렬하도록 구현
     * 3. person list를 정렬한 후, 순회하면서 최소 값이 갱신될 때마다 count를 증가시킨다.
     * 4. count를 출력
     */

    static class Person implements Comparable {

        int a;
        int b;

        public Person(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            Person target = (Person) o;
            return (this.a > target.a ? 1 : -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int t=0;t<cases;t++) {
            List<Person> personList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
                personList.add(new Person(scores[0], scores[1]));
            }

            personList.sort(Person::compareTo);
            int minB = Integer.MAX_VALUE;
            int count = 0;
            for (Person p : personList) {
                if (p.b < minB) {
                    count++;
                    minB = p.b;
                }
            }
            System.out.println(count);
        }
    }
}

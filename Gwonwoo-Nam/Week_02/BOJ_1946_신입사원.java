import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1946_신입사원 {

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

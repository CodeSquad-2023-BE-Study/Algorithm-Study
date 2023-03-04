import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_10814_나이순정렬 {

    static class Person implements Comparable {

        private String name;
        private int age;
        private int index;

        public Person(String name, int age, int index) {
            this.name = name;
            this.age = age;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            Person target = (Person)o;
            if (this.age > target.age) {
                return 1;
            }
            else if (this.age == target.age) {
                return (this.index > target.index ? 1 : -1);
            }
            return -1;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            personList.add(new Person(info[1], Integer.parseInt(info[0]),i));
        }

        personList.sort(Person::compareTo);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

}

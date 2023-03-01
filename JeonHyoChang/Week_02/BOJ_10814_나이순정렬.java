package Week_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// User 객체
class User {
    int age;
    String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class BOJ_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        List<User> user_List = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            user_List.add(new User(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        // 람다를 활용하여 age 기준으로 정렬 & 데이터가 들어가 있으므로 age가 같을시 먼저것이 앞에 있는다!!
        Collections.sort(user_List, (o1, o2) -> o1.age - o2.age);

        for (User temp : user_List) {
            System.out.println(temp.age + " " + temp.name);
        }
    }
}
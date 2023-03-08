package Week_02;

import java.util.*;

public class BOJ_10814_나이순정렬 {
    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        Member[] members = new Member[num];

        for (int i = 0; i < num; i++) {
            String[] input = sc.nextLine().split(" ");
            members[i] = new Member(Integer.parseInt(input[0]), input[1]);
        }

        Arrays.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });

        for (Member member : members){
            System.out.println(member.toString());
        }

    }
}

package season1.week_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1713_후보_추천하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int postSize = Integer.parseInt(br.readLine());
        int votes = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 최종 후보 확인
        Student[] students = new Student[101]; // 모든 학생의 정보를 담는 배열
        List<Student> post = new ArrayList<>(); // 사진틀에 게시된 최종 후보의 학생 정보를 담는 배열

        for (int i = 0; i < votes; i++) {
            int vote = Integer.parseInt(st.nextToken());

            if (students[vote] == null) { // 처음 추천받았다면 객체 생성
                students[vote] = new Student(vote, 0, 0, false);
            }

            if (students[vote].isPosted) {  // 이미 게시되어 있으면 추천수만 1증가
                students[vote].count++;     // 4번 조건 주의
                continue;
            }

            if (post.size() < postSize) {    // 사진틀이 비어있으면
                post.add(students[vote]);       // 게시하고

            } else {                          // 사진들이 차있으면
                Collections.sort(post);       // 추천순, 시간순으로 정렬하고
                post.get(0).isPosted = false; // 게시 여부 정보 바꾸고
                post.get(0).count = 0;        // 추천 수 0으로 변경
                post.remove(0);         // 기존 학생 제거하고
                post.add(students[vote]);     // 새로운 학생 게시
            }

            // 추천된 학생 정보 업데이트
            students[vote].count++;         // 추천수 1 증가하고
            students[vote].time = i;        // 포스팅 시간 업데이트하고
            students[vote].isPosted = true; // 포스팅 여부 업데이트
        }

        // 출력
        post.sort(Comparator.comparingInt(o -> o.index));
        post.forEach(student -> System.out.print(student.index + " "));
    }

    static class Student implements Comparable<Student> {
        int index;
        int count;
        int time;
        boolean isPosted;

        public Student(int index, int count, int time, boolean isPosted) {
            this.index = index;
            this.count = count;
            this.time = time;
            this.isPosted = isPosted;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count == o.count) {
                return this.time - o.time;
            }
            return this.count - o.count;
        }
    }
}

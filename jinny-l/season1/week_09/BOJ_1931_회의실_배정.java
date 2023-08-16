package season1.week_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 회의 수 입력
        int N = Integer.parseInt(br.readLine());

        // 회의 시간 입력
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        // 정렬
        Collections.sort(meetings);

        // 그리디
        int count = 1;
        int previousEndTime = meetings.get(0).end;
        for (int i = 1; i < N; i++) {
            int nextStartTime = meetings.get(i).start;

            if (nextStartTime >= previousEndTime) { // 다음 회의 시작 시간이 이전 회의 시간 종료 이후라면 회의 개수 증가
                previousEndTime = meetings.get(i).end; // 이전 회의 종료 시간 갱신
                count++;
            }
        }
        System.out.println(count);
    }

    private static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if (end == meeting.end) { // 종료 시간 기준으로 정렬하되, 똑같으면 일찍 시작하는거 먼저
                return Integer.compare(start, meeting.start);
            }
            return Integer.compare(end, meeting.end);
        }
    }
}

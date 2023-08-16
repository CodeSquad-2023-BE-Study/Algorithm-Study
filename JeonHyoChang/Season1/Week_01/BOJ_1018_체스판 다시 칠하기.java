import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main03 {
    public static int getCheckCount(List<String[]> boardList, String[] start01, String[] start02, int boardX, int boardY) {
        int count = 0;
        for (int i = boardX; i < 8 + boardX; i++) {
            for (int j = boardY, strCount = 0; j < 8 + boardY; j++, strCount++) {
                if ((i - boardX) % 2 == 1) {
                    if (!boardList.get(i)[j].equals(start02[strCount])) count++;
                } else {
                    if (!boardList.get(i)[j].equals(start01[strCount])) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        List<String[]> boardList = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            String str = "";
            str = br.readLine();

            boardList.add(str.split(""));
        }

        String[] wStart = {"W", "B", "W", "B", "W", "B", "W", "B"};
        String[] bStart = {"B", "W", "B", "W", "B", "W", "B", "W"};

        List<Integer> countList = new ArrayList<>();

        for (int i = 7; i < x; i++) {
            for (int j = 7; j < y; j++) {
                countList.add(getCheckCount(boardList, wStart, bStart, i - 7, j - 7));
                countList.add(getCheckCount(boardList, bStart, wStart, i - 7, j - 7));
            }
        }

        Collections.sort(countList);
        System.out.println(countList.get(0));
    }
}
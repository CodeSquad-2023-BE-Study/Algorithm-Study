import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        List<Integer[]> square = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            String str = "";
            str = br.readLine();

            square.add(Arrays.stream(str.split("")).map(Integer::parseInt).toArray(Integer[]::new));
        }

        int min_size = Math.min(x, y);
        boolean roof_check = true;

        while (min_size > 1 && roof_check) {
            for (int i = 0; i + min_size - 1 < x && roof_check; i++) {
                for (int j = 0; j + min_size - 1 < y && roof_check; j++) {
                    if (square.get(i)[j] == square.get(i + min_size - 1)[j]
                            && square.get(i)[j] == square.get(i)[j + min_size - 1]
                            && square.get(i)[j] == square.get(i + min_size - 1)[j + min_size - 1]) {
                        roof_check = false;
                        break;
                    }
                }
            }

            if (roof_check) min_size--;
        }

        System.out.println(min_size * min_size);
    }
}
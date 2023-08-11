import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main02 {
    public static void get_dwarfs(List<Integer> nine_dwarfs) {
        int sum = nine_dwarfs.stream().mapToInt(i -> i).sum();
        boolean break_check = true;

        for (int i = 0; i < 8 && break_check; i++) {
            for (int j = i + 1; j < 9 && break_check; j++) {
                if (sum - nine_dwarfs.get(i) - nine_dwarfs.get(j) == 100) {
                    break_check = false;
                    nine_dwarfs.remove(j);
                    nine_dwarfs.remove(i);

                    nine_dwarfs.forEach(System.out::println);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> nine_dwarfs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();

            nine_dwarfs.add(Integer.parseInt(str));
        }

        Collections.sort(nine_dwarfs);
        get_dwarfs(nine_dwarfs);
    }
}

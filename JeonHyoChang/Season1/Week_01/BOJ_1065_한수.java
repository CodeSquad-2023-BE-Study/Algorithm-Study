import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);

        int hansu = 0;
        if (num < 100) System.out.println(num);
        else {
            for (int i = 111; i <= num; i++) {
                int i_100 = i / 100;
                int i_10 = (i / 10) % 10;
                int i_1 = i % 10;

                if (i_100 - i_10 == i_10 - i_1) hansu++;
            }

            System.out.println(hansu + 99);
        }
    }
}

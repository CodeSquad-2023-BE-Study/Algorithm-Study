package season2._230825;

public class PGS_문자열_압축 {

    public static void main(String[] args) {
        System.out.println(solution("a" ));
    }

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        String prev = "";
        String tmp = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s.length() / 2; i++) {
            for (int j = 0; j < s.length(); j += i) {

                if ((j + i) > s.length()) { // 남은 문자열이 자르는 길이보다 짧을 때 처리
                    tmp = s.substring(j);
                } else {
                    tmp = s.substring(j, j + i);
                }

                if (!tmp.equals(prev)) { // 앞에 문자열이 다르면
                    if (count == 1 || prev.equals("")) {    // 개수가 1이면 문자열만 붙이고
                        sb.append(prev);
                    } else {
                        sb.append(count).append(prev); // 아니면 숫자와 문자열 붙인다.
                    }
                    prev = tmp;
                    count = 0;
                }
                count++;
            }

            // 문자열 비어있는지 확인
            if (!prev.equals("")) {
                if (count == 1) {    // 개수가 1이면 문자열만 붙이고
                    sb.append(prev);
                } else {
                    sb.append(count).append(prev); // 아니면 숫자와 문자열 붙인다.
                }
                prev = "";
                count = 0;
            }

            min = Math.min(min, sb.length());
            sb = new StringBuilder();
        }
        if (s.length() == 1) {
            return 1;
        }
        return min;
    }

}

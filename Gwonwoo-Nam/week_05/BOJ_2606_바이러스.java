import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BOJ_2606_바이러스 {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfComputers = Integer.parseInt(br.readLine());


        List<List<Integer>> nodes = new ArrayList<>();
        boolean[] visited = new boolean[numberOfComputers];
        int numberOfConnections = Integer.parseInt(br.readLine());
        for (int i=0; i<numberOfConnections; i++) {
            List<Integer> graph = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            nodes.add(graph);
        }

        dfs(0, visited, nodes);
        System.out.println(count - 1);
    }

    public static void dfs(int computer, boolean[] visited, List<List<Integer>> nodes) {
        visited[computer] = true;
        count++;
        for (List<Integer> node : nodes) {
            //감염된 노드를 포함하고, 둘 중 하나를 방문한 적이 없을 때.
            if (node.get(0) - 1 == computer && visited[node.get(1) - 1] == false) {
                dfs(node.get(1) - 1, visited, nodes);
            }
            if (node.get(1) - 1 == computer && visited[node.get(0) - 1] == false) {
                dfs(node.get(0) - 1, visited, nodes);
            }
        }
    }
}

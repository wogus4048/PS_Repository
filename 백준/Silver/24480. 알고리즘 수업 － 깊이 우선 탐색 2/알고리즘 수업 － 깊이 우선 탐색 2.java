import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    dfs , 시작정점에서 시작해서 dfs를 하고
    각 정점에 대하여 몇번째 방문되는지를 출력, 시작정점에서 dfs했는데 도착못하는 정점이면 0을 출력
     */

    static boolean[] visited;
    static int n,m,start;
    static ArrayList<Integer>[] graph  = new ArrayList[n+1]; // 그래프용 리스트배열

    static int[] rank = new int[100001];
    static int rankCount = 2;


    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        start = input[2];
        graph = new ArrayList[n+1];
        visited = new boolean[n + 1];
        for (int a = 1; a <= n; a++) {
            graph[a] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[input[0]].add(input[1]);
            graph[input[1]].add(input[0]);
        }
        for (int a = 1; a <= n; a++) {
            graph[a].sort(Comparator.reverseOrder());
        }

    }

    static void solve() throws IOException {
        rank[start] = 1;
        visited[start] = true;

        dfs(start);

        for (int i = 1; i <= n; i++) {
            if (rank[i] == 0) {
                bw.write(0+"\n");
                continue;
            }
            bw.write(rank[i]+"\n");
        }

    }

    static void dfs(int node) throws IOException {

        for (int nearNode : graph[node]) {
            if (!visited[nearNode]) {
                visited[nearNode] = true;
                rank[nearNode] = rankCount;
                rankCount++;
                dfs(nearNode);
            }
        }

    }

}
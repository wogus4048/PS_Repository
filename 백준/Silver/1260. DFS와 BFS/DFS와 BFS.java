import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*

     */

    static List<Integer>[] graph;
    static int n,m,start;
    static Scanner sc = new Scanner(System.in);

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        graph = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
//            if (!graph[u].contains(v)) {
//                graph[u].add(v);
//            }
//            if (!graph[v].contains(u)) {
//                graph[v].add(u);
//            }
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }

    }

    static void solve() throws IOException {
        dfs(start);
        visited = new boolean[n + 1];
        bw.newLine();
        bfs();

    }

    static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.write(node+" ");

        for (int nextNode : graph[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }

    static void bfs()throws IOException {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            bw.write(node+" ");

            for (int nextNode : graph[node]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }

}

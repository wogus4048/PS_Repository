

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m,r;

    static List<Integer>[] graph;
    static boolean[] visited;
    static Integer[] result;
    static int count =1;
    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);
        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] nodeInput = br.readLine().split(" ");
            int start = Integer.parseInt(nodeInput[0]) ;
            int end = Integer.parseInt(nodeInput[1]) ;

            graph[start].add(end);
            graph[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.reverseOrder());
        }

        result = new Integer[n + 1];
        result[r] = count++;
        visited[r] = true;

        dfs(r);

        for (int i = 1; i <= n; i++) {
            if (result[i] == null) {
                bw.write(0 + "\n");
            } else {
                bw.write(result[i] + "\n");
            }
        }



    }
    static void solve() throws IOException {



    }

    static void dfs(int node) {

        for (int adjNode : graph[node]) {
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                result [adjNode] = count++;

                dfs(adjNode);

            }
        }


    }






}



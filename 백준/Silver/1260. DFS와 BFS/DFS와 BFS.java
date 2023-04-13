

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

    static int n,e,v;

    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] result1;
    static int[] result2;

    static int count=1;
    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        visited = new boolean[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);

            graph[start].add(end);
            graph[end].add(start);
        }
        for (int i = 1; i <= n; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }
        result1 = new int[n + 1];
        result2 = new int[n + 1];


        visited[v] = true;
        result1[count] = v;
        count++;
        dfs(v);

        visited = new boolean[n+1];
        count =1;
        bfs(v);

        for (int i=1 ; i<=n;i++) {
            if (result1[i] != 0) {
                bw.write(result1[i]+ " ");
            }
        }
        bw.newLine();
        for (int i=1 ; i<=n;i++) {
            if (result2[i] != 0) {
                bw.write(result2[i]+ " ");
            }
        }

    }
    static void solve() throws IOException {



    }
    static void bfs(int node) throws IOException {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int currentNode = q.poll();
            visited[currentNode] = true;
            result2[count] = currentNode;
            count++;

            for (int adjNode : graph[currentNode]) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    q.add(adjNode);
                }
            }
        }



    }

    static void dfs(int node) throws IOException {

        for (int adjNode : graph[node]) {
            if (!visited[adjNode]) {
                result1[count] = adjNode;
                count++;
                visited[adjNode] = true;
                dfs(adjNode);
            }
        }

    }







}



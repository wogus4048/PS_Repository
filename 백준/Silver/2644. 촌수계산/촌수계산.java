

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<Integer>[] graph;
    static boolean[] visited;
    static int n,e,start,end;

    static int result = -1;


    /*
    * 그래프로 만들고, 주어진 노드에서 목표노드까지 최단거리를 구하면된다. 즉 몇개노드를 지나야 해당 노드에 도착하는지 (목표노드도 갯수에 포함)
    * */
    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        e = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int s =  Integer.parseInt(edgeInfo[0]);
            int e =  Integer.parseInt(edgeInfo[1]);

            graph[s].add(e);
            graph[e].add(s);
        }

        visited = new boolean[n + 1];


    }
    static void solve() throws IOException {
        bfs();
        System.out.println(result);


    }

    static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {

            int[] current = q.poll();
            int currentNode = current[0];
            int currentStep = current[1];

            if (currentNode == end) {
                result = currentStep;
                return;
            }

            for (int adjNode : graph[currentNode]) {
                if (!visited[adjNode]) {
                    q.add(new int[]{adjNode, currentStep + 1});
                    visited[adjNode] = true;
                }
            }

        }


    }




}



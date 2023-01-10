import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int v, e;
    static long[] cost; // 10만개 간선 * 10만의 비용 => 최대 비용 10만^2이므로 long
    static List<List<Node>> graph;
    static final int maxRange = 100000 * 100000;


    /*
    최단비용 해결문제이다. 가중치가 서로 다르고, 양수이므로 다익스트라를 사용한다.
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        cost = new long[v+1];
        Arrays.fill(cost, maxRange + 1);
        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            graph.get(edgeInfo[0]).add(new Node(edgeInfo[1], edgeInfo[2]));
        }


    }

    static void solve() throws IOException {
        for (int i = 1; i <= v; i++) {
            dijkstra(i);
            for (int j = 1; j <= v; j++) {
                if (i == j || cost[j] == maxRange+1) {
                    bw.write(0 + " ");
                } else {
                    bw.write(cost[j]+" ");
                }
            }
            bw.newLine();
            Arrays.fill(cost,maxRange+1);
        }

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));
        cost[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node pqNode = pq.poll();

            if (cost[pqNode.index] < pqNode.cost) {
                continue;
            }

            for (Node adjNode : graph.get(pqNode.index)) {
                if (cost[adjNode.index] > cost[pqNode.index] + adjNode.cost) {
                    cost[adjNode.index] = cost[pqNode.index] + adjNode.cost;
                    pq.add(new Node(adjNode.index, cost[adjNode.index]));
                }
            }

        }

    }


    static class Node {

        int index;
        long cost;

        public Node(int index, long cost) {
            this.index = index;
            this.cost = cost;
        }
    }


}
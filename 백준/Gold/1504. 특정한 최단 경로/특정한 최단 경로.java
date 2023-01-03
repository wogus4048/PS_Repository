import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    방향성이 없다 == 양방향
    1 ~ v1까지 최소비용 v1~ v2 까지 최소비용 v2 ~ n까지 최소비용과
    1 ~ v2 , v2~ v1, v1 ~ n 까지 더한것을 서로 최소비용 비교.
     */


    static int v,e,v1,v2;
    static int[] distance;
    static boolean[] visited;
    static List<List<Node>> graph = new ArrayList<>();

    static final int maxCost = 200000 * 1000;

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException{
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = input[0];
        e = input[1];
        visited = new boolean[v + 1];
        distance = new int[v + 1];
        Arrays.fill(distance,maxCost);
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            graph.get(edgeInfo[0]).add(new Node(edgeInfo[1], edgeInfo[2]));
            graph.get(edgeInfo[1]).add(new Node(edgeInfo[0], edgeInfo[2]));
        }
        int[] vv = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v1 = vv[0];
        v2 = vv[1];
    }

    static void solve() throws IOException{
        //지나갔던 간선을 다시 이동할 수 있다. -> 각각 시작노드와 끝노드를 주고 다익스트라를 돌리면서 , 시작노드 -> 끝노드 최소비용을 구하기때문에, 다른 다익스트라가 지나갔던 경로따윈 신경쓰지않고 결과를 구한다.
        //그러므로 지나갔던 간선까지 자동으로 고려된다.
        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, v);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, v);

        int answer = (result1 >= maxCost && result2 >= maxCost) ? -1 :Math.min(result1, result2);
        bw.write(answer+"");
    }

    static int dijkstra(int start,int end) throws IOException {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        Arrays.fill(distance, maxCost);
        Arrays.fill(visited, false);

        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node currentNode = pq.poll();
            int currentNodeIndex = currentNode.index;
            int currentNodeCost = currentNode.cost;

//            if (currentNodeIndex == end) { //해당 노드를 뽑았다면 , 그 노드는 확정된 최소비용값(갱신되지않는)이 저장되어있다, 그러므로 더 보지 않고 리턴해도된다.
//                return distance[end];
//            }

            if (visited[currentNodeIndex]) {
                continue;
            }
            visited[currentNodeIndex] = true;

            for (Node adjNode : graph.get(currentNodeIndex)) {
                if (!visited[adjNode.index]
                    && distance[adjNode.index] > distance[currentNodeIndex] + adjNode.cost) {
                    distance[adjNode.index] = distance[currentNodeIndex] + adjNode.cost;
                    pq.add(new Node(adjNode.index, distance[adjNode.index]));
                }
            }
        }
        return distance[end]; //큐가 다 빌때까지 기다렸다가 값을 리턴해도된다.
    }

    static class Node {
        int index;
        int cost;
        public Node (int index,int cost) {
            this.index = index;
            this.cost = cost;
        }
    }


}
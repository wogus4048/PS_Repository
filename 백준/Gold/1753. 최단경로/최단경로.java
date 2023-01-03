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
     */

    static boolean[] visited;
    static int v,e,start;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] distance;


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        v = input[0]; //정점
        e = input[1]; //간선
        start = Integer.parseInt(br.readLine());
        visited = new boolean[v + 1]; // 방문배열도 초기화해준다.
        distance = new int[v + 1]; //출발지 ~ 노드 까지 최단거리(비용)을 저장할 배열, 배열인덱스를 노드인데게스와 같게 사용하기 위해서 크기는 v+1
        Arrays.fill(distance, Integer.MAX_VALUE); //거리 배열을 최댓값으로 초기화해둔다.

        for (int i = 0; i < v+1; i++) { //그래프 리스트 초기화 , 리스트인덱스를 노드인덱스와 같게사용하기 위해서 크기는 v+1
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) { //간선의 수만큼, graph 리스트에 값 추가. 출발노드,도착노드,비용 으로 들어온다.
            int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            graph.get(edgeInfo[0]).add(new Node(edgeInfo[1], edgeInfo[2]));
        }

    }
    static void solve() throws IOException {
        dijkstra();
        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i]+"\n");
            }
        }

    }

    static void dijkstra() throws IOException {
        //우선순위큐를 이용한다. 비용을 정렬기준으로 전달한다.(비용이 낮은것이 우선순위가 높다.)
        PriorityQueue<Node> pq = new PriorityQueue<>( (o1,o2) ->  o1.cost - o2.cost);

        //출발노드는 자기자신에게 가는 비용은 0이므로 0으로 초기화하고 우선순위큐에 넣는다.
        distance[start] = 0;
        pq.add(new Node(start, 0)); // 큐에 넣을때는 (노드인덱스, 해당 인덱스까지 가는 최소비용)로 넣는다.

        while (!pq.isEmpty()) { //우선순위큐가 빌때까지 반복한다.

            Node currentNode = pq.poll();

            if (visited[currentNode.index]) { //방문했던 노드라면 넘어간다. (방문된 노드라면 , distance[해당 노드인덱스] 값은 최소비용이고, 더이상 갱신되지 않는다.
                continue;
            }
            visited[currentNode.index] = true;

            for (Node adjNode : graph.get(currentNode.index)) {
                int adjNodeIndex = adjNode.index;
                int adjNodeCost = adjNode.cost;
                if ( !visited[adjNodeIndex] && distance[adjNodeIndex] > adjNodeCost + distance[currentNode.index]) {
                    distance[adjNodeIndex] = adjNodeCost + distance[currentNode.index];
                    pq.add(new Node(adjNodeIndex, distance[adjNodeIndex]));
                }
            }
        }

    }
    static class Node {
        int index;
        int cost;
        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }



}
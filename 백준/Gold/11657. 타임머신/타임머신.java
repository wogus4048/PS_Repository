import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int v,e;

    static List<List<Edge>> graph ;
    static long[] time;
    static final int maxRange = 60000000;

    /*
     */

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        //초기화 작업들
        time = new long[v + 1];
        Arrays.fill(time, maxRange + 1);
        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            graph.get(edgeInfo[0]).add(new Edge(edgeInfo[1], edgeInfo[2])); //단방향
//            graph.get(edgeInfo[1]).add(new Edge(edgeInfo[0], edgeInfo[2]));  양방향일 경우 추가
        }
    }

    static void solve() throws IOException {
        if (bellmanFord()) {
            for (int i = 2; i <= v; i++) {
                if (time[i] == maxRange + 1) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(time[i]+"\n");
                }
            }
        } else {
            bw.write(-1+"");
        }
    }
    static boolean bellmanFord() throws IOException {
        time[1] = 0;

        for (int i = 1; i < v; i++) { //(정점의 개수 -1)번 만큼 최소비용 초기화 작업 반복한다.
            for (int j = 1; j <= v; j++) { //초기화 작업 ==> 모든 간선을 살피며 최소비용값 업데이트를 한다
                for (Edge edge : graph.get(j)) { //해당 노드와 연결된 모든 간선에 대해 체크한다. (모든 간선을 살피기 위해 각 노드에 연결된 모든 간선을 가져온다)
                    if (time[j] == maxRange + 1) { // 지금 노드로 가는 길에 대한 비용이 아직 업데이트 되지않았다면, 그 길 + 간선 을 이용한 비용업데이트를 할 수 없으니 넘어간다.
                        break; // 다음 노드로
                    }
                    if (time[edge.index] > time[j] + edge.cost) { //원래 저장된 간선의 도착지(인접노드)를 가는 최소비용이  지금 노드가는 비용 + 간선의비용 보다 크다면 갱신시켜준다.
                        time[edge.index] = time[j] + edge.cost;
                    }
                }
            }
        }

        //위에서 (정점의개수-1)번 최소비용값을 초기화해줘서 초기화가 완료됬다. 1번 더했는데 값이 업데이트가 되는경우가 있다면 음수사이클이 존재하므로 실패를 의미한다.
        for (int j = 1; j <= v; j++) {
            for (Edge edge : graph.get(j)) {
                if (time[j] == maxRange + 1) { //maxRange+1은 초기값을 의미
                    break;
                }
                if (time[edge.index] > time[j] + edge.cost) {
                    return false; //수정될게 있다 -> 음수사이클이 존재해서 , 초기화작업을 할때마다 값이 더 작아질것이다 ( 비용이 무한히 작아지는 음수사이클이 존재)
                }
            }
        }

        return true;// 음수사이클이 없다면 성공


    }

    static class Edge {  //다익스트라에서는 이름이 Node라고하고 내용은 같았다 , 인접노드로 가는 간선이므로 정확히는 Edge라는 표현이 맞는거같다.
        int index;
        int cost;

        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }


}
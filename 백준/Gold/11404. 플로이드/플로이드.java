
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int v, e;
    static long[][] cost;
    static final long maxRange = 100000L * 100000;
    /*
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
        cost =new long[v+1][v+1];
        //인접행렬 초기화
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else {
                    cost[i][j] = maxRange + 1; //최대값으로 초기화
                }
            }
        }
        //입력된 간선 정보를 이용하여 인접행렬 초기화
        for (int i = 0; i < e; i++) {
            int[] edgeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
            //두 정점사이에 많은 간선이 있을 수 있다. 그러면 들어오는 간선 정보중 가장 작은값을 인접행렬에 저장하기 위함.
            cost[edgeInfo[0]][edgeInfo[1]] = Math.min(cost[edgeInfo[0]][edgeInfo[1]], edgeInfo[2]);
        }

    }

    static void solve() throws IOException {
        floyd();
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (cost[i][j] == maxRange + 1) {
                    bw.write(0 + " ");
                } else {
                    bw.write(cost[i][j]+" ");
                }
            }
            bw.newLine();
        }

    }

    static void floyd() {
        //각각 모든 정점을 경유해서 가는 경우를 생각해본다.
        for (int i = 1; i <= v; i++) {
            // j->k를 갈때 cost[j][k]의 비용이 더 작을지 아니면 j->i  i->k 처럼 i 노드를 경유해서 가는것이 더 비용이 적은지 체크하고, 갱신해준다.
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if (cost[j][k] > cost[j][i] + cost[i][k]) {
                        cost[j][k] = cost[j][i] + cost[i][k];
                    }
                }
            }
        }
    }

}
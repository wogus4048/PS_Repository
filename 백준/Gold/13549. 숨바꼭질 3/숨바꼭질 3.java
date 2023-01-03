import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    /*
    예전에 숨바꼭질 문제랑 뭐가다른걸까. -> 순간이동 소요시간이 0초였다.
    bfs를 이용해서 풀려고했지만 -> 실패
    원래 예전 숨바꼭질에서 bfs를 이용한다는것은 , 1초씩 지나가면서 +1,-1,*2를 한 경우들을 큐에 담는다, 그리고 담은 위치를 방문처리를 한다.
    그렇게해서 해당 시간에 모든 경우를 살펴볼 수 있어서, 목적지를 도달하는 최소시간을 확인 할 수 있었다.

    하지만 이번 문제를 bfs로 풀려면
    4 -> 6 으로 가는경우 ( 4 , 3 , 6 ) 으로 시간이 1초가 나와야하는데 ( 4 , 5 , 6 ) 이런식으로 먼저 방문해버리면 2초가 나와버립니다.
    물론 이건 ( *2, -1, +1) 순으로 검사하면 걸리지않지만 (*2, +1, -1) 로 하는 경우 걸리게 되는 문제입니다.
    만약 (*2, +1, -1)로 BFS의 코드를 작성하신 경우 해당 목표값에 도달했다고 바로 값을 출력하지 마시고, 방문시간을 계산해서 최소값으로 갱신해주는 방식으로 접근해야 합니다.
    ----
    4 6 을 계산하는데 (*2, +1, -1) 순으로 큐에 값을 넣었다면 4,5,6으로 2초가 나오면서 bfs가 종료한다.
    그래서 4 -> 3 -> 6 순서대로 1초만에 6에 도달하는 경우를 확인 못하게 된다.
    그러므로 큐가 빌때까지 == 모든 경우를 살펴보고,  목적지에 도달했을때 최소시간인지 확인해서 갱신해준다.
     */

    static int n, k,answer;
    static final int maxRange = 100000;
    static boolean[] visited = new boolean[maxRange+1];


    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        answer = Integer.MAX_VALUE;

    }

    static void solve() throws IOException {
        bfs();
        bw.write(answer+"");
    }

    static void bfs() throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = true;

        while (!q.isEmpty()) {

            int[] current = q.poll();
            int currentPosition = current[0];
            int time = current[1];

            if (currentPosition == k) {
                answer = Math.min(answer, time);
            }

            if (currentPosition *2  <= maxRange && !visited[currentPosition*2] ) {
                visited[currentPosition *2] = true;
                q.add(new int[]{currentPosition*2, time});
            }
            if (currentPosition - 1 >= 0 && !visited[currentPosition-1] ) {
                visited[currentPosition - 1] = true;
                q.add(new int[]{currentPosition-1, time + 1});
            }
            if (currentPosition + 1 <= maxRange && !visited[currentPosition+1] ) {
                visited[currentPosition + 1] = true;
                q.add(new int[]{currentPosition+1, time + 1});
            }



        }

    }


}
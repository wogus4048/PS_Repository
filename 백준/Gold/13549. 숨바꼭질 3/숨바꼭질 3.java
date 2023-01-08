import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,k;
    static final int maxRange = 100000;
    static boolean[] visited = new boolean[maxRange+1];


    //bfs로 먼저 풀이,
    //bfs로 풀게되면 곱셈과 덧셈뺄셈의 가중치가 서로 다르기 때문에 가중치 , 즉 비용이 작은것부터 큐에 넣어야한다. 최소비용을 사용해서 도달하는경우를 찾아야하니까.
    //비용이 같은 덧셈과 뺄셈의 경우, 비용이 작은 곱셈과 조합해서 사용하였을때 어떤 기호가 더 유용한지 생각해야한다.
    //덧셈같은경우 해당숫자+1 의 곱으로 값을 찾게된다. 못찾으면 또 +1 해서 곱셈을 반복해보는.. 즉 원하는 목적지 좌표값을 나눌수있는수를 덧셈으로 찾는것이다.
    //그것보다는 뺄셈으로 진행시 점점값이 작아지므로, 목적지 좌표값을 나눌 수 있는 가능성이 훨씬 커진다. 그래서 결과적으로 곱셈,뺄셈,덧셈 순서대로 큐에 넣는다.

    public static void main(String[] args) throws IOException {
        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        k = input[1];


    }
    static void solve() throws IOException {
        bfs();
    }
    static void bfs() throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentPosition = current[0];
            int currentTime = current[1];

            if (currentPosition == k) {
                bw.write(currentTime+"");
                return;
            }

            if (currentPosition * 2 <= maxRange && !visited[currentPosition * 2 ]) {
                visited[currentPosition * 2 ] = true;
                q.add(new int[]{currentPosition * 2 , currentTime});
            }

            if (currentPosition - 1 >= 0  && !visited[currentPosition - 1]) {
                visited[currentPosition - 1] = true;
                q.add(new int[]{currentPosition - 1, currentTime + 1});
            }

            if (currentPosition + 1 <= maxRange && !visited[currentPosition + 1]) {
                visited[currentPosition + 1] = true;
                q.add(new int[]{currentPosition + 1, currentTime + 1});
            }


        }

    }

}
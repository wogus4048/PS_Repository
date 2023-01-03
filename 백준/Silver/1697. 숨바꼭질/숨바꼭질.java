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


    /*
       bfs 최단시간을 찾는문제.
       이미 들렸던 위치는 큐에 다시 넣는일이 없어야한다. bfs는 시간순서대로 이동하는데(트리의 레벨단위 이동처럼) 이미 들렸던곳이라는것은 현재보다 이른시간에 들렸다는것이므로 최소시간이 될 수 없는경우다.
       다음으로 확인해볼 위치가 범위를 넘는지, 방문했던곳인지 체크한다.
       이런 경우에 대해 조건처리를 해줘야 메모리초과가 발생하지않는다.
     */

    static int n,k;
    static final int maxRange = 100000;
    static boolean[] visited = new boolean[maxRange+1];


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
        visited[n] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int currentPosition = current[0];
            int currentTime = current[1];
            
            
            if (currentPosition == k) {
                bw.write(currentTime+"");
                bw.flush();
                System.exit(0);
            }

            //수에범위가 벗어나는지를 먼저 체크해줘야한다. 그래야 인덱스 에러가 발생하지않음.
            if (currentPosition + 1<=maxRange && !visited[currentPosition + 1] ) {
                visited[currentPosition + 1] = true;
                q.add(new int[]{currentPosition+1,currentTime+1}); // 1초뒤 앞으로 한칸 이동한경우
            }
            if ( (currentPosition-1) >= 0 && !visited[currentPosition - 1]) {
                visited[currentPosition - 1] = true;
                q.add(new int[]{currentPosition-1,currentTime+1});// 1초뒤 뒤로 한칸 이동한경우
            }
            if (currentPosition * 2 <= maxRange && !visited[currentPosition * 2]) {
                visited[currentPosition *2] = true;
                q.add(new int[]{currentPosition * 2, currentTime + 1});// 1초뒤 순간이동한 경우
            }

        }

    }

}

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
    dfs 또는 bfs를 1회 진행했을때 방문되는 배추들이 하나의 그룹이다, dfs 또는 bfs를 진행후 같은 그룹의 배추들은 방문처리가 된다.
    전체 배추밭 배열을 돌면서 배추이면서 방문이 되지않은 배추에대해 bfs 또는 dfs를 진행한다. 그렇게 총 몇번 진행했냐가 배추그룹의 수이고 즉 필요한 벌레의 수다.

     */

    static int[][] map;
    static boolean[][] visited;
    static int testcase;
    static int m,n,k;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count =0;




    public static void main(String[] args) throws IOException {

        input();
        solve();

        bw.flush();
        bw.close();

    }

    static void input() throws IOException {
        testcase = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {

        for (int t = 0; t < testcase; t++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = input[0];
            n = input[1];
            k = input[2];
            map = new int[n][m]; //int형은 기본값이 0이므로 따로 초기화하지않는다.
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
                int x = position[0];
                int y = position[1];
                //배추가있는곳에 1을 표시한다.
                map[y][x] = 1;
            }
            //dfs 또는 bfs를 돌린다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        dfs(i,j);
                    }
                }
            }
            bw.write(count+"\n");
            count =0;
        }


    }

    static void dfs(int x,int y) throws IOException {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
                    dfs(nextX, nextY);
                }
            }
        }

    }
    static void bfs(int x, int y) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y}); //배추그룹의 첫번째 배추는 직접 넣어준다.
        visited[x][y] = true;

        while (!q.isEmpty()) { //그 그룹의 나머지배추는 bfs를 돌려서 방문한다.
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
                        visited[nextX][nextY] = true; //큐에 넣으면서 방문처리한다. 큐에 중복되서 들어가지않게하기위함.
                        q.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

    }

}
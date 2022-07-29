import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, m;
  static boolean[][][] visited;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };
  static int[][] map;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    visited = new boolean[2][n][m];
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      for (int j = 0; j < m; j++) {
        int temp2 = temp.charAt(j) - '0';
        map[i][j] = temp2;
      }
    }
    // for (int[] a : map) {
    //   bw.write(Arrays.toString(a) + "\n");
    // }

  }

  public static void solve() throws IOException {
    bw.write(bfs() + "\n");

  }

  public static int bfs() throws IOException {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { 0, 0, 1, 1 }); // 0.0에서 시작, 벽부실수있는횟수 1, step 1

    while (!q.isEmpty()) {
      int[] current = q.poll();
      int current_x = current[0];
      int current_y = current[1];
      int wall_count = current[2];
      int current_step = current[3];

      if (current_x == n - 1 && current_y == m - 1) {
        return current_step;
      }

      for (int i = 0; i < 4; i++) {
        int next_x = current_x + dx[i];
        int next_y = current_y + dy[i];

        if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m) {
          if (wall_count > 0) // 벽을 부실수 있는 기회가있다면
          {
            if (map[next_x][next_y] == 1) // 그런데 마침 앞이 벽이야
            {
              if (!visited[wall_count - 1][next_x][next_y]) // 부셔본 벽도 아님
              {
                q.add(new int[] { next_x, next_y, wall_count - 1, current_step + 1 }); // 그럼이동
                visited[wall_count - 1][next_x][next_y] = true;
              } // 부셔본거라면 그냥 넘어감
            } else { // 벽 부실기회가있는데 벽이 아니라면
              if (!visited[wall_count][next_x][next_y]) {
                // 방문한적있는지 체크하고
                q.add(new int[] { next_x, next_y, wall_count, current_step + 1 }); // 그럼이동
                visited[wall_count][next_x][next_y] = true;
              }
            }

          } else { // 벽 부실 기회가없다면
            if (!visited[wall_count][next_x][next_y] && map[next_x][next_y] == 0) {
              // 방문한적있는지 체크하고 , 벽인지 체크하고
              q.add(new int[] { next_x, next_y, wall_count, current_step + 1 }); // 그럼이동
              visited[wall_count][next_x][next_y] = true;
            }
          }

        }
      }

    }
    return -1;

  }

}
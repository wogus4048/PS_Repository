import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int m, n, k, count, division_count;
  static boolean[][] visited;
  static int[][] map;
  static ArrayList<Integer> result = new ArrayList<>();
  static int[] di = { 1, -1, 0, 0 };
  static int[] dj = { 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    division_count = 0;

    visited = new boolean[m][n];
    map = new int[m][n];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int left_x = Integer.parseInt(st.nextToken());
      int left_y = Integer.parseInt(st.nextToken());

      int right_x = Integer.parseInt(st.nextToken()) - 1;
      int right_y = Integer.parseInt(st.nextToken()) - 1;

      for (int a = left_x; a <= right_x; a++) {
        for (int b = left_y; b <= right_y; b++) {
          if (map[b][a] != 1) {
            map[b][a] = 1;
          }
        }
      }

    }
    // for (int[] a : map) {
    // bw.write(Arrays.toString(a) + "\n");
    // }

  }

  static void solve() throws IOException {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 0 && !visited[i][j]) {
          count = 0;
          bfs(i, j);
          result.add(count);
          division_count++;
        }
      }
    }
    Collections.sort(result);
    bw.write(division_count + "\n");
    for (int a : result) {
      bw.write(a + " ");
    }

  }

  static void bfs(int i, int j) throws IOException {
    visited[i][j] = true;
    count++;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { i, j });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      for (int a = 0; a < 4; a++) {
        int next_i = current[0] + di[a];
        int next_j = current[1] + dj[a];

        if (0 <= next_i && next_i < m && 0 <= next_j && next_j < n) {
          if (!visited[next_i][next_j] && map[next_i][next_j] == 0) {
            queue.add(new int[] { next_i, next_j });
            count++;
            visited[next_i][next_j] = true;
          }
        }
      }

    }

  }

}

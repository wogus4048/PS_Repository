import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, max, min, count, area_max;
  static int[][] map;
  static boolean[][] visited;
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
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    // visited = new boolean[n][n];
    max = 0;
    min = 100;

    area_max = 0;

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int temp = Integer.parseInt(st.nextToken());
        max = Math.max(max, temp);
        min = Math.min(min, temp);
        map[i][j] = temp;
      }

    }

  }

  static void solve() throws IOException {
    for (int i = 0; i <= max; i++) {
      count = 0;
      visited = new boolean[n][n];
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (!visited[j][k] && map[j][k] > i) {
            count++;
            dfs(j, k, i);
          }

        }
      }
      area_max = Math.max(area_max, count);
    }
    bw.write(area_max + "");

  }

  static void dfs(int i, int j, int rain) throws IOException {
    visited[i][j] = true;

    for (int a = 0; a < 4; a++) {
      int next_i = i + di[a];
      int next_j = j + dj[a];

      if (0 <= next_i && next_i < n && 0 <= next_j && next_j < n) {
        if (!visited[next_i][next_j] && map[next_i][next_j] > rain) {
          dfs(next_i, next_j, rain);
        }
      }
    }

  }

}

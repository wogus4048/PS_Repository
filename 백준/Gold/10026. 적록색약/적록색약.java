import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, count1, count2;
  static char[][] map;
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

    map = new char[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      for (int j = 0; j < n; j++) {
        map[i][j] = temp.charAt(j);
      }
    }
    count1 = 0;
    count2 = 0;

  }

  static void solve() throws IOException {

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          count1++;
        }

      }
    }
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 'G') {
          map[i][j] = 'R';
        }
      }

    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
          count2++;
        }

      }
    }
    bw.write(count1 + " " + count2);
  }

  static void dfs(int i, int j) throws IOException {
    char color = map[i][j];

    for (int a = 0; a < 4; a++) {
      int next_i = i + di[a];
      int next_j = j + dj[a];

      if (0 <= next_i && next_i < n && 0 <= next_j && next_j < n) {
        if (!visited[next_i][next_j] && map[next_i][next_j] == color) {
          visited[next_i][next_j] = true;
          dfs(next_i, next_j);
        }
      }
    }

  }
}

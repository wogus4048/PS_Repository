import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int m;
  static int k;
  static boolean[][] map;
  static boolean[][] visited;
  static int ans;
  static int cnt;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new boolean[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int index_0 = Integer.parseInt(st.nextToken());
      int index_1 = Integer.parseInt(st.nextToken());
      map[index_0 - 1][index_1 - 1] = true;

    }
  }

  static void solve() throws IOException {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && map[i][j]) {
          cnt = 0;
          bfs(i, j);
          ans = Math.max(ans, cnt);
        }
      }
    }
    bw.write(ans + "");

  }

  static void bfs(int index0, int index1) throws IOException {
    Queue<point> q = new LinkedList<>();
    q.add(new point(index0, index1));
    visited[index0][index1] = true;
    cnt++;
    while (!q.isEmpty()) {
      point temp = q.poll();

      for (int k = 0; k < 4; k++) {
        int xx = temp.x + dx[k];
        int yy = temp.y + dy[k];
        if (xx < 0 || yy < 0 || xx >= n || yy >= m) {
          continue;
        }
        if (!visited[xx][yy] && map[xx][yy]) {
          q.add(new point(xx, yy));
          visited[xx][yy] = true;
          cnt++;
        }

      }

    }

  }

  static class point {
    int x;
    int y;

    public point(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }
  }

}

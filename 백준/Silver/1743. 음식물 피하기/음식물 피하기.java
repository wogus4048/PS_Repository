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
  static boolean[][] position;
  static boolean[][] visited;
  static int max = 0;
  static int count;
  static int[] d0 = { 0, 1, 0, -1 };
  static int[] d1 = { 1, 0, -1, 0 };

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

    position = new boolean[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int index_0 = Integer.parseInt(st.nextToken());
      int index_1 = Integer.parseInt(st.nextToken());
      position[index_0 - 1][index_1 - 1] = true;

    }
  }

  static void solve() throws IOException {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && position[i][j]) {
          count = 0;
          bfs(i, j);
          max = Math.max(max, count);
        }
      }
    }
    bw.write(max + "");

  }

  static void bfs(int index0, int index1) throws IOException {
    Queue<point> q = new LinkedList<>();
    q.add(new point(index0, index1));
    visited[index0][index1] = true;
    count++;
    while (!q.isEmpty()) {
      point temp = q.poll();

      for (int k = 0; k < 4; k++) {
        int xx = temp.x + d0[k];
        int yy = temp.y + d1[k];
        if (xx < 0 || yy < 0 || xx >= n || yy >= m) {
          continue;
        }
        if (!visited[xx][yy] && position[xx][yy]) {
          q.add(new point(xx, yy));
          visited[xx][yy] = true;
          count++;
        }

      }

    }

  }

}

class point {
  int x;
  int y;

  public point(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }
}

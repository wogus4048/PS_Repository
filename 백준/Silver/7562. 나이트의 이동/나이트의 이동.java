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
  static int test_case, n, count;
  static int[] target;
  static int[] start;
  static int[][] map;
  static boolean[][] visited;
  static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
  static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    for (int i = 0; i < test_case; i++) {
      n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      visited = new boolean[n][n];
      start = new int[2];
      target = new int[2];
      StringTokenizer st = new StringTokenizer(br.readLine());
      start[0] = Integer.parseInt(st.nextToken());
      start[1] = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      target[0] = Integer.parseInt(st.nextToken());
      target[1] = Integer.parseInt(st.nextToken());

      bw.write(bfs(start, target) + "\n");

    }

  }

  static int bfs(int[] start, int[] target) throws IOException {

    visited[start[0]][start[1]] = true;
    count = 0;
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[] { start[0], start[1], count });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int jump = current[2];

      if (x == target[0] && y == target[1]) {
        return jump;
      }

      for (int i = 0; i < 8; i++) {
        int xx = x + dx[i];
        int yy = y + dy[i];

        if (0 <= xx && xx < n && 0 <= yy && yy < n) {
          if (!visited[xx][yy]) {
            queue.add(new int[] { xx, yy, jump + 1 });
            visited[xx][yy] = true;
          }

        }

      }

    }
    return 0;

  }

}

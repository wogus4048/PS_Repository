import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
  static int result;

  static int[][] position;
  static boolean[][] visited;

  static int[] d0 = { 1, -1, 0, 0 };
  static int[] d1 = { 0, 0, 1, -1 };
  static Queue<int[]> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    position = new int[n][m];
    visited = new boolean[n][m];
    result = 0;

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        position[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    boolean check = true;
    loop1: for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (position[i][j] == -1 || position[i][j] == 0) {
          check = false;
          break loop1;
        }
      }
    }
    if (check) {
      bw.write(0 + "");
      bw.flush();
      bw.close();
      System.exit(0);
    }
    // for (int[] a : position) {
    // bw.write(Arrays.toString(a) + "\n");
    // }

  }

  static void solve() throws IOException {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (position[i][j] == 1 && !visited[i][j]) {
          queue.add(new int[] { i, j, 0 });
        }
      }
    }
    int result = bfs();

    //for (int[] a : position) {
   //   bw.write(Arrays.toString(a) + "\n");
   // }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (position[i][j] == 0) {
          bw.write(-1 + "\n");
          return;
        }
      }
    }

    bw.write(result + "\n");

  }

  static void test() throws IOException {

  }

  static int bfs() throws IOException {

    int current_day = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int current_x = current[0];
      int current_y = current[1];
      current_day = current[2];

      visited[current_x][current_y] = true;

      for (int i = 0; i < 4; i++) {
        int xx = current_x + d0[i];
        int yy = current_y + d1[i];

        if (0 <= xx && xx < n && 0 <= yy && yy < m) {
          if (!visited[xx][yy] && position[xx][yy] != -1) {
            if (position[xx][yy] == 0) {
              position[xx][yy] = 1;
            }
            visited[xx][yy] = true;
            queue.add(new int[] { xx, yy, current_day + 1 });
          }
        }

      }

    }
    return current_day;

  }

}

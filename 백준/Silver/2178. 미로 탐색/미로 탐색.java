import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int m;
  static boolean[][] check;
  static Queue<int[]> queue = new LinkedList<>();
  static int count = 1;
  static int[][] result;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    check = new boolean[n][m];

    result = new int[n][m];

    for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      for (int j = 0; j < m; j++) {
        result[i][j] = temp.charAt(j) - '0';
      }
    }

    for (int i = 0; i < n; i++) {
      Arrays.fill(check[i], false);
      // bw.write(Arrays.toString(check[i]) + "\n");
    }

  }

  static void solve() throws IOException {
    queue.add(new int[] { 0, 0 });
    bfs();

  }

  static void test() throws IOException {
  }

  static void bfs() throws IOException {
    int[] d0 = { 0, 1, 0, -1 };
    int[] d1 = { 1, 0, -1, 0 };

    while (true) {

      if (queue.isEmpty()) {
        break;
      }
      int[] temp = queue.poll();
      check[temp[0]][temp[1]] = true;
      // bw.write(String.format("지금위치:(%d,%d)\n", temp[0], temp[1]));
      if (temp[0] == n - 1 && temp[1] == m - 1) {
        bw.write(result[temp[0]][temp[1]] + "\n");
        break;
      }

      for (int i = 0; i < 4; i++) {
        int next_index_0 = temp[0] + d0[i];
        int next_index_1 = temp[1] + d1[i];

        if (0 <= next_index_0 && next_index_0 < n && 0 <= next_index_1 && next_index_1 < m) {
          if (!check[next_index_0][next_index_1] && result[next_index_0][next_index_1] == 1) {
            queue.add(new int[] { next_index_0, next_index_1 });
            result[next_index_0][next_index_1] = result[temp[0]][temp[1]] + 1;
          }
        }

      }

    }
    // for (int[] a : result) {
    // bw.write(Arrays.toString(a) + "\n");
    // }
  }

}

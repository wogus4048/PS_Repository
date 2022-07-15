import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main{
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int[][] map;
  static boolean[][] visited;
  static ArrayList<Integer> house_count = new ArrayList<>();
  static int total_dangi = 0;
  static int house_num;
  static int[] di = { 0, 1, 0, -1 };
  static int[] dj = { 1, 0, -1, 0 };

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
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      for (int j = 0; j < n; j++) {
        map[i][j] = temp.charAt(j) - '0';
      }
    }

    // for (int[] a : map) {
    // bw.write(Arrays.toString(a) + "\n");
    // }

  }

  static void solve() throws IOException {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          house_num = 0;
          bfs(i, j);
          house_count.add(house_num);
          total_dangi++;

        }

      }
    }
    Collections.sort(house_count);
    bw.write(total_dangi + "\n");
    for (int num : house_count) {
      bw.write(num + "\n");
    }

  }

  static void bfs(int i, int j) {
    visited[i][j] = true;
    house_num++;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { i, j });

    while (!queue.isEmpty()) {
      int[] current_ij = queue.poll();

      for (int a = 0; a < 4; a++) {
        int next_i = current_ij[0] + di[a];
        int next_j = current_ij[1] + dj[a];

        if (0 <= next_i && next_i < n && 0 <= next_j && next_j < n) {
          if (!visited[next_i][next_j] && map[next_i][next_j] == 1) {
            queue.add(new int[] { next_i, next_j });
            house_num++;
            visited[next_i][next_j] = true;
          }
        }

      }

    }

  }

}

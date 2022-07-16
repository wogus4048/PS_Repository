import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int L, R, C;
  static char[][][] building;
  static boolean[][][] visited;

  static int[] start;
  static int[] exit;

  static int[] dx = { 1, -1, 0, 0, 0, 0 };
  static int[] dy = { 0, 0, 1, -1, 0, 0 };
  static int[] dz = { 0, 0, 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {

  }

  static void solve() throws IOException {
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      if (!st.hasMoreTokens()) {
        continue;
      }
      L = Integer.parseInt(st.nextToken());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      if (L == 0 && R == 0 && C == 0) {
        break;
      }

      building = new char[L][R][C];
      visited = new boolean[L][R][C];

      int k = 0;
      while (k < L) {
        for (int i = 0; i < R; i++) {
          String temp = br.readLine();
          for (int j = 0; j < C; j++) {
            if (temp.charAt(j) == 'S') {
              start = new int[] { k, i, j };
            }
            if (temp.charAt(j) == 'E') {
              exit = new int[] { k, i, j };
            }
            building[k][i][j] = temp.charAt(j);

          }
        }
        String temp2 = br.readLine();
        k++;

      }

      // for (int a = 0; a < L; a++) {
      // for (int b = 0; b < R; b++) {
      // for (int c = 0; c < C; c++) {
      // bw.write(building[a][b][c] + " ");
      // }
      // bw.write("\n");
      // }
      // bw.write("\n");
      // }
      int result = bfs();
      if (result == 0) {
        bw.write("Trapped!\n");
      } else {
        bw.write(String.format("Escaped in %d minute(s).\n", result));
      }
    }

  }

  static int bfs() throws IOException {
    int z = start[0];
    int x = start[1];
    int y = start[2];
    int move = 0;

    visited[z][x][y] = true;

    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[] { z, x, y, move });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      int current_z = current[0];
      int current_x = current[1];
      int current_y = current[2];
      int current_move = current[3];

      if (current_z == exit[0] && current_x == exit[1] && current_y == exit[2]) {
        return current_move;
      }

      for (int i = 0; i < 6; i++) {
        int zz = current_z + dz[i];
        int xx = current_x + dx[i];
        int yy = current_y + dy[i];

        if (0 <= zz && zz < L && 0 <= xx && xx < R && 0 <= yy && yy < C) {
          if (!visited[zz][xx][yy] && building[zz][xx][yy] != '#') {
            visited[zz][xx][yy] = true;
            queue.add(new int[] { zz, xx, yy, current_move + 1 });
          }
        }

      }

    }

    return 0;

  }
}

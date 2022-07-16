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
  static int r, c, k, count;
  static char[][] map;
  static int[] target;
  static int[] di = { 1, -1, 0, 0, };
  static int[] dj = { 0, 0, 1, -1 };
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    map = new char[r][c];
    target = new int[2];
    visited = new boolean[r][c];
    for (int i = 0; i < r; i++) {
      String temp = br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = temp.charAt(j);
      }
    }

  }

  static void solve() throws IOException {

    int[] start = new int[] { r - 1, 0 }; // 맨왼쪽 끝이니까 인덱스는 다음과같다.
    target = new int[] { 0, c - 1 }; // 맨오른쪽 끝이니까 인덱스는 다음과같다.

    dfs(start, 1);
    bw.write(count + "");

  }

  static void dfs(int[] position, int move_count) throws IOException {
    int x = position[0];
    int y = position[1];
    visited[x][y] = true;

    if (move_count == k) {
      if (x == target[0] && y == target[1]) {
        count++;
      }
      return;
    }

    for (int i = 0; i < 4; i++) {
      int xx = x + di[i];
      int yy = y + dj[i];

      if (0 <= xx && xx < r && 0 <= yy && yy < c) {
        if (map[xx][yy] != 'T' && !visited[xx][yy]) {
          dfs(new int[] { xx, yy }, move_count + 1);
          visited[xx][yy] = false;
        }
      }

    }

  }

}

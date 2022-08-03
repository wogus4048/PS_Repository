import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.text.TabStop;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int r, c;
  static boolean[] alpha = new boolean[26 + 1]; // 인덱스1이 A임
  static boolean[][] visited;
  static char[][] map;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };
  static int max = 0;

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    map = new char[r][c];
    visited = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      String temp = br.readLine();
      for (int j = 0; j < c; j++) {
        map[i][j] = temp.charAt(j);
      }
    }

    // for (char[] a : map) {
    // bw.write(Arrays.toString(a) + '\n');
    // }

  }

  public static void solve() throws IOException {
    dfs(0, 0, 1); // 말은 좌측 1행1열에 놓여있다고하니까. 0,0에서 시작
    bw.write(max + "\n");

  }

  public static void dfs(int i, int j, int step) throws IOException {
    visited[i][j] = true;
    alpha[((int) map[i][j]) - 64] = true; // A가 인덱스 1에 들어감

    for (int a = 0; a < 4; a++) {// 상하좌우 체크해야함
      int next_x = i + dx[a];
      int next_y = j + dy[a];

      if (next_x >= 0 && next_x < r && next_y >= 0 && next_y < c) // 범위체크
      {
        if (!visited[next_x][next_y] && !alpha[(int) map[next_x][next_y] - 64]) // 방문 및 알파벳 중복체크
        {
          visited[next_x][next_y] = true;
          alpha[(int) map[next_x][next_y] - 64] = true;
          dfs(next_x, next_y, step + 1);

          // 다른곳으로 이동할거니까 전의 이동했던것은 false처리해준다.
          visited[next_x][next_y] = false;
          alpha[(int) map[next_x][next_y] - 64] = false;

        }

      }
    }
    // 반복문을 빠져나왔다 ==> 갈곳이없다.
    max = Math.max(max, step); // 현재 이동값을 max 최대값 비교
    return; // 현재 dfs 종료

  }

  static void test() throws IOException {

  }

}
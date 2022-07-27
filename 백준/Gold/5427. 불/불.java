import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int test_case;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = { 1, -1, 0, 0 };
  static int[] dy = { 0, 0, 1, -1 };

  public static void main(String[] args) throws IOException {
    input();
    solve();
    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());

  }

  public static void solve() throws IOException {
    for (int a = 0; a < test_case; a++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int j = Integer.parseInt(st.nextToken());
      int i = Integer.parseInt(st.nextToken());

      int[] start_position = new int[3]; // 상근이의 위치를 넣을곳.

      Queue<int[]> q = new LinkedList<>();

      map = new char[i][j];
      visited = new boolean[i][j];

      // 입력된값을 받으면서 처리할것 하는부분
      for (int b = 0; b < i; b++) {
        String temp = br.readLine();
        for (int c = 0; c < j; c++) {
          char temp2 = temp.charAt(c);
          map[b][c] = temp2;
          if (temp2 == '@') {
            start_position[0] = b; // 0은 이동횟수
            start_position[1] = c;
            start_position[2] = 0;

            visited[b][c] = true;

          } else if (temp2 == '*') {
            q.add(new int[] { b, c, -1 }); // 불과 상근이를 구별하기위해 불은 -1
            visited[b][c] = true;
          } else if (temp2 == '#') {
            visited[b][c] = true; // 벽은 미리 못가게 true로 해둔다.
          }
        }
      }

      // 불 다넣고 상근이 위치 넣어줌
      q.add(start_position);

      /// 입력된값과 큐에 넣어진값을 이용하여 처리할부분
      boolean check = false;
      loop: while (!q.isEmpty()) {

        int[] current = q.poll();

        int current_x = current[0];
        int current_y = current[1];
        int step = current[2];

        // bw.write(String.format("x : %d, y: %d , step: %d\n", current_x, current_y,
        // step));

        for (int d = 0; d < 4; d++) {
          int next_x = current_x + dx[d];
          int next_y = current_y + dy[d];

          // 범위를 안넘었을때
          if (next_x >= 0 && next_x < i && next_y >= 0 && next_y < j) {
            if (!visited[next_x][next_y]) {
              if (step == -1) {
                // 불이면 step값 그냥 -1로 큐에넣음
                q.add(new int[] { next_x, next_y, -1 });
                visited[next_x][next_y] = true;
              } else {
                // 상근이면 step값 증가해서 넣는다.
                q.add(new int[] { next_x, next_y, step + 1 });
                visited[next_x][next_y] = true;
              }
            }
          }
          // 범위를 넘었을때
          else {
            if (step >= 0) // 근데 그게 상근이인지 체크 , 불은 -1이므로
            {
              bw.write(step + 1 + "\n");
              check = true;
              break loop;
            }
          }

        }

      }
      if (!check) // 탈출불가라면
      {
        bw.write("IMPOSSIBLE\n");
      }

    }
  }

  public static void dfs(int depth) throws IOException {

  }

}
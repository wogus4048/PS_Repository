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
  static int k, W, H, move;
  static int[][] map;
  static boolean[][][] visited;
  static int[] start;
  static int[] target;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    k = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new int[H][W];
    visited = new boolean[k + 1][H][W];
    start = new int[] { 0, 0 };
    target = new int[] { H - 1, W - 1 };

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // for (int[] a : map) {
    // bw.write(Arrays.toString(a) + "\n");
    // }

  }

  static void solve() throws IOException {

    bw.write(bfs() + "");

  }

  static int bfs() throws IOException {
    int[] di = { 1, -1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2 };
    int[] dj = { 0, 0, 1, -1, 1, 2, -2, 1, -1, 2, -2, -1 };

    int start_x = start[0];
    int start_y = start[1];
    move = 0;
    int jump = k;

    visited[jump][start_x][start_y] = true;

    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[] { start_x, start_y, move, jump });

    while (!queue.isEmpty()) {
      int[] current = queue.poll();

      int current_x = current[0];
      int current_y = current[1];
      int current_move = current[2];
      int spare_jump = current[3];

      // if (spare_jump == 1) {
      // bw.write(
      // String.format("x : %d, y: %d, move : %d, spare jump : %d\n", current_x,
      // current_y, current_move, spare_jump));

      // }

      if (current_x == target[0] && current_y == target[1]) {
        return current_move; // 도착했다면 가는데 걸린 횟수를
      }

      for (int i = 0; i < 12; i++) {
        int next_x = current_x + di[i];
        int next_y = current_y + dj[i];

        if (0 <= next_x && next_x < H && 0 <= next_y && next_y < W) { // 범위 체크
          if (i < 4) { // 상하좌우 이동 할때
            if (!visited[spare_jump][next_x][next_y] && map[next_x][next_y] != 1) {
              queue.add(new int[] { next_x, next_y, current_move + 1, spare_jump }); // 점프값은 냅두고,이동값을 늘려주고, 큐에 넣는다.
              visited[spare_jump][next_x][next_y] = true; // 방문 True

            }
          } else if (i > 3 && spare_jump > 0 && map[next_x][next_y] != 1) { // 점프가 남아있고 점프를 할때, i가 4~11까지는 점프입니다.
            if (!visited[spare_jump - 1][next_x][next_y]) { // 점프할거니까
              queue.add(new int[] { next_x, next_y, current_move + 1, spare_jump - 1 });
              visited[spare_jump - 1][next_x][next_y] = true;
            }
          }

        }
      }

    }
    return -1; // 갈수없을때는 -1

  }

  static void test() throws IOException {

  }

}

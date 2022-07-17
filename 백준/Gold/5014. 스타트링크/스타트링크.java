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
  static int F, S, G, U, D;
  static boolean[] visited;

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
    F = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    U = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());

    visited = new boolean[F + 1];

  }

  static void solve() throws IOException {
    if (S == G) {
      bw.write(0 + "\n");
      return;
    }

    int result = bfs(S, 0);
    if (result != 0) {
      bw.write(result + "");
    }

  }

  static void test() throws IOException {

  }

  static int bfs(int floor, int move) throws IOException {
    int[] d = { U, -D };

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { floor, move });
    visited[floor] = true;

    while (!queue.isEmpty()) {
      int current[] = queue.poll();

      int current_floor = current[0];
      int current_move = current[1];

      if (current_floor == G) {
        return current_move;
      }

      for (int i = 0; i < 2; i++) {
        int next_floor = current_floor + d[i];

        if (0 < next_floor && next_floor <= F) {
          if (!visited[next_floor]) {
            queue.add(new int[] { next_floor, current_move + 1 });
            visited[next_floor] = true;
          }
        }

      }

    }
    bw.write("use the stairs\n");
    return 0;

  }

}

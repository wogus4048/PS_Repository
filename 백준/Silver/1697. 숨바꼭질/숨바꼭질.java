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
  static int n, k, min, count;
  static int a, b, c;
  static boolean[] check = new boolean[100001];

  public static void main(String[] args) throws IOException {

    input();
    solve();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    count = 0;

  }

  static void solve() throws IOException {
    if (n == k) {
      bw.write(0 + "\n");
    } else {
      bw.write(bfs(n, k) + "");
    }

  }

  static int bfs(int n, int k) throws IOException {
    Queue<int[]> queue = new LinkedList<>();
    count = 0;
    queue.add(new int[] { n, count });

    while (!queue.isEmpty()) {

      int[] current = queue.poll();
      int current_n = current[0];
      check[current_n] = true;
      int current_count = current[1];

      if (current_n == k) {
        return current_count;
      }

      if (current_n + 1 < 100001) {
        if (!check[current_n + 1])
          queue.add(new int[] { current_n + 1, current_count + 1 });
      }
      if (0 < current_n) {
        if (!check[current_n - 1])
          queue.add(new int[] { current_n - 1, current_count + 1 });
      }
      if (current_n * 2 < 100001) {
        if (!check[current_n * 2])
          queue.add(new int[] { current_n * 2, current_count + 1 });
      }

    }
    return 0;

  }

}
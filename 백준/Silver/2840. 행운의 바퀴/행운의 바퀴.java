import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n, k;
  static Deque<Character> deq = new ArrayDeque<>();
  static StringTokenizer st;
  static int[] alphabets = new int[27];

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      deq.add('?');
    }
    Arrays.fill(alphabets, 0);

  }

  static void solve() throws IOException {
    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int move = Integer.parseInt(st.nextToken());
      char alpha = st.nextToken().charAt(0);

      for (int k = 0; k < move; k++) {
        deq.add(deq.poll());
      }

      if (deq.peek() != '?' && deq.peek() != alpha) {// 다르면 행운의바퀴가없는것
        bw.write("!");
        return;
      }

      if (deq.peek() == '?') {
        deq.remove();
        deq.addFirst(alpha);
        alphabets[(int) alpha - 65] += 1;

        if (alphabets[(int) alpha - 65] > 1) {
          bw.write("!");
          return;
        }
      }

    }
    deq.add(deq.poll());
    while (!deq.isEmpty()) {
      bw.write(deq.pollLast() + "");
    }

  }

  static void bfs() throws IOException {

  }

  static void test() throws IOException {

    bw.write((int) 'A' - 65 + "");
  }

}

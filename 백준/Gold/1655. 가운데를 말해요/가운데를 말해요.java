import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static PriorityQueue<Integer> minq = new PriorityQueue<>(); // 우선순위가 낮은순.
  static PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위가 높은순

  static int n;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    n = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    for (int i = 0; i < n; i++) {
      int temp = Integer.parseInt(br.readLine());
      int current_min_size = minq.size();
      int current_max_size = maxq.size();

      if (current_max_size == current_min_size) {
        maxq.add(temp);
      } else if (current_max_size != current_min_size) {
        minq.add(temp);
      }

      if (!maxq.isEmpty() && !minq.isEmpty()) {
        if (maxq.peek() > minq.peek()) {
          int temp2 = maxq.poll();
          maxq.add(minq.poll());
          minq.add(temp2);
        }

      }
      bw.write(maxq.peek() + "\n");

    }

  }

  static void test() throws IOException {

  }

}

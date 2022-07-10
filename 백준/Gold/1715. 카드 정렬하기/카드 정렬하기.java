import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static PriorityQueue<Integer> cards = new PriorityQueue<>();

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
    for (int i = 0; i < n; i++) {
      cards.add(Integer.parseInt(br.readLine()));
    }

  }

  static void solve() throws IOException {
    int count = 0;
    if (n == 1) {
      bw.write(0 + "");
      return;
    } else {
      while (cards.size() > 1) {
        int a = cards.poll();
        int b = cards.poll();
        int sum = a + b;
        count = count + sum;

        cards.add(sum);

      }
    }
    bw.write(count + "");

  }

  static void test() throws IOException {

  }

}

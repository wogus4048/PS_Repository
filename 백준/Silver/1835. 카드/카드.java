import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static Deque<Integer> dec = new ArrayDeque<>();

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
    dec.addFirst(n);
    for (int i = n - 1; i > 0; i--) {
      dec.addFirst(i);
      for (int j = 0; j < i; j++) {
        int temp = dec.pollLast();
        dec.addFirst(temp);
      }

    }
    for (int a : dec) {
      bw.write(a + " ");
    }

  }

  static void test() throws IOException {

  }
}

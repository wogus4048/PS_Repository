import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static Deque<Integer> dec = new ArrayDeque<>();
  static HashMap<Integer, Integer> paper = new HashMap<>();

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      dec.addFirst(i);
    }
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int count = 1;
    while (st.hasMoreTokens()) {
      paper.put(count, Integer.parseInt(st.nextToken()));
      count++;
    }

  }

  static void solve() throws IOException {
    boolean right = true;
    int paper_num = paper.get(1);
    while (dec.size() != 1) {
      if (paper_num > 0) {
        if (right == true) {
          bw.write(dec.removeLast() + " ");
        } else {
          bw.write(dec.removeFirst() + " ");
        }
        for (int i = 0; i < paper_num - 1; i++) {
          dec.addFirst(dec.pollLast());
        }
        paper_num = paper.get(dec.peekLast());
        right = true;
      } else {
        if (right == true) {
          bw.write(dec.removeLast() + " ");
        } else {
          bw.write(dec.removeFirst() + " ");
        }
        for (int i = 0; i < Math.abs(paper_num) - 1; i++) {
          dec.addLast(dec.pollFirst());
        }
        paper_num = paper.get(dec.peekFirst());
        right = false;
      }
    }
    bw.write(dec.poll() + "");

  }

  static void test() throws IOException {
  }
}

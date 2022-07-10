import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());

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
      String input = br.readLine();
      if (input.equals("0")) {
        if (gift.isEmpty()) {
          bw.write("-1\n");
        } else {
          bw.write(gift.poll() + "\n");
        }
      } else {
        StringTokenizer st = new StringTokenizer(input, " ");
        int gift_count = Integer.parseInt(st.nextToken());
        for (int j = 0; j < gift_count; j++) {
          gift.add(Integer.parseInt(st.nextToken()));
        }
      }

    }

  }

  static void test() throws IOException {

  }
}

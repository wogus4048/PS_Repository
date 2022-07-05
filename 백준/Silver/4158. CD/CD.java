import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;

import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {

  }

  static void solve() throws IOException {
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      int count = 0;
      if (n == 0 && n2 == 0) {
        break;
      } else {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
          set.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < n2; i++) {
          int temp = Integer.parseInt(br.readLine());
          if (set.contains(temp)) {
            count++;
          }
        }
        bw.write(count + "\n");

      }

    }

  }

  static void test() throws IOException {

  }
}

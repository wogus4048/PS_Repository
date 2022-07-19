import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int k;
  static int[] arr;
  static boolean[] selected;

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
      StringTokenizer st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
      arr = new int[k];
      selected = new boolean[k];

      if (k == 0) {
        break;
      }

      for (int i = 0; i < k; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      combi(arr, 0, 0, selected);
      bw.write("\n");

    }

  }

  static void combi(int[] arr, int count, int start, boolean[] check) throws IOException {

    if (count == 6) {
      StringBuilder sb = new StringBuilder();
      for (int a = 0; a < k; a++) {
        if (check[a]) {
          sb.append(arr[a] + " ");
        }
      }
      bw.write(sb.toString() + "\n");
      return;
    }

    for (int i = start; i < k; i++) {
      check[i] = true;

      combi(arr, count + 1, i + 1, check);

      check[i] = false;

    }

  }

  static void test() throws IOException {

  }

}

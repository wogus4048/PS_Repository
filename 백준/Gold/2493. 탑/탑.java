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
  static Stack<int[]> stack = new Stack<>();

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
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    bw.write(0 + " ");
    stack.push(new int[] { 1, Integer.parseInt(st.nextToken()) });
    for (int i = 2; i <= n; i++) {
      int input = Integer.parseInt(st.nextToken());

      while (true) {
        if (!stack.isEmpty()) {
          if (stack.peek()[1] >= input) {
            bw.write(stack.peek()[0] + " ");
            stack.push(new int[] { i, input });
            break;
          } else {
            stack.pop();
          }
        } else {
          bw.write(0 + " ");
          stack.push(new int[] { i, input });
          break;
        }

      }

    }

  }

  static void test() throws IOException {

  }

}

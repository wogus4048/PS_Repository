import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
    loop: for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      Stack<String> stack = new Stack<>();
      for (int j = 0; j < temp.length(); j++) {

        if (temp.charAt(j) == '(') {
          stack.push("(");
        } else if (temp.charAt(j) == ')') {

          if (stack.empty()) {
            bw.write("NO" + "\n");
            continue loop;

          } else {
            stack.pop();
          }

        }

      }
      if (stack.empty()) {
        // 비워져있다면
        bw.write("YES" + "\n");
      } else {
        bw.write("NO" + "\n");
      }

    }

  }

  static void test() throws IOException {

  }
}

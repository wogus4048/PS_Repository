import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int num;
  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) throws IOException {
    input();
    solve();
    // test();

    bw.flush();
    bw.close();

  }

  public static void input() throws IOException {
    num = Integer.parseInt(br.readLine());

  }

  public static void solve() throws IOException {

    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String input = st.nextToken();
      if (input.equals("push")) {
        stack.push(Integer.parseInt(st.nextToken()));
      } else if (input.equals("top")) {
        if (stack.isEmpty()) {
          bw.write(-1 + "\n");
        } else {
          bw.write(stack.peek() + "\n");
        }
      }

      else if (input.equals("size")) {
        bw.write(stack.size() + "\n");
      } else if (input.equals("empty")) {
        if (stack.isEmpty()) {
          bw.write("1\n");
        } else {
          bw.write("0\n");
        }
      } else if (input.equals("pop")) {
        if (stack.isEmpty()) {
          bw.write("-1\n");
        } else {
          bw.write(stack.pop() + "\n");
        }
      }

    }

  }

  static void test() throws IOException {

  }

}
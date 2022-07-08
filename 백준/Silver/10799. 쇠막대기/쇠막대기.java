import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {

    // input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {

  }

  static void solve() throws IOException {
    int count = 0;

    Stack<Character> stack = new Stack<>();
    String aaa = br.readLine();
    for (int i = 0; i < aaa.length(); i++) {
      if (aaa.charAt(i) == '(') {
        if (aaa.charAt(i + 1) == ')') {
          if (!stack.isEmpty()) {
            count = count + stack.size();
          }
          i++; // 레이저 이므로 다음에 나올 닫힐 괄호를 스킵
        } else {
          stack.add('(');
        }

      } else {
        stack.pop(); // 레이저가 아닌 닫힌 괄호는 쇠막대기의 끝부분이므로 열린괄호를 스택에서 POP
        count++; // +1해준다.

      }

    }
    bw.write(count + "\n");

  }

  static void test() throws IOException {
  }
}

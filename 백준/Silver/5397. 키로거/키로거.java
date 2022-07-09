import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int test_case;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());

  }

  static void solve() throws IOException {
    for (int i = 0; i < test_case; i++) {
      String temp = br.readLine();
      Stack<Character> left = new Stack<>();
      Stack<Character> right = new Stack<>();
      for (int k = 0; k < temp.length(); k++) {
        char current = temp.charAt(k);
        if (current == '<' | current == '>') {
          if (current == '<') {
            if (!left.isEmpty()) {
              right.push(left.pop());
            }
          } else {
            if (!right.isEmpty()) {
              left.push(right.pop());
            }
          }
        } else if (current == '-') {
          if (!left.isEmpty()) {
            left.pop();
          }
        } else {
          left.push(current);

        }

      }
      while (!right.isEmpty()) {
        left.push(right.pop());
      }
      for (char c : left) {
        bw.write(c + "");
      }
      bw.write("\n");

    }

  }

  static void test() throws IOException {
    Stack<String> stack = new Stack<>();
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");
    for (String a : stack) {
      bw.write(a + " ");
    }

  }
}

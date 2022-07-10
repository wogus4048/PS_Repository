import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int number_count;
  static String temp;
  static int[] arr;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    number_count = Integer.parseInt(br.readLine());
    temp = br.readLine();
    arr = new int[number_count];
    for (int i = 0; i < number_count; i++) {
      arr[i] = Integer.parseInt(br.readLine());

    }

  }

  static void solve() throws IOException {
    Stack<Double> stack = new Stack<>();
    for (int i = 0; i < temp.length(); i++) {
      char current = temp.charAt(i);
      if ('A' <= current && current <= 'Z') {
        // bw.write(String.format("current : %c", current));
        double d = arr[current - 'A'];
        stack.push(d);
      }
      if (current == '*' | current == '+' | current == '-' | current == '/') {
        if (current == '*') {
          double b = stack.pop();
          double a = stack.pop();
          // bw.write(String.format("a: %f , b : %f a * b : %f", a, b, a * b));
          stack.push((a * b));
        } else if (current == '+') {
          double b = stack.pop();
          double a = stack.pop();
          // bw.write(String.format("a: %f , b : %f a * b : %f", a, b, a + b));
          stack.push((a + b));
        } else if (current == '-') {
          double b = stack.pop();
          double a = stack.pop();
          // bw.write(String.format("a: %f , b : %f a * b : %f", a, b, a - b));
          stack.push((a - b));
        } else if (current == '/') {
          double b = stack.pop();
          double a = stack.pop();
          // bw.write(String.format("a: %f , b : %f a * b : %f", a, b, a / b));
          stack.push((a / b));
        }

      }

    }
    bw.write(String.format("%.2f", stack.pop()));
  }

  static void test() throws IOException {
    char b = 'A';
    int a = b - 'A';
    bw.write(a + "");

  }
}

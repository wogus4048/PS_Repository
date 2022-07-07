import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.Popup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static String[] words_arr;

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
    words_arr = new String[N];
    for (int i = 0; i < N; i++) {
      words_arr[i] = br.readLine();
    }

  }

  static void solve() throws IOException {
    int count = 0;
    for (int i = 0; i < N; i++) {
      String word = words_arr[i];
      Stack<Character> stack = new Stack<>();
      for (int j = 0; j < word.length(); j++) {
        if (stack.isEmpty() != true && word.charAt(j) == stack.peek()) {
          stack.pop();
        } else {
          stack.add(word.charAt(j));
        }
      }
      if (stack.size() == 0) {
        count++;
      }

    }
    bw.write(count + "\n");

  }

  static void test() throws IOException {

  }

}

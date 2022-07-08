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
      int length = Integer.parseInt(br.readLine());
      Deque<Character> result = new ArrayDeque<>();
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      result.addFirst(st.nextToken().charAt(0)); // 첫번째 문자는 그냥 저장
      for (int k = 1; k < length; k++) {
        char current_left = result.peekFirst();
        char Alphabet = st.nextToken().charAt(0);
        if ((int) current_left >= (int) Alphabet) // 덱의 왼쪽 문자보다 사전순이 더 빠르거나 같다면
        {
          result.addFirst(Alphabet);
        } else {
          result.addLast(Alphabet);
        }

      }
      for (char alpha : result) {
        bw.write(alpha + "");
      }
      bw.write("\n");

    }

  }

  static void test() throws IOException {

  }
}

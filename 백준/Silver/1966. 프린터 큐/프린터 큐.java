import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());
      int result = 1;

      Queue<int[]> qq = new LinkedList<>();
      ArrayList<Integer> priority = new ArrayList<>();
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      for (int k = 0; k < N; k++) {
        int temp = Integer.parseInt(st2.nextToken());
        if (k == target) {
          qq.add(new int[] { 1, temp });
        } else {
          qq.add(new int[] { 0, temp });
        }
        priority.add(temp);
      }
      if (N == 1) {
        bw.write(1 + "\n");
        continue;
      }
      /// 위에는 저장
      // 아래에서 연산
      Collections.sort(priority, Collections.reverseOrder());
      while (true) {
        if (qq.peek()[1] == priority.get(0)) {
          if (qq.peek()[0] == 1) {
            bw.write(result + "\n");
            break;
          }
          qq.poll();
          priority.remove(0);
          result++;
        } else {
          qq.add(qq.poll());

        }

      }

    }

  }

  static void test() throws IOException {

  }
}

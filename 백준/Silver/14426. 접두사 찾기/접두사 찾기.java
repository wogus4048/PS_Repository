import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int m;
  static String[] arr1;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr1 = new String[n];
    for (int i = 0; i < n; i++) {
      arr1[i] = br.readLine();
    }

  }

  static void solve() throws IOException {
    // int count = 0;
    // for (int i = 0; i < m; i++) {
    // String input = br.readLine();
    // for (int j = 0; j < n; j++) {
    // if (arr1[j].startsWith(input)) {
    // count++;
    // break;

    // }

    // }
    // }
    // bw.write(count + "\n");
    int count = 0;
    for (int i = 0; i < m; i++) {

      String input = br.readLine();
      boolean check = false;
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < input.length(); k++) {
          if (input.charAt(k) != arr1[j].charAt(k)) {
            break;
          }
          if (k == input.length() - 1) {
            check = true;
          }
        }
        if (check == true) {
          count++;
          break;
        }

      }
    }
    bw.write(count + "\n");
  }

  static void test() throws IOException {
    // N개의 문자열 저장
    // for(M개 만큼 반복)
    // {
    // 문자열 입력받고 해당 문자열의 첫번째 문자를 가지고
    // for(N개만큼 반복)
    // {

    // }

    // }

  }
}

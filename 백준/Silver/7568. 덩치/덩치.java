import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int test_case;
  static int[] rank;
  static String[][] arr;

  public static void main(String[] args) throws IOException {

    input();
    solve();
    // test();
    for (int number : rank) {
      bw.write(number + " ");
    }

    bw.flush();
    br.close();
    bw.close();
  }

  static void input() throws IOException {
    test_case = Integer.parseInt(br.readLine());
    arr = new String[test_case][];
    for (int i = 0; i < test_case; i++) {
      arr[i] = br.readLine().split(" ");
    }
    rank = new int[test_case];
    Arrays.fill(rank, 1);
  }

  static void solve() throws IOException {
    for (int i = 0; i < test_case; i++) {

      for (int j = i + 1; j < test_case; j++) {
        if (i != test_case - 1) {

          if (Integer.parseInt(arr[i][0]) > Integer.parseInt(arr[j][0])) {
            if (Integer.parseInt(arr[i][1]) > Integer.parseInt(arr[j][1])) {
              rank[j] += 1;
            }
          }
          if (Integer.parseInt(arr[i][0]) < Integer.parseInt(arr[j][0])) {
            if (Integer.parseInt(arr[i][1]) < Integer.parseInt(arr[j][1])) {
              rank[i] += 1;
            }
          }
        }

      }

    }

  }

  static void test() throws IOException {

  }
}
